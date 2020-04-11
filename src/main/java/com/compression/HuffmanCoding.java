package com.compression;

/*
f : 0
c:  100
d : 101
a : 1100
b:  1101
e:  111
 */

import java.util.*;

/*
   'f',0,
    'c',100,
    'd',101,
    'a',1100,
    'b',1101,
    'e',111
 */
public class HuffmanCoding {
    public static void main(String...args) {

        Map<Character, Integer> map = Map.of(
                'a',5,
                'b',9,
                'c',12,
                'd',13,
                'e',16,
                'f',45

        );

        var tree = new HuffmanTree<Character,Integer>();
        tree.BuildTree(map);
        tree.TraverseTree();
    }
}

class PriorityQueue<Tkey , TItem extends Number & Comparable<TItem>> {
    private final Map<Tkey,TItem> queue;

    public PriorityQueue() {
        this.queue = new HashMap<>();
    }

    public void Enqueue(Tkey key, TItem item){
        if(!queue.containsKey(key)) {
            queue.put(key,item);
        }
    }

    public Optional<Tkey> TryPeekMin(){
        if(this.queue.isEmpty()){
            return Optional.empty();
        }
        return this.queue
                .entrySet()
                .stream()
                .min((kvp1, kvp2) -> kvp1.getValue().compareTo(kvp2.getValue()))
                .map(Map.Entry::getKey);
    }

    public Optional<Tkey> TryDequeueMin(){
        if(this.queue.isEmpty()){
            return  Optional.empty();
        }
        Optional<Tkey> result = this.TryPeekMin();
        if(result.isPresent()){
            this.queue.remove(result.get());
        }
        return result;
    }

    public int GetSize() {
        return this.queue.size();
    }
}

class HuffmanNode<TValue,TWeight extends Number> {
    private final TValue value;

    private final TWeight weight;

    private final HuffmanNode right;

    private final HuffmanNode left;

    // Leaf Node
    public HuffmanNode(TValue value, TWeight weight) {
        this.value = value;
        this.weight = weight;
        this.right =null;
        this.left =null;
    }

    // Branch Node
    public HuffmanNode(TWeight combinedWeight, HuffmanNode<TValue, TWeight> left, HuffmanNode<TValue,TWeight> right) {
        this.value = null;
        this.weight = combinedWeight;
        this.left = left;
        this.right = right;
    }

    public TValue getValue() {
        return value;
    }

    public TWeight getWeight() {
        return weight;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public HuffmanNode getLeft() {
        return left;
    }
}

class HuffmanTree<TValue,TWeight extends Number & Comparable<TWeight>> {

    private HuffmanNode<TValue,TWeight> root;

    public void BuildTree(Map<TValue,TWeight> map){
        // Build List of Leaf Nodes in queue
        var priorityQueue = new PriorityQueue<HuffmanNode<TValue,TWeight>,TWeight>();

        for(Map.Entry<TValue,TWeight> entry : map.entrySet()){
            HuffmanNode node = new HuffmanNode<TValue,TWeight>(entry.getKey(),entry.getValue());
            priorityQueue.Enqueue(node, entry.getValue());
        }

        while(priorityQueue.GetSize() > 1) {
            var leftNode = priorityQueue.TryDequeueMin();
            var rightNode = priorityQueue.TryDequeueMin();
            Integer combinedValue =  leftNode.get().getWeight().intValue() + rightNode.get().getWeight().intValue();
            var branchNode = new HuffmanNode<TValue,TWeight>((TWeight)combinedValue, leftNode.get(), rightNode.get());
            priorityQueue.Enqueue(branchNode,(TWeight)combinedValue);
        }

        this.root = priorityQueue.TryDequeueMin().get();
    }

    public void TraverseTree(){
        traverseTree(this.root, "");
    }

    private void traverseTree(HuffmanNode<TValue,TWeight> node, String encoding) {
        if(node != null){
            traverseTree(node.getLeft(),encoding+"0");
            if(node.getValue() != null){
                System.out.printf("\n %s:%s", node.getValue(), encoding);
            }
            traverseTree(node.getRight(),encoding+"1");
        }
    }

}
