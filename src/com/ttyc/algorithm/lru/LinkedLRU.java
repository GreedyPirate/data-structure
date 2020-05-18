package com.ttyc.algorithm.lru;

import java.time.temporal.ValueRange;

public class LinkedLRU<K, V> {

    class Node<K, V>{
        K key;

        V value;

        Node<K,V> next;
    }

    private int size;

    private int capacity;

    private Node<K,V> head;

    private Node<K,V> tail;

    public LinkedLRU(int capacity) {
        this.capacity = capacity;
    }

    public V add(K key, V value) {
        V old = remove(key);

        if(old == null && isFull()) {
            removeFirst();
        }

        Node<K, V> node = new Node<>();
        node.key = key;
        node.value = value;

        if(head == null) {
            head.next = node;
            tail = node;
        }else {
            tail.next = node;
            node.next = null;
            tail = node;
        }
        return old;
    }

    public V get(K key) {
        Node<K,V> curr = head.next;
        while (curr != null) {
            if(curr.key.equals(key)) {
                moveToTail(key, curr.value);
                return curr.value;
            }
         }
        return null;
    }

    public void moveToTail(K key, V value) {
        remove(key);
        Node<K,V> node = new Node<>();
        node.key = key;
        node.value = value;
        tail.next = node;
        node.next = null;
        tail = node;
    }

    private boolean isFull() {
        return size + 1 == capacity;
    }

    private void removeFirst() {
        Node<K, V> first = head.next;

        Node<K,V> second = first.next;
        head.next = second;
    }

    private V remove(K key) {
        Node<K,V> curr = head.next;
        Node<K,V> pre = head;
        while (curr.next != null) {
            if(curr.key.equals(key)) {
                pre.next = curr.next;
                curr.next = null;
                return curr.value;
            }
        }
        return null;
    }
}
