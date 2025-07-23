package com.symphony.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Person {
    private final String name;
    private final List<Integer> contactNo;

    public Person(String name, List<Integer> contactNo) {
        this.name = name;
        this.contactNo = contactNo;
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getContactNo() {
        return Collections.unmodifiableList(contactNo);
    }

    public static void main(String[] args) {
        Person person = new Person("naveen", Arrays.asList(1, 2, 3,4));
        person.getContactNo().add(10);
        person.getName();
    }
}
