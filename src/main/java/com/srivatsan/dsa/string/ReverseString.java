package com.srivatsan.dsa.string;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcd";
        String reversed = reverseUsingStack(str);
        System.out.println(reversed);
    }

    public static String reverseUsingStack(String input) {
        if (input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.empty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

}
