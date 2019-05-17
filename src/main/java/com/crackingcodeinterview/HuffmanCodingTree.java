package com.crackingcodeinterview;

/*
There are mainly two major parts in Huffman Coding
1) Build a Huffman Tree from input characters.
2) Traverse the Huffman Tree and assign codes to characters.

Steps to build Huffman Tree
Input is an array of unique characters along with their frequency of occurrences and output is Huffman Tree.

1. Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap is used as a priority queue. The value of frequency field is used to compare two nodes in min heap. Initially, the least frequent character is at root)

2. Extract two nodes with the minimum frequency from the min heap.

3. Create a new internal node with a frequency equal to the sum of the two nodes frequencies. Make the first extracted node as its left child and the other extracted node as its right child. Add this node to the min heap.

4. Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root node and the tree is complete.

Let us understand the algorithm with an example:



character   Frequency
    a            5
    b           9
    c           12
    d           13
    e           16
    f           45
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HuffmanCodingTree {


    private class Node {

        public Character value;

        public Integer Frequencey;

        public Node Right;

        public Node Left;

        public Node(Character value, Integer frequence) {
            this.value = value;
            Frequencey = frequence;
        }

        public Node(Integer frequence) {
            Frequencey = frequence;
            this.value = null;
        }
    }

    private class PriorityNodeQueue {
        private HashMap<Node,Integer> queue;

        public PriorityNodeQueue() {
            this.queue = new HashMap<>();
        }

        public void Enqueue(Node node, Integer frequency) {
            this.queue.put(node, frequency);
        }

        public Node PeekMin(){
            if(this.queue.isEmpty()){
                return null;
            }

            return this.queue.entrySet().stream()
                    .min(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
        }

        public Node DequeueMin(){
            Node currentNode = this.PeekMin();
            if(currentNode != null){
                this.queue.remove(currentNode);
            }
            return currentNode;
        }

        public int Size() {
            return this.queue.size();
        }
    }

    private Node root;

    public void ScenarioOne() {
        HashMap<Character, Integer> input = new HashMap<>();
        input.put('a',5);
        input.put('b',9);
        input.put('c',12);
        input.put('d',13);
        input.put('e',16);
        input.put('f',45);

        BuildTree(input);
        DisplayTree();
    }


    public void BuildTree(HashMap<Character, Integer> map){
       // 1. Create a leaf node for each unique character and
        // build a min heap of all leaf nodes (Min Heap is
        // used as a priority queue. The value of frequency
        // field is used to compare two nodes in min heap.
        // Initially, the least frequent character is at root)

        PriorityNodeQueue priorityNodeQueue = new PriorityNodeQueue();

        for(Map.Entry<Character, Integer> set : map.entrySet()){
            Node leafNode = new Node(set.getKey(), set.getValue());
            priorityNodeQueue.Enqueue(leafNode, leafNode.Frequencey);
        }

        while(priorityNodeQueue.Size() >1){

            //2. Extract two nodes with the minimum frequency from the min heap.

            Node left = priorityNodeQueue.DequeueMin();
            Node right = priorityNodeQueue.DequeueMin();

            // 3. Create a new internal node with a frequency equal to the sum
            // of the two nodes frequencies. Make the first extracted node
            // as its left child and the other extracted node as its
            // right child. Add this node to the min heap.
            int newFreq = left.Frequencey + (right != null ? right.Frequencey : 0);

            Node branch = new Node(newFreq);
            branch.Left = left;
            branch.Right = right;

            priorityNodeQueue.Enqueue(branch, branch.Frequencey);
        }

        this.root = priorityNodeQueue.DequeueMin();
    }


    //Steps to print codes from Huffman Tree:
    //Traverse the tree formed starting from the root.
    // Maintain an auxiliary array.
    // While moving to the left child, write 0 to the array.
    // While moving to the right child, write 1 to the array.
    // Print the array when a leaf node is encountered.
    public void DisplayTree(){
        displayTree(this.root, "");
    }

    private void displayTree(Node currentNode, String array){
        if(currentNode == null){
            return;
        }
        if(currentNode.value != null){
            System.out.printf("\n %s : %s \n", currentNode.value, array);
        }

        displayTree(currentNode.Left, array+"0");
        displayTree(currentNode.Right, array+"1");
    }
}
