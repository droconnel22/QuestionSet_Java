package com.hackerrank.combinatrics;

/*
Given a number in the form of a list of digits, return all possible permutations.

For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].

1,2,3
1,3,2
2,1,3
2,3,1
3,1,2
3,2,1


1,2,3

2,1,3 [0,1]
1,3,2 [1,2]
2,3,1 [2,3]

*/

import java.util.Arrays;


public class Program {
    public static void main(String[] args){
        int[] array = {1,2,3};
        permutations(array,0,array.length-1);
    }

    private static void swap(int[] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void permutations(int[] array, int startIndex, int endIndex){
        if(startIndex < endIndex)
        {
            swap(array,startIndex,endIndex);
            System.out.println(Arrays.toString(array));
            permutations(array,startIndex, endIndex-1);
            permutations(array,startIndex+1, endIndex);
        }
    }
}
