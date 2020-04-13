package com.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class SimplePipelineDemo {
    public static void main(String...args){
        ExecutorService service = Executors.newFixedThreadPool(4);

        try {
            List<Long> myList = List.of(1L, 2L, 3L);

            CompletableFuture
                    .supplyAsync(() -> myList,service)
                    .thenApplyAsync(list -> list.stream().map(User::new).collect(Collectors.toList()),service)
                    .thenAcceptAsync(users -> {
                        System.out.println(users);
                    })
                    .thenRunAsync(() -> System.out.println("Done!"),service)
                    .whenCompleteAsync((v, t) -> {
                        if (t != null) {
                            t.printStackTrace();
                        }
                    },service);

        BetterSleep.Sleep(1_000L);
        } finally {
            service.shutdown();
        }
    }
}
