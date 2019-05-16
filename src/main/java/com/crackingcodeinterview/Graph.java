package com.crackingcodeinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph<T>  implements IGraph<T> {

    private List<INode<T>> nodes;

    private boolean isDirected;

    private  int numberOfVerticies;

    public Graph(boolean isDirected, int numberOfVerticies) {
        this.nodes = new ArrayList<>();
        this.isDirected = isDirected;
        this.numberOfVerticies = numberOfVerticies;
    }

    @Override
    public List<INode<T>> GetNodes() {
        return this.nodes;
    }

    @Override
    public void AddNodes(T value, T other, int weight) throws Exception {
        isValidWeight(weight);
        INode<T> first = this.FindNode(value);
        if(first == null){
            first = new Node<>(value);
            this.nodes.add(first);
        }

        INode<T> second = this.FindNode(other);
        if(second == null){
            second = new Node<>(other);
            this.nodes.add(second);
        }

        first.AddNode(second,weight);
        if(!this.isDirected){
            second.AddNode(first, weight);
        }
    }

    @Override
    public void Display() {
        System.out.println();
        for(INode<T> node : this.nodes){
            for(INode<T> adjancentNode : node.GetAdjacentNodes()){
                System.out.printf(this.isDirected ?
                        node.GetValue() + " -> " +  adjancentNode.GetValue() +"\n" :
                        node.GetValue() + " <-> " +  adjancentNode.GetValue() +"\n"
                );
            }
        }
        System.out.println();
    }

    @Override
    public int GetInDegree(T value) throws Exception {
        INode<T> getNode = this.FindNode(value);
        isValidNode(getNode);
        int indegree = 0;
        for(INode<T> node : this.nodes){
            indegree += node
                    .GetAdjacentNodes()
                    .stream()
                    .filter(n -> n.GetValue() == value )
                    .count();
        }

        return indegree;
    }

    @Override
    public INode<T> FindNode(T value) {
        Optional<INode<T>> optionalNode = this
                .nodes
                .stream()
                .filter(n -> n.GetValue().equals(value))
                .findFirst();
        return  optionalNode.isPresent() ? optionalNode.get() : null;
    }

    @Override
    public Boolean GetIsDirected() {
        return  this.isDirected;
    }

    @Override
    public int GetNumberOfVerticies() {
        return  this.numberOfVerticies;
    }

    private void isValidWeight(int weight) throws IllegalArgumentException {
        if(weight < 0 ){
            throw new IllegalArgumentException("Weight is below zero");
        }
    }

    private void isValidNode(INode<T> node) throws IllegalArgumentException {
        if(node == null) {
            throw new IllegalArgumentException("Node is null");
        }
    }
}
