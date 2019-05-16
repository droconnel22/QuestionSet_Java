package com.crackingcodeinterview;


import java.util.ArrayDeque;
import java.util.HashSet;

// Queue -> First In First Out

public class BreathFirstSearch<T>{

    public void Search(IGraph<T> graph, T value){

        HashSet<INode<T>> searched = new HashSet<>();
        ArrayDeque<INode<T>> queue = new ArrayDeque<>();

        INode<T> origin = graph.FindNode(value);

        queue.addFirst(origin);

        while(!queue.isEmpty()) {
            INode<T> currentNode = queue.removeLast();
            if(searched.contains(currentNode)){
                continue;
            }

            searched.add(currentNode);
            System.out.println(currentNode.GetValue());
            for(INode<T> adjacentNode : currentNode.GetAdjacentNodes()){
                queue.addFirst(adjacentNode);
            }
        }
    }

}
