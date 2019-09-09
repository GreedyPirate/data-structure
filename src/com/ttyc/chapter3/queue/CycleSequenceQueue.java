package com.ttyc.chapter3.queue;

import java.util.Arrays;

/**
 * 使用顺序表实现的循环队列
 * @param <T>
 */
public class CycleSequenceQueue<T> {

    private Object[] elements;

    /**
     * front记录头元素所在位置
     * rear 记录尾元素的下一个位置
     */
    private int front, rear;

    private static final int DEFAULT_CAPACITY = 15;

    public CycleSequenceQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CycleSequenceQueue(int capacity) {
        elements = new Object[capacity];
    }

    public void add(T t) {
        // rear的下一个如果是front，那么循环队列一定是满了
        if ((rear + 1) % elements.length == front) {
            throw new IllegalStateException("队列已满");
        }
        elements[rear] = t;

        rear = (rear + 1) % elements.length;
    }

    public T poll() {
        if (rear == front) {
            return null;
        }
        T t = (T) elements[front];
        front = (front + 1) % elements.length;
        return t;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
