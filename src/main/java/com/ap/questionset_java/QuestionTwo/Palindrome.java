package com.ap.questionset_java.QuestionTwo;

public class Palindrome {

    public static Boolean Check(String input) {
        int index = 0;
        String inputTrimmed = input.replaceAll("\\s+","");
        char[] input_array = inputTrimmed.toCharArray();
        while(index < input_array.length) {
            if(input_array[index] != input_array[input_array.length-1-index]){
                return false;
            }
            index++;
        }

        return true;
    }
}

