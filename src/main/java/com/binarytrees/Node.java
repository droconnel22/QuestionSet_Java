package com.binarytrees;


import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {

    private T value;

    private Node<T> right;

    private Node<T> left;


    public Node(T value)
    {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void AddValue(T value) {
        if(value == null){
            return;
        }

        if(this.value.compareTo(value) == 0){
            return;
        } else if(this.value.compareTo(value) < 0){
            if(this.left == null){
                this.left = new Node<>(value);
            } else {
                this.left.AddValue(value);
            }
        } else {
            if(this.right == null){
                this.right = new Node<>(value);
            } else {
                this.right.AddValue(value);
            }
        }
    }

    public Node<T> FindValue(T value) {
        if(value == null){
            return null;
        }

        if (this.value.compareTo(value) == 0) {
            return  this;
        } else if(this.left != null && this.value.compareTo(value) < 0){
            return  this.left.FindValue(value);
        } else if(this.right != null) {
            return this.right.FindValue(value);
        } else {
            return  null;
        }
    }


}
