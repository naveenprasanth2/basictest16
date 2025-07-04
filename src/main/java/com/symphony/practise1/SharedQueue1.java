package com.symphony.practise1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue1 {
    private final int MAX_SIZE = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    private final ReentrantLock lock;
    private final Condition spaceAvailable;
    private final Condition itemAvailable;


    public SharedQueue1() {
        this.lock = new ReentrantLock();
        this.spaceAvailable = lock.newCondition();
        this.itemAvailable = lock.newCondition();
    }

    public void add(int val) {
        try {
            lock.lock();
            while (queue.size() == MAX_SIZE) {
                spaceAvailable.await();
            }
            queue.offer(val);
            itemAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void remove() {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                itemAvailable.await();
            }
            System.out.println(queue.poll());
            spaceAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
