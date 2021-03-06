package com.crackingcodeinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CCProgram {
    public static void main(String...args){

        final List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,5,2,3,7,3,8,9);
        final Integer pos = Integer.valueOf(3);
        list.remove(pos);
        System.out.println(list);


    int a = 1;
        int b = a++;
        int c = ++b;

        int k = 1 << 2;

        final char s = 0x20;
        final int message = 1;
        System.out.println(s+message+"=A");


        System.out.println(a+" "+ b + " " +c + " "+ k);

        try {

            /*
            int[] array = {4,7,9,2,3,1,10};
            QuickSort quickSort = new QuickSort();
            quickSort.Sort(array);
            System.out.println();
            Arrays.stream(array).forEach(i -> System.out.print(i+ " "));
            */

            IGraph<Integer> intgraph = new Graph<>(true,5);
            intgraph.AddNodes(0,1,0);
            intgraph.AddNodes(1, 2, 0);
            intgraph.AddNodes(2,3, 0);
            intgraph.AddNodes(3,4,0);
            intgraph.AddNodes(0,5, 0);
            intgraph.AddNodes(3,5, 0);
            intgraph.Display();

            BreathFirstSearch<Integer> bfs = new BreathFirstSearch<>();
            bfs.Search(intgraph,0);

            System.out.println("------------");

            DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
            dfs.Search(intgraph,0);

            Integer[] llarray = {1,2,3,4,6,7,8,9,10};

            LinkedListMidInsertion<Integer> lln = new LinkedListMidInsertion<>();
            lln.BuildList(llarray);
            lln.Display();
            lln.Insert(5);
            lln.Display();

            CoinChangeProblem ccp = new CoinChangeProblem();
            ccp.ScenarioOne();
            ccp.ScenarioTwo();

            int[] mergeArray = {3,6,2,7,8,5,1,10,12,15,19};
            MergeSort mergeSort = new MergeSort();
            Arrays.stream(mergeSort.mergeSort(mergeArray)).boxed().forEach(i -> System.out.print(i+ " "));

            System.out.println();
            int[] isArray = {3,6,2,7,8,5,1,10,12,15,19};
            InsertionSort insertionSort = new InsertionSort();
            Arrays.stream(insertionSort.sort(isArray)).boxed().forEach(i -> System.out.print(i+ " "));

            HuffmanCodingTree huffmanCodingTree = new HuffmanCodingTree();
            huffmanCodingTree.ScenarioOne();

            //StringPermutations stringPermutations = new StringPermutations();
            //stringPermutations.ScenarioOne();

            BinarySearch binarySearch = new BinarySearch();
            binarySearch.ScenarioExists();

            LinkedListCycle linkedListCycle = new LinkedListCycle();
            linkedListCycle.ScenarioWithCycle();

            StringAnagram stringAnagram = new StringAnagram();
            stringAnagram.ScenarioOne();

        } catch (Exception ex){
            System.out.println();
            System.out.println("ERROR: " + ex.getMessage());
        }

    }
}
