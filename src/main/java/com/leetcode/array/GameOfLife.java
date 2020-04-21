package com.leetcode.array;

// 289. Game of Life
/*
According to he wikipedia article:

"The Game of life also known simply as Life, is a cellular automation
devised by the British Mathematician John Horton Conway in 1970.

Given a board with m by n cells, eahc cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, and diagnoal)
using the following 4 rules (take from wiki):
1. Any live cell with fewer than two live neighbors dies. As if caused by under-population
2. Any live cell with two or three live neighbors lives on to the next generation
3. Any dead cell with exactly three live neighbors becomes a live cell as if by reproduction.

Write a function to compute the next state (after one update) of the board
given its current state.

The next state is created by applying the above rules, simultaneously to every cell in the
current state, where births and deaths occur simultaneously.

can't do in place otherwise you'll lose information.

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]

Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:

1. could you solve it in-place? Remember that the board needs to be updated at the same time.
YOu cannot update some cells first and then use their update values to update other cells.

2. In this question we represent the board using a 2D array, In principle, the board is infnite,
which would cause problems when the active area encroaches the border of the array?
How would you address these problems?

What are some questions you might have?

1. Are there more examples?
2. Do I have to consider beyond the limit
3. How would you do it in one sweep, unless you created a buffer. If you change the information you
only have a partial answer.
- Could create an array
4. I need a function that will read the neighbors with boundary conditions and output a solution
5. Is there any graph algorithm I can apply
    - topological sort?
    - it has to be immediate turn over
 6. Did you re-read the instructions
 7. What if the result does not match - do I have to guess the values beyond the boundary condition
 8. Throw out some crazy things -> Big Integer, Dynamic programming, recursion, swap?
 If you hold the previous value in temp you can swap around the array


// double recursion strategy?



 */
public class GameOfLife {

    public static void main(String...args){
        var g = new GameOfLife();
        int[][] arr = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
       // g.gameOfLife(arr);
        g.gameOfLife2(arr);
    }

    public void gameOfLife2(int[][] board) {
       board = gameOfLifeClever(board,0,0);
        System.out.println("Result Is....");
        for(int i = 0; i < board.length;i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++){
                System.out.printf("%d, ",board[i][j]);
            }
            System.out.print("]");
            System.out.println();
        }
    }


    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];

        for(int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[i].length; j++){
                result[i][j] = evolve(board,i,j);
            }
        }

        System.out.println("Result Is....");
        for(int i = 0; i < result.length;i++) {
            System.out.print("[");
            for (int j = 0; j < result[i].length; j++){
                System.out.printf("%d, ",result[i][j]);
            }
            System.out.print("]");
            System.out.println();
        }

    }

    private int[][] gameOfLifeClever(int[][] board, int rowLocation, int colLocation ){

        if(rowLocation == board.length){
            return board;
        }

        if(colLocation == board[rowLocation].length){
            return gameOfLifeClever(board, rowLocation+1,0);
        }


        int swapStatus = evolve(board,rowLocation,colLocation);
        board = gameOfLifeClever(board,rowLocation, colLocation+1);
        board[rowLocation][colLocation] = swapStatus;
        return board;
    }

    public int evolve(int[][] board, int rowLocation, int colLocation){
        int oneCount = 0;
        int currentLifeStatus  = board[rowLocation][colLocation];
        System.out.printf("\n Next Life Status is: [%d] at (%d,%d) \n", currentLifeStatus, rowLocation,colLocation );

        // Top Row - recall indexing
        for(int row = 0; row < board.length; row++){
            System.out.print("[");
            for(int col = 0; col < board[row].length; col++){

                if(Math.abs(rowLocation-row) <= 1 && Math.abs(colLocation-col) <=1 ){

                    System.out.printf(rowLocation == row && colLocation == col ? "{%d}" : "%d, ",board[row][col]);
                    if (board[row][col] == 1 && (row != rowLocation || col != colLocation)) {
                        oneCount++;
                    }
                }
            }
            System.out.print("]");

            System.out.println();
        }

        System.out.println("  One Count: " + oneCount + " ");
        // Rules
        //1. Any live cell with fewer than two live neighbors dies. As if caused by under-population
        if(currentLifeStatus == 1 &&  oneCount < 2){
            return  0;
        }
        // Any live cell with two or three live neighbors lives on to the next generation.
        else if(currentLifeStatus ==1 &&( oneCount == 2 || oneCount == 3)){
            return  1;
        }
        //  Any live cell with more than three live neighbors dies, as if by over-population..
        else  if(currentLifeStatus == 1 &&  oneCount > 3){
            return 0;
        }
        // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        else if(currentLifeStatus == 0 && oneCount == 3) {
            return  1;
        } else {
            return currentLifeStatus;
        }
    }
}

class JustIncase {
    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];

        for(int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[i].length; j++){
                result[i][j] = evolve(board,i,j);
            }
        }
        for(int i = 0; i < result.length;i++) {

            for (int j = 0; j < result[i].length; j++){
                board[i][j] = result[i][j];
            }

        }
    }

    public int evolve(int[][] board, int rowLocation, int colLocation){
        int oneCount = 0;
        int currentLifeStatus  = board[rowLocation][colLocation];

        // Top Row - recall indexing
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){

                if(Math.abs(rowLocation-row) <= 1 && Math.abs(colLocation-col) <=1 ){

                    if (board[row][col] == 1 && (row != rowLocation || col != colLocation)) {
                        oneCount++;
                    }
                }
            }

        }

        // Rules
        //1. Any live cell with fewer than two live neighbors dies. As if caused by under-population
        if(currentLifeStatus == 1 &&  oneCount < 2){
            return  0;
        }
        // Any live cell with two or three live neighbors lives on to the next generation.
        else if(currentLifeStatus ==1 &&( oneCount == 2 || oneCount == 3)){
            return  1;
        }
        //  Any live cell with more than three live neighbors dies, as if by over-population..
        else  if(currentLifeStatus == 1 &&  oneCount > 3){
            return 0;
        }
        // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        else if(currentLifeStatus == 0 && oneCount == 3) {
            return  1;
        } else {
            return currentLifeStatus;
        }
    }

}
