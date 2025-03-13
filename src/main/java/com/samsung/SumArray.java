package com.samsung;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];


            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }

            for (int j = 0; j < m; j++) {
                b[j] = scanner.nextInt();
            }

            if (n != m) {
                System.out.println("0");
                continue;
            }

            boolean flag = true;

            for (int j = 0; j < n; j++) {
                if (a[j] != b[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
