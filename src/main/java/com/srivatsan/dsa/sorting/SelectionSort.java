package com.srivatsan.dsa.sorting;

import java.util.Arrays;

/**
 * Find the smallest elements and swap it
 */
public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {64, 24, 12, 22, 11};
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
