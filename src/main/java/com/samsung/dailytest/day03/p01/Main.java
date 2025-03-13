package com.samsung.dailytest.day03.p01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int[] revenue = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            revenue[i] = sc.nextInt();
            if (revenue[i] >= X && revenue[i] <= Y) {
                count++;
            }
        }
        System.out.println(count);
    }
}
