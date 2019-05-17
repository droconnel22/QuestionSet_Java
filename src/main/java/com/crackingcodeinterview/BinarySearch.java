package com.crackingcodeinterview;

public class BinarySearch {

    public void ScenarioExists(){
        int[] array = { 19, 20, 23,4,6,7,8,2,1,45,34,77, 62};
        int find = 45;

        Search(array,0, array.length-1, find);
    }

    private void Search(int[] array, int left, int right, int find){

        if(left < right){
            int midpoint = (left+right)/2;
            if(array[midpoint] == find){
                System.out.printf("Found %d \n",array[midpoint]);
                return;
            } else if(array[midpoint] < find){
                Search(array,midpoint+1,right,find);
            } else {
                Search(array,left,midpoint-1, find);
            }
        }
        System.out.println("Not found!");
    }
}
