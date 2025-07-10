package com.symphony.practise1;

public class BuilderTest {
    public static void main(String[] args) {
        BuilderEx builderEx = BuilderEx.builder().setName("naveen").setAge(10).build();
        System.out.println(builderEx.getAge());
        System.out.println(builderEx.getName());
    }
}
