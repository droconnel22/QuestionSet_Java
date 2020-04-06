package com.crackingcodeinterview;


import java.util.HashMap;
import java.util.HashSet;

/*

Given a value N, if we want to make change for N cents,
 and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change?

The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3},
 there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 So output should be 4.

 For N = 10 and S = {2, 5, 3, 6},
  there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
  So the output should be 5.



 */
public class CoinChangeProblem {

    public void ScenarioOne(){
        int N = 4;
        int[] s = {1,2,3};
        int output = makeChange(N, s, 0, new HashMap<>());
        System.out.printf("Actual: %d Expected %d \n", output,4);
    }

    public void ScenarioTwo(){
        int N = 10;
        int[] s= {2,5,3,6};
        int output = makeChange(N, s, 0, new HashMap<>());
        System.out.printf("Actual: %d Expected %d \n", output,5);
    }

    public int makeChange(int n, int[] s, int currentCoin,  HashMap<String,Integer> memo){

        // over shot
        if(n < 0){
            return 0;
        }

        // nice!
        if(n == 0){
            return  1;
        }

        // ran out coins.
        if(currentCoin == s.length){
            return  0;
        }

        String key = n+"-"+currentCoin;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int ways = makeChange(n-s[currentCoin],s,currentCoin, memo)
                + makeChange(n,s, currentCoin+1, memo);
        memo.put(key,ways);
        return ways;
    }

}
