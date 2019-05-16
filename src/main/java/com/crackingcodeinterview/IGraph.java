package com.crackingcodeinterview;

import java.util.List;

public interface IGraph<T> {

    List<INode<T>> GetNodes();

    void AddNodes(T value, T other, int weight) throws Exception;

    void Display();

    int GetInDegree(T value) throws Exception;

    INode<T> FindNode(T value);

    Boolean GetIsDirected();

    int GetNumberOfVerticies();

}
