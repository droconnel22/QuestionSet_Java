package com.graph2.pathing;

import com.graph2.Graph;
import com.graph2.common.PriorityQueue;
import com.graph2.nodes.Node;

import java.util.*;

import static com.graph2.common.GraphSaftey.CheckGraph;
import static com.graph2.common.GraphSaftey.CheckValue;
import com.graph2.common.*;

public class DijkstrasShortestPath {
    public static <TValue extends Comparable<TValue>> void FindShortestWeightedPath(Graph<TValue> graph, TValue start, TValue end){
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

        // Initialize Distance Table
        Map<Node<TValue>, Pair<Integer, Node<TValue>>> distanceTable = new HashMap<>();

        // Populate Distance Table
        for(Node<TValue> edge : graph.GetEdges()){
            distanceTable.put(edge, new Pair(-1,null));
        }

        // Set For Origin
        distanceTable.put(startNode,new Pair<>(0,startNode));

        var searched = new ArrayList<Node<TValue>>();
        var queue = new PriorityQueue<Node<TValue>, Integer>();
        queue.Enqueue(startNode, 0);

        while(queue.GetSize() > 0){
            var currentNode = queue.DequeueMin().get();
            var currentDistance = distanceTable.get(currentNode).getT1();
            if(searched.contains(currentNode)){
                continue;
            }
            searched.add(currentNode);
            for(Node<TValue> adjEdge : currentNode.GetAdjacentEdges()){
                // have we been here before
                var adjacentDistance = distanceTable.get(adjEdge).getT1();

                // how costly is the distance
                var weightBetween = currentNode.GetWeight(adjEdge);

                // total distance arriving from current node
                var totalDistance = currentDistance+weightBetween;

                if(adjacentDistance == -1 || totalDistance < adjacentDistance){
                    distanceTable.put(adjEdge, new Pair<>(totalDistance,currentNode));
                }

                if(!adjEdge.GetAdjacentEdges().isEmpty()) {
                    queue.Enqueue(adjEdge,weightBetween);
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
        System.out.print("Dijkstras Path Unweighted: ");
        for(Node<TValue> edge : path) {
            System.out.print(" --> " + edge.GetValue());
        }

        System.out.println();
    }
}
