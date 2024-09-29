package com.srivatsan.dsa;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello","hello");
        map.put("hellos","hello2");
        map.put("hellop","hello3");

        System.out.println(Arrays.toString(map.values().toArray(new String[0])));
    }
}