package com.symphony.practise1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FindSentence {
    public static void main(String[] args) {
        String sentence = "He is a 2 89good boy78 boy-boy and--and";
        List<String> result = Stream.of(sentence.split(" "))
                .filter(x -> Pattern.matches("[a-zA-Z]+|[a-zA-Z]+-?[a-zA-Z]+", x)).toList();
        System.out.println(result);
        long sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        int[] arr = {1,2,3,4,5,6,7};
        Arrays.stream(arr).filter(x -> x%2==0).forEach(System.out::println);

        char[] chars = {'a','b','c','d'};
        List<Character> charList = new String(chars).chars().mapToObj(c -> (char) c).toList();
        System.out.println(charList);
    }
}
