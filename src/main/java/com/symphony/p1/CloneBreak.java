package com.symphony.p1;

public class CloneBreak {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.clone());
        System.out.println(singleton);
    }
}
