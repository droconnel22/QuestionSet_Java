package com.crackingcodeinterview;


import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public void Sort(int[] array){
         sort(array,0, array.length-1);
    }

    private void sort(int[] array, int left, int right){

        if(left < right){
            int pivotIndexHeuristic = ThreadLocalRandom.current().nextInt(left, right+1);
            int pivotIndex = partitation(array,left, right, pivotIndexHeuristic);
            sort(array,left, pivotIndex-1);
            sort(array, pivotIndex+1, right);
        }
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int partitation(int[] array, int i, int j, int heuristicParitionIndex){

        int pivotValue = array[heuristicParitionIndex];

        while(i <= j){
            while(array[i] < pivotValue){
                i++;
            }

            while(array[j] > pivotValue) {
                j--;
            }

            if(i < j){
                swap(array,i, j);
                i++;
                j--;
            }
        }

        return i;
    }
}
