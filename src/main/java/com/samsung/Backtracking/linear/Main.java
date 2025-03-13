package com.samsung.Backtracking.linear;

import java.util.Scanner;

public class Main {
    int n;
    int[] x;
    int M;

    public Main(int n, int m) {
        this.M = m;
        x = new int[n + 1];
        this.n = n;
    }

    public void printSolution() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += x[i];
        }
        if (sum == M) {
            for (int i = 1; i <= n; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        }
    }

    public void Try(int k) {
        for (int i = 1; i <= M; i++) {
            x[k] = i;
            if (k == n) {
                printSolution();
            } else {
                Try(k + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();
        Main m = new Main(n, M);

        m.Try(1);
    }
}
