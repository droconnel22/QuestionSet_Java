package com.crackingcodeinterview;

import java.util.List;

public interface INode<T> {
    T GetValue();

    void AddNode(INode<T> INode, int weight) throws Exception;

    List<INode<T>> GetAdjacentNodes();

    int GetWeight(INode<T> other) throws  IllegalArgumentException;
}
