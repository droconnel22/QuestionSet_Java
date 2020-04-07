package com.contests;

import java.util.HashMap;
import java.util.Map;

public class Contest182 {

    // 1394. Find Lucky Integer in an Array
    /*
        Given an array of integers arr, a lucky integer
        is an integer which has a frequency in the array
        equal to its value.

        Return a lucky integer in the array. If there are
        multiple lucky integers return the largest of them.
        If there is no lucky integer return -1

        Input: arr = [2,2,3,4]
        Output: 2
        Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
     */
    public int findLucky(int[] arr) {
        Map<Integer,Integer> memo = new HashMap<>();
        for(int num : arr){
            if(memo.containsKey(num)){
                memo.put(num, memo.get(num)+1);
            } else {
                memo.put(num,1);
            }
        }

        return memo
                .entrySet()
                .stream()
                .filter(es -> es.getKey().equals(es.getValue()))
                .map(Map.Entry::getKey)
                .max(Integer::compareTo)
                .orElse(-1);
    }


    // 1395. Count Number of Teams
    /*
        // There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
        // You have to form a team of 3 soldiers amongst them under the following rules:
        //
        //Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
        //A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
        //Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

        Input: rating = [2,5,3,4,1]
        Output: 3
        Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).

        Input: rating = [2,1,3]
        Output: 0
        Explanation: We can't form any team given the conditions.

        Input: rating = [1,2,3,4]
        Output: 4

        n == rating.length
        1 <= n <= 200
        1 <= rating[i] <= 10^5
     */
    public int numTeams(int[] rating) {
        int count = 0;

        int i = 0;
        int j = rating.length/2;
        int k = rating.length-1;

        while(i < j&& j < k){





        }
        return  count;

    }

}
