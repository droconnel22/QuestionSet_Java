package com.dynamic;

public class CoinChange {

    /*
    Given a value N, if we want to make change for N cents,
    and we have infinite supply of each of S = { S1, S2, .. , Sm}
    valued coins, how many ways can we make the change?

    The order of coins doesn’t matter.
    For example, for N = 4 and S = {1,2,3},
    there are four solutions:
     {1,1,1,1},
     {1,1,2},
     {2,2},
     {1,3}.
     So output should be 4.

     For N = 10 and S = {2, 5, 3, 6},
     there are five solutions:
      {2,2,2,2,2},
       {2,2,3,3},
        {2,2,6},
        {2,3,5}
         and
          {5,5}.
           So the output should be 5.
     */
    public static void main(String...args) {
        int n = 10;
        int[] coins  = {2,5,3,6};
        int expected = 5;
        System.out.printf("Coin Change Expected: %d. Actual: %d",expected, makeChange(n,coins));
    }

    private static int makeChange(int n, int[] coins){
                return makeChange(n,coins,0);
    }

    private static int makeChange(int n, int[] coins, int index){
        // if we run out of coins
        if(index == coins.length){
            return  0;
        }

        // there was an overshot
        if(n < 0){
            return  0;
        }

        // if the change is exactly equal to 0
        if(n == 0){
            return 1;
        }

        // we either apply the change or we don't apply
        int applied = makeChange(n-coins[index],coins,index);
        int advanced = makeChange(n,coins,index+1);
        return applied + advanced;
    }
}
