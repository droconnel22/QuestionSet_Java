package com.graph2;

import com.graph2.common.GraphSaftey;
import com.graph2.nodes.Node;
import com.graph2.nodes.NodeImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.graph2.common.GraphSaftey.*;

public class GraphImpl<TValue extends Comparable<TValue>> implements Graph<TValue> {
    private final List<Node<TValue>> edges;

    private final Integer numberOfEdges;

    private final Boolean isDirected;


    public GraphImpl(Integer numberOfEdges, Boolean isDirected) {
        this.numberOfEdges = numberOfEdges;
        this.isDirected = isDirected;
        this.edges = new ArrayList<>();
    }

    public GraphImpl(){ this(10,false); }

    public GraphImpl(Boolean isDirected){ this(100,isDirected); }

    @Override
    public Integer GetSize() {
        return this.numberOfEdges;
    }

    @Override
    public Boolean IsDirected() {return this.isDirected;  }

    @Override
    public List<Node<TValue>> GetEdges() {
        return this.edges;
    }

    @Override
    public void AddValue(TValue value, TValue other) {this.AddValue(value,other,0); }

    @Override
    public void AddValue(TValue value, TValue other, Integer weight) {
        CheckValue(value);
        CheckValue(other);
        CheckWeight(weight);

        var firstNodeResult = this.TryFindNodeByValue(value);
        Node<TValue> firstNode;
        if(firstNodeResult.isEmpty()){
            firstNode = new NodeImpl<>(value);
            this.edges.add(firstNode);
        } else {
            firstNode = firstNodeResult.get();
        }

        var secondNodeResult = this.TryFindNodeByValue(other);
        Node<TValue> secondNode;
        if(secondNodeResult.isEmpty()){
            secondNode = new NodeImpl<>(other);
            this.edges.add(secondNode);
        } else {
            secondNode = secondNodeResult.get();
        }

        firstNode.AddEdge(secondNode,weight);
        if(!this.isDirected){
            secondNode.AddEdge(firstNode,weight);
        }
    }

    @Override
    public void Display() {
        System.out.println("----------------");
        for(Node<TValue> edge : this.edges){
            for(Node<TValue> adjacentEdge : edge.GetAdjacentEdges()){
                System.out.printf(this.isDirected ?  "%s -->  %s \n" : "%s <-> %s \n", edge.GetValue(), adjacentEdge.GetValue());
            }
        }
        System.out.println("----------------");    }

    @Override
    public Optional<Node<TValue>> TryFindNodeByValue(TValue value) {
        CheckValue(value);
        return this.edges.stream()
                .filter(n -> n.GetValue().equals(value))
                .findFirst();
    }

    @Override
    public Integer GetInDegrees(Node<TValue> node) {
        CheckNode(node);
        Integer indegrees = 0;
        for(Node<TValue> edge : this.edges){
            indegrees += edge.GetInDegree(node);
        }
        return indegrees;
    }
}
