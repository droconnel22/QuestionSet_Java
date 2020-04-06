package com.avltrees;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {
    public static void main(String...args) throws Exception {
        var tree = new AVLTree<Integer>();
        Random random = new Random();

       final var results = IntStream.range(0,100)
        .map(i -> random.nextInt(10000))
        .peek(tree::Insert)
        .boxed()
        .collect(Collectors.toList());

       tree.Display();
    }

}
