package com.collections;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Product {
    public String name;
    public Double cost;

    public static final Comparator<Product> ByCost
            = new Comparator<Product>()
    {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.cost.compareTo(o2.cost);
        }
    };
}
