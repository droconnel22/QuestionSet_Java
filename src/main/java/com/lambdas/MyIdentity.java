package com.lambdas;

@FunctionalInterface
public interface MyIdentity<TIn, TOut> {
    TOut apply(TIn t);
    static <TIn> MyIdentity<TIn,TIn> identity(){ return t->t;}
}
