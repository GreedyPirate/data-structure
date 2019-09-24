package com.ttyc.chapter6.binary;

public class TestCase {
    public static void main(String[] args) {
        String text = "AB#D##C##";

        LinkedBinaryTree<Character> tree = new LinkedBinaryTree<>();
        tree.create(text);
    }
}
