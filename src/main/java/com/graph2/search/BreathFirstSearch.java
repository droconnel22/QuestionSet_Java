package com.graph2.search;

import com.graph2.Graph;
import com.graph2.common.GraphSaftey;
import com.graph2.nodes.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.graph2.common.GraphSaftey.*;


public interface BreathFirstSearch extends GraphSaftey {
    static <TValue extends Comparable<TValue>> void Search(Graph<TValue> graph, TValue origin){
       CheckValue(origin);
       CheckGraph(graph);
       var searched = new ArrayList<Node<TValue>>();
       Queue<Node<TValue>> queue = new LinkedList<Node<TValue>>();
       var originNodeResult = graph.TryFindNodeByValue(origin);
       if(originNodeResult.isEmpty()){
           throw  new IllegalArgumentException("Origin does not exist.");
       }
       queue.add(originNodeResult.get());
        System.out.println();
        System.out.print("Breath First Search: ");
       while(!queue.isEmpty()) {
           var currentNode = queue.remove();
           if (searched.contains(currentNode)) {
               continue;
           }

           System.out.print("--> " + currentNode.GetValue());
           searched.add(currentNode);
           for(Node<TValue> ajdEdge : currentNode.GetAdjacentEdges()){
               queue.add(ajdEdge);
           }
       }
    }
}
