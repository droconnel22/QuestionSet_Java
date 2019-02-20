package com.hackerrank.array.twoarrays;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayBuilder {

    private  static  java.util.Random Random = new Random();

    public  static int[] Build(int n ){
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = Random.nextInt(n*10);
        }

        return  array;
    }

    public  static List<Integer> BuildList(int n){
        return
                IntStream
                .generate(() ->
                        ThreadLocalRandom
                            .current()
                            .nextInt(n*10))
                .limit(n)
                .boxed()
                .collect(Collectors.toList());
    }

}