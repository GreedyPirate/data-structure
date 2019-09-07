package com.ttyc.chapter1.linked;

public class TestCase2 {
    public static void main(String[] args) {
        DoubleLinkedList<String> headList = new DoubleLinkedList<>("head");
        headList.headInsert("aaa");
        headList.headInsert("bbb");
        headList.headInsert("ccc");

        DoubleLinkedList<Integer> tailList = new DoubleLinkedList<>(0);
        tailList.tailInsert(1);
        tailList.tailInsert(2);
        tailList.tailInsert(3);
        tailList.tailInsert(4);

    }

}
