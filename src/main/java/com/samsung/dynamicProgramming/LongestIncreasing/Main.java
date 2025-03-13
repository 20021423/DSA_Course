package com.samsung.dynamicProgramming.LongestIncreasing;

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
        int max = 1;

        for (int i = 0; i < n; i++) {
            s[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[i] > arr[j]) {
                    if (s[i] < s[j] + 1) {
                        s[i] = s[j] + 1;
                    }

                }
            }
            if (s[i] > max) {
                max = s[i];
            }
        }
        System.out.println(max);
    }
}
