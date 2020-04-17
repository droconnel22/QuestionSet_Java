package com.avltrees;

import java.util.*;

public class AVLTree<T extends Number & Comparable<T>> {

    private AVLNode<T> root;

    public void Insert(T value) {
        this.root = this.insert(this.root, value);
    }

    private Integer getHeight(AVLNode<T> node) {
        if(node == null)
            return 0;
        return node.getHeight();
    }

    private Integer getBalance(AVLNode<T> node) {
        if(node == null)
            return 0;
        // check balance of children
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private AVLNode<T> insert(AVLNode<T> node, T value){
        // 1. traditional node insert
        if(node == null)
            return new AVLNode<>(value);

        int result = node.getValue().compareTo(value);
        if(result > 1) {
            node.setLeft(insert(node.getLeft(),value));
        } else if(result < 1) {
            node.setRight(insert(node.getRight(),value));
        } else {
            return node;
        }

        // Update Height
        node.setHeight(1 +Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));

        // Check Balance cases
        int balance = getBalance(node);

        // There are 4 cases if balance is off
        // If balance factor is greater than 1, then the current node is unbalanced
        //  . To check whether it is left left case or not, compare
        //  the newly inserted key with the key in left subtree root.

        //  BST property (keys(left) < key(root) < keys(right)).
        // Left Left Case
        if(balance > 1 && value.compareTo(node.getLeft().getValue()) < 0)
            return  rightRotate(node);

        // Right Right Case
        if(balance < -1 && value.compareTo(node.getRight().getValue()) > 0)
            return leftRotate(node);

        // Left Right Case
        if(balance > 1 && value.compareTo(node.getLeft().getValue()) > 0)
            return  rightRotate(node);

        // Right Left Case
        if(balance < -1 && value.compareTo(node.getRight().getValue()) < 0)
            return leftRotate(node);

        return node;
    }

    /*
    T1, T2 and T3 are subtrees of the tree
rooted with y (on the left side) or x (on
the right side)
     y                               x
    / \     Right Rotation          /  \
   x   T3   - - - - - - - >        T1   y
  / \       < - - - - - - -            / \
 T1  T2     Left Rotation            T2  T3
Keys in both of the above trees follow the
following order
 keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)
So BST property is not violated anywhere.
     */
    private AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = y.getLeft();
        AVLNode<T> T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        // Recalculate height
        x.setHeight(1+Math.max(getHeight(x.getRight()), getHeight(x.getLeft())));
        y.setHeight(1+Math.max(getHeight(y.getRight()), getHeight(y.getLeft())));

        // Return root
        return x;
    }

    private AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> y = x.getRight();
        AVLNode<T> T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        //Recalculate height
        x.setHeight(1+Math.max(getHeight(x.getRight()), getHeight(x.getLeft())));
        y.setHeight(1+Math.max(getHeight(y.getRight()), getHeight(y.getLeft())));

        // Return root
        return y;
    }


    public Optional<AVLNode<T>> TryFindNodeByValue(T value){
        return tryFindNodeByValue(this.root, value);
    }

    private Optional<AVLNode<T>> tryFindNodeByValue(AVLNode<T> node, T value){
        if(node ==null) {
            return  Optional.empty();
        }
        int result = node.getValue().compareTo(value);
        if(result < 0){
            return tryFindNodeByValue(node.getRight(),value);
        } else if(result > 0) {
            return tryFindNodeByValue(node.getLeft(),value);
        } else {
            return Optional.of(node);
        }
    }

    public Optional<Integer> GetHeightByValue(T value) throws Exception {
        if(value == null){
            throw  new IllegalArgumentException("Value is null");
        }

        Optional<AVLNode<T>> result = this.tryFindNodeByValue(this.root,value);
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

