package com.ttyc.chapter1.linked;

/**
 * 循环单链表
 */
public class CycleSingleLinkedList<E> {

    private Node head;

    private int size;

    public static class Node<E> {
        private E e;

        private Node next;

        public Node(E e) {
            this.e = e;
        }
    }

    public CycleSingleLinkedList() {
        head = new Node(null);
        head.next = head;
    }

    public void headInsert(E e) {
        Node<E> node = new Node<>(e);
        if(isEmpty()) {
            head.next = node;
            node.next = head;
        }else {
            node.next = head.next;
            head.next = node;
        }
        size++;
    }

    /**
     * 尾插法，没有使用尾节点，循环找到最后一个
     */
    public void tailInsert(E e) {
        Node<E> node = new Node<>(e);
        if(isEmpty()) {
            head.next = node;
            node.next = head;
        }else {
            Node<E> tail = head.next;
            while (tail.next != head) {
                tail = tail.next;
            }
            node.next = tail.next; //即head
            tail.next = node;
        }
        size++;
    }

    public void traversals(Action action) {
        if(isEmpty()) {
            return;
        }
        Node<E> node = head.next;
        // 不能判断为node.next != head，最后一个遍历不到
        while (node != head) {
            action.perform(node);
            node = node.next;
        }
    }

    public void josephus(int step) {
        if(isEmpty()) {
            return;
        }
        Node<E> pre = head;
        Node<E> node = head.next;
        int counter = 1;
        while (size > 1) {
            if(counter == step) {
                pre.next = node.next;
                node = node.next;
                counter = 0;
                System.out.println(node.e + " is killed");
                // 从被杀的下一个人开始，pre保存了下一个人
                size --;
            }
            node = node.next;
            pre = pre.next;
            counter++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public interface Action<E> {
        void perform(Node<E> node);
    }

    public class PrintAction<E> implements Action<E> {

        @Override
        public void perform(Node<E> node) {
            System.out.println(node.e);
        }
    }
}
