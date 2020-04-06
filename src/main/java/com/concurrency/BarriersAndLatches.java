package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/*
 // barriers have several tasks wait for each other
 // latches count down operations and let a task start; Once open can't be closed
 // when all the threads are done then a merging operation is run

 // remember barriers can be reset, latches can not.
 */
public class BarriersAndLatches {

    public static void main(String...args) {
        var bal = new BarriersAndLatches();
        System.out.println(bal.isPrime(37));
        System.out.println(bal.isPrime(81));
        System.out.println(bal.isPrime(1234568));
        System.out.println(bal.isPrime(19));

        var inputSet = new ArrayList<Integer>();


        // this callable has to wait for the other tasks launched in parallel
        // when its task is done
        // for this we need a cyclic barrier object
        // the parameter is the number of task that will be launched
        CyclicBarrier barrier = new CyclicBarrier(4, ()-> System.out.println("Barrier has opened"));
        ExecutorService service = Executors.newFixedThreadPool(4);


        Callable<Set<Integer>> task = () -> {
            Set<Integer> result = bal.findPrimes(inputSet);
            try {
                // blocks until every thread is ready.
                barrier.await();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return result;
        };

        // call back task for when the barrier is opened.
        Future<Set<Integer>> future = service.submit(task);

        try {
            future.get().forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            service.shutdown();
        }
    }

    public Set<Integer> findPrimes(List<Integer> inputSet) {
        return
                inputSet
                .stream()
                .filter(this::isPrime)
                .collect(Collectors.toSet());
    }

    public boolean isPrime(long number){
      if(number %2 ==0)
          return false;

        for(int i =3; i <Math.sqrt(number);i+=2) {
            if(number%i ==0)
                return false;
        }
        return true;
    }
}


