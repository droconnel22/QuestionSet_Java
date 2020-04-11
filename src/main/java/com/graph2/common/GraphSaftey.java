package com.graph2.common;

import com.graph2.Graph;
import com.graph2.nodes.Node;

import java.util.IllegalFormatException;

public interface GraphSaftey {
    static <TValue extends Comparable<TValue>> void CheckNode(Node<TValue> node) throws IllegalArgumentException{
        if(node == null){
            throw new IllegalArgumentException("Node must be specified");
        }
    }

    static <TValue extends Comparable<TValue>> void CheckGraph(Graph<TValue> node) throws IllegalArgumentException{
        if(node == null){
            throw new IllegalArgumentException("Graph must be specified");
        }
    }

    static <TValue extends Comparable<TValue>> void CheckValue(TValue value) throws IllegalArgumentException {
        if(value == null){
            throw new IllegalArgumentException("Value must be specified");
        }
    }

    static void CheckWeight(Integer weight) throws IllegalAccessError, IllegalArgumentException {
        if(weight == null){
            throw new IllegalAccessError("Weight is null");
        }
       else if(weight < 0){
            throw  new IllegalArgumentException("Weight must be specified and positive");
        }
    }
}
