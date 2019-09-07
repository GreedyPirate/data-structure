package com.ttyc.chapter3.stack;

/**
 * 链式栈，只在头节点做增加和删除
 * @param <T>
 */
public class LinkedStack<T> {

    private Node<T> head;

    class Node<T> {
        private Node<T> next;

        private T data;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }
    }

    public LinkedStack() {
        head = new Node<>();
    }

    public void push(T t) {
        Node<T> node = new Node<>(t);
        node.next = head.next;
        head.next = node;
    }

    public T pop() {
        if(head.next == null) {
            throw new RuntimeException("当前为空栈");
        }
        Node<T> firt = head.next;
        T ret = firt.data;
        head.next = firt.next;
        firt.next = null;
        return ret;
    }

    public T peek() {
        if(head.next == null) {
            throw new RuntimeException("当前为空栈");
        }
        return head.next.data;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public String toString() {
        if(head.next == null) {
            return "empty stack";
        }
        StringBuilder builder = new StringBuilder();
        Node<T> node = head.next;
        while (node!= null) {
            builder.append(node.data).append(",");
            node = node.next;
        }
        return builder.deleteCharAt(builder.length()-1).toString();
    }
}
