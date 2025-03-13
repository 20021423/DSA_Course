package com.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImpl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new PriorityQueue<>();
        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }
            String[] tokens = line.split(" ");
            String first = tokens[0];
            if (first.equals("PUSH")) {
                q.add(Integer.parseInt(tokens[1]));
            } else if (first.equals("POP")) {
                if(q.isEmpty()) {
                    System.out.println("NULL");
                }
                else {
                    System.out.println(q.remove());
                }
            }

        }
    }
}
