package com.ttyc.chapter1.linked;

public class DoubleLinkedList<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    class Node<E> {
        private E e;

        private Node<E> prior;

        private Node<E> next;

    }

    public DoubleLinkedList() {
        head = new Node<>();
        tail = head;
    }

    public DoubleLinkedList(E e) {
        head = new Node<>();
        head.e = e;
        tail = head;
    }

    public void headInsert(E e) {
        Node<E> newNode = new Node<>();
        newNode.e = e;

        newNode.next = head.next;
        if (head.next != null) {
            head.next.prior = newNode;
        }
        head.next = newNode;
        newNode.prior = head;
        size++;
    }

    public void tailInsert(E e) {
        Node<E> newNode = new Node<>();
        newNode.e = e;
        newNode.next = tail.next;

        tail.next = newNode;
        newNode.prior = tail;
        tail = newNode;
        size++;
    }

    public void insert(E e, int index) {
        if (!checkPosition(index)) {
            throw new IndexOutOfBoundsException("index out of bounds for " + index);
        }

        if (index == size) {
            tailInsert(e);
        }

        if (index == 0) {
            headInsert(e);
        }


    }

    private Node<E> getNodeByIndex(int index) {
        if (index < (size >> 1)) {
            Node<E> e = head;
            for (int i = 0; i < size; i++) {
                e = e.next;
            }
            return e;
        } else {

            return null;
        }
    }

    /**
     * 获取时校验
     */
    private boolean checkSize(int index) {
        return index >= 0 && index < size;
    }

    /**
     * 插入时校验
     */
    private boolean checkPosition(int index) {
        return index >= 0 && index <= size;
    }

    public Node<E> getHead() {
        return head;
    }

}

































