package com.symphony.practise1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.StringTemplate.STR;

public class SharedQueue {
    private final int MAX_SIZE = 5;
    Queue<Integer> queue;
    ReentrantLock lock;
    Condition spaceAvailable;
    Condition itemAvailable;

    public SharedQueue() {
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        spaceAvailable = lock.newCondition();
        itemAvailable = lock.newCondition();
    }

    public void addItem(int val) {
        try{
            lock.lock();
            while (queue.size() == MAX_SIZE){
                System.out.println(STR."Inside the loop block");
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

    public void remove(){
        try {
            lock.lock();
            while (queue.isEmpty()){
                System.out.println(STR."Inside items available");
                itemAvailable.await();
            }
            queue.poll();
            spaceAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
