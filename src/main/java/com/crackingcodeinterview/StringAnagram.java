package com.crackingcodeinterview;

import java.util.HashMap;
import java.util.HashSet;

public class StringAnagram {

    public void ScenarioOne(){
        String first = "hello";
        String second = "billion";


        HashMap<Character, Integer> secondMap = BuildMap(second);
        HashMap<Character, Integer> firstMap = BuildMap(first);

        int count = CountRemoval(secondMap, firstMap);
        System.out.println("Total count: "+ count);

    }

    private  HashMap<Character, Integer> BuildMap(String input){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        return map;
    }

    private int CountRemoval(HashMap<Character,Integer> first, HashMap<Character,Integer> second) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();

        for(Character firstKey : first.keySet()){
            if(second.containsKey(firstKey)){
                if(first.get(firstKey).intValue() != second.get(firstKey).intValue()){
                    count += Math.abs(first.get(firstKey) - second.get(firstKey));
                }
            } else {
                // doesn't contain so remove it
                count+=first.get(firstKey);
            }
        }

        for(Character secondKey : second.keySet()){
            if(!first.containsKey(secondKey)){
                count += second.get(secondKey);
            }
        }

        return count;
    }
}
