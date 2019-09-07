package com.ttyc.chapter1.linked.usercase;

import com.ttyc.chapter1.linked.SingleLinkedList;

public class PalindromeNumber {

    public static void main(String[] args) {
        String number = "123321";
        char[] chars = number.toCharArray();
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            linkedList.tailInsert(Character.getNumericValue(aChar));
        }
        linkedList.isPalindromeNumber();
    }
}
