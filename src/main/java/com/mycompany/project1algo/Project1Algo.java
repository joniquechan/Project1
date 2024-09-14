/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project1algo;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class Project1Algo {
    // testing
    // function to generate random arrays
    private static int[] generateArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        
        // generate random int from 0-19
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(20);
        }
        return array;
    }

    public static void main(String[] args) {
        

        // test - insertion sort random data
        int[] arraytest = generateArray(20);
        System.out.println("unsorted: " + Arrays.toString(arraytest));
        long startTime = System.nanoTime();
        InsertionSort.sort(arraytest);
        long endTime = System.nanoTime();
        System.out.println("sorted: " + Arrays.toString(arraytest));
        long insertionSortTime = endTime - startTime;
        System.out.println("time (ns): " + insertionSortTime);


        // measure time for quicksort 1 pointer
        // measure time for quicksort 2 pointer
        // measure time for quicksort 1 pointer last pivot
        // measure time for quicksort 1 pointer median
        // measure time for quicksort 1 pointer median of 3
        // measure time for insertionsort random data
        // measure time for insertionsort reverse sorted data
        // measure time for insertionsort forward sorted data
        
        // function for generating graphs?
        // overall algorithm performance
        // partition algorithms
    }
}
