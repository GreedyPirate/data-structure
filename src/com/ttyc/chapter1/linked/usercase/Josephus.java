package com.ttyc.chapter1.linked.usercase;

import com.ttyc.chapter1.linked.CycleSingleLinkedList;

import java.util.Arrays;

/**
 * 循环链表解决约瑟夫问题
 */
public class Josephus {

    private static CycleSingleLinkedList<Integer> list = new CycleSingleLinkedList<>();


    static {
        for (int i = 0; i < 41; i++) {
            list.tailInsert(i+1);
        }
    }

    public static void main(String[] args) {
        CycleSingleLinkedList.Action<Integer> action = list.new PrintAction<Integer>();
        list.traversals(action);

        list.josephus(3);
        System.out.println("total killed :" + list.total);
    }
}
