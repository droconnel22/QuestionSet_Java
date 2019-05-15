package com.hackerrank.strings;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class LexicalgraphicalOrder {
    public static void main(String... args){
        String s = "welcometojava";
        Integer k = 3;

        SortedSet<String> treeSet = new TreeSet<>();
        for(int i =0; i < s.length()-2;i++){
            String sub = s.substring(i,i+3);
            //System.out.println(sub);
            treeSet.add(sub);
        }

        //System.out.println(treeSet.first());
        //System.out.println(treeSet.last());
        alternative();
    }

    public static void alternative(String... args){
        String s = "welcometojava";
        Integer k = 3;
        String max = "";
        String min = "";
        for(int i =0; i < s.length()-2;i++){
            String sub = s.substring(i,i+k);
            if(max.isEmpty()|| sub.compareTo(max) < 0){
                max =sub;
            }

            if(min.isEmpty() || sub.compareTo(min) > 0) {
                min = sub;
            }
        }

        System.out.printf("Max: %s Min: %s", max, min);

    }
}

class QuickSort {
    ThreadLocalRandom generator = ThreadLocalRandom.current();


    public void sort(String[] sarray, int left, int right){
        if(left <= right){
            int huesticIndex = generator.nextInt(left, right+1);
            int pivotIndex = partition(sarray,left, right, huesticIndex);
            sort(sarray,left, pivotIndex-1);
            sort(sarray,pivotIndex+1,right);
        }
    }

    private void swap(String[] s, int i, int j){

       String temp = s[i];
       s[i] = s[j];
       s[j] = temp;
    }

    private int partition(String[] s, int left, int right, int huesistic){
        String pivotValue = s[huesistic];

        swap(s,right,huesistic);

        int i = left;
        int j = right;
        boolean inProgress = true;

        try{
            while(inProgress){
                while(i <= j && s[i].compareTo(pivotValue) <= 0){
                    i++;
                }

                while(i <= j && s[j].compareTo(pivotValue) > 0){
                    j--;
                }

                if(i < j){
                    swap(s,i,j);
                } else {
                    inProgress = false;
                }
            }
        } catch (Exception ex){
            System.out.println(ex.getCause());
        }



        int pivotIndex = i;
        swap(s,pivotIndex,right);
        return pivotIndex;
    }

}
