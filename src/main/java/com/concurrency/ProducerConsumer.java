package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProducerConsumer {


    public static void main(String...args){


        var buffer = new ArrayList<Integer>();
        var lock = new ReentrantLock();

        Predicate<List<Integer>> isEmpty = List::isEmpty;
        Predicate<List<Integer>> isFull = (l) -> l.size() >= 10;
        //Function<List<Integer>, Boolean> isFull = (l) -> l.size() >=50;

        Condition isEmptyCon = lock.newCondition();
        Condition isFullCon = lock.newCondition();


        Callable<String> consumer = () -> {
            int count = 0;
            try {
                while(count++ < 50) {

                    lock.lock();
                    while(isEmpty.test(buffer)) {
                        // wait
                        isEmptyCon.await();
                    }
                    buffer.remove(buffer.size()-1);
                    //signal
                    isFullCon.signalAll();
                }

            } catch (Exception ie) {
                System.out.println(ie.getMessage());
            } finally {
                //guarantee at language level this lock will be called
                lock.unlock();
            }

            return "Consumed " + (count-1);
        };

        Callable<String> supplier = () -> {
            int count =0;
                while (count++ < 50) {
                    try {
                        lock.lock();

                        while (isFull.test(buffer)) {
                            //wait
                            isFullCon.await();
                        }
                        buffer.add(1);
                        //signal
                        isEmptyCon.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }

          return "Produced " + (count -1);
        };


        var service = Executors.newFixedThreadPool(4);
        var producersAndConsumers = List.of(consumer, supplier);
        try {
            var futures = service.invokeAll(producersAndConsumers);
            futures
                    .forEach(c ->{
                        try {
                            System.out.println(c.get(1000, TimeUnit.MILLISECONDS));
                        } catch (InterruptedException | ExecutionException | TimeoutException e) {
                            System.out.println(e.getMessage());
                        }
                    });

        } catch (Exception ex){
          System.out.println(ex.getMessage());
        } finally {
            service.shutdown();
            System.out.println("Service shut down.");
        }

    }
}
