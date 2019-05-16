package com.crackingcodeinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Node<T> implements INode<T> {

    private HashMap<INode<T>,Integer> adjacentNodes;

    private T value;

    public Node(T value){
        this.value = value;
        adjacentNodes = new HashMap<>();
    }

    @Override
    public void AddNode(INode<T> node, int weight) throws Exception {
        if(checkWeight(weight) || isValidNode(node)){
            throw new IllegalArgumentException();
        }

        if(!adjacentNodes.containsKey(node)) {
            adjacentNodes.put(node, weight);
        }
    }

    @Override
    public List<INode<T>> GetAdjacentNodes() {
        return new ArrayList<>(this.adjacentNodes.keySet());
    }

    @Override
    public int GetWeight(INode<T> other)throws  IllegalArgumentException{
        if(isValidNode(other)) {
            throw  new IllegalArgumentException("Other node was null");
        }
        return this.adjacentNodes.getOrDefault(other, 0);
    }

    @Override
    public T GetValue(){
        return value;
    }

    private boolean checkWeight(int weight) { return weight < 0;  }

    private boolean isValidNode(INode<T> node) { return node == null;}
}
