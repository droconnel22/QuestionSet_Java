package com.avltrees;

public class AVLNode<T extends Comparable<T>> {
    private T value;
    private AVLNode<T> right;
    private AVLNode<T> left;

    public AVLNode(T value) {
        this.value = value;
        this.right =null;
        this.left =null;
    }

    public AVLNode(T value, AVLNode<T> right, AVLNode<T> left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public T getValue() {
        return value;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public AVLNode<T> getLeft() {
        return left;
    }
}
