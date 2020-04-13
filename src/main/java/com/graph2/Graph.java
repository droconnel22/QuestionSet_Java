package com.graph2;

import com.graph2.common.GraphSaftey;
import com.graph2.nodes.Node;

import java.util.List;
import java.util.Optional;

public interface Graph<TValue extends Comparable<TValue>> extends GraphSaftey {
    Integer GetSize();
    Boolean IsDirected();
    List<Node<TValue>> GetEdges();
    void AddValue(TValue value, TValue other);
    void AddValue(TValue value, TValue other, Integer weight);
    void Display();
    Optional<Node<TValue>> TryFindNodeByValue(TValue value);
    Integer GetInDegrees(Node<TValue> node);
}

