package com.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class ComputeCkn {

    static final int MOD = 1_000_000_007;
    static int[][] M;

    public static int C(int k, int n) {

        if (k == 0 || k == n) return 1;


        if (M[k][n] == -1) {
            M[k][n] = (C(k, n - 1) + C(k - 1, n - 1)) % MOD;
        }

        return M[k][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        M = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(M[i], -1);
        }

        long startTime = System.currentTimeMillis();
        int compute = C(k, n);
        long endTime = System.currentTimeMillis();

        System.out.println(compute);
        System.out.println("Execution time = " + (endTime - startTime) + " ms");
    }
}
