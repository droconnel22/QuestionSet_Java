package com.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Given a non-empty array of integers, every element appears
twice except for one. Find that single one.

Given a non-empty array of integers, every element
appears twice except for one. Find that single one.
 */

public class SingleNumber {
    public static void main(String...args) throws Exception {
       // var bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //final String line = bufferedReader.readLine();
        //System.out.println("Hello line: " + line);
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));

    }

    public static int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}
