package com.samsung.dailytest.day03.p02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count = 0; // so cot ma toan bang 1
        for (int i = 1; i <= n; i++) {
            int countN = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[j][i] == 1) {
                    countN++;
                } else {
                    break;
                }
            }
            if (countN == n) {
                count++;
            }
        }
        System.out.println(count);
    }
}
