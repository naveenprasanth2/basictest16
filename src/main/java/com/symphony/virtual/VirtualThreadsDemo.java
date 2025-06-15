package com.symphony.virtual;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 20000;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println(Thread.currentThread());
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            list.add(Thread.ofVirtual().unstarted(runnable));
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }
    }
}
