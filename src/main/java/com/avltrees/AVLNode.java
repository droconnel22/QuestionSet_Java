package com.avltrees;

public class AVLNode<T extends Comparable<T>> {
    private T value;
    private Integer height;

    private AVLNode<T> parent;
    private AVLNode<T> right;
    private AVLNode<T> left;

    public AVLNode(T value, Integer height, AVLNode<T> parent, AVLNode<T> right, AVLNode<T> left) {
        this.value = value;
        this.height = height;
        this.parent = parent;
        this.right = right;
        this.left = left;
    }

    public AVLNode(T value) {
        this(value,0,null,null,null);
    }

    public AVLNode(T value, AVLNode<T> right, AVLNode<T> left) {
        this(value,0, null, null, null);
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


    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }
}

