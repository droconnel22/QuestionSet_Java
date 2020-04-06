package com.concurrency;

public class SingletonPattern {
    private static SingletonPattern instance;

    private SingletonPattern(){}

    // every java object has a lock key
    // another thread will wait for the key to become available
    // synchronized handles the key management for the object
    // key is also known as a monitor
    // synchronzied choses the class itself for static
    // synchnronized choses the instance
    public static synchronized SingletonPattern GetInstance(){
        if(instance == null){
            instance = new SingletonPattern();
        }
        return instance;
    }
}

class Person {

    private  final Object monitor = new Object();

    private  final Object ageMonitor = new Object();

    private String name;

    private Integer age;

    // explicit object for key ownership
    public void setName(String name) {
        synchronized (monitor){
            this.name = name;
        }
    }

    // oof now we have two different keys acting on the same instance
    // means we can have sync issues as one field will be independently updated over another
    public void setAge(Integer age) {
        synchronized (ageMonitor) {
            this.age = age;
        }
    }
}
