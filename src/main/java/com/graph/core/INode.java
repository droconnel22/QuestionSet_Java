package com.graph.core;

import java.util.List;

public interface INode<T> {

    T GetValue();

    List<INode<T>> GetAdjacentNodes();

    Integer GetWeight(INode<T> other);

    void AddNode(INode<T> node, Integer weight) throws Exception;
}
