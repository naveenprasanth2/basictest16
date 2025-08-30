package com.symphony.sudha;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue {
    private final Queue<Integer> queue;
    public final int capacity;
    private final ReentrantLock reentrantLock;
    private final Condition spacesAvailable;
    private final Condition itemsAvailalble;

    public SharedQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        reentrantLock = new ReentrantLock();
        spacesAvailable = reentrantLock.newCondition();
        itemsAvailalble = reentrantLock.newCondition();
    }

    public void put(int val) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (queue.size() == capacity) {
                spacesAvailable.await();
            }
            queue.add(val);
            itemsAvailalble.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void take() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (queue.isEmpty()) {
                itemsAvailalble.await();
            }
            System.out.println(queue.poll());
            spacesAvailable.signal();
        } finally {
            reentrantLock.unlock();
        }
    }
}
