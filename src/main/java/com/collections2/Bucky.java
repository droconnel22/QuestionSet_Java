package com.collections2;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class Bucky {
    public static void main(String...args) throws Exception {
        String[] stuff = {"eggs","lasers","hats","pie"};
        List<String> stuffList = new ArrayList<>(Arrays.asList(stuff));


        Iterator<String> stuffIterator = stuffList.iterator();
        while(stuffIterator.hasNext())
            System.out.println(stuffIterator.next());


        String[] things = {"apples","noobs","pwnge","bacon","goats"};
        List<String> linkedList = new LinkedList<>(
                Arrays.asList(things)
        );

        String[] things2 = {"sausage","bacon","goast","harrypotter"};
        List<String> linkedList2 = new LinkedList<>(
                Arrays.asList(things2)
        );

        linkedList2
                .stream()
                .filter(i -> !linkedList.contains(i))
                .forEach(linkedList::add);

        for(int i = 0; i < linkedList.size()/2 ; i++) {
            int j = linkedList.size()-1-i;
            String temp = linkedList.get(i);
            linkedList.set(i,linkedList.get(j));
            linkedList.set(j,temp);
        }

        linkedList.forEach(System.out::println);



        MySuperDuperClass superDuperClass =
                new MySuperDuperClass(
                        "Bananas",
                        "Strawberries");

        superDuperClass.AmIFat();
        superDuperClass.Execute();
        superDuperClass.ExecuteMeToo();
        superDuperClass.MyDefaultYell();
        superDuperClass.MyOverloadedYell();

        CompareInterface
                .MaxAsync(Integer::compareTo, 9,8,7,6,1,23,45,6)
                .exceptionally(e-> Optional.empty())
                .whenComplete((o,e) -> o.ifPresent(System.out::println));
    }
}

interface CompareInterface {
    static <T extends Number & Comparable<T>> CompletableFuture<Optional<T>> MaxAsync(Comparator<T> comparer, T... a) throws IllegalArgumentException, InterruptedException {
        if (a.length == 0) throw new IllegalArgumentException("varags are empty");
        if (comparer == null) throw new IllegalArgumentException("Comparator required");
        Thread.sleep(5000);
        return CompletableFuture
                .supplyAsync(() ->
                        Arrays.stream(a)
                                .reduce((cur, next) -> comparer.compare(cur, next) < 0 ? next : cur));
    }
}




interface MyInteface {
    void Execute();
}

interface MyotherInteface {
    void ExecuteMeToo();
}

interface MyFatInteface {
    default void AmIFat() {
        System.out.println("MY Fat interface is fat");
    }

    static void WhoAmi() {
        System.out.println(MyFatInteface.class.getCanonicalName());
    }

    static <T extends Number & Comparable<T>> Optional<T> Max(Comparator<T> comparer, T ... a) throws IllegalArgumentException, IOException {
        if(comparer == null) throw new IllegalArgumentException("Compararer required");
        return Arrays.stream(a)
                .reduce((cur,next) -> comparer.compare(cur,next) < 0 ? next : cur );
    }
}

abstract  class MyBaseClass {
    private String name;

    public MyBaseClass(String name) {
        this.name = name;
    }

    public abstract void DoStuff();
}

class MyImpl extends MyBaseClass {

    public MyImpl(String name) {
        super(name);
    }

    public MyImpl(String name, String nickName) {
        this(name+nickName);
    }

    @Override
    public void DoStuff() {
        System.out.println("Stuff Done!");
    }
}

class MyImplInterface implements MyInteface ,MyotherInteface {

    @Override
    public void Execute() {
        System.out.println("Executed!");
    }

    @Override
    public void ExecuteMeToo() {
        System.out.println("Execute Me too!");
    }
}

abstract class MyOverloadedBaseClass implements MyInteface, MyotherInteface, MyFatInteface {
    protected String favoriteSaying;

    public MyOverloadedBaseClass(String favoriteSaying) {
        this.favoriteSaying = favoriteSaying;
    }

    protected abstract void MyOverloadedYell();

    protected void MyDefaultYell() {
        System.out.println("Default Yell!");
    }
}

class MySuperDuperClass extends  MyOverloadedBaseClass {


    static {
        Integer staticI = 5;
        System.out.println("Static block!!");
    }

    public MySuperDuperClass(String myFavoriteSaying) {
        super(myFavoriteSaying);

    }

    public MySuperDuperClass(String myFavoriteSaying, String myAfterthought) {
        this(myFavoriteSaying+myAfterthought);
    }

    @Override
    protected void MyOverloadedYell() {
        System.out.println("My overloaded yell!");
    }

    @Override
    public void Execute() {
        System.out.println("My Super Duper Execute!");
    }

    @Override
    public void ExecuteMeToo() {
        System.out.println("My Super Duper Execute Me to!");
    }

    @Override
    protected void MyDefaultYell() {
        super.MyDefaultYell();
        System.out.println("After the super default yell!");
    }

    @Override
    public void AmIFat() {
        System.out.println("MY super duper execute is NOT fat");
        MyFatInteface.WhoAmi();
    }
}
