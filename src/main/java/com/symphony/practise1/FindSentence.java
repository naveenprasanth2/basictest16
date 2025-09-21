package com.symphony.practise1;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FindSentence {
    public static void main(String[] args) {
        String sentence = "He is a 2 89good boy78 boy-boy and--and";
        List<String> result = Stream.of(sentence.split(" "))
                .filter(x -> Pattern.matches("[a-zA-Z]+|[a-zA-Z]+-?[a-zA-Z]+", x)).toList();
        System.out.println(result);
    }
}
