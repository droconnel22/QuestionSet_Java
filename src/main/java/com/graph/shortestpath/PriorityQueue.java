package com.graph.shortestpath;

import com.graph.core.INode;

import java.util.HashMap;

public class PriorityQueue<T> {

    private HashMap<INode<T>, Integer> queue;

    public PriorityQueue() {
        this.queue = new HashMap<>();
    }

    public void Enqueue(INode<T> node, Integer weight) throws  Exception {
        if(node == null){
            throw new  IllegalArgumentException("Node was null");
        }

        queue.put(node,weight);
    }

    public INode<T> DequeueMin(){
        if(queue.isEmpty()){
            return  null;
        }

        INode<T> resultNode = queue.entrySet().stream().min((k,p) -> k.getValue()).get().getKey();
        queue.remove(resultNode);
        return resultNode;
    }

    public Boolean Any() {return queue.isEmpty();}

    public INode<T> Peek() {
        if(queue.isEmpty()){
            return null;
        }

        return queue.entrySet().stream().min((k,p) -> k.getValue()).get().getKey();
    }
}
