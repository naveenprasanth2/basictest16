package com.symphony.p1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue {
    private final int capacity = 5;
    Queue<Integer> queue;
    private final ReentrantLock lock;
    private final Condition spaceAvailable;
    private final Condition itemAvailable;

    public SharedQueue() {
        lock = new ReentrantLock();
        queue = new LinkedList<>();
        spaceAvailable = lock.newCondition();
        itemAvailable = lock.newCondition();
    }

    public void put(int val) {
        try {
            lock.lock();
            while (queue.size() == capacity) {
                spaceAvailable.await();
            }
            queue.add(val);
            itemAvailable.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void take() {
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
