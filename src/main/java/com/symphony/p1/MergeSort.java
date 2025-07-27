package com.symphony.p1;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2, 3, 4, 5, 4, 3, 2};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] original) {
        if (original.length == 1)
            return;
        int n = original.length;
        int half = n / 2;
        int[] left = new int[half];
        int[] right = new int[n - half];
        System.arraycopy(original, 0, left, 0, half);
        System.arraycopy(original, half, right, 0, right.length);
        sort(left);
        sort(right);
        merge(original, left, right);
    }

    private static void merge(int[] original, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                original[k++] = left[i++];
            } else {
                original[k++] = right[j++];
            }
        }
        while (i < left.length) {
            original[k++] = left[i++];
        }
        while (j < right.length) {
            original[k++] = right[j++];
        }
    }
}
