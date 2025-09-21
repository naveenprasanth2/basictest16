package com.symphony.sudha;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue1 {
    int limit;
    Queue<Integer> queue;
    ReentrantLock lock;
    Condition spacesAvailable;
    Condition itemsAvailable;
    public SharedQueue1(int limit){
        this.limit = limit;
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.spacesAvailable = lock.newCondition();
        this.itemsAvailable = lock.newCondition();
    }

    public void put(int val){
        lock.lock();
        try {
            while (queue.size() == limit){
                spacesAvailable.await();
            }
            queue.offer(val);
            itemsAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                itemsAvailable.await();
            }
            IO.println("The element fetched from the queue is " + queue.poll());
            spacesAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
