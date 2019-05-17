package com.crackingcodeinterview;

import java.util.Arrays;
import java.util.HashSet;

public class StringPermutations {

    public void ScenarioOne(){
        String input = "supercalifragilisticexpialidocious";
        int size = 3;

        HashSet<String> samples = new HashSet<>();

        PrintPermutations(input,0, input.length()-1,size,samples);
    }

    private void PrintPermutations(String input, int startIndex, int endIndex, int size, HashSet<String> sampls){
        if(startIndex < endIndex){
            String current = input.substring(startIndex,endIndex);
            if(current.length() == size) {
                if(!sampls.contains(current)){
                    sampls.add(current);
                    System.out.println(current);
                }
            }

            swap(input,startIndex, endIndex);
            PrintPermutations(input, startIndex, endIndex-1,size,sampls);
            PrintPermutations(input,startIndex+1, endIndex,size,sampls);
        }
    }

    private String swap(String input, int i , int j){
        char[] array = input.toCharArray();
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return new String(array);
    }
}
