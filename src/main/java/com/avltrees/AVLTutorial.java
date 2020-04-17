package com.avltrees;


import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

// Java will set a default access to a given class, method or property.
// The default access modifier is also called package-private,
// which means that all members are visible within the same
// package but aren't accessible from other packages
public class AVLTutorial {

    public static void main(String...args){
        var tree = new AVLTree();

        IntStream.range(0,10)
                .forEach(i -> {
                    tree.root = tree.insert(tree.root, ThreadLocalRandom.current().nextInt(0,50));
                });

        tree.preOrder(tree.root);


    }

    private static class Node {
        int key, height;
        Node left, right;
        Node(int key) {
            this.key =key;
            height =1;
        }
    }

    private static class AVLTree {
        Node root;

        int height(Node node){
            if(node == null){
                return  0;
            }
            return node.height;
        }

        int getBalance(Node node){
            if(node == null){
                return  0;
            }

            return height(node.left) - height(node.right);
        }

        void preOrder(Node node){
            if(node == null) {
                preOrder(node.left);
                System.out.println(node.key);
                preOrder(node.right);
            }
        }

        Node insert(Node node, int key){
            // 1. Perform the normal BST Insertion
            if(node == null)
                return new Node(key);
            if(key< node.key)
                node.left = insert(node.left,key);
            else if(key > node.key)
                node.right = insert(node.right,key);
            else
                return node;

            // 2 Update height of this ancestor
            node.height = 1 + Math.max(height(node.left),height(node.right));

            // 3 Get the balance factor of this node to check whether this node is unbalanced
            int balance = getBalance(node);

            // if this node becomes unbalanced, there are are 4 cases

            // Left Left Case
            if(balance >1 && key < node.left.key)
                return rightRotate(node);

            // Right Right Case
            if(balance < -1 && key > node.right.key)
                return  leftRotate(node);

            // Left Right Case
            if(balance > 1 && key > node.left.key)
                return rightRotate(node);

            // Right Left Case
            if(balance < -1 && key < node.right.key)
                return leftRotate(node);

            return node;
        }

        Node rightRotate(Node y){
            Node x = y.left;
            Node T2 = x.right;

            // Perform rotation
            x.right = y;
            y.left = T2;

            // Update heights
            y.height = 1+ Math.max(height(y.left), height(y.right));
            x.height = 1+ Math.max(height(x.left),height(x.right));

            // Return the new root
            return x;
        }

        Node leftRotate(Node x){
            Node y = x.right;
            Node T2 = y.left;

            // Perform Rotation
            y.left = x;
            x.right = T2;

            // Update heights
            x.height = 1 + Math.max(height(x.left),height(x.right));
            y.height = 1 + Math.max(height(y.left),height(y.right));

            // Return the Root
            return y;
        }



    }

}
