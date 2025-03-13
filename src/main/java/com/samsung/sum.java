package com.samsung;

import java.math.BigInteger;
import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();


        BigInteger sum = a.add(b);

        System.out.println(sum);

        scanner.close();
    }
}

