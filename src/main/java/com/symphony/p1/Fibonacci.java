package com.symphony.p1;

public class Fibonacci {
    int[] memo;
    int n;

    public Fibonacci(int n) {
        this.n = n;
        this.memo = new int[n + 1];
    }

    private int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        if (memo[n] == 0) { // n != 0 avoids overwriting base case
            memo[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(15);
        System.out.println(fibonacci.fibonacci(15));
    }
}
