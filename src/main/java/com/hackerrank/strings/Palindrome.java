package com.hackerrank.strings;

public class Palindrome {
    public static void main(String... args){
        String s = "java";
        char[] arr = s.toCharArray();

        String result = "Yes";
        for(int i = 0; i < s.length()/2; i++){
            if(arr[i]  != arr[s.length()-1-i]){
                result = "No";
                break;
            }
        }

        System.out.println(result);
    }
}
