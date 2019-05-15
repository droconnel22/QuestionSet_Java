package com.collections;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// Sets have uniquness
public class SetSample {

    private Set<Product> ProductHash = new HashSet<>();

    private HashMap<Integer, Product> ProductMap = new HashMap<>();

    public void sampele (){

        Product door = new Product("Door",110.0);
        Product window = new Product("window",222.0);
        Product floorboard = new Product("floor board", 55.0);

        ProductHash.add(door);

        ProductMap.put(door.hashCode(),door);
        ProductMap.put(window.hashCode(),window);
        ProductMap.put(floorboard.hashCode(), floorboard);

        TreeSet<Product> ProductTree = new TreeSet<>(Product.ByCost);
        ProductTree.addAll(ProductMap.values());

    }
}
