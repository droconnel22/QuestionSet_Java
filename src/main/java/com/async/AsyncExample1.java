package com.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class
AsyncExample1 {
    public static void main(String...args) {
        ExecutorService service = Executors.newFixedThreadPool(8);

        Supplier<List<Long>> supplyIds = () -> {
            sleep(300);
            return Arrays.asList(1L,2L,3L);
        };

        Function<List<Long>, List<User>> fetchUsers = ids -> {
            sleep(500);
            return ids
                    .stream()
                    .map(User::new)
                    .collect(Collectors.toList());
        };

        Function<List<Long>, CompletableFuture<List<User>>> fetchUsersAsync = ids -> {
            sleep(1000);
            Supplier<List<User>> userSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
            return CompletableFuture.supplyAsync(userSupplier);
        };

        Consumer<List<User>> displayer = users -> {
            System.out.printf("\n Running in Thread: %s \n", Thread.currentThread().getName());
            users.forEach(System.out::println);
        };

        // Example
        final CompletableFuture<List<Long>> supplyFuture = CompletableFuture.supplyAsync(supplyIds);

        // v1
        supplyFuture
                .thenApply(fetchUsers)
                .thenAccept(displayer);

        // v2
       CompletableFuture.supplyAsync(supplyIds,service)
               .thenComposeAsync(fetchUsersAsync,service)
               .thenAcceptAsync(displayer,service);

       // v3
        CompletableFuture.supplyAsync(supplyIds)
                .thenCompose(fetchUsersAsync)
                .thenAcceptAsync(displayer,service);

       sleep(2000);
       service.shutdown();

    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}

