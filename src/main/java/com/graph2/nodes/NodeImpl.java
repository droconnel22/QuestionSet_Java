package com.graph2.nodes;

import com.crackingcodeinterview.Graph;
import com.graph2.common.GraphSaftey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.graph2.common.GraphSaftey.CheckNode;

public class NodeImpl<TValue extends Comparable<TValue>> implements Node<TValue>{

    private final TValue value;

    private final HashMap<Node<TValue>,Integer> adjacentNodes;

    public NodeImpl(TValue value) {
        this.value = value;
        this.adjacentNodes = new HashMap<>();
    }

    @Override
    public TValue GetValue() {
        return this.value;
    }

    @Override
    public List<Node<TValue>> GetAdjacentEdges() {
        return new ArrayList<>(this.adjacentNodes.keySet());
    }

    @Override
    public void AddEdge(Node<TValue> node, Integer weight) {
        CheckNode(node);
        GraphSaftey.CheckWeight(weight);
        this.adjacentNodes.putIfAbsent(node, weight);
    }

    @Override
    public Integer GetWeight(Node<TValue> node) {
        CheckNode(node);
        return this.adjacentNodes.getOrDefault(node,0);
    }

    @Override
    public Integer GetInDegree(Node<TValue> node) {
        CheckNode(node);
        return this.adjacentNodes.containsKey(node) ? 1 : 0;
    }
}
