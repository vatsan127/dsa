package com.srivatsan.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        /*merge left[]  and right[] */
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        /*add other remaining elements from left[]*/
        while (i < left.length) {
            arr[k] = left[i];
            k++;
            i++;
        }

        /*add other remaining elements from right[]*/
        while (j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    /*to create 2 arrays left[] and right[]*/
    public static void divide(int[] arr) {

        /*if size of the arrays is 1 No further divide is done*/
        if (arr.length < 2) {
            return;
        }

        /*size for the arrays */
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;

        /*left[] and right[]*/
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        /*put data into the left[] and right[]*/
        System.arraycopy(arr, 0, left, 0, leftSize);
        System.arraycopy(arr, leftSize, right, 0, rightSize);

        divide(left);
        divide(right);
        merge(arr, left, right);
    }


    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 87};
        divide(arr);
        System.out.println(Arrays.toString(arr));
    }
}
