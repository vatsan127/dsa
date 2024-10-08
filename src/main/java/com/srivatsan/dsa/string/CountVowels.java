package com.srivatsan.dsa.string;

public class CountVowels {
    public static void main(String[] args) {
        String str = "hello";
        int result = countVowels(str);
        System.out.println("count : " + result);
    }

    private static int countVowels(String word) {
        String vowels = "aeiou";
        int count = 0;
        char[] charArray = word.toCharArray();
        for (char ch : charArray) {
            if (vowels.indexOf(ch) != -1) count++;
        }
        return count;
    }
}
