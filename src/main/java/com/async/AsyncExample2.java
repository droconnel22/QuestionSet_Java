package com.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class AsyncExample2 {
    public static void main(String...args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(4);
        try {

            Supplier<List<Long>> supplyIds = () -> {
                BetterSleep.Sleep(300);
                return Arrays.asList(1L,2L,3L);
            };

            Supplier<Optional<List<Long>>> trySupplyIds = () -> {
                BetterSleep.Sleep(300L);
                return Optional.of(List.of(1L,2L,3L));
            };

            Function<List<Long>, CompletableFuture<List<User>>> fetchUsersAsyncFast = ids -> {
                BetterSleep.Sleep(150L);
                Supplier<List<User>> userSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
                return CompletableFuture.supplyAsync(userSupplier);
            };

            Function<List<Long>, CompletableFuture<List<User>>> fetchUsersAsyncSlow = ids -> {
                BetterSleep.Sleep(5000L);
                Supplier<List<User>> userSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
                return CompletableFuture.supplyAsync(userSupplier);
            };


            Function<List<Long>, CompletableFuture<List<Email>>> fetchEmailsAsyncMed= ids -> {
                BetterSleep.Sleep(1000L);
                Supplier<List<Email>> emailSupplier = () -> ids.stream().map(Email::new).collect(Collectors.toList());
                return CompletableFuture.supplyAsync(emailSupplier);
            };

            Consumer<List<User>> displayer = users -> {
                System.out.printf("\n Running in Thread: %s \n", Thread.currentThread().getName());
                users.forEach(System.out::println);
            };

         CompletableFuture.supplyAsync(trySupplyIds,service)
                    .exceptionally((err)-> {
                        err.printStackTrace();
                        return Optional.empty();
                    });


         final var supplyFuture = CompletableFuture.supplyAsync(supplyIds);

         final var userFutureFast = supplyFuture.thenComposeAsync(fetchUsersAsyncFast, service);

         final var userFutureSlow = supplyFuture.thenComposeAsync(fetchUsersAsyncSlow, service);

         final var emailFutureMed = supplyFuture.thenComposeAsync(fetchEmailsAsyncMed, service);


         userFutureFast.thenAcceptBothAsync(emailFutureMed, (users,emails)-> {
             System.out.printf("\n User count: %d | Email count; %d \n", users.size(), emails.size());
         });

         userFutureFast.acceptEither(userFutureSlow,displayer);


         BetterSleep.Sleep(1_000L);
        } finally {
            service.shutdown();
        }
    }
}
