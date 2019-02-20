package com.hashing;

import com.sun.tools.javac.util.Pair;

import java.util.HashSet;


public class UniqueSets {

    private HashSet<Pair<String,String>> hashSet;

    private  HashSet<String> hashSetNoPair;

    public UniqueSets() {
        hashSet = new HashSet<>();
        hashSetNoPair = new HashSet<>();
    }

    public Integer Check(String[] pairLeft, String[] pairRight)  {
        Integer index =0;
        while(index < pairLeft.length && index < pairRight.length){
            hashSet.add(new Pair<>(pairLeft[index], pairRight[index]));
            index++;
        }
        return hashSet.size();
    }
}
