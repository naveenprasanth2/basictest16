package com.symphony.p1;

import java.util.List;

public class ListManipulation {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        int result = list.stream().filter(x -> x % 2 == 0)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
    }
}
