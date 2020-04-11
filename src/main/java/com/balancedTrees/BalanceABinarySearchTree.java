package com.balancedTrees;

// Leet Code 1382 Balance Binary Search Tree

/*
Problem.
Given a binary search tree, return a balanced binary search tree with the same node values
A binary search tree is balanced if and only if the depth of the two subtrees of every node
never differ by more than 1. If there is more than one answer, return any of them.

Input: root [1,null,2,null,3,null,4,null,null]
output: [2,1,3,null, null, null ,4]
There are multiple variantions of the correct answe


Solution.
The DSW algorhim is more complicated then re-creating a balanced tree from a sorted array.
However it does not require any extra memory as we manipulate existing nodes.
it can be a big plus if your node stores more than just an int

the diea is to convert the tree into a vine (think linked list) using left rotations,
and then balance it using right rotations.

You can look online for the full description of the DSW algorithm

So what is the algo?
1. Convert the initial tree into a vine. By doing right rotations, we flatten a tree into a linked list.
where the head is the former left most node, and tail is the former right most node.
2. As you convert the tree into a vine, count the total number of nodes in cnt.
3. Calculate the height of the closest perfectly balanced tree with the equation
h = log2(cnt+1) (by power of 2)
4. Calculate the number of nodes in the cloeset perfectly balanced tree
m = pow(2,h)-1
5. Left-rotate cnt - m nodes to cover up the excess of nodes.

Note: you rotate the root node, then you rotate the right child of the new root ndoe, and so on
in other words left rotations are performed on every second node of the vine.


6. Left-rotate m / 2 nodes.
7. Divide m by two and repeat the step above  while m / 2 is greater then zero.

csactor.blogspot.com/2018/08/dsw-day-stout-warren-algorithm-dsw.html


 */

public class BalanceABinarySearchTree {
    private static class TreeNode {
        private final int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        private TreeNode left;
        private TreeNode right;

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static void main(String...args){

    }

    private static TreeNode balanceBST(TreeNode root){

    }
}
