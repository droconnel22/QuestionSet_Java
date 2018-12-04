package com.ap.questionset_java.QuestionOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReverseAndInterWeave {

    public String Reverse(String input) {

        char[] array = input.toCharArray();
        for(int i = 0; i < array.length/2; i++) {
            int j = array.length - 1 - i;
            char t = array[i];
            array[i] = array[j];
            array[j] = t;
        }

        return String.valueOf(array);
    }

    public String Execute(String input) {

        String reverse_input = Reverse(input);
        char[] reverse_array = reverse_input.toCharArray();
        List<Character> reverse_list = new ArrayList<>();
        for(char c : reverse_array){
            reverse_list.add(c);
        }
        Iterator<Character> reverseIterator = reverse_list.iterator();

        char[] input_array = input.toCharArray();
        List<Character> input_list = new ArrayList<>();
        for(char c: input_array) {
            input_list.add(c);
        }
        Iterator<Character> inputIterator = input_list.iterator();

        String result = "";
        while(reverseIterator.hasNext() && inputIterator.hasNext()) {
            result += inputIterator.next().toString() + reverseIterator.next().toString();
        }
        return result;
    }
}
