package com.hackerrank.array.twoarrays;

import com.sorting.QuickSort;

import java.util.Arrays;
import java.util.List;
import  static java.util.Collections.swap;

public class TwoArrays {
    public static String Solve(int k, int[] A, int[] B){
        int[] sortedA = QuickSort.Sort(A, 0, A.length-1);
        int[] sortedB = QuickSort.Sort(B, 0, B.length-1);

        int index = 0;
        while(index < sortedA.length && index < sortedB.length && sortedA[index] + sortedB[index] >=k) {
            System.out.println("Comparing " + index + " A: " + sortedA[index] + " B: " + sortedB[index]);
            index++;
        }

        return  index == A.length ? "YES" : "NO";

    }

    public void PermutateArray(List<Integer> array, int currentIndex){
        for(int i = currentIndex; i <array.size(); i++){
            swap(array, i, currentIndex);
            PermutateArray(array, currentIndex+1);
            swap(array, i, currentIndex);
        }

        if(currentIndex == array.size()-1){
            System.out.println(Arrays.toString(array.toArray()));
        }
    }
}
