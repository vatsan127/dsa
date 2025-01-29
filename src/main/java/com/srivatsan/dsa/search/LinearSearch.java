package com.srivatsan.dsa.search;

public class LinearSearch {
    public static int linearSearch(int arr[], int length, int findNumber) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == findNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90, 87};
        int result = linearSearch(arr, arr.length, 12);
        if (result == -1) {
            System.out.println("Number Not Found");
        } else {
            System.out.println("Number found at Index " + result);
        }
    }
}