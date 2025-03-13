package com.samsung.dailytest.day1;

import java.util.Scanner;


public class P02 {
    public static int timTongLonNhat(int[] a) {
        int tongHienTai = 0;

        int tongLonNhat = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            tongHienTai = tongHienTai + a[i];

            if (tongHienTai > tongLonNhat) {
                tongLonNhat = tongHienTai;
            }

            if (tongHienTai < 0) {
                tongHienTai = 0;
            }
        }

        return tongLonNhat;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(timTongLonNhat(arr));
    }

}


