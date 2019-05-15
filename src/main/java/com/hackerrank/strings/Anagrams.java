package com.hackerrank.strings;

import java.util.Arrays;

public class Anagrams {
    public static void main(String... args){

        String a ="anagram";
        String b ="margana";

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        boolean result =  java.util.Arrays.equals(arrayA, arrayB);
        System.out.println(result);
    }
}
