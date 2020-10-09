package com.hackerrank.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

stream of consciousness is key
ok what can i do

i have to recuserively search and check

but what i don't understand is
- is do i see the column? why?
- why am i iterating..
 */

public class EightQueens {

    private static final Integer SIZE = 8;

    public static void main(String...args){
        var e = new EightQueens();
        var result = e.SolveEightQueens();
        System.out.println(result.size());
    }

    List<int[]> SolveEightQueens(){
        int[] columns = new int[]{0,0,0,0,0,0,0,0};
        int row = 0;
        List<int[]> solutions = new ArrayList<int[]>();
        return solveEightQueens(columns,row,solutions);
    }

    private List<int[]> solveEightQueens(int[]columns, int row, List<int[]> solutions) {
        // Start with bottom up base case
        if(row == SIZE){
            solutions.add(columns.clone());
        } else {
            // more rows to go
            // each col has a unique queen that queen will have a number
            for(int queen = 0; queen < SIZE; queen++) {
                if(checkQueen(columns,row,queen)){
                    // made it through check - place queen
                    columns[row] = queen;
                    solveEightQueens(columns,row+1,solutions);
                }
            }
        }

        return solutions;
    }

    /*
    how do i check the row?
    how do i check the col
    how do i check the diagonal
    keep thinking!!
    your not thinking your just stalling

    but I don't know what i am doing
    what am i doing?
    checking for unique values in a matrix
    the x axis doesn't matter

    only the position within the columns

    what is the column value!??!?

    why do i have to loop through the column

    how do i critical think and problem solve?

    Why!?
     why is the key
     you have a matrix of a board 8x8
     queens must have unique row and column and also occupy a unique diagonal.
     so it only matter one side
     [1] 0
     [2] 0
     [3] 0
     [4] 0
     [5] 0
     [6] 0
     [7] 1
     [8] 1
     */

    private boolean checkQueen(int[] columns, int proposedRowIndex, int proposedColIndex) {

        // Bottom Up
        for(int currentRow = 0; currentRow < proposedRowIndex; currentRow++){
            int currentCol = columns[currentRow];
            // Check Row
            // there is no check because we go bottom up and so only consider empty rows.

            // Check Column
            if(currentCol == proposedColIndex){
                return false;
            }

            // Check Diagonal
            int columnDistance = Math.abs(proposedColIndex-currentCol);
            int rowDistnace = currentRow-proposedRowIndex;
            if(columnDistance == rowDistnace){
                return false;
            }

        }
        // if we get this far we made it
        return true;
    }
}
