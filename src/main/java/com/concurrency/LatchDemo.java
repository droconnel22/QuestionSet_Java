package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class LatchDemo {

    @FunctionalInterface
    public interface CallableWithException<T, E extends Exception> extends Callable<T> {
        T call() throws E;
    }


    public static void main(String...args) throws Exception{
        // assume 3 services
        // will until all threads are completed
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService service= Executors.newFixedThreadPool(8);

        List<ServiceWorker> serviceWorkerTasks = List.of(
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService()),
                new ServiceWorker(latch, new DemoService())
        );

        try {
            service.invokeAll(serviceWorkerTasks, 10000, TimeUnit.MILLISECONDS)
                    .stream()
                    .map(f -> {
                        try {
                          return f.get();
                        } catch (InterruptedException |ExecutionException e) {
                            System.out.println(e.getMessage());
                            return new ArrayList<>();
                        }
                    })
                    .forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("Shutting down..");
            service.shutdown();
        }
    }

}

class DemoService {
    public void Init(int millis){
        try {

            Thread.sleep(millis);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}


class ServiceWorker implements LatchDemo.CallableWithException<List<Integer>,Exception> {
    private CountDownLatch latch;
    private DemoService service;

    public ServiceWorker(CountDownLatch latch, DemoService service) {
        this.latch = latch;
        this.service = service;
    }


    @Override
    public List<Integer> call() throws Exception {
        var random = new Random();
        System.out.println("Called service on thread: " + Thread.currentThread().getName());
        service.Init(random.nextInt(10));
        latch.countDown();
        System.out.println("Latch count remaining: " + latch.getCount());
        return List.of(random.nextInt(10));
    }
}