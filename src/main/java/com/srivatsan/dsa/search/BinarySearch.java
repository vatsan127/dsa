package com.srivatsan.dsa.search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int length, int findNumber) {
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == findNumber) {
                return middle;
            }
            if (arr[middle] > findNumber) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {11, 12, 22, 25, 34, 64, 87, 90};
        int result = binarySearch(arr, arr.length, 90);
        if (result == -1) {
            System.out.println("Number Not found");
        } else {
            System.out.println("Number found at index " + result);
        }
    }
}