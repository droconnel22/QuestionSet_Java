package com.hackerrank.search;


/*
* https://www.hackerrank.com/challenges/icecream-parlor/problem
*
* Sunny and Johnny like to pool their money and go to the ice cream parlor.
*
*  Johnny never buys the same flavor that Sunny does.
*
*  The only other rule they have is that they spend all of their money.
*
*  Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
*
*  m = 6 to spend
*
*  flavors costing cost = [1,3,4,5,6]
*
*  The two flavors costing 1 and 5 meet the criteria.
*
*  t should return an array containing the indices of the prices of the two flavors they buy, sorted ascending.
*
*  r = [0,3]

 */

import java.util.*;

public class IceCreamParlor {

    public Integer[] Purchase(ArrayList<Integer> costs, Integer allowance) {
        // 1. Sort In Descending Order

        // 2. Go to the first value lower then allowance.

        // 3. Go to the first value that matches difference / if none met reset to next lowest.

        // only take first O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < costs.size(); i++) {
            map.put(costs.get(i),i);
        }

        // O (N)
        for(int i = 0; i < costs.size(); i++) {
            int remaining = allowance - costs.get(i);
            if(map.containsKey(remaining)) {
                if(map.get(remaining) != i) {
                    Integer[] array = {i+1, map.get(remaining)+1};
                    Arrays.sort(array);
                    return array;
                }
            }
        }

        return new Integer[]{};
    }




}

/**
 int currentCostIndex = 0;
 while(currentCostIndex < costs.size()){
 if(costs.get(currentCostIndex) < allowance) {
 int nextCostIndex = currentCostIndex+1;
 int remaining = allowance - costs.get(currentCostIndex);
 //  select the two -> doesnt work they are the same...
 while(nextCostIndex < costs.size()){
 if(remaining == costs.get(nextCostIndex)) {
 return new Integer[]{
 map.get(costs.get(nextCostIndex))+1,
 map.get(costs.get(currentCostIndex))+1
 };
 }
 nextCostIndex++;
 }
 }
 currentCostIndex++;
 }
 return new Integer[]{};

 */