package com.samsung.dailytest.day2.p02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CheckOut();
    }

    public static void CheckOut() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n matrix of 9-9
        for (int i = 0; i < n; i++) {
            int[][] matrix = new int[10][10];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            boolean flag = true;
            int[][] row = new int[10][10];
            int[][] col = new int[10][10];
            int[][] box = new int[10][10];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    int number = matrix[j][k];
                    if (number > 0 && number <= 9) {
                        int boxIndex = (j / 3) * 3 + (k / 3)  ;
                        if (row[j][number] == 1 || col[j][number] == 1 || box[boxIndex][number] == 1) {
                            flag = false;
                            break;
                        }
                        row[j][number] = 1;
                        col[j][number] = 1;
                        box[boxIndex][number] = 1;
                    }
                    else  {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }
}
