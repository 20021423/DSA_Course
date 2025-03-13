package com.samsung.Backtracking;

//JAVA
import java.util.*;
import java.util.Scanner;

public class BinarySequence {
    public int n;
    public int[] x;

    public BinarySequence(int n) {
        this.n = n;
        x = new int[n + 1];
    }

    public void printSolution() {
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i]);
        }
        System.out.println();
    }

    public void Try(int k) {
        for (int i = 0; i <= 1; i++) {
            x[k] = i;
            if (k == n) printSolution();
            else Try(k + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySequence m = new BinarySequence(n);
        m.Try(1);
    }
}

