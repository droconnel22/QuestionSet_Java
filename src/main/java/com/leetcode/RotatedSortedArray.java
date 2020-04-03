package com.leetcode;

public class RotatedSortedArray {
    public static void main(String...args) throws Exception {
       final int[] nums = {4,5,6,7,0,1,2};
       final int target = 0;
       final int expected = 4;
        System.out.printf("\n Expected: %d Actual: %d \n",
                expected,
                search(nums,target));
        final int expected2 = -1;
        final int target2 = 3;
        System.out.printf("\n Expected: %d Actual: %d \n",
                expected2,
                search(nums,target2));
        final int[] num2 = {1,3,5};
        int target3 = 3;
        int expected3 = 1;
        System.out.printf("\n Expected: %d Actual: %d \n",
                expected3,
                search(num2,target3));

        int target4 = 5;
        int expected4 = 2;
        System.out.printf("\n Expected: %d Actual: %d \n",
                expected4,
                search(num2,target4));

        final int[] nums3 = {4,5,6,7,8,1,2,3};
        int target5 = 8;
        int expected5 = 4;
        System.out.printf("\n Expected: %d Actual: %d \n",
                expected5,
                search(nums3,target5));
    }

    // [4,5,6,7,0,1,2] target = 1
    private static Integer search(int[] nums, int target) {


        int low= 0;
        int high =nums.length-1;

        while(low <= high) {
            int midpoint = (high-low)/2+low;
            if(nums[midpoint] == target)
            {
                return  midpoint;
            }
            if(nums[midpoint] >= nums[low] ) {
               if(nums[low] <= target && target < nums[midpoint]) {
                   high = midpoint-1;
               } else {
                   low  = midpoint+1;
               }
            }
            else
            {
                if(target <= nums[high] && target > nums[midpoint]) {
                    low = midpoint+1;
                } else {
                    high = midpoint-1;
                }
            }
        }

        return -1;
    }
}
