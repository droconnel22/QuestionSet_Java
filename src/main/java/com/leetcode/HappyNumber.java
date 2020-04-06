package com.leetcode;

/*
Write an algo to determine if a number is happy

A happy number is a number defined by the following process:
-Starting with any positive integer,
- replace the number by the sum of the squares of its digits,
- and repeat the process until the number equals 1 (where it will stay)
- or it loops endlessly in a cycle which does not include 1
- Those numbers for which this process ends in 1 are happy numbers.

Input 19
Expected True
1^2 9^2 = 82
64 4 = 68
36 64 =  100
1 0 0 = 1
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String...args) {
        System.out.println(isHappy(45));
    }

    public static boolean isHappy(int n) {
        try {

            Set<Integer> memeo = new HashSet<>();
            while(true){
                if(memeo.contains(n)){
                    return false;
                }
                memeo.add(n);
                n = splitNumberAndSquare(n);
                if(n ==1) {
                    return true;
                }
            }
        }catch (StackOverflowError ex) {
            return false;
        }
    }

    private static int splitNumberAndSquare(int n) {
        return Arrays.stream(Integer.toString(n)
                    .split(""))
                    .mapToInt(Integer::parseInt)
                    .map(i -> i*i)
                    .reduce(0, (total,current) -> total+=current);
    }
}

