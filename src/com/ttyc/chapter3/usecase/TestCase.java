package com.ttyc.chapter3.usecase;

public class TestCase {
    public static void main(String[] args) {
        BracketsMatch bracketsMatch = new BracketsMatch();
        boolean isMatch = bracketsMatch.isMatch("[2*(3+2)]+{[5*3]+[2/8]}");
        System.out.println("isMatch = " + isMatch);

        RadixTransform radixTransform = new RadixTransform();
        String binary = radixTransform.transform(37);
        System.out.println("binary = " + binary);
    }
}
