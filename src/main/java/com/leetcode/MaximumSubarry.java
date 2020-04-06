package com.leetcode;

import java.util.Arrays;

public class MaximumSubarry {
    public static void main(String...args) {
        int[] arr= {-1,-2};
        System.out.println("Result is " + maxSubArrayLinear(arr));
    }

    public static int maxSubArray(int[] nums) {
        return maxSubArray(nums,0,nums.length,Integer.MIN_VALUE);
    }

    // divide and conquer
    private static int maxSubArray(int[] nums, int low, int high,int sum) {
        if( low >= high) {
            return sum;
        }

        int tempSum = 0;
        for(int i = low; i < high;i++){
            tempSum += nums[i];
        }
        if(tempSum > sum)
        {
            sum = tempSum;
        }
        return Math.max(maxSubArray(nums,low, high-1,sum),maxSubArray(nums,low+1, high,sum));
    }


    // linear approach o(N)
    public static int maxSubArrayLinear(int[] nums) {
        int currentSum = nums[0];
        int maxSum =currentSum;
        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(maxSum,currentSum);
        }

        return maxSum;
    }

}
