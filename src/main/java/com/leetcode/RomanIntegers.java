package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanIntegers {
    public static void main(String ... args) throws Exception {

        // written largest to smallest from left to right

        // IV -> 5
        // IX -> 9
        // XL -> 40
        // XC -> 90
        // CD -> 400
        // CM -> 900

        String[] examples = {"III","IV","IX","LVIII","MCMXCIV"};
        Arrays.stream(examples).forEach(i ->System.out.println(convert(i)));
    }

    private static long convert(String input){
        int index =0;
        char[] sequence= input.toCharArray();

        Map<Character ,Integer> d = new HashMap<>();
        d.put('I',1);
        d.put('V',5);
        d.put('X',10);
        d.put('L',50);
        d.put('C',100);
        d.put('D',500);
        d.put('M',1000);

        Map<String, Integer> exceptions = new HashMap<>();
        exceptions.put("IV",4);
        exceptions.put("IX",9);
        exceptions.put("XL",40);
        exceptions.put("XC",90);
        exceptions.put("CD",400);
        exceptions.put("CM",900);


        Long result =0L;
        while(index < sequence.length-1){

           StringBuilder tester = new StringBuilder();
           tester.append(sequence[index]);
           tester.append(sequence[index+1]);
           if(exceptions.containsKey(tester.toString())) {
               result += exceptions.get(tester.toString());
               index+=2;
           } else {
                if(d.containsKey(sequence[index]))
                {
                    result += d.get(sequence[index]);
                    index++;
                }
           }
        }

        int last =sequence.length-1;
        if(index < sequence.length &&  d.containsKey(sequence[last]))
        {
            result += d.get(sequence[last]);
        }

        return result;
    }
}
