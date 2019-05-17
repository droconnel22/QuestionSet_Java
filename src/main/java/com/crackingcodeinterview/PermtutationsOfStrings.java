package com.crackingcodeinterview;

import java.util.HashSet;

public class PermtutationsOfStrings {

    public void ScenarioOne(){
        String input= "abbccd";
        int size = 2;
        HashSet<String> set = new HashSet<>();
        Permutate(input,size,0, input.length()-1, set);
    }

    public void Permutate(String input, int size, int left, int right, HashSet<String> set){
        if(left < right){
            String current = input.substring(left, right);
            if(current.length() == size && !set.contains(current)){
                set.add(current);
                System.out.println(current);
            }

            String next = swap(input,left, right);
            Permutate(next,size,left, right-1, set);
            Permutate(next, size, left+1, right,set);
        }
    }


    private String swap(String input, int i, int j){
        char[] arr = input.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return  new String(arr);
    }
}
