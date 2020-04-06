package com.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheWithReadWriteLock {
    private Map<Long,String> cache = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public String put(long key, String value){
        writeLock.lock();
        try {
            return cache.put(key,value);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(long key){
        readLock.lock();
        try {
            return cache.getOrDefault(key,"Missing");
        } finally {
            readLock.unlock();
        }

    }

    public static void main(String...args) {
        var cacheWithReadWriteLock = new CacheWithReadWriteLock();

        Callable<Void> producer  = () -> {
            var random = new Random();

            while(true) {
                long key = random.nextInt(1_000);
                cacheWithReadWriteLock.put(key, Long.toString(key));
                if(cacheWithReadWriteLock.get(key) == "Missing") {
                    System.out.printf("\n %d has not been put in the map \n",key);
                }
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(4);

        try {
            for(int i =0; i < 4;i++) {
                service.submit(producer);
            }

        } finally {
            service.shutdown();
        }

    }
}
