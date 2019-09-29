package com.ttyc.chapter6.binary;

public class BinarySearchTree {

    private Node root;

    class Node {
        private int data;

        private Node left;

        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data){
        if(root == null) {
            root = new Node(data);
            return;
        }
        insertInternal(root, data);
    }

    private void insertInternal(Node current, int data) {
        Node node = new Node(data);
        if(data > current.data) {
            if(current.right == null){
                current.right = node;
            } else {
                insertInternal(current.right, data);
            }
        }else if(data < current.data) {
            if(current.left == null) {
                current.left = node;
            }else {
                insertInternal(current.left, data);
            }
        }
    }

    public void  travel() {
        travel(root);
    }

    private void travel(Node node) {
        if(node.left != null) {
            travel(node.left);
        }
        if(node.right != null) {
            travel(node.right);
        }
        System.out.println(node.data);
    }
}
