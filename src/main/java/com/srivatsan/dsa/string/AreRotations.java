package com.srivatsan.dsa.string;

public class AreRotations {

    public static void main(String[] args) {
        String string = "ABCD";
        String word = "CDAB";
        boolean result = checkRotations(string, word);
        System.out.println(result);
    }

    private static boolean checkRotations(String string, String word) {
        String str = string + string;
        return string.length() == word.length() && str.contains(word);

    }
}
