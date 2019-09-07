package com.ttyc.chapter3.stack;

import java.util.Arrays;

public class SequenceStack<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int top = -1;

    private int capacity;

    private Object[] elements = null;

    public SequenceStack() {
        this(DEFAULT_CAPACITY);
    }

    public SequenceStack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    public void push(T t) {
        if (top == capacity - 1) {
            throw new RuntimeException("顺序栈已满");
        }
        elements[++top] = t;
    }

    public T pop() {
        if (top == -1) {
            throw new RuntimeException("顺序栈为空");
        }
        T ret = (T) elements[top];
        elements[top--] = null;
        return ret;
    }

    public T peek() {
        if (top == -1) {
            throw new RuntimeException("顺序栈为空");
        }
        return (T) elements[top];
    }

    public int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
