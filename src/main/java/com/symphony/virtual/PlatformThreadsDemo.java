package com.symphony.virtual;

public class PlatformThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.ofPlatform().unstarted(() -> System.out.println(Thread.currentThread()));
        thread.start();
        thread.join();
    }
}
