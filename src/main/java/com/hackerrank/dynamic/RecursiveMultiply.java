package com.hackerrank.dynamic;

/*
Recursive Multiply
Write a recursive function to multiply two positive integers
wihtout using the * operator or / operationr.

You can use addition,sub, and bit shifting but you should
minimize the number of operations.

what does it really mean to do something,
even when its obvious
 */

public class RecursiveMultiply {
    public static void main(String...args){
        // two positive integers
        System.out.println(multiplyR(333,100));
    }

    private static int multiplyBF(int a, int b){

        if(a == 0 || b == 0){
            return  0;
        }
        if(a == 1){
            return  b;
        }
        if(b == 1){
            return  a;
        }
        int result = 0;
        int smaller = a < b ? a : b;
        int larger = a > b ? a : b;
        boolean isOdd = smaller % 2 != 0;

        // divide by 2
        // but only does this once
        // leaving more performance opt on the table
        int size = smaller>>1;
        while(size-->0){
            result +=larger;
        }
        result*=2;
        if(isOdd){
             result+= larger;
        }

        return  result;
    }

    private static int multiplyR(int a, int b){
        int smaller = a < b ? a : b;
        int larger = a > b ? a : b;

        return multiplyRHelper(smaller,larger);
    }

    private static int multiplyRHelper(int smaller, int larger){
        if(smaller == 0)
            return  smaller;
        if(smaller == 1)
            return larger;

        // keep dividing by 2 for O(log N)
        int split = smaller >> 1;
        int result = multiplyRHelper(split,larger);
        boolean isOdd = smaller % 2 != 0;
        result*=2;
        if(isOdd){
            result+= larger;
        }

        return  result;
    }
}
