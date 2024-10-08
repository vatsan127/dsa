package com.srivatsan.dsa;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strList = List.of("hello", "danger", "hello", "danger");
        System.out.println(strList);

        System.out.println(strList.stream().distinct().collect(Collectors.toList()));
    }
}