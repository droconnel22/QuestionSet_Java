package com.crackingcodeinterview;

import java.util.Arrays;

public class MergeSort {



    public int[] mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }

        int midpoint = array.length/2;
        int[] leftArray = mergeSort(splitArray(array,0, midpoint));
        int[] rightArray = mergeSort(splitArray(array, midpoint, array.length));
        return merge(leftArray, rightArray);

    }

    private int[] splitArray(int[] array, int left, int right){
            int resultSize = right - left;
            int[] result = new int[resultSize];
            int resultIndex = 0;
            for(int i = left; i < right; i++){
                result[resultIndex] = array[i];
                resultIndex++;
            }
            return result;
    }

    private int[] merge(int[] leftArray, int[] rightArray){
        int resultSize = rightArray.length + leftArray.length;
        int[] resultArray =  new int[resultSize];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex =0;

        while(resultIndex < resultSize){

            if(leftIndex == leftArray.length && rightIndex < rightArray.length){
                resultArray[resultIndex] = rightArray[rightIndex];
                resultIndex++;
            }
            else if(rightIndex == rightArray.length && leftIndex < leftArray.length){
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else if(leftArray[leftIndex] <= rightArray[rightIndex]){
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                resultArray[resultIndex] = rightArray[rightIndex];
                rightIndex++;
            }

            resultIndex++;
        }

        System.out.println();
        for(int e : resultArray){
            System.out.print(" " + e);
        }
        System.out.println();
        return resultArray;
    }
}
