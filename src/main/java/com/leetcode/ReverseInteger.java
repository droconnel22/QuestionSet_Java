package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseInteger {
    public static void main(String...args) throws Exception {
        int[]arr = {1534236469,-10,-123,123,120,0,10};
        Arrays.stream(arr).forEach(i -> System.out.println(i +" : "+ reverse2(i)));
    }

    public static int reverse(int x) {
        char[] arr = Integer.toString(x).toCharArray();
        List<Character> result = new ArrayList<>();
        int i = 0;
        if(arr[i] == '-') {
            result.add(arr[i]);
            i = 1;
        }
        int j = arr.length-1;
        while(j >= i)
        {
            result.add(arr[j]);
            j--;
        }
        String numResult = result.stream().map(String::valueOf).collect(Collectors.joining());
        try {
            return Integer.parseInt(numResult);
        }catch (Exception ex) {
            return 0;
        }
    }

    public static int reverse2(int x) {
        String ans = x < 0 ?
                new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }

    }
}
