package com.ttyc.chapter6.binary;

import java.util.Random;

public class TestCase {
    public static void main(String[] args) {
        Random random = new Random();
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(100);
            tree.insert(number);
        }
        tree.insert(50);
        System.out.println("has 50 = " + tree.contains(50));
        tree.travel();

        tree = new BinarySearchTree();
        System.out.println("===============");
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(100);
            tree.add(number);
        }
        tree.travel();

    }
}
