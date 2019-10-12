package com.ttyc.chapter6.binary;

/**
 * TODO
 * BinarySearchTree<K extends Comparable<K>, V>
 */
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

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        insertInternal(root, data);
    }

    private void insertInternal(Node current, int data) {
        Node node = new Node(data);
        if (data > current.data) {
            if (current.right == null) {
                current.right = node;
            } else {
                insertInternal(current.right, data);
            }
        } else if (data < current.data) {
            if (current.left == null) {
                current.left = node;
            } else {
                insertInternal(current.left, data);
            }
        }
    }

    public void add(int data) {
        root = add(root, data);
    }

    private Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data)
            node.left = add(node.left, data);
        else if (data > node.data)
            node.right = add(node.right, data);

        return node;
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.data) {
            return true;
        }
        if (data > node.data) {
            return contains(node.right, data);
        } else {
            return contains(node.left, data);
        }
    }

    public void travel() {
        travel(root);
    }

    private void travel(Node node) {
        if (node.left == null) {
            return;
        }
        travel(node.left);
        travel(node.right);
        System.out.println(node.data);
    }
}
