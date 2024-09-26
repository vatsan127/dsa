package com.srivatsan.dsa.string;

import java.util.List;
import java.util.Stack;

class Expressions {

    private final List<Character> leftCharList = List.of('(', '[', '{', '<');
    private final List<Character> rightCharList = List.of(')', ']', '}', '>');

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            if (checkLeftBraces(ch)) stack.push(ch);

            if (checkRightBraces(ch)) {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (!bracesMatch(pop, ch)) return false;
            }
        }
        return stack.empty();
    }

    private boolean checkLeftBraces(char ch) {
        return ch == '(' || ch == '[' || ch == '{' || ch == '<';
    }

    private boolean checkRightBraces(char ch) {
        return ch == ')' || ch == ']' || ch == '}' || ch == '>';
    }

    private boolean bracesMatch(char left, char right) {
        return leftCharList.indexOf(left) == rightCharList.indexOf(right);
    }
}

public class BalancedString {
    public static void main(String[] args) {
        String str = "([1+2])";
        Expressions exp = new Expressions();
        System.out.println("String: "+str);
        String result = exp.isBalanced(str) ? "Balanced String " : "Imbalanced String";
        System.out.println(result);
    }
}
