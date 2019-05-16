package com.sorting;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static int[] Sort(int[] array, int left, int right){
        if(left <= right){
            int pivotHeuristic = getHeuristic(left, right);
            int pivotIndex = partition(array,left, right, pivotHeuristic);
            Sort(array,left, pivotIndex-1);
            Sort(array,pivotIndex+1, right);
        }
        return array;
    }

    private static int getHeuristic(int a, int b){
        return ThreadLocalRandom.current().nextInt(a, b+1);
    }

    private  static int partition(int[] array, int left, int right, int pivotHeuristic){
        int pivotValue = array[pivotHeuristic];
        swap(array,right,pivotHeuristic);

        boolean inProgress = true;

        int i = left;
        int j = right;

        while(inProgress){
            while(i < j && array[i] <= pivotValue){
                i++;
            }

            while(i <j && array[j] > pivotValue){
                j--;
            }

            if(i <= j){
                swap(array,i,j);
            } else {
                inProgress = false;
            }
        }

        int pivotIndex = i;
        swap(array,pivotIndex,right);
        return pivotIndex;
    }

    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
