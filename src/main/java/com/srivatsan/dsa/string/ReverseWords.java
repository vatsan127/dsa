package com.srivatsan.dsa.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "Welcome to  java";
        String reversedWords = reverseWords(sentence);
        System.out.println(reversedWords);
    }

    private static String reverseWords(String sentence) {
        String[] sentenceArray = sentence.split(" ");
        List<String> list = Arrays.asList(sentenceArray);
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
