package com.ttyc.chapter6.binary;

public class LinkedBinaryTree<T> {

    private Node<T> root;

    public void create(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            Node<Character> node = new Node<>(ch);
        }
    }

    private void createInternal(Node<T> node) {

    }


    class Node<T> {
        private T data;

        private Node<T> left;

        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }
}
