package com.crackingcodeinterview;





public class LinkedListMidInsertion<T extends Comparable<T>> {

    private LinkedNode<T> root = null;

    public void BuildList(T[] array){

        for(T item : array){

            if(this.root == null){
                root = new LinkedNode<>(item);
            } else {
                LinkedNode<T> current = this.root;
                while(current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(new LinkedNode<>(item));
            }
        }
    }

    public void Display() {

        LinkedNode<T> currentNode = this.root;
        while(currentNode != null){
            System.out.print(currentNode.getValue()+ " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public void Insert(T value){
        LinkedNode<T> currentNode = this.root;
        while(currentNode.getNext().getValue().compareTo(value) < 0){
            currentNode = currentNode.getNext();
        }

        LinkedNode<T> node = new LinkedNode<>(value);
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
    }
}
