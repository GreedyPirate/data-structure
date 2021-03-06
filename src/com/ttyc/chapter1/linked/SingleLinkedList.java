package com.ttyc.chapter1.linked;

public class SingleLinkedList<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size = 0;

    class Node<E> {
        private E e;
        private Node next;
    }

    public SingleLinkedList() {
        this.init();
    }

    private void init() {
        head = new Node<E>();
        tail = head;
    }

    public void headInsert(E e) {
        Node<E> node = new Node<>();
        node.e = e;
        node.next = head.next;

        head.next = node;
        size++;
    }

    public void tailInsert(E e) {
        Node<E> node = new Node<>();
        node.e = e;
        node.next = null;

        if (head.next != null) {
            tail.next = node;
        } else {
            head.next = node;
        }
        tail = node;
        size++;
    }

    public <E> E delete(int index) {
        rangeCheck(index);

        Node<E> node = head.next;
        Node<E> pre = (Node<E>) head;
        int i = 1;
        E result = null;
        while (i <= size) {
            if (i == index) {
                Node<E> next = node.next;
                if (next != null) {
                    pre.next = next;
                    node.next = null;
                    result = node.e;
                    node.e = null;
                } else {
                    pre.next = null;
                    tail = (Node) pre;
                    result = node.e;
                    node.e = null;

                }
                size--;
            }
            pre = node;
            node = node.next;
            i++;
        }
        return result;
    }

    private void rangeCheck(int index) {
        if (head.next == null) {
            throw new IllegalArgumentException("List is empty");
        }
        if (index < 1 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
    }

    public void insert(int index, E e) {
        rangeCheck(index);

        int i = 1;
        Node<E> node = head.next;
        Node<E> pre = (Node<E>) head;

        while (i <= size) {
            if(i == index) {
                Node<E> insert = new Node<>();
                insert.e = e;
                if(node.next == null) {
                    tail = insert;
                }
                insert.next = node.next;
                pre.next = insert;
            }

            pre = node;
            node = node.next;
            i++;
        }
    }

    public void delete(E e) {
        Node<E> node = head.next;
        if (node == null) {
            return;
        }

        while (node.next != null) {
            if (node.next.e == e) {
                node.next = node.next.next;
                node.next = null;
            }
        }
    }

    public void destroy() {
        Node<E> x = head, next = head.next;
        while (next != null) {
            x.e = null;
            x.next = null;
            x = next;
            next = x.next;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public int size() {
        return size;
    }

    /**
     * 为啥不直接用size？ 就当练习了
     *
     * @return
     */
    public int getLength() {
        int count = 0;
        Node<E> node = head.next;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public <E> E get(int index) {
        rangeCheck(index);
        int i = 0;
        Node<E> node = head.next;
        while (node.next != null) {
            i++;
            if (i == index) {
                return node.e;
            }
            node = node.next;
        }
        return null;
    }


    public int indexOf(E e) {
        Node<E> node = head.next;
        int i = 1;
        while (node != null) {
            E data = node.e;
            if (e.equals(data)) {
                return i;
            }
            i++;
            node = node.next;
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("elements are: ");
        Node<E> node = head.next;

        while (node != null) {
            builder.append(node.e).append(',');
            node = node.next;
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    public boolean isPalindromeNumber() {
        // 快慢指针找中间节点
        Node<E> slow, fast;
        slow = fast = head;
        // fast成为尾结点才停
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 链表反转
        Node<E> middleNextOne = slow.next;
        Node<E> pre = slow.next;
        Node<E> next = pre.next;
        while (pre != null) {
            if(pre == middleNextOne) {
                pre.next = null;
            }else {
                pre.next = slow.next;
            }
            slow.next = pre;

            pre = next;
            // pre为最后一个元素时，pre.next为null， next为null, null.next报错
            next = next == null ? null : next.next;
        }

        // 比较
        Node<E> next0 = head.next;
        Node<E> next1 = slow.next;
        boolean result = true;
        while (next0 != slow && next1 != null) {
            if(!next0.e.equals(next1.e)) {
                result = false;
                break;
            }
            next0 = next0.next;
            next1 = next1.next;
        }

        // 还原链表
        middleNextOne = slow.next;
        pre = slow.next;
        next = pre.next;
        while (pre != null) {
            if(pre == middleNextOne) {
                pre.next = null;
            }else {
                pre.next = slow.next;
            }
            slow.next = pre;

            pre = next;
            // pre为最后一个元素时，pre.next为null， next为null, null.next报错
            next = next == null ? null : next.next;
        }
        return result;
    }

    public SingleLinkedList<E> reverse() {
        SingleLinkedList<E> newList = new SingleLinkedList();
        Node<E> node = head.next;
        while (node != null) {
            newList.headInsert(node.e);
            node = node.next;
        }
        return newList;
    }

    public void reverse0() {
        Node<E> first = head.next;
        Node<E> pre = head.next;
        Node<E> next = pre.next;
        while (pre != null) {
            if(pre == first) {
                pre.next = null;
            }else {
                pre.next = head.next;
            }
            head.next = pre;

            pre = next;
            // pre为最后一个元素时，pre.next为null， next为null, null.next报错
            next = next == null ? null : next.next;
        }
    }

    public E removeLast(int n) {
        Node<E> fast = head;
        Node<E> slow = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return (E) head.next.e;
    }

    public boolean remove(E e){
        remove(head, e);
        return true;
    }

    public Node<E> remove(Node<E> node, E e){
        if(node.e.equals(e)) {

        }
        return node.next;
    }
}
