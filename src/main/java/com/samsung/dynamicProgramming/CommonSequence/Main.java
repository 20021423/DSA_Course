package com.samsung.dynamicProgramming.CommonSequence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n + 1];
        int[] y = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
        }

        for (int i = 1; i <= m; i++) {
            y[i] = sc.nextInt();
        }

        int[][] s = new int[n + 2][m + 2];
        for (int i = 0; i <= n; i++) {
            s[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            s[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x[i] == y[j]) {
                    s[i][j] = s[i - 1][j - 1] + 1;
                } else {
                    s[i][j] = Math.max(s[i - 1][j], s[i][j - 1]);
                }
            }
        }
        System.out.println(s[n][m]);

    }
}
