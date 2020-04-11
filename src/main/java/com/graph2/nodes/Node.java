package com.graph2.nodes;

import com.graph2.common.GraphSaftey;

import java.util.List;

public interface Node<TValue extends Comparable<TValue>> extends GraphSaftey {
    TValue GetValue();
    List<Node<TValue>> GetAdjacentEdges();
    void AddEdge(Node<TValue> node, Integer weight);
    Integer GetWeight(Node<TValue> node);
    Integer GetInDegree(Node<TValue> node);
}

