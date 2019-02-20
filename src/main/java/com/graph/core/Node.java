package com.graph.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node<T> implements INode<T> {

    private HashMap<INode<T>, Integer> adjacentNodes;

    private T value;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public T GetValue() {
        return this.value;
    }

    @Override
    public List<INode<T>> GetAdjacentNodes() {

        return new ArrayList<>(this.adjacentNodes.keySet());
    }

    @Override
    public Integer GetWeight(INode<T> node) throws IllegalArgumentException {
        if(isValidNode(node)){
            throw new IllegalArgumentException("Node can not be null");
        }
        return this.adjacentNodes.keySet().contains(node) ? this.adjacentNodes.get(node) : 0;
    }

    @Override
    public void AddNode(INode<T> node, Integer weight) throws IllegalArgumentException {
        if(isValidNode(node)){
            throw new IllegalArgumentException("Node was null");
        }

        if(isValidWeight(weight)){
            throw  new IllegalArgumentException("Weight was out of bounds, must be positive.");
        }

        if(!this.adjacentNodes.containsKey(node)){
            this.adjacentNodes.put(node, weight);
        }
    }

    private Boolean isValidNode(INode<T> node) { return  node == null;}

    private Boolean isValidWeight(Integer weight) { return  weight < 0;}
}
