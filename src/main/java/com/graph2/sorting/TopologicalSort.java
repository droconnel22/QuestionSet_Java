package com.graph2.sorting;

import com.graph2.Graph;
import com.graph2.nodes.Node;

import java.util.*;

import static com.graph2.common.GraphSaftey.*;

public class TopologicalSort {
    public static <TValue extends Comparable<TValue>> void Sort(Graph<TValue> graph) {

        Map<Node<TValue>, Integer> inDegreeMap = new HashMap<>();
        Queue<Node<TValue>> queue = new LinkedList<>();
        Set<Node<TValue>> path = new HashSet<>();

        // Build Indegree Dictionary
        for(Node<TValue> edge : graph.GetEdges()){
            int indegree = graph.GetInDegrees(edge);
            inDegreeMap.put(edge,indegree);
            if(indegree == 0){
                queue.add(edge);
            }
        }


        while(!queue.isEmpty()){
            var currentNode = queue.remove();
            if(path.contains(currentNode)){
                continue;
            }

            path.add(currentNode);
            for(Node<TValue> ajdNode : currentNode.GetAdjacentEdges()){
               int currentIndgree = inDegreeMap.get(ajdNode);
               currentIndgree-=1;
               inDegreeMap.put(ajdNode,currentIndgree);
               if(currentIndgree == 0){
                   queue.add(ajdNode);
               }
            }
        }
        System.out.println();
        if(path.size() != graph.GetSize()){
            System.out.println("A cycle exists!");
        } else {
            System.out.print("Topological Sort: ");
            for(Node<TValue> e : path){
                System.out.printf(" --> %d", e.GetValue());
            }
        }
        System.out.println();

    }
}
