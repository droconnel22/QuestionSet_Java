package com.graph.search;

import com.graph.core.IGraph;
import com.graph.core.INode;

import java.util.ArrayList;

public class DepthFirstSearch<T> {

    public  void Search(INode<T> currentNode, ArrayList<INode<T>> searched){
        if(searched.contains(currentNode)){
            return;
        }

        searched.add(currentNode);
        System.out.println(currentNode.GetValue());
        for(INode<T> adjacentNode : currentNode.GetAdjacentNodes()){
            Search(adjacentNode, searched);
        }
    }
}
