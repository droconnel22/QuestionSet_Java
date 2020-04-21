package com.hackerrank.dynamic;

/*
Think of base case and build approach
Towers of Hanoi: In the classic problem of the Towers of Haoi, you have 3 towers
and N disks of different sizes which can slide onto any tower.

The puzzle starts with disks sorted in ascending order of size from top to bottom
(i.e each disk sits on top of a larger disk).

YOu have the following constraints:
1. Only one disk can bse moved at a time
2. A disk is slid off the top of one tower onto another tower
3. A disk cannot be placed on top of a smaller disk

Write a program to move the disks from the first tower to the last using Stacks
First in First Out (FiFo)

Examples:
Smallest possible example: n  = 1
case n  = 1
Can we move Disk 1 from Tower 1 to Tower 3? Yes.

1. we simply move disk1 from tower 1 to tower 3.

Example 2:
Case n = 2. Can we move Disk 1 and Disk 2 from Tower 1 to Tower 3? Yes.

1. Move Disk 1 from Tower 1 to Tower 2
2. Move Disk 2 from Tower 1 to Tower 3
3. Move Disk 1 from Tower 2 to Tower 3

Example 3:
Case n = 3.  Can we move Disk 1,2, and 3 from Tower 1 to 3. Yes



 */

import java.util.*;

public class TowersOfHanoi {

    private static class Tower<T> {
        private class Node<T> {
            T value;
            Node next;

            public Node(T value) {
                this.value = value;
                this.next =null;
            }
        }

        private Node<T> root;
        private Node<T> tail;
        private int count;

        public Tower() {
            this.root = null;
            this.tail = null;
            this.count = 0;
        }

        public Tower(List<T> items){
           this.count = 0;
           this.root = null;
           this.seedInPlace(items);
        }

        private void seedInPlace(List<T> items){
            Node<T> node = this.root;
            for(T item : items){
                Node<T> newNode = new Node<T>(item);
                this.count++;
                if(node == null){
                    node = newNode;
                    this.root = newNode;
                } else {
                    node.next = newNode;
                    node = node.next;
                }
            }
        }
        // Seed is not stacked
        private void seed(List<T> items){
            for(T item: items) {
                Node<T> newNode = new Node<T>(item);
                this.count++;
                if(this.root == null){
                    this.root = newNode;
                } else {
                    Node temp = this.root;
                    newNode.next = temp;
                    this.root = newNode;
                }
            }

        }

        public void AddValue(T value){
            if(this.root == null){
                this.root = new Node<>(value);
                this.tail = this.root;
            }

            this.count++;
            Node<T> node = new Node<>(value);
            node.next = this.root;
            this.root = node;
        }

        public Optional<T> TryPeek() {
            if(this.root == null)
                return Optional.empty();
            return Optional.of(this.root.value);
        }

        public Optional<T> TryPop() {
            if(this.root == null)
                return Optional.empty();
            Node<T> temp = this.root;
            this.root = this.root.next;
            count--;
            return Optional.of(temp.value);
        }

        public Integer GetCount() {
            return this.count;
        }

        public void Display(){
            System.out.println();
            if(this.root == null){
                System.out.println("Tower is empty");
            }
            Node<T> current = this.root;
            while(current.next != null){
                System.out.print(current.value+", ");
                current =current.next;
            }
        }
    }

    public static void main(String...args){
        Tower<Integer> tower1 = new Tower<>(List.of(1,2,3,4,5));
        tower1.Display();
        Tower<Integer> tower2 = new Tower<>();
        Tower<Integer> tower3 = migrateTowers(tower1,tower2);
        tower3.Display();

    }

    private static Tower migrateTowers(Tower<Integer> tower1, Tower<Integer> tower2) {

        // base case
        var valueResult = tower1.TryPop();
        Tower tower3;
        if(tower1.GetCount() == 0){
             tower3 = new Tower();
             tower3.AddValue(valueResult.get());
             return tower3;
        } else{
            tower2.AddValue(valueResult.get());
            tower3 = migrateTowers(tower1,tower2);
            tower3.AddValue(tower2.TryPop().get());
        }

        return tower3;
    }


}
