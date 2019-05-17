package com.crackingcodeinterview;

import java.math.BigInteger;
import java.util.HashMap;

public class FiboMemo {

    public BigInteger Fib(BigInteger n, HashMap<BigInteger, BigInteger> memo){
        if(n.intValue() <2){
            return BigInteger.ONE;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        memo.put(n,Fib(n.min(BigInteger.ONE), memo).add(Fib(n.min(BigInteger.ONE.add(BigInteger.ONE)),memo)));
        return memo.get(n);
    }
}
