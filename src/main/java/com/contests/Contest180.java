package com.contests;

import java.util.List;

public class Contest180 {
    public static void main(String... args) {
        int current = 0;
        switch (current){
            case  1-> System.out.println("hello");
            default ->  System.out.println("No available");
        }
    }

    // 1380. Lucky Numbers in a Matrix
    /*
    Given a m * n matrix of distinct numbers,
     return all lucky numbers in the matrix in any order.

     A lucky number is an element of the matrix such that it is the minimum
      element in its row and maximum in its column.

      Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
      Output: [15]
      Explanation: 15 is the only lucky number since it is
      the minimum in its row and the maximum in its column

      Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
      Output: [12]
      Explanation: 12 is the only lucky number since it is
      the minimum in its row and the maximum in its column.

     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        return null;
    }
}
