package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Factorial {
    public static void main(String...args) {

        for(Integer num :  Arrays.asList(1,2,3,4,5,10,20)) {
            long factorial = factor(num);
            System.out.println(factorial);
        }

    }

    private static Map<Integer,Long> memo = new HashMap<>();

    private static long factor(int num) {
        if(num < 1) return 1;

        if(memo.containsKey(num))
        {
            return  memo.get(num);
        } else {
           long result = num*factor(num-1);
           memo.put(num,result);
           return result;
        }
    }
}
