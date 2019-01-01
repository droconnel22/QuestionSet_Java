package com.dailycoding.google;


/*
Problem # 35
Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so
 that all the Rs come first, the Gs come second, and the Bs come last.

 You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */

// start with some form of quick sort, could do reverse lexigraphical order.


public class RGBArray {

    public char[] QuickSort(char[] array,int low, int high) {
        if(low <= high) {
            int guess = (low + high) /2;
            int pivotIndex = partition(array,low, high, guess);
            QuickSort(array, low, pivotIndex-1);
            QuickSort(array, pivotIndex+1, high);
        }
        return array;
    }

    private int partition(char[] array, int low, int high, int pivot) {

        char value = array[pivot];

        swap(array,pivot, high);
        int i = low;
        int j = high;
        Boolean inProgress = true;
        while(inProgress) {
            while(array[i] > value && i < j){
                i++;
            }
            while(array[j] <= value && i < j){
                j--;
            }

            if(i < j) {
                swap(array,i,j);
            } else {
                inProgress = false;
            }
        }

        int pivotIndex = i;
        swap(array, high,pivotIndex);
        return pivotIndex;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
