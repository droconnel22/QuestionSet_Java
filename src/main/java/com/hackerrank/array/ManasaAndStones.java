package com.hackerrank.array;

import java.util.*;

import static java.lang.Integer.parseInt;

/*
Sample Input

2

3
1
2

4
10
100

Sample Output

2 3 4
30 120 210 300

200 234 268 302 336 370 404 438 472
200, 234, 268, 302, 336, 370, 404, 438, 472,

476

286 295 304 313 322 331 340 349 358 367 376 385
286, 295, 304, 313, 322, 331, 340, 349, 358, 367, 376, 385,
 */



public class ManasaAndStones {
    public static void main(String...args) throws  Exception{
        for(int i = 1; i < args.length; i+=3){
            int n = parseInt(args[i]);
            int a = parseInt(args[i+1]);
            int b = parseInt(args[i+2]);
            try {
                stones(n,a,b);
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    static Integer[] stones(int n, int a, int b) {
        //System.out.printf("\n %d %d %d",n,a,b);
        Set<Integer> set = calcInOrder(n,a,b,0,0,new HashSet<>());
        set.stream().sorted().forEach(i -> System.out.print(i + ", "));
        System.out.println();
        return set.stream().toArray(Integer[]::new);
    }

    static Set<Integer> calcInOrder(int n, int a, int b, int currentIndex, int currentValue, Set<Integer> memo){
        if(currentIndex == n-1){
            memo.add(currentValue);
            return memo;
        }

        // oh have i been here before, if so return answer,

        //memo
        Set<Integer> resultFromLeft =  calcInOrder(n,a, b,currentIndex+1, currentValue+a, memo);
        Set<Integer> resultFromRight =  calcInOrder(n,a,b, currentIndex+1,currentValue+b, memo);

        //return new memo
        resultFromLeft.addAll(resultFromRight);
        return resultFromLeft;
    }
}
