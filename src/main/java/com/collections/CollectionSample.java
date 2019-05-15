package com.collections;


import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSample {


    public void sample(){
        Product door = new Product("Door",110.0);
        Product window = new Product("window",222.0);
        Product floorboard = new Product("floor board", 55.0);

        Collection<Product> products = new ArrayList<>();

        products.add(door);
        products.add(window);
        products.add(floorboard);

        final Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()){
            System.out.println(productIterator.next());
        }
    }
}
