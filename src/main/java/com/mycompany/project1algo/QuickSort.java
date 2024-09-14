package com.mycompany.project1algo;

public class QuickSort {
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

    private static int twoPointerPartition(int[] arr, int low, int high, int pivot) {
        // find pivot val
        // intialize two pointers (left and right)
        // lopp until pointers meet
        // move left pointer right until < pivot
        // move right pointer left until > pivot
        // swap elements
    }

    private static int pivotType(int[] arr, int low, int high, int pivotType) {
        switch (pivotType) {
            // median
            case 1:
                return arr[(low + high) / 2];
            // median of three
            case 2:
                int mid = (low + high) / 2;
                int a = arr[low], b = arr[mid], c = arr[high];
                if ((a > b) == (a < c)) {
                    return a;
                }
                else if ((b > a) == (b < c)) {
                    return b;
                }
                else {
                    return c;
                }
            // last element
            default:
                return arr[high];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int low, int high, int pivot, int partition) {
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
        }
    }

    // overload function to make it easier :P
    public static void quickSort(int[] arr, int pivot, int partition) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high, pivot, partition);
    }
}
