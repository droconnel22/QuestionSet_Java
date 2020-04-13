package com.graph2.pathing;

import com.graph2.Graph;
import com.graph2.common.*;
import com.graph2.nodes.Node;

import java.util.*;

import static com.graph2.common.GraphSaftey.*;

public class ShortestPath {

    public static <TValue extends Comparable<TValue>> void FindShortestPath(Graph<TValue> graph, TValue start, TValue end){
        CheckGraph(graph);
        CheckValue(start);
        CheckValue(end);

        var startNodeResult = graph.TryFindNodeByValue(start);
        var endNodeResult = graph.TryFindNodeByValue(end);

        if(startNodeResult.isEmpty() || endNodeResult.isEmpty()){
            throw new IllegalArgumentException("Impossible path, start or finish does not exist.");
        }

        var startNode = startNodeResult.get();
        var endNode = endNodeResult.get();


        Queue<Node<TValue>> queue = new LinkedList<>();
        List<Node<TValue>> searched = new ArrayList<>();

        // Initialize Distance Table
        Map<Node<TValue>, Pair<Integer, Node<TValue>>> distanceTable = new HashMap<>();

        // Populate Distance Table
        for(Node<TValue> edge : graph.GetEdges()){
            distanceTable.put(edge, new Pair<>(-1,null));
        }

        // Set For Origin
        distanceTable.put(startNode,new Pair<>(0,startNode));
        queue.add(startNode);

        while(!queue.isEmpty()){
            var currentNode = queue.remove();
            var currentDistance = distanceTable.get(currentNode).getT1();
            if(searched.contains(currentNode)){
                continue;
            }
            searched.add(currentNode);
            for(Node<TValue> adjEdge : currentNode.GetAdjacentEdges()){
                var distance = distanceTable.get(currentNode).getT1();
                if(distance == -1 || currentDistance < distance){
                    distanceTable.put(adjEdge,new Pair<>(currentDistance+1,currentNode));
                }
                if(!adjEdge.GetAdjacentEdges().isEmpty()) {
                    queue.add(adjEdge);
                }
            }
        }

        List<Node<TValue>> path = new ArrayList<>();
        path.add(endNode);
        var currentNode = endNode;
        while(currentNode != null && currentNode != startNode){
            path.add(currentNode);
            currentNode = distanceTable.get(currentNode).getT2();
        }
        if(currentNode == null){
           System.out.println("No path exists!");
           return;
        }
        path.add(startNode);
        Collections.reverse(path);
        System.out.println();
        System.out.print("Shortest Path Unweighted: ");
        for(Node<TValue> edge : path) {
            System.out.print(" --> " + edge.GetValue());
        }

        System.out.println();

    }
}
