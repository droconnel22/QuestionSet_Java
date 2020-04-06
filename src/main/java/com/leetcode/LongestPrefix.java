package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String result = "";
        for(int i = 0; i < strs.length-1; i++){
            char[] first = strs[i].toCharArray();
            char[] second = strs[i+1].toCharArray();

            String temp = "";
            int prefixIndex = 0;
            while (prefixIndex < first.length && prefixIndex < second.length &&
                    first[prefixIndex] == second[prefixIndex])
            {
                temp += first[prefixIndex];
                prefixIndex++;
            }

            System.out.println(temp);
            if(temp.length() > result.length()){
                result = temp;
            }
        }
        return result;
    }
}



