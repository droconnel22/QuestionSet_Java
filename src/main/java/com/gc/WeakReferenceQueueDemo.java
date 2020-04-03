package com.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeakReferenceQueueDemo {
    public static void main(String...args)  {
        Person p = new Person();
        final ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        PersonCleaner personCleaner = new PersonCleaner();
        PersonWeakReference weakReference = new PersonWeakReference(p,personCleaner,referenceQueue);

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.execute(() -> {
            try {
                PersonWeakReference wr = (PersonWeakReference) referenceQueue.remove();
                wr.clean();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        p = null;
        System.gc();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press any Key to contine");
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

final class Person {

}

class PersonCleaner {
public void clean() {
    System.out.println("Cleaned");
}
}

class PersonWeakReference extends WeakReference<Person> {
    PersonCleaner cleaner;
    public PersonWeakReference(Person referrent, PersonCleaner cleaner, ReferenceQueue<? super Person> q) {
        super(referrent,q);
        this.cleaner = cleaner;
    }

    public void clean(){
        this.cleaner.clean();
    }
}
