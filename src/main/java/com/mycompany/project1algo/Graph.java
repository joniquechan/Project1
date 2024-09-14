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
        
        try{
            createCSV(graphInsertion());
        }
        catch(Exception e){
            
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
    
    private static String[] graphInsertion(){
        String[] list = new String[10000];
        for(int i = 1; i <= 10000; i++){
            int[] arraytest = generateArray(i);;
            long startTime = System.nanoTime();
            QuickSort.quickSort(arraytest, 3, 1);
            long endTime = System.nanoTime();
            list[i - 1] = Long.toString(endTime - startTime);
        }
        return list;
    }
 
    
    public static void createCSV(String[] list) throws IOException {
            FileWriter writer = new FileWriter("C:/Users/ronie/OneDrive/Documents/Cedarville/Fall-2024/CS-3410/Project 1/csv1.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i = 1; i <= list.length; i++){
                bw.write(i + ", " + list[i - 1]);   
                bw.newLine();
            }
            bw.close();
    }
}
