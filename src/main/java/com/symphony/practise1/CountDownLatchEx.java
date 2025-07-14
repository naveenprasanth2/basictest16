package com.symphony.practise1;

public class CountDownLatchEx {
    private int count;

    public CountDownLatchEx(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        if (count > 0) {
            count--;
            if (count == 0) {
                notifyAll();
            }
        }
    }

    public int getCount() {
        return this.count;
    }
}
