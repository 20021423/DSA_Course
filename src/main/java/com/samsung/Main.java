package com.samsung;

import java.util.ArrayList;

public class Main {
    int a,b;
    ArrayList<Integer> L;

    public Main(int b) {
        this.a = 11;
        this.b = b;
        L = new ArrayList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        System.out.println("check 2 in L = " + L.contains(2));
        System.out.println("First element = " + L.get(0));
        System.out.println("Last element = " + L.get(L.size()-1));

        for (int i = 0; i < L.size(); i++) {
            if (L.get(i) % 2 == 0) {
                System.out.println("Chia het cho 2: " + L.get(i));
            }
            else {
                System.out.println("Khong chia het cho 2: " + L.get(i));
            }

        }
    }
    public int sum() {
        return a + b;
    }
    public static void main(String[] args) {
        Main m = new Main(7);
        System.out.println(m.sum());
    }
}