package com.ttyc.chapter1.linked.usercase;

import com.ttyc.chapter1.linked.SingleLinkedList;

/**
 * 删除倒数第N个节点
 */
public class RemoveLastN {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.tailInsert(2);
        list.tailInsert(4);
        list.tailInsert(6);
        list.tailInsert(8);
        list.tailInsert(10);
        list.tailInsert(20);
        list.tailInsert(30);

        list.removeLast(3);
    }
}
