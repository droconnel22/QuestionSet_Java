package com.hackerrank.search;

public class FIndTheSquareRoot {
    public static void main(String...args){
        int[] scenarios = {2147395599,1024,4,8,36,10,1,0};
        for(int s : scenarios)
        {
            System.out.println("Square root of " + s+ " is " + squareRoot2(s));
        }

    }

    private static int squareRoot(int x)
    {
        if(x <2 ){
            return  x;
        }
        int low = 0;
        int high= x/2;
        while(low <= high) {
            int midpoint = (high-low)/2+low;
            long midpointSquaredValue = midpoint*midpoint;
            if(midpointSquaredValue < x)  {
                low = midpoint+1;
            }
            else if(midpointSquaredValue > x) {
                high = midpoint-1;
            }
            else {
                return midpoint;
            }
        }
        return Math.min(low,high);
    }

    private static int squareRoot2(int x){
        if(x <2) return x;
        int left = squareRoot2(x >> 2) << 1;
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}
