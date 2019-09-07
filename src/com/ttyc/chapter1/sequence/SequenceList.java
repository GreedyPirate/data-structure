package com.ttyc.chapter1.sequence;

/**
 * a liner sequence list implementation
 * thread un-safe
 *
 * @author jaynnay
 * @createTime 2019/1/28 21:59
 * @description
 */
public class SequenceList<E> {

    private Object[] elements = null;

    private static final Object[] DEFAULT_EMPTY_ARRAY = {};

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private double factor = 0.75;

    public SequenceList() {
        elements = DEFAULT_EMPTY_ARRAY;
    }

    public SequenceList(int size) {
        this.init(size);
    }

    private void init(int size) {
        if (size > 0) {
            elements = new Object[size];
        } else if (size == 0) {
            elements = DEFAULT_EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("size can not be negative number!");
        }
    }

    public <E> E getElementByIndex(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    public int getElementLocation(E e) {
        for (int i = 0; i < elements.length; i++) {
            E temp = (E) elements[i];
            if (temp.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(E e) {
        ensureArraySize();
        elements[size] = e;
        this.size++;
    }

    public void add(E e, int index) {
        rangeCheck(index);
        ensureArraySize();

        /**
         * JDK实现：System.arraycopy(elementData, index, elementData, index + 1, size - index);
         */
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = e;
        this.size++;
    }

    public <E> E delete(int index) {
        rangeCheck(index);
        E e = (E) elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        // 释放空间，--size表示最后一个
        elements[--size] = null;
        return e;
    }

    /**
     * 删除一个元素，时间复杂度为O(n), JDK的是O(n^2)
     * 不等于e的元素重新放入数组
     *
     * @param e
     */
    public void delete(E e) {
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (!e.equals(elements[i])) {
                elements[k] = elements[i];
                k++;
            }
        }
        this.size = k;
    }

    public void destroy() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        this.size = 0;
    }

    /**
     * 添加元素前校验是否需要扩容
     */
    private void ensureArraySize() {
        if (elements == DEFAULT_EMPTY_ARRAY) {
            elements = new Object[DEFAULT_CAPACITY];
        }

        if (size == elements.length) {
            int newSize = (int) (this.size * factor);
            Object[] resizedArray = new Object[newSize];
            System.arraycopy(elements, 0, resizedArray, 0, elements.length);
        }
    }

    /**
     * 数组下标校验
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0)
            throw new IllegalArgumentException("invalid index " + index);
        if (index > this.size - 1) {
            throw new ArrayIndexOutOfBoundsException("index out of bounds");
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "list is empty";
        }
        StringBuilder builder = new StringBuilder("elements are: [");
        for (int i = 0; i < this.size; i++) {
            builder.append("{").append(elements[i].toString()).append("},");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.append("]").toString();
    }
}
