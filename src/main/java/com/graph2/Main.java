package com.graph2;

import com.graph2.pathing.DijkstrasShortestPath;
import com.graph2.pathing.ShortestPath;
import com.graph2.search.BreathFirstSearch;
import com.graph2.search.DepthFirstSearch;
import com.graph2.sorting.TopologicalSort;

public class Main {
    public static void main(String...args) throws Exception {
        var graph = new GraphImpl<Integer>(3,true);
        graph.AddValue(0,1,0);
        graph.AddValue(1,2);
        graph.AddValue(0,2);
        graph.AddValue(2,3);
        graph.AddValue(2,4);
        graph.AddValue(3,4);
       //graph.Display();

        var g = new GraphImpl<Integer>(9, true);
        g.AddValue(0,1);
        g.AddValue(1,2);
        g.AddValue(2,7);
        g.AddValue(2,4);
        g.AddValue(2,3);
        g.AddValue(1,5);
        g.AddValue(5,6);
        g.AddValue(6,3);
        g.AddValue(3,4);
        g.AddValue(6,8);
        g.Display();

        BreathFirstSearch.Search(g,1);
        DepthFirstSearch.Search(g,1);
        TopologicalSort.Sort(g);
        ShortestPath.FindShortestPath(g,0,8);
        DijkstrasShortestPath.FindShortestWeightedPath(g,0,6);
    }
}
