package com.samsung;

import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
           
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    System.out.println("0");  
                    return;
                }
                char top = stack.pop();
                if (!isPair(top, c)) {
                    System.out.println("0");  
                    return;
                }
            }
        }

        
        if (stack.isEmpty()) {
            System.out.println("1");  
        } else {
            System.out.println("0");  
        }
    }

    
    public static boolean isPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
