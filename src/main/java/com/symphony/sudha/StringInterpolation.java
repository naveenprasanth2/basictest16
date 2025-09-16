package com.symphony.sudha;

public class StringInterpolation {
    public static void main(String[] args) {
       String name  = """
                Java 25 has been released today by 
                %s
                """.formatted("16-Sep-2025");
        System.out.println(name);
    }
}
