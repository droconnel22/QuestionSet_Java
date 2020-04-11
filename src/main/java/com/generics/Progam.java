package com.generics;

import java.util.*;
import java.util.stream.Collectors;

public class Progam {
    public static void main(String...args) throws  Exception {
        Company<Parent> company = new Company<>();

        Person dennis = new Person("Blue",20, "Dennis");
        company.addEntity(dennis);

        Employee dean = new Employee("Cook","Green",21,"Dean");
        company.addEntity(dean);

        Parent father = new Parent("Green");

        var officeBuilding = new Officebuilding();
        officeBuilding.AddTenant(company.getEntities());
        officeBuilding.Display();

        final Class<?> className = Class.forName(Person.class.getName());

        Parent guardain = new Parent("Purple");
        Company<? super Parent> parentCompany = new Company<>();
        parentCompany.addEntity(guardain);
        parentCompany.addEntity(dean);
        parentCompany.addEntity(dennis);
        parentCompany.Display();


    }

    @SafeVarargs
    public static <T> List<? extends  T> combine(List<? extends  T>...items) {
        return  Arrays
                .stream(items)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}




class Parent {
    protected   String color;

    public Parent(String color) {
        this.color = color;
    }
}

class Person extends Parent {
    protected final int age;

    private final String name;

    public Person(String color, int age, String name){
        super(color);
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "color='" + color + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Employee extends Person {
    protected final String job;

    public Employee(String job, String colour, int age, String name){
        super(colour,age,name);
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "color='" + color + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}

class Company<TEntity> {
    private Set<TEntity> entities;

    public Company(){
        this.entities = new HashSet<>();
    }

    public List<TEntity> getEntities() { return new ArrayList<>(this.entities);}

    public void addEntity(TEntity entity) { this.entities.add(entity);}

    public void Display(){
        System.out.println();
        for(TEntity entity : this.entities){
            System.out.println(entity);
        }
    }

}

// Contra variant
class Officebuilding {
    private  List< List<? super  Employee>> tenats;

    public Officebuilding() {
        this.tenats = new ArrayList<>();
    }

    public void AddTenant(final List<? super Employee> employees) { this.tenats.add(employees);}
    public void Display(){
        System.out.println();
        for(List<? super  Employee> employees : this.tenats){
            for(Object obj : employees){
                System.out.println(obj);
            }
        }
    }

}

// Covariant
class MovieTheater {
    private List<List<? extends  Parent>> groups;

    public MovieTheater() {
        this.groups = new ArrayList<>();
    }

    public List<List<? extends Parent>> getGroups() {
        return groups;
    }

    public void setGroups(List<List<? extends Parent>> groups) {
        this.groups = groups;
    }
}
