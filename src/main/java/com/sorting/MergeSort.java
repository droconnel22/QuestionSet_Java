package com.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MergeSort<T extends  Comparable<T>> {

    public ArrayList<T> Sort(ArrayList<T> array){
        if(array.size() <=1){
            return  array;
        }

        int midpoint = array.size()/2;
        ArrayList<T> leftHalf = Sort(splitArray(array,0, midpoint));
        ArrayList<T> rightHalf = Sort(splitArray(array, midpoint, array.size()-1));
        return merge(leftHalf, rightHalf);
    }

    private ArrayList<T> splitArray(ArrayList<T> array, int left, int right) {
        int resultSize = right - left;
        ArrayList<T> resultArray = new ArrayList<>(resultSize);
        for(int i = left; i < right; i++){
            resultArray.add(array.get(i));
        }

        return resultArray;
    }

    private ArrayList<T> merge(ArrayList<T> leftArray, ArrayList<T> rightArray){

        int resultSize = leftArray.size() + rightArray.size();
        ArrayList<T> resultArray = new ArrayList<>(resultSize);
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int resultArrayIndex = 0;

        while(resultArrayIndex < resultSize){
            if(leftArrayIndex == leftArray.size() && rightArrayIndex < rightArray.size()) {
                resultArray.add(rightArray.get(rightArrayIndex));
                rightArrayIndex++;
            }
            else if(rightArrayIndex == rightArray.size() && leftArrayIndex < leftArray.size()){
                resultArray.add(leftArray.get(leftArrayIndex));
                leftArrayIndex++;
            }
            else if(leftArray.get(leftArrayIndex).compareTo(rightArray.get(rightArrayIndex)) <= 0) {
                resultArray.add(leftArray.get(leftArrayIndex));
                leftArrayIndex++;
            }
            else {
                resultArray.add(rightArray.get(rightArrayIndex));
                rightArrayIndex++;
            }
            resultArrayIndex++;
        }

        return resultArray;
    }


}
