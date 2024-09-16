package com.mycompany.project1algo;

/**
 * This class is the quick sort algorithm.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: QuickSort.java
 * Created: Sep 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is the quick sort algorithm. It has support for
 * multiple pivot indexes and 2 partitions algorithms. 
 */
public class QuickSort {
    //Algorithm for one pointer partition. Returns the index of the pivot.
    private static int onePointerPartition(int[] arr, int low, int high, int pivot) {
        int pivotVal = pivotType(arr, low, high, pivot);
        // pointer for tracking swapping position
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // swap smaller element to the front 
            if (arr[j] <= pivotVal) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    //Algorithm for two pointer partition. Returns the index of the pivot.
    private static int twoPointerPartition(int[] arr, int low, int high, int pivot) {
        // find pivot val and pivot index
        int pivotVal = pivotType(arr, low, high, pivot);
        int pivotIndex = pivotIndex(arr, low, high, pivot);
        // move pivot to the end of the array
        swap(arr, pivotIndex, high);
        // intialize two pointers (left and right)
        int lower = low;
        int upper = high - 1;
        // lopp until pointers meet
        while(lower <= upper){
            //move upper down until < pivot
            while(lower <= upper && arr[upper] >= pivotVal){
                upper--;
            }
            //move lower pointer up until > pivot
            while(lower <= upper && arr[lower] <= pivotVal){
                lower++;
            }
            //swap elements
            if(lower < upper){
                swap(arr, lower, upper);
            }
        }       
        //move pivot back to the middle of array
        swap(arr, lower, high);
        return lower;
    }
    
    //Finds pivot index depending on last, median, or median of 3. 
    private static int pivotIndex(int[] arr, int low, int high, int pivotType){
        switch (pivotType) {
            // median
            case 1:
                return (low + high) / 2;
            // median of three
            case 2:
                int mid = (low + high) / 2;
                int a = arr[low], b = arr[mid], c = arr[high];
                int median = Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
                if(a == median){
                    return low;
                }
                else if(b == median){
                    return mid;
                }
                else{
                    return high;
                }
                     
            // last element
            default:
                return high;
        }
    }
    
    //Finds pivot value depending on last, median, or median of 3.
    private static int pivotType(int[] arr, int low, int high, int pivotType) {
        switch (pivotType) {
            // median
            case 1:
                return arr[(low + high) / 2];
            // median of three
            case 2:
                int mid = (low + high) / 2;
                int a = arr[low], b = arr[mid], c = arr[high];
                return Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
            // last element
            default:
                return arr[high];
        }
    }

    //swaps 2 elements in the array.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Recursive quickSort method.
    private static void quickSort(int[] arr, int low, int high, int pivot, int partition) {
        // for pivot, 0 = last, 1 = median, 2 = median of 3
        // for partition, 1 = 1 pointer method, 2 = two pointer method
        // FIX THIS
        int pivotIndex;
        if (low < high && partition == 1) {
            // get pivot
            pivotIndex = onePointerPartition(arr, low, high, pivot);
            quickSort(arr, low, pivotIndex - 1, pivot, partition);
            quickSort(arr, pivotIndex + 1, high, pivot, partition);
        } 
        else if (low < high && partition == 2) {
            // get pivot 
            pivotIndex = twoPointerPartition(arr, low, high, pivot);
            quickSort(arr, low, pivotIndex - 1, pivot, partition);
            quickSort(arr, pivotIndex + 1, high, pivot, partition);
        }
    }

    // Initial quickSort method called in other files.
    public static void quickSort(int[] arr, int pivot, int partition) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high, pivot, partition);
    }
}
