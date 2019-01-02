package com.hackerrank.implementation;

//https://www.hackerrank.com/challenges/encryption/problem?h_r=internal-search

public class Encryption {

    public String Encrypt(String s) throws Exception {

        String removedSpaces = s.replaceAll("\\s", "");
        // x is floor and x is ceiling

        double raw = Math.sqrt(removedSpaces.length());

        int rowCount = (int) Math.floor(raw);

        int colCount = (int) Math.ceil(raw);

        if (rowCount * colCount < removedSpaces.length()) {
            while(rowCount* colCount < removedSpaces.length()){
                if(rowCount < colCount) {
                    rowCount++;
                } else {
                    colCount++;
                }
            }
        }

        char[][] encodedMatrix = new char[rowCount][colCount];
        char[] trimedSourceArray = removedSpaces.toCharArray();
        int sourceIndex = 0;
        for(int i = 0; i < rowCount; i++){

            for(int j = 0; j < colCount; j++){
                if(sourceIndex < trimedSourceArray.length){
                    encodedMatrix[i][j] = trimedSourceArray[sourceIndex];
                    sourceIndex++;
                   //
                } else {
                    encodedMatrix[i][j] = ' ';
                }
                System.out.print(encodedMatrix[i][j]);
            }
            System.out.println();
        }

        String result = "";
        for(int j = 0; j < colCount; j++){
            for(int i = 0; i < rowCount; i++){
                if(encodedMatrix[i][j] != ' ') {
                    result+= encodedMatrix[i][j];
                }
            }
            if(j+1 < colCount){
                result +=" ";
            }
        }
        return result;
    }
}
