package com.mycompany.project1algo;

/**
 * This class is the insertion sort algorithm.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: InsertionSort.java
 * Created: Sep 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is the insertion sort algorithm. It has one method
 * sort which takes in an array and does an insertion sort on the array in 
 * place.
 */
public class InsertionSort {
    //sorts the input array in place
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
