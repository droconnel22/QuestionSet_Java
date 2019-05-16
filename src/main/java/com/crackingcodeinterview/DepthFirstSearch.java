package com.crackingcodeinterview;

import java.util.HashSet;

public class DepthFirstSearch<T> {

    public void Search(IGraph<T> graph, T value){
        INode<T> node = graph.FindNode(value);
        HashSet<INode<T>> searched = new HashSet<>();
        search(node, searched);
    }

    public void search(INode<T> currentNode, HashSet<INode<T>> searched){
        if(searched.contains(currentNode)){
            return;
        }

        searched.add(currentNode);
        System.out.println(currentNode.GetValue());
        for(INode<T> adjacentNode : currentNode.GetAdjacentNodes()){
            search(adjacentNode, searched);
        }
    }
}
