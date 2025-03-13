package com.samsung;

import java.io.*;
import java.util.Scanner;

public class BasicQuerriesOnArray {
    static int findMax(int[] arr, int n, int m) {
        int max = arr[n];
        for (int i = n; i <= m; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int findMin(int[] arr, int n, int m) {
        int min = arr[n];
        for (int i = n; i <= m; i++) {
            if (arr[i] <= min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = scanner.readLine();
            if (line.equals("***")) {
                break;
            }

            String[] tokens = line.split(" ");
            String op = tokens[0];
            switch (op) {
                case "find-max":
                    System.out.println(findMax(arr, 0, arr.length - 1));
                    break;
                case "find-min":
                    System.out.println(findMin(arr, 0, arr.length - 1));
                    break;
                case "find-max-segment":
                    int i = Integer.parseInt(tokens[1]);
                    int j = Integer.parseInt(tokens[2]);
                    System.out.println(findMax(arr, i - 1, j - 1));
                    break;
                case "sum":
                    int sum = 0;
                    for (int index = 0; index < arr.length; index++) {
                        sum += arr[index];
                    }
                    System.out.println(sum);
            }
        }
    }
}
