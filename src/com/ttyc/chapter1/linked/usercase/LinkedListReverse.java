package com.ttyc.chapter1.linked.usercase;

import com.ttyc.chapter1.linked.SingleLinkedList;

/**
 * 链表反转
 */
public class LinkedListReverse {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.tailInsert(1);
        list.tailInsert(2);
        list.tailInsert(3);
        list.tailInsert(4);

        System.out.println(list.reverse());

        list.reverse0();
        System.out.println(list);
    }
}
