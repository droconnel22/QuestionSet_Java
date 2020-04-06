package com.contests;

import java.math.BigInteger;
import java.util.*;

public class Contest183 {
    public static void main(String...args){
        int[] nums = {4,3,10,9,8};
       // var example = new MinimumSubsequenceInNonIncreasingOrderAnswer();
        // example.minSubsequence(nums).forEach(System.out::println);
        var q2 = new NumberOfStepsToReduceANumberInBinaryRepresentationToOne1404();
        System.out.println(q2.numSteps("1101"));
    }
}

//subsequence of the array whose sum of elements is
// strictly greater than the sum of the non included elements
// in such subsequence.

//If there are multiple solutions, return the subsequence
// with minimum size and if there still exist multiple solutions,
// return the subsequence with the maximum total sum of all
// its elements.
// A subsequence of an array can be obtained by erasing some
// (possibly zero) elements from the array.
class MinimumSubsequenceInNonIncreasingOrder {

    class MyTuple implements Comparable<MyTuple>{
        Integer value;
        List<Integer> set;

        public MyTuple(Integer value, List<Integer> set) {
            this.value = value;
            this.set = set;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public List<Integer> getSet() {
            return set;
        }

        public void setSet(List<Integer> set) {
            this.set = set;
        }

        @Override
        public int compareTo(MyTuple o) {
            return this.value.compareTo(o.value);
        }
    }

    public List<Integer> minSubsequence(int[] nums) {
        return minSubsequence(nums,0,nums.length-1,null).set;

    }

    private MyTuple  minSubsequence(int[] nums, int low, int high,MyTuple maxPair){
        if(low > high){
            return maxPair;
        }
        int tempSum = 0;
        int antiSum =0;
        List<Integer> tempsequence = new ArrayList<>();
        for(int i = 0; i < nums.length;i++)
        {
            if(i >= low && i < high)
            {
                tempSum+= nums[i];
                tempsequence.add(nums[i]);
            } else {
                antiSum += nums[i];
            }
        }
        if(tempSum > antiSum && maxPair == null ) {
            maxPair = new MyTuple(tempSum,tempsequence);
        } else  if((tempSum > antiSum &&  tempsequence.size() < maxPair.set.size())) {
            maxPair = new MyTuple(tempSum,tempsequence);
        }

        MyTuple left =  minSubsequence(nums,low+1, high,maxPair);
        MyTuple right =   minSubsequence(nums,low+1,high-1,maxPair);
        if(left.set.size() < right.set.size()){
            return  left;
        } else {
            return right;
        }
    }
}

//Intuition: pick the largest number from the array and add it to subsequence.
// Repeat till the subsequence sum sub_sum is greater than the half
// of the total sum half_sum. Priority queue is the natural choice
// to pull largest numbers.
class MinimumSubsequenceInNonIncreasingOrderAnswer {
    public List<Integer> minSubsequence(int[] nums){
        List<Integer> results = new ArrayList<>();
        int maxSum =0, subSum  =0;
        var priorityQueue=
                new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums){
            maxSum += n;
            priorityQueue.offer(n);
        }

        while(subSum <= maxSum/2){
            results.add((Integer) priorityQueue.peek());
            subSum+= (Integer)priorityQueue.poll();
        }
        return results;
    }
}

// Given a number s in their binary representation.
// Return the number of steps to reduce it to 1 under the following rules:
// If the current number is even, you have to divide it by 2.
// If the current number is odd, you have to add 1 to it.
//It's guaranteed that you can always reach to one for all testcases.
// ex:
//  Input: s = "1101"
//        Output: 6
class NumberOfStepsToReduceANumberInBinaryRepresentationToOne1404 {
    public int numSteps(String s) {
        int steps = 0;
        BigInteger num = new BigInteger(s,2);
        while(!num.equals(BigInteger.ONE)) {
           // System.out.println(num);
            if(num.testBit(0)) {
               num = num.add(BigInteger.ONE);
            } else {
               num = num.shiftRight(BigInteger.ONE.intValue());
            }
            steps++;
        }
        return steps;
    }
}

//Intuition: division by two is the same as the right shift by one bit (character).
// If the bit is 0, we just do the shift - one operation.
// If the bit is 1 - we do plus one, and our bit changes to zero.
// So, we set carry to 1 and shift. Two operations.
//..The rest:
//        3A. Every 1 needs one operation (carry makes it 0). carry is still 1 due to addition.
//        3B. Every 0 needs two operations (carry makes it 1). carry is still 1 as we need to add 1 in this case.
class NumberOfStepsToReduceANumberInBinaryRepresentationToOne1404Answer{
    public int numSteps(String s) {
        int res = 0, carry = 0;
        for(int i = s.length()-1; i > 0; --i) {
            ++res;
            if(s.charAt(i) -'0' + carry==1) {
                carry =1;
                ++res;
            }
        }
        return res+carry;
    }
}

