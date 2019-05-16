package com.graph.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph<T> implements IGraph<T>{

    private Boolean isDirected;

    private Integer numberOfVerticies;

    private List<INode<T>> edges;

    public Graph(Boolean isDirected, Integer numberOfVerticies) {
        this.isDirected = isDirected;
        this.numberOfVerticies = numberOfVerticies;
        this.edges = new ArrayList<>();
    }



    @Override
    public List<INode<T>> GetEdges() {
        return this.edges;
    }

    @Override
    public Integer GetWeight(INode<T> node, INode<T> other) throws IllegalArgumentException {
        if(isValidNode(node) || isValidNode(other)){
            throw new IllegalArgumentException("Can not get weight because node is null");
        }

        return node.GetWeight(other);
    }

    @Override
    public Integer GetInDegree(INode<T> node) {
        int inDegree = 0;
        for(INode<T> edge : this.edges){
            inDegree += edge.GetAdjacentNodes()
                    .stream()
                    .filter(e -> node.GetValue().equals(e.GetValue()))
                    .count();
        }
        return inDegree;
    }

    @Override
    public void AddEdges(T value, T other, Integer weight) throws Exception {
        if(isValidValue(value) || isValidValue(other) || isValidWeight(weight)){
            throw new IllegalArgumentException("value or weight was null or out of bounds");
        }

        INode<T> firstNode = this.FindNode(value);
        if(firstNode == null){
            firstNode = new Node<>(value);
            this.edges.add(firstNode);
        }

        INode<T> secondNode = this.FindNode(other);
        if(secondNode == null){
            secondNode = new Node<>(other);
            this.edges.add(secondNode);
        }

        firstNode.AddNode(secondNode,weight);
        if(!this.isDirected){
            secondNode.AddNode(firstNode,weight);
        }
    }

    @Override
    public INode<T> FindNode(T value) {

       if(value == null){
           throw new IllegalArgumentException("Value is null unable to node");
       }

       INode<T> resultNode = null;

        Iterator<INode<T>> nodeIterator = this.edges.iterator();
        while(nodeIterator.hasNext() && resultNode == null){
            INode<T> currentNode = nodeIterator.next();
            if(currentNode.GetValue().equals(value)) {
                resultNode = currentNode;
            }
        }

        return resultNode;
    }

    @Override
    public void Display() {
        System.out.println();
        for(INode<T> edge : this.edges){
            for(INode<T> adjacentEdge : edge.GetAdjacentNodes()){
                System.out.println(this.isDirected ? edge.GetValue() + " -> " + adjacentEdge.GetValue() :
                        edge.GetValue() + " <-> " + adjacentEdge.GetValue());
            }
        }
        System.out.println();
    }

    @Override
    public Boolean GetIsDirected() {
        return this.isDirected;
    }

    @Override
    public Integer GetNumberOfVerticies() {
        return this.numberOfVerticies;
    }

    private Boolean isValidNode(INode<T> node) { return  node == null;}

    private Boolean isValidValue(T value) { return value == null;}

    private Boolean isValidWeight(Integer weight) { return  weight < 0;}
}
