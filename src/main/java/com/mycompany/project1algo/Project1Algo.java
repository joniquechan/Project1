package com.mycompany.project1algo;

/**
 *
 * @author User
 */
public class Project1Algo {

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

    public static void main(String[] args) {
        Graph g = new Graph();
    }
}
