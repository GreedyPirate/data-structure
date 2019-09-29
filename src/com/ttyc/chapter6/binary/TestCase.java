package com.ttyc.chapter6.binary;

import java.util.Random;

public class TestCase {
    public static void main(String[] args) {
        Random random = new Random();
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(100);
            System.out.println("number = " + number);
            tree.insert(number);
        }
        tree.travel();
    }
}
