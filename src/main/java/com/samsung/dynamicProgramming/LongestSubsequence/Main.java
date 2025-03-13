package com.samsung.dynamicProgramming.LongestSubsequence;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        int start = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (s[i - 1] > 0) {
                s[i] = s[i - 1] + arr[i];
            } else {
                s[i] = arr[i];
                start = i;
            }
            if (s[i] > max) {
                max = s[i];
                end = i;
            }
        }
        System.out.println(max);
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
