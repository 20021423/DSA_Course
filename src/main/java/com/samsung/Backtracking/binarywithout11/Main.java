package com.samsung.Backtracking.binarywithout11;

import java.util.Scanner;

public class Main {
    public int n;
    public int[] x;

    public Main(int n) {
        this.n = n;
        x = new int[n + 1];
    }

    public void printSolution() {
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i]);
        }
        System.out.println();
    }

    public boolean check(int k, int i) {
        if (k == 1) return true;
        if (x[k - 1] == 1 && i == 1 && x[k - 2] == 1) {
            return false;
        }
        return true;
    }

    public void Try(int k) {
        for (int i = 0; i <= 1; i++) {
            if (check(k, i)) {
                x[k] = i;
                if (k == n) printSolution();
                else Try(k + 1);
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


