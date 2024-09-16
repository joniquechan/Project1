package com.mycompany.project1algo;

import java.util.Random;
import java.io.*; 
import java.util.*; 
/**
 * This class creates .csv files for graphs.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Graph.java
 * Created: Sep 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class creates .csv files for graphs.
 */

public class Graph {
    
    //Checks to see if input array is sorted.
    private static boolean checkSorted(int[] arr){
        boolean sorted = true;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(prev > arr[i]){
                sorted = false;
                break;
            }
            prev = arr[i];
        }
        
        return sorted;
    }
    
    // method to generate random arrays
    private static int[] generateArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        
        // generate random int from 0-19
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }
    
    //method to generate sorted array
    private static int[] generateForwardSorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
    
    //method to generate reverse sorted array.
    private static int[] generateReverseSorted(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    
    //Runs insertion sort based on the range of array sizes you want and 
    //amount of runs you want to do to smooth the graph.
    public static void graphInsertion(int size, int runs){
        String[] list = new String[size];
        for(int i = 1; i <= size; i++){
            int average = 0;
            for(int j = 0; j < runs; j++){
                int[] arraytest = generateArray(i);;
                long startTime = System.nanoTime();
                InsertionSort.sort(arraytest);
                long endTime = System.nanoTime();
                average += endTime - startTime;
            }
            list[i - 1] = Long.toString(average/runs);
        }
        try{
            createCSV(list);
        }
        catch(Exception e){
            System.out.println("File error.");
        }
    }
    
    //Runs insertion sort based on the range of array sizes you want and 
    //amount of runs you want to do to smooth the graph. Also sorts presorted
    //arrays.
    public static void graphInsertion(int size, int runs, boolean sorted){
        ArrayList<String[]> list = new ArrayList();
        for(int i = 1; i <= size; i++){
            int random = 0;
            int forward = 0;
            int reverse = 0;
            for(int j = 0; j < runs; j++){
                int[] arraytest = generateArray(i);
                long startTime = System.nanoTime();
                InsertionSort.sort(arraytest);
                long endTime = System.nanoTime();
                random += endTime - startTime;
                
                arraytest = generateForwardSorted(i);
                startTime = System.nanoTime();
                InsertionSort.sort(arraytest);
                endTime = System.nanoTime();
                forward += endTime - startTime;
                
                arraytest = generateReverseSorted(i);
                startTime = System.nanoTime();
                InsertionSort.sort(arraytest);
                endTime = System.nanoTime();
                reverse += endTime - startTime;
            }
            String[] set = {Long.toString(random/runs), Long.toString(forward/runs), Long.toString(reverse/runs)};
            list.add(set);
        }
        try{
            createCSV(list, true);
        }
        catch(Exception e){
            System.out.println("File error.");
        }
    }
    
    //Runs quick sort based on the range of array sizes you want and amount of 
    //runs you want to do to smooth the graph.
    public static void graphQuickSort(int size, int pivot, int partition, int runs, int step){
        String[] list = new String[size/step];
        int index = 0;
        for(int i = 1; i <= size; i+= step){
            int average = 0;
            for(int j = 0; j < runs; j++){
                int[] arraytest = generateArray(i);;
                long startTime = System.nanoTime();
                QuickSort.quickSort(arraytest, pivot, partition);
                long endTime = System.nanoTime();
                average+= endTime - startTime;
            }
            list[index] = Long.toString(average/runs);
            index++;
        }
        try{
            createCSV(list, step);
        }
        catch(Exception e){
            System.out.println("File error.");
        }
    }
    
    //Runs quick sort based on the range of array sizes you want and amount of 
    //runs you want to do to smooth the graph. Also sorts presorted arrays.
    public static void graphQuickSort(int size, int pivot, int partition, int runs, int step, boolean sorted){
        ArrayList<String[]> list = new ArrayList();
        for(int i = 1; i <= size; i+= step){
            int random = 0;
            int forward = 0;
            int reverse = 0;
            for(int j = 0; j < runs; j++){
                int[] arraytest = generateArray(i);
                long startTime = System.nanoTime();
                QuickSort.quickSort(arraytest, pivot, partition);
                long endTime = System.nanoTime();
                random += endTime - startTime;
                
                arraytest = generateForwardSorted(i);
                startTime = System.nanoTime();
                QuickSort.quickSort(arraytest, pivot, partition);
                endTime = System.nanoTime();
                forward += endTime - startTime;
                
                arraytest = generateReverseSorted(i);
                startTime = System.nanoTime();
                QuickSort.quickSort(arraytest, pivot, partition);
                endTime = System.nanoTime();
                reverse += endTime - startTime;
            }
            String[] set = {Long.toString(random/runs), Long.toString(forward/runs), Long.toString(reverse/runs)};
            list.add(set);
        }
        try{
            createCSV(list, step, true);
        }
        catch(Exception e){
            System.out.println("File error.");
        }
    }
 
    //Creates csv file for quick sort
    private static void createCSV(String[] list, int step) throws IOException {
            FileWriter writer = new FileWriter("data.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i = 1; i <= list.length; i++){
                bw.write(i*step + ", " + list[i - 1]);   
                bw.newLine();
            }
            bw.close();
    }
    
    //Creates csv file for quick sort and for pre-sorted data
    public static void createCSV(ArrayList<String[]> list, int step, boolean sorted) throws IOException {
            FileWriter writer = new FileWriter("data.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i = 1; i <= list.size(); i++){
                String[] vals = list.get(i - 1);
                bw.write(i*step + ", " + vals[0] + ", " + vals[1] + ", " + vals[2]);   
                bw.newLine();
            }
            bw.close();
    }
    
    //Creates csv file for insertion sort.
    public static void createCSV(String[] list) throws IOException {
            FileWriter writer = new FileWriter("data.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i = 1; i <= list.length; i++){
                bw.write(i + ", " + list[i - 1]);   
                bw.newLine();
            }
            bw.close();
    }
    
    //Creates csv file for insertion sort and for pre-sorted data.
    public static void createCSV(ArrayList<String[]> list, boolean sorted) throws IOException {
            FileWriter writer = new FileWriter("data.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i = 1; i <= list.size(); i++){
                String[] vals = list.get(i - 1);
                bw.write(i + ", " + vals[0] + ", " + vals[1] + ", " + vals[2]);   
                bw.newLine();
            }
            bw.close();
    }
    
     
}
