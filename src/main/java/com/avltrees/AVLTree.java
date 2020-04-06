package com.avltrees;

import java.util.*;

public class AVLTree<T extends Number & Comparable<T>> {

    private AVLNode<T> root;

    public void Insert(T value) {
        if(this.root == null)
            this.root = new AVLNode<T>(value,0,null, null,null);
        else
            insert(this.root, value);
    }

    private void insert(AVLNode<T> node, T value){
        int result =node.getValue().compareTo(value);
        if(result < 0) {
            if(node.getRight() == null){
                AVLNode<T> newNode =
                        new AVLNode<>(value,0,
                                node,
                                null,
                                null);

                node.setRight(newNode);
            } else {
                insert(node.getRight(),value);
            }
        } else if(result > 0) {
            if(node.getLeft() == null) {
                AVLNode<T> newNode =
                        new AVLNode<>(value,
                                0,
                                node,
                                null,
                                null);
                node.setLeft(newNode);
            } else {
                insert(node.getLeft(),value);
            }
        } else {
            // value exists.
        }
    }

    public Optional<AVLNode<T>> FindNodeByValue(T value){
        return findNodeByValue(this.root, value);
    }

    private Optional<AVLNode<T>> findNodeByValue(AVLNode<T> node, T value){
        if(node ==null) {
            return  Optional.empty();
        }
        int result = node.getValue().compareTo(value);
        if(result < 0){
            return findNodeByValue(node.getRight(),value);
        } else if(result > 0) {
            return findNodeByValue(node.getLeft(),value);
        } else {
            return Optional.of(node);
        }
    }

    public Optional<Integer> GetHeightByValue(T value) throws Exception {
        if(value == null){
            throw  new IllegalArgumentException("Value is null");
        }

        Optional<AVLNode<T>> result = this.findNodeByValue(this.root,value);
        if(result.isEmpty()) {
            return Optional.empty();
        }

        int height = 0;
        int r = getHeight(this.root, 0);
        return Optional.of(r);
    }

    private Integer getHeight(AVLNode<T> node, int height){
        if(node ==null){
            return height;
        }

        return Math.max(getHeight(node.getRight(),height+1),
                getHeight(node.getLeft(),height+1));
    }

    public void Display() {
        System.out.println("------------------");
        List<AVLNode<T>> searched = new ArrayList<>();
        Queue<AVLNode<T>> queue = new LinkedList<>();

        queue.add(this.root);
        int count = 1;
        int marker = 0;
        while(!queue.isEmpty()) {
            AVLNode<T> currentNode = queue.remove();
            if(searched.contains(currentNode))
                continue;
            searched.add(currentNode);
            System.out.print(currentNode.getValue()+" ");
            count--;
            if(count <=0) {
                System.out.println();
                marker++;
                count = (int)Math.pow(2,marker);
            }


            if(currentNode.getLeft()!= null)
                queue.add(currentNode.getLeft());
            if(currentNode.getRight() !=null)
                queue.add(currentNode.getRight());

        }

        System.out.println();
    }
}

