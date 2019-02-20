package com.deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class MaxContinousUnique {
    public Integer GetMax(Integer[] array, int span){
        Deque deque = new LinkedList<Integer>();
        for(Integer elm  : array){
            deque.addLast(elm);
        }

        int indexLeft = 0;
        int indexRight = array.length-1;

        int maxSize = -1;

        while(indexLeft + span <= indexRight-span){
            HashSet<Integer> leftHash = new HashSet<>();
            HashSet<Integer> rightHash = new HashSet<>();

            for(int i = indexLeft; i < indexLeft+span; i++){
                leftHash.add(array[i]);
            }

            for(int j = indexRight; j >= indexRight-span; j--){
                rightHash.add(array[j]);
            }

            int temp =  Math.max(leftHash.size(), rightHash.size());
            if(maxSize == -1 || temp > maxSize){
                maxSize = temp;
            }

            indexLeft++;
            indexRight--;

        }
        return  maxSize;
    }

    public int GetMaxR(ArrayList<Integer> array, int span){
        if(array.size() <= span){
            return new HashSet<Integer>(array).size();
        }

        int midpoint = array.size()/2;
        int leftMax = GetMaxR(splitArray(array,0,midpoint), span);
        int rightMax = GetMaxR(splitArray(array, midpoint, array.size()-1),span);
        return Math.max(leftMax, rightMax);

    }

    private ArrayList<Integer> splitArray(ArrayList<Integer> array, int left, int right){

        ArrayList<Integer> resultArray = new ArrayList<>();
        int resultIndex = 0;
        for(int i = left; i < right; i++){
            resultArray.add(array.get(i));
            resultIndex++;
        }
        return  resultArray;

    }


}
