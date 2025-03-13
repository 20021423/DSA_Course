package com.samsung.dailytest.day03.p04;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int D = sc.nextInt();
        int[] ai = new int[n + 1];
        int[] ti = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ai[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            ti[i] = sc.nextInt();
        }
        int[] t = new int[n + 1];
        int[] d = new int[n + 1];
        d[1] = ai[1];
        t[1] = ti[1];
        int maxD = ai[1];
        int maxT = ti[1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if ( i - j <= D && t[i] <= T) {
                    d[i] = Math.max(d[i], ai[i] + d[j]);
                    t[i] = Math.max(t[i], ti[i] + t[j]);
                }
            }
            maxD = Math.max(maxD, d[i]);
            maxT = Math.max(maxT, t[i]);


        }
        System.out.println(maxD);

    }
}
