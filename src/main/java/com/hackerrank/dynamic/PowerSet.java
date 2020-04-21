package com.hackerrank.dynamic;

/*
Write a method to return all subsets of a set

so what is the decision to move or not move?
incremetn low and leave high
leave low and increment high
 */

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PowerSet {
    public static void main(String...args){
        // left shift has effect of dividing by 2
        int x = -8;
        System.out.println(x>>1);
        int y = 8;
        System.out.println(y>>1);

        int n = -8;
        System.out.println(n<<1);
        int m = 8;
        System.out.println(m<<1);
        int[] scenaro =
                IntStream
                .range(0,3)
                .map(i -> ThreadLocalRandom.current().nextInt(0, 10))
                .toArray();
       // DisplayAllSubsets(scenaro);

       List<Integer> scenaro2 =
                IntStream
                        .range(0,5)
                        .map(i -> ThreadLocalRandom.current().nextInt(0, 10))
                        .boxed()
               .collect(Collectors.toList());

       for(ArrayList<Integer> subset : anotherWay2(new ArrayList<>(scenaro2),0)){
           Display(subset);
       }




    }

    private static class Pair<T1 extends Comparable<T1>,T2 extends Comparable<T2>> implements Comparable<Pair<T1,T2>>{
        T1 t1;
        T2 t2;
        Pair(T1 t1, T2 t2){ this.t1 = t1; this.t2 = t2;}


        @Override
        public int compareTo(Pair<T1, T2> o) {
            return this.t1.compareTo(o.t1) & this.t2.compareTo(o.t2);
        }
    }

    public static void DisplayAllSubsets(int[] array){
        Set<Pair<Integer,Integer>> searched = new HashSet<>();
        displayAllSubsets(array,0, 1,searched);
    }




    private static void displayAllSubsets(int[] array, int low, int high,  Set<Pair<Integer,Integer>> searched){
        if(low == array.length || high== array.length)
            return;

        var tempPair = new Pair(low,high);
        if(searched.contains(tempPair)){
            return;
        }
        display(array,low,high);
        searched.add(tempPair);

        displayAllSubsets(array,low,high+1,searched);
        displayAllSubsets(array,low+1, high+1,searched);
    }

    private static void display(int[] array, int low, int high){
        if(Math.abs(low-high) == 0)
            return;
        System.out.println();
        System.out.print("[ ");
        for(int i = low; i < high; i++){
            System.out.printf("%d,",array[i]);
        }
        System.out.print("]");
    }

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<>();
        int max = 1 << set.size();
        for(int k = 0; k < max; k++){
            ArrayList<Integer> subset = convertIntToSet(k,set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

 // All integers are signed in Java, and it is fine to use >> for negative numbers.
 // The operator ‘>>’ uses the sign bit (left most bit) to fill the trailing positions after shift.
    // If the number is negative, then 1 is used as a filler and if the number is positive, then 0 is used as a filler.
    // For example, if binary representation of number is 10….100, then right shifting it by 2 using >> will make it 11…….1.
    ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index =0;
        // 1) >> (Signed right shift) In Java, the operator ‘>>’ is signed right shift operator.
        for(int k =  x; k > 0; k >>= 1){
            if((k & 1) ==1){
                subset.get(set.get(index));
            }
            index++;
        }
        return subset;
    }

    // This is truly dynamic because you are building on the previous solutions
    public ArrayList<ArrayList<Integer>> anotherWay(int[] array, int index){
        // reach the end now roll up back
        ArrayList<ArrayList<Integer>> allsubsets;
        if(index == array.length){
            allsubsets = new ArrayList<ArrayList<Integer>>();
            return allsubsets;
        } else {
            allsubsets = anotherWay(array,index+1);
            var localsubsets = new ArrayList<ArrayList<Integer>>();
            int item = array[index];
            for(ArrayList<Integer> subset: allsubsets){
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                allsubsets.add(newsubset);
            }

            allsubsets.addAll(localsubsets);
        }

        return allsubsets;
    }

    public static ArrayList<ArrayList<Integer>> anotherWay2(ArrayList<Integer> array, int index){
        // we will build previous solutions in the next
        ArrayList<ArrayList<Integer>> globalsubsets;

        // consider the base case when the index is at the end
        // we will rubber band back
        if(index == array.size()){
            globalsubsets = new ArrayList<>();
            // Add empty case
            globalsubsets.add(new ArrayList<>());
            // recursive return to build further
            return  globalsubsets;
        } else {
            // Now lets build new subsets based on the next element
            globalsubsets = anotherWay2(array,index+1);
            int next = array.get(index);
            var localsubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : globalsubsets){
                ArrayList<Integer> nextSubset = new ArrayList<>();
                nextSubset.addAll(subset);
                nextSubset.add(next);
                localsubsets.add(nextSubset);
            }

            globalsubsets.addAll(localsubsets);
        }

        return globalsubsets;

    }

    public static void Display(ArrayList<Integer> subset){

        System.out.println();
        System.out.print("[ ");
        for(Integer elm : subset){
            System.out.printf("%d,",elm);
        }
        System.out.print("]");
    }
}
