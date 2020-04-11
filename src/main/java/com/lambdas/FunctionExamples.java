package com.lambdas;

import java.util.function.Consumer;

public class FunctionExamples {
    public static void main(String...args){
        Consumer<String> printer = System.out::println;
    }
}
