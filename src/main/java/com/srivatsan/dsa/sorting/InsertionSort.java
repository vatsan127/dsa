package com.srivatsan.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {64, 24, 12, 22, 11};
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
