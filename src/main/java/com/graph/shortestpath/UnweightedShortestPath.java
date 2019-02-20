package com.graph.shortestpath;

import com.graph.core.IGraph;
import com.graph.core.INode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class UnweightedShortestPath<T> {

    private HashMap<INode<T>, Pair<Integer, INode<T>>> distanceTable;

    public UnweightedShortestPath() {
        this.distanceTable = new HashMap<>();
    }

    public void Path(IGraph<T> graph, T origin, T destination) throws Exception {
        INode<T> originNode = graph.FindNode(origin);
        INode<T> destinationNode = graph.FindNode(destination);

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


    private  void BuildDistanceTable(IGraph<T> graph, INode<T> originNode){

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

        // set queue
        queue.add(originNode);

        while(!queue.isEmpty()){
            INode<T> currentNode = queue.remove();

            Integer currentDistance = distanceTable.get(currentNode).getKey();
            for(INode<T> adjacentEdge : currentNode.GetAdjacentNodes()) {
                Integer distance = distanceTable.get(adjacentEdge).getKey();

                if(distance == -1) {
                    distanceTable.put(adjacentEdge, Pair.of(distance+currentDistance, currentNode));
                    if(!adjacentEdge.GetAdjacentNodes().isEmpty()){
                        queue.add(adjacentEdge);
                    }
                }
            }
        }
    }

}
