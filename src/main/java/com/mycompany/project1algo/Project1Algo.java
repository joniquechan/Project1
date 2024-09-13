/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project1algo;

import java.util.Random;

/**
 *
 * @author User
 */
public class Project1Algo {

    public static void main(String[] args) {
        int size = 10000;
        int[] array = new int[size];
        Random rand = new Random();

        // generate random int from 0-100000
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000);
        }

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
