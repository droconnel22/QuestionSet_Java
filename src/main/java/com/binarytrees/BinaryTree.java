package com.binarytrees;




public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public void AddNode(T value){
        if(root == null){
            root = new Node<>(value);
        } else {
            root.AddValue(value);
        }
    }

    public Node<T> FindNode(T value){
        if(root == null){
            return  null;
        } else {
            return root.FindValue(value);
        }
    }

    public void PrintInOrder(){
        if(root == null){
            return;
        }

        this.printInOrder(this.root);
    }

    private void printInOrder(Node<T> node) {
        if(node == null){
            return;
        }

        this.printInOrder(node.getLeft());
        System.out.println(node.getValue());
        this.printInOrder(node.getRight());
    }

    public void PrintPreOrder() throws  Exception {
        if(root == null){
            throw  new Exception("Root is null can not pring");
        }

        this.printPreOrder(this.root);
    }

    private void printPreOrder(Node<T> node){
        if(node == null){
            return;
        }

        System.out.println(node.getValue());
        this.printPreOrder(node.getLeft());
        this.printPreOrder(node.getRight());
    }
}
