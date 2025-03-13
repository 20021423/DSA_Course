package com.samsung.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Queue<Integer> q = new PriorityQueue<Integer>();

        while (true) {
            line = br.readLine();
            if (line.equals("#")) {
                break;
            }
            String[] tokens = line.split(" ");
            String command = tokens[0];
            switch (command) {
                case "PUSH":
                    int u = Integer.parseInt(tokens[1]);
                    q.add(u);
                    break;
                case "POP":
                    if (!q.isEmpty()) {
                        System.out.println(q.poll());
                        break;
                    }
            }
        }
    }
}
