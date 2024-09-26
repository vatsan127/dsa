package com.srivatsan.dsa.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        // a green apple
        String sentence = "a green apple";
        Map<Character, Integer> charSet = new HashMap<>();

        char[] charArray = sentence.toCharArray();
        for (char ch : charArray) {
            int count = charSet.containsKey(ch) ? charSet.get(ch) : 0;
            charSet.put(ch, count + 1);
        }
        System.out.println(charSet);
        List<Character> nonRepeatedChar = charSet.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).toList();
        System.out.println(nonRepeatedChar);
    }
}
