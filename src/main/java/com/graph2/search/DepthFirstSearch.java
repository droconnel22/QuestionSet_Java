package com.graph2.search;

import com.graph2.Graph;
import com.graph2.nodes.Node;

import java.util.HashSet;
import java.util.Set;

import static com.graph2.common.GraphSaftey.*;

public interface DepthFirstSearch {
    static <TValue extends Comparable<TValue>> void Search(Graph<TValue> graph, TValue origin){
        CheckValue(origin);
        CheckGraph(graph);
        var originNodeResult = graph.TryFindNodeByValue(origin);
        if(originNodeResult.isEmpty()){
            throw new IllegalArgumentException("Origin not present");
        }
        Set<Node<TValue>> searched = new HashSet<Node<TValue>>();
        System.out.println();
        System.out.print("Depth First Search: ");
        search(originNodeResult.get(),searched);
    }

    static<TValue extends Comparable<TValue>> void search(Node<TValue> currentNode, Set<Node<TValue>> searched){
        if(searched.contains(currentNode)){
            return;
        }
        System.out.print("--> " + currentNode.GetValue());
        searched.add(currentNode);
        for(Node<TValue> adjEdge : currentNode.GetAdjacentEdges()){
            search(adjEdge,searched);
        }
    }
}
