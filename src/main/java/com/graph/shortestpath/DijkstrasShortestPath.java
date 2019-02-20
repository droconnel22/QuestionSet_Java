package com.graph.shortestpath;

import com.graph.core.IGraph;
import com.graph.core.INode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class DijkstrasShortestPath<T> {
    private HashMap<INode<T>, Pair<Integer, INode<T>>> distanceTable;

    public DijkstrasShortestPath() {
        distanceTable = new HashMap<>();
    }

    public void Path(IGraph<T> graph, T origin, T destintation) throws Exception {
        INode<T> originNode = graph.FindNode(origin);
        INode<T> destinationNode = graph.FindNode(destintation);

        if(origin == null || destinationNode == null){
            throw new IllegalArgumentException("Origin or destination is invalid");
        }

        BuildDistanceTable(graph, originNode);

        INode<T> currentNode = destinationNode;
        List<INode<T>> path = new ArrayList<>();
        while(currentNode != null && currentNode != originNode){
            path.add(currentNode);
            currentNode = distanceTable.get(currentNode).getValue();
        }

        if(currentNode == null){
            throw new Exception("Path does not exists");
        }

        path.add(currentNode);
        Collections.reverse(path);
        for(INode<T> node : path){
            System.out.println(path.indexOf(node) != path.size() - 1 ? node.GetValue() + " " : node.GetValue() + "\n");
        }
    }

    private  void BuildDistanceTable(IGraph<T> graph, INode<T> originNode) throws Exception{

        // Reset
        distanceTable = new HashMap<INode<T>, Pair<Integer, INode<T>>>();

        // Initialize
        for(INode<T> edge : graph.GetEdges()) {
            distanceTable.put(edge, Pair.of(-1, null));
        }

        // Set origin
        distanceTable.put(originNode, Pair.of(0, originNode));

        // breath first search
        LinkedList<INode<T>> queue = new LinkedList<>();

        // set priority queue
        PriorityQueue<T> priorityQueue = new PriorityQueue<>();
        priorityQueue.Enqueue(originNode,0);


        while(!priorityQueue.Any()){
            INode<T> currentNode = priorityQueue.DequeueMin();
            Integer currentDistance = distanceTable.get(currentNode).getKey();

            for(INode<T> adjacentEdge : currentNode.GetAdjacentNodes()) {

                // Distance between the nodes from the current path
                Integer distance =  currentDistance + graph.GetWeight(currentNode, adjacentEdge);

                // Previous or unseen distance between two nodes
                int neighborDistance = distanceTable.get(adjacentEdge).getKey();

                // not seen yet or is this new path better?
                if(neighborDistance == -1 || distance < neighborDistance){
                    distanceTable.put(adjacentEdge, Pair.of(distance, currentNode));
                    priorityQueue.Enqueue(adjacentEdge, distance);
                }
            }
        }
    }

}
