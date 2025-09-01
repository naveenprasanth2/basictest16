package com.symphony.p1;

public class Employee {
    @Times(times = 5)
    public void test(){
        System.out.println("test");
    }

    @Times
    public void test1(){
        System.out.println("test1");
    }


}
