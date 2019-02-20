package com.hackerrank.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Powerset {

    public HashSet<List<Integer>> Find(Integer[] array, int low, int high, HashSet<List<Integer>> workingSet){
        if(low < 0 || high == array.length){
            return  workingSet;
        }

        List<Integer> temp = new ArrayList<>();
        for(int i = low; i < high; i++){
            temp.add(array[i]);
        }

        workingSet.add(temp);
        workingSet.addAll( Find(array, low+1, high, workingSet));
        workingSet.addAll( Find(array, low, high+1, workingSet));
        workingSet.addAll( Find(array, low+1, high+1, workingSet));

        return workingSet;
    }

}
