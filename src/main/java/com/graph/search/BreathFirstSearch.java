package com.graph.search;

import com.graph.core.IGraph;
import com.graph.core.INode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BreathFirstSearch<T> {
    public  void Search(IGraph<T> graph, INode<T> startingNode){
        List<INode<T>> searched = new ArrayList<>();
        ArrayDeque<INode<T>> queue = new ArrayDeque<>();

        queue.add(startingNode);

        while(!queue.isEmpty()){
            INode<T> currentNode = queue.remove();
            if(searched.contains(currentNode)){
                continue;
            }

            searched.add(currentNode);
            System.out.println(currentNode.GetValue());
            for(INode<T> adjacentEdge : currentNode.GetAdjacentNodes()){
                queue.add(adjacentEdge);
            }
        }
    }
}
