package com.ttyc.chapter3.queue;

/**
 * 循环链表队列
 * 只用一个尾指针rear，然后rear.next指向第一个节点
 */
public class CycleLinkedListQueue<T> {

    private Node<T> rear;

    class Node<T> {
        private Node<T> next;
        private T data;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }
    }

    public CycleLinkedListQueue() {
        rear = new Node<>();
    }

    public void add(T e) {
        Node<T> node = new Node<>(e);
        if(rear.next == null) {
            node.next = node;
        }else {
            node.next = rear.next;
            rear.next = node;
        }
        rear = node;
    }

    public T poll() {
        if(rear.next == null) {
            throw new RuntimeException("队列已空");
        }
        Node<T> head = rear.next;
        T ret = head.data;
        rear.next = head.next;
        head.next = null;
        return ret;
    }

    @Override
    public String toString() {
        Node<T> node = rear.next;
        StringBuilder builder = new StringBuilder();
        while (node != rear) {
            builder.append(node.data).append(",");
            node = node.next;
        }
        builder.append(node.data);

        return builder.toString();
    }
}
