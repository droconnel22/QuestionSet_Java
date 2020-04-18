package com.greedy;

import java.util.*;

public class QueueReconstructionByHeight {
    //406. Queue Reconstruction by Height

    /*
     Suppose you have a random list of people standing in a queue.
     Each person is described by a pair of integers (h, k)
     where h is the height of the person
     k is the number of people in front of this person who
     have a height greater than or equal to h

     Write an algorithm to reconstruct the queue.

     The number of people is less than 1,100.

     Example:
        Input:
        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

        Output:
        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

        What can you say about the position of the shortest person?
        If the position of the shortest person is i,
        how many people would be in front of the shortest person?

        Once you fix the position of the shortest person,
        what can you say about the position of the second shortest person?

        // write down some thoughts
        ok so the weight is mostly 0 in the front but not necessarily guaranteed
        there is relationship between the position and the weight

        some questions?
        what can i do with the original array?
        how can i move the array forward
        so i have 7, and 0
        so 0 says it nothing to the left can be ahead of it taller
        so do i go looking for the first shortest with the less then or equal
        7,0 hey 4,4 are you taller no but you require 4 in front of you so your index is too large
        i know 7 and i know the min index is 0
        ok thats not going to work
        am i swapping or constructing a new array? how do i find the first

        the first is the largest number with the smallest weight no

        it is the smallest number with the smallest weight both!

        so think about it again
        I have 7,0 what do i want to know, what is the smallest in the group by
        - height
        - position
        So i want the smallest in height and position and i run a simple min algo

        OK

        now i swap the smallest



     */

    private class Node {
        int height;
        int position;
        Node next;
        Node previous;
        Node(int height, int pos) { this.height = height; this.position = pos; this.next = null;}

    }
    /*
    Map<Node,Integer> priorityQueue = new HashMap<>();
        final int height = 0;
        final int position =1;
        for(int person = 0; person < people.length; person++){
            priorityQueue.put(new Node(people[person][height],people[person][position]),people[person][position]);
        }

        List<int[]> result = new ArrayList<>();
        while(!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue
                    .entrySet()
                    .stream()
                    .min(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
            if(currentNode == null)
                continue;


        }

          int placed = 0;
        while(placed < people.length) {
            int height = people[placed][0], smallestWeight = people[placed][1];
            int selected = placed;
            for(int i = placed; i < people.length;i++){
                if(people[i][0] < height && people[i][1] <= smallestWeight){
                    height = people[i][0];
                    smallestWeight =  people[i][1];
                    selected = i;
                }
            }
            System.out.println(height+" " + smallestWeight);
            swap(people,placed,selected);
            placed++;
        }
        return people;

        The following strategy could be continued recursively:

        Sort the tallest guys in the ascending order by k-values and then insert them one by one into output queue          at the indexes equal to their k-values.

        Take the next height in the descending order. Sort the guys of that height in the ascending order by        k-values and then insert them one by one into output queue at the indexes equal to their k-values.

        And so on and so forth.
     */

    public int[][] reconstructQueue2(int[][] people){
        for(int i = 0; i < people.length-1; i++){
            for(int j = 0; j < people.length-i-1; j++) {
                if(people[j][0] < people[j+1][0]){
                    swap(people,j,j+1);
                } else if(people[j][0] == people[j+1][0]) {
                        if(people[j][1] > people[j+1][1]){
                            swap(people,j,j+1);
                        }
                }
            }
        }

        // need the ability to insert and shift over
        Node root = new Node(people[0][0],people[0][1]);
        Node current = root;
        for(int i = 1; i < people.length; i++) {
            int targetIndex = people[i][1];
            int currentIndex  = 0;
            while(current != null && currentIndex < targetIndex){
                currentIndex++;
                assert current != null;
                current = current.next;
            }

            Node newNode = new Node(people[i][0],people[i][1]);
            if(current.previous != null){
                current.previous.next = newNode;
                newNode.previous = current;
                current.next = newNode;
            }

            if(current.next != null){
                current.next.previous = newNode;
                newNode.next = current.next;
            }
        }

        int[][] result = new int[people.length][2];
        int index =0;
        while(root.next != null){
            result[index] = new int[]{root.height,root.position};
            index++;
            root = root.next;
        }

        return  result;
    }

    private void swap(int[][] arr, int start, int end){
        int[] temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    public int[][] reconstructQueue(int[][] people) {
        if(people.length <=1) {
            return people;
        }

        int midpoint = people.length/2;
        int[][] leftHalf = reconstructQueue(splitArray(people,0,midpoint));
        int[][] rightHalf = reconstructQueue(splitArray(people,midpoint,people.length));

        return mergeArray(leftHalf,rightHalf);
    }

    private int[][] splitArray(int[][] arr, int start, int end){
        int size = end-start;
        int resultIndex = 0;
        int[][] resultArray = new int[size][2];
        for(int i = start; i< end; i++){
            resultArray[resultIndex] = arr[i];
            resultIndex++;
        }
        return  resultArray;
    }

    private int[][] mergeArray(int[][] leftArray, int[][] rigthtArry){
        final int height = 0;
        final int weight = 1;
        int resultSize = leftArray.length + rigthtArry.length;
        int[][] resultArray = new int[resultSize][2];
        int resultIndex =0, leftIndex =0, rightIndex =0;
        while(resultIndex < resultSize) {

            if(leftIndex == leftArray.length && rightIndex < rigthtArry.length){
                resultArray[resultIndex] = rigthtArry[rightIndex];
                rightIndex++;
            } else if(rightIndex == rigthtArry.length && leftIndex < leftArray.length) {
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            } else if(leftArray[leftIndex][height] > rigthtArry[rightIndex][height]){
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {

                resultArray[resultIndex] = rigthtArry[rightIndex];
                rightIndex++;
            }

            resultIndex++;
        }

        return resultArray;
    }




    public static void main(String...args){
        int[][] arr= {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        var c = new QueueReconstructionByHeight();
        for(int[] rarr : c.reconstructQueue2(arr)) {
            System.out.printf("(%s : %s),",rarr[0],rarr[1]);
        }
        System.out.println();
    }

}
