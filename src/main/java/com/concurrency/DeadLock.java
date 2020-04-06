package com.concurrency;

public class DeadLock {
    private static Object monitor1 = new Object();
    private static Object monitor2 = new Object();

    public void a() {
        synchronized (monitor1) {
            System.out.println("I am holding monitor 1 and I am in thread " + Thread.currentThread().getName() );
            b();
        }
    }

    public void b() {
        synchronized (monitor2){
            System.out.println("I am holding monitor 2 and I am in thread " + Thread.currentThread().getName() );
            c();
        }
    }

    public void c(){
        synchronized (monitor1){
            System.out.println("I am holding monitor 1 and I am in thread " + Thread.currentThread().getName() );
        }
    }

    public static void main(String...args) {
       var deadLock = new DeadLock();
       Runnable r1 = deadLock::a;
       Runnable r2 = deadLock::b;


       Thread t1 = new Thread(r1);
       Thread t2 = new Thread(r2);

       t1.start();
       t2.start();

       try {
           t1.join();
           t2.join();
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
    }
}
