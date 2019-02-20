package com.graph.core;

import java.util.List;

public interface IGraph<T> {

    List<INode<T>> GetEdges();

    Integer GetWeight(INode<T> node, INode<T> other);

    Integer GetInDegree(INode<T> node);

    void AddEdges(T value, T other, Integer weight) throws Exception;

    INode<T> FindNode(T value);

    void Display();

    Boolean GetIsDirected();

    Integer GetNumberOfVerticies();

}

