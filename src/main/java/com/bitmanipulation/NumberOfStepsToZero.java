package com.bitmanipulation;

public class NumberOfStepsToZero {
    /*
    Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

    Input: num = 14
    Output: 6
    Explanation:
    Step 1) 14 is even; divide by 2 and obtain 7.
    Step 2) 7 is odd; subtract 1 and obtain 6.
    Step 3) 6 is even; divide by 2 and obtain 3.
    Step 4) 3 is odd; subtract 1 and obtain 2.
    Step 5) 2 is even; divide by 2 and obtain 1.
    Step 6) 1 is odd; subtract 1 and obtain 0.
     */

    public static void main(String...args) {
            var c= new NumberOfStepsToZero();
            System.out.println(c.numberOfSteps(210));
            System.out.println("-----");
            System.out.println(c.numberOfStepsBin(210));
    }

    public int numberOfSteps (int num) {
        int steps = 0;

        while(num > 0) {
            System.out.println(num +" | " +Integer.toBinaryString(num));
            if(num % 2 == 0){
                num/=2;
            } else {
               num-=1;
            }
            steps++;
        }
        return steps;
    }

    // Recall that odd numbers always have a last bit of 1.
    // Subtracting 1, from an odd number, changes the last bit from 1 to 0.
    // Dividing by 2 removes the last bit from the number.
    //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/solution/
    public int numberOfStepsBin(int num){
        String binary = Integer.toBinaryString(num);
        int steps=0;
        for(char bit : binary.toCharArray()){
            if(bit == '1'){
                steps+=2;
            }
            if(bit=='0'){
                steps+=1;
            }
        }
        // Do not double count last bit
        return steps-1;
    }

    public int numberOfStepsBin2(int num){
        if(num ==0)
            return  0;

        int steps=0;
        for(int powerOfTwo = 1; powerOfTwo <= num; powerOfTwo*=2){
            // Apply the bit mask tocheck fi the bit at powerofWto is a 1

            if((powerOfTwo & num) != 0){
                steps+=2;
            } else {
                steps+=1;
            }
        }

        // remover over counter of last bit
        return steps=1;
    }
}
