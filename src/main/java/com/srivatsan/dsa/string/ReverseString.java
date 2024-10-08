package com.srivatsan.dsa.string;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello";
        String reversedString = reverseString(str);
        System.out.println(reversedString);
    }

    private static String reverseString(String word) {
        StringBuilder reversedString = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedString.append(word.charAt(i));
        }

        return reversedString.toString();
    }
}
