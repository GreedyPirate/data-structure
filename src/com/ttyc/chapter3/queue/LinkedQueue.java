package com.ttyc.chapter3.queue;

/**
 * 使用链表实现的队列
 * 维护尾指针，使用尾插发，O(1), 然后出头结点
 */
public class LinkedQueue<T> {

    private Node<T> front;

    private Node<T> rear;

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }
    }

    public LinkedQueue() {
        front = new Node<>();
        rear = front;
    }

    public void add(T t) {
        Node<T> node = new Node<>(t);
        rear.next = node;
        rear = node;
    }

    public T poll() {
        if(front.next == null) {
            return null;
        }
        Node<T> second = front.next.next;
        T data = front.next.data;
        front.next = second;
        return data;
    }

    @Override
    public String toString() {
        if(front.next == null) {
            return "";
        }
        Node<T> node = front.next;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.data.toString()).append(",");
            node = node.next;
        }
        return builder.toString();
    }
}
