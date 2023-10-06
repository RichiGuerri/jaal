package com.example.jaal.m1.s08;

public class NewBinarySearch {
    
    public static int iterative(int[] array, int target) {
        int rightIndex = array.length - 1;
        int leftIndex = 0;
        
        while (leftIndex <= rightIndex) {
            int mediumIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (array[mediumIndex] == target) {
                return mediumIndex;
            } else if (target > array[mediumIndex]) {
                leftIndex = mediumIndex + 1;
            } else if (target < array[mediumIndex]) {
                rightIndex = mediumIndex - 1;
            }
        }
        return -1;
    }

    public static boolean recursive(int[] arr, int start, int end, int target){
        int index = start + ((end - start)/2);
        if(start >= end) return false;
        else if(arr[index] == target) return true;
        else if(arr[index] > target){
            end = index;
            return recursive(arr, start, end, target);
        } else {
            start = index;
            return recursive(arr, start, end, target);
        }
    }
    
    public static void main(String[] args) {
        int[] array = { -36, -24, -14, 0, 52, 61, 77, 84, 98, 102 };

        int target = 0;
        iterative(array, target);
    }
}
