package com.ttyc.chapter1.linked;

public class TestCase {
    public static void main(String[] args) {
        SingleLinkedList<String> headList = new SingleLinkedList<>();
        headList.headInsert("aaa");
        headList.headInsert("bbb");
        headList.headInsert("ccc");

        System.out.println(headList);

        SingleLinkedList<String> tailList = new SingleLinkedList<>();
        tailList.tailInsert("ddd");
        String removed = tailList.delete(1);
        System.out.println(removed);
        tailList.tailInsert("eee");
        tailList.tailInsert("fff");
        System.out.println(tailList);

        String deleted = tailList.delete(2);
        System.out.println(deleted);
        System.out.println("deleted 2: " + tailList);

        tailList.tailInsert("ggg");
        tailList.tailInsert("hhh");
        System.out.println(tailList);

    }


}
