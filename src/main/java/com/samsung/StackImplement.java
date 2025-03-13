package com.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackImplement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }
            String[] tokens = line.split(" ");
            String command = tokens[0];
            if (command.equals("PUSH")) {
                stack.push(Integer.parseInt(tokens[1]));
            } else if (command.equals("POP")) {
                if (stack.isEmpty()) {
                    System.out.println("NULL");
                    break;
                }
                else{
                    System.out.println(stack.pop());
                }
            }
        }
    }
}
