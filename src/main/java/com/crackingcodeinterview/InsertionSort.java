package com.crackingcodeinterview;

public class InsertionSort {

    public int[] sort(int[] array){
        for(int i = 0; i < array.length; i++){
            int j = i;
            while(j > 0){
                if(array[j] < array[j-1]){
                    swap(array, j, j-1);
                }
                j--;
            }
        }
        return array;
    }

    private void swap(int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}