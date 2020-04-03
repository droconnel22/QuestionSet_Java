package com.binarySearch;

import java.util.List;

/*
A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
 */
public class FindPeakElement {

    private static class Scenario {
        private int[] nums;
        private int expected;

        public Scenario(int expected, int... nums) {
            this.nums = nums;
            this.expected = expected;
        }

        public int[] getNums() {
            return nums;
        }

        public int getExpected() {
            return expected;
        }
    }

    public static void main(String...args) throws Exception {
        var scenarios =
                List.of(
                        new Scenario(1,1,2),
                        new Scenario(2,1,2,3,1),
                        new Scenario(5,1,2,1,3,5,6,4)
                        );
        scenarios
                .forEach(s ->
                        System.out.printf(
                                "\n Expected %d | Actual: %d",
                                s.getExpected(),
                                findPeakElement(s.getNums()))
                );
    }

    //Your solution should be in logarithmic complexity.
    private static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            int midpoint = (high-low)/2+low;
            if(nums[midpoint] > nums[midpoint+1]) {
               high = midpoint;
            } else {
                low = midpoint+1;
            }
        }
        return low;
    }

}
