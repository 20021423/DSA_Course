package com.samsung.dailytest.day2.p01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n + 1];
        int smallest = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
            if (x[i] < smallest) {
                smallest = x[i];
            }
        }
        System.out.println(smallest);
    }
}
