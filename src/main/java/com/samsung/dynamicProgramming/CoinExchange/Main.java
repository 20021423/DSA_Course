package com.samsung.dynamicProgramming.CoinExchange;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] D = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            D[i] = sc.nextInt();
        }
        int[][] minCoins = new int[n + 1][x + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(minCoins[i], Integer.MAX_VALUE - 1);
        }

        for (int i = 0; i <= n; i++) {
            minCoins[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                if (D[i] > j) {
                    minCoins[i][j] = minCoins[i - 1][j];
                } else {
                    minCoins[i][j] = Math.min(minCoins[i - 1][j], minCoins[i][j - D[i]] + 1);
                }
            }
        }
        int min = minCoins[n][x];
        System.out.println(min);
    }
}
