package com.graph2.common;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PriorityQueue<TItem, TWeight extends Number & Comparable<TWeight>> {
    private final Map<TItem, TWeight> queue;

    public PriorityQueue() {
        this.queue = new HashMap<>();
    }

    public void Enqueue(TItem item, TWeight weight){
        queue.putIfAbsent(item,weight);
    }

    public Optional<TItem> TryPeekMin() {
        if(this.queue.isEmpty()){
           return Optional.empty();
        }
        return this.queue
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Optional<TItem> DequeueMin() {
        if(this.queue.isEmpty()){
            return Optional.empty();
        }
        var result = this.TryPeekMin();
        result.ifPresent(this.queue::remove);
        return result;
    }

    public Integer GetSize()  {
        return this.queue.size();
    }
}
