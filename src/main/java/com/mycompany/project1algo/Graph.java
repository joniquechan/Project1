/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1algo;

import java.util.Random;
import java.io.*; 
import java.util.*; 
/**
 *
 * @author ronie
 */
public class Graph {
    
    public Graph(){
        
        try {
            createCSV(graphQuickSort(1000000, 3, 2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // function to generate random arrays
    private static int[] generateArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        
        // generate random int from 0-19
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }

    private static int[] generateForwardSorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] generateReverseSorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    
    private static String[] graphInsertion(int size){
        String[] list = new String[size];
        for(int i = 1; i <= size; i++){
            int[] arraytest = generateArray(i);;
            long startTime = System.nanoTime();
            InsertionSort.sort(arraytest);
            long endTime = System.nanoTime();
            list[i - 1] = Long.toString(endTime - startTime);
        }
        return list;
    }
    
    private static String[] graphQuickSort(int size, int pivot, int partition){
        String[] list = new String[size/1000];
        int index = 0;
        for(int i = 1; i <= size; i+= 1000){
            int[] arraytest = generateArray(i);;
            long startTime = System.nanoTime();
            QuickSort.quickSort(arraytest, pivot, partition);
            long endTime = System.nanoTime();
            list[index] = Long.toString(endTime - startTime);
            index++;
        }
        return list;
    }
 
    
    public static void createCSV(String[] list) throws IOException {
            FileWriter writer = new FileWriter("data.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i = 1; i <= list.length; i++){
                bw.write(i*1000 + ", " + list[i - 1]);   
                bw.newLine();
            }
            bw.close();
    }
}
