package com.symphony.practise2;

import java.util.List;

public class FunctionalTest {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = list.stream().map(x -> x * 10).filter(x -> x % 3 == 0).toList();

        System.out.println(result);

    }
}
