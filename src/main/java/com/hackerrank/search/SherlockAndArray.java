package com.hackerrank.search;

import java.util.HashSet;
import java.util.Set;

public class SherlockAndArray {

    public String balancedSums(int[] array){
        boolean criterionMet = balancedSums(array,0, array.length-1, new HashSet<>());
        return  criterionMet ? "YES" : "NO";
    }

    private boolean balancedSums(int[] array, int low, int high, Set<Integer> searchedIndex) {

        if (low > high) {
            return  false;
        }

        int midpoint = (low+high)/2;
        if(searchedIndex.contains(midpoint)){
            return false;
        }

        searchedIndex.add(midpoint);

        int leftSum = getLeftSum(array,midpoint);
        int rightSum = getRightSum(array,midpoint);

        if(leftSum == rightSum){
            return true;
        } else if(leftSum > rightSum){
            return balancedSums(array,low,midpoint-1, searchedIndex);
        } else {
            return balancedSums(array,midpoint+1, high, searchedIndex);
        }
    }

    private int getLeftSum(int[] array, int midpoint){
        int sum = 0;
        for(int i = 0; i < midpoint; i++){
            sum += array[i];
        }
        return sum;
    }

    private int getRightSum(int[] array, int midpoint){
        int sum = 0;
        for(int i = midpoint+1; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
}
