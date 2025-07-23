package com.symphony.practise2;

import java.util.List;
import java.util.function.Consumer;

public class FunctionalTest {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer<Integer> consumer = x -> System.out.println(x * 10);

        List<Integer> result = list.stream().map(x -> x * 10).filter(x -> x % 3 == 0).toList();

        list.stream().map(x -> x * 10).filter(x -> x % 3 == 0).forEach(consumer);

        System.out.println(result);

    }
}
