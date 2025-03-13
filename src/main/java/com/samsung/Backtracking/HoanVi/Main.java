package com.samsung.Backtracking.HoanVi;

import java.util.Scanner;

public class Main {
    public int n;
    public int[] x;
    boolean marked[];


    public Main(int n) {
        this.n = n;
        x = new int[n + 1];
        marked = new boolean[n + 1];
    }

    public void printSolution() {
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public void Try(int k) {
        for (int i = 1; i <= n; i++) {
            if (!marked[i]) {
                x[k] = i;
                marked[i] = true;
                if (k == n) printSolution();
                else Try(k + 1);
                marked[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main m = new Main(n);
        m.Try(1);
    }
}
