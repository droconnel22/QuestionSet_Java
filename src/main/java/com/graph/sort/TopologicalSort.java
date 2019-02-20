package com.graph.sort;

import com.graph.core.IGraph;
import com.graph.core.INode;

import java.util.*;

public class TopologicalSort<T> {

    public void Sort(IGraph<T> graph) throws  Exception {

        HashMap<INode<T>, Integer> inDegreeDict = new HashMap<>();
        LinkedList<INode<T>> queue = new LinkedList<>();
        List<INode<T>> searched = new ArrayList<>();

        for(INode<T> edge : graph.GetEdges()){
            int indegree = graph.GetInDegree(edge);
            inDegreeDict.put(edge, indegree);
            if(indegree == 0){
                queue.add(edge);
            }
        }

        while (!queue.isEmpty()){
            INode<T> currentNode = queue.remove();

            if(searched.contains(currentNode)){
                continue;
            }

            searched.add(currentNode);
            System.out.println(currentNode.GetValue());
            for(INode<T> adjacentEdge : currentNode.GetAdjacentNodes()){
                inDegreeDict.put(adjacentEdge, inDegreeDict.get(adjacentEdge)-1);
                if(inDegreeDict.get(adjacentEdge).intValue() == 0){
                    queue.add(adjacentEdge);
                }
            }
        }

        if(searched.size() != graph.GetNumberOfVerticies()){
            throw new Exception("There exists a cycle");
        }

        Collections.reverse(searched);
        for(INode<T> node : searched){
            System.out.println(searched.indexOf(node) != searched.size()-1 ? node.GetValue() + " " : node.GetValue()+"\n");
        }
    }
}
