package com.ttyc.chapter1.linked.usercase;

import javax.management.relation.Relation;
import java.util.Random;

/**
 * 跳表
 * TODO
 * 1、用户自定义比较器
 * 2、int存储的数据太单一，应该可以存对象，类似Map
 */
public class SkipList {

    /**
     * 最高16层
     */
    private static int MAX_LEVEL = 16;

    /**
     * 最上层的头尾指针，指向MIN，MAX
     */
    private Node head;

    private Node tail;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 跳表高度
     */
    private int height;

    /**
     * 插入时向上层再次插入的概率
     */
    private static final double PROBABILITY = 0.5;
    /**
     * 左右边界值
     */
    private static int MIN = Integer.MIN_VALUE;
    private static int MAX = Integer.MAX_VALUE;
    /**
     * 左右两个无穷节点，其实就是head和tail
     * 但是head和tail在增加层数时要上移一层
     */
    private Node left = new Node(MIN);
    private Node right = new Node(MAX);

    private Random random;

    /**
     * 用双链表存储
     */
    class Node {
        private int data;
        private Node pre;
        private Node next;
        private Node up;
        private Node down;

        public Node(){}
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 初始化数据
     */
    public SkipList() {
        left.next = tail;
        right.pre = head;

        head = left;
        tail = right;

        size = 0;
        height = 1;
        random = new Random();
    }

    /**
     * 查找节点
     * 增删都依赖于此
     */
    public Node find(int key) {
        return findInternal(head, tail, key, Relation.EQUAL);
    }

    private Node findInternal(Node head, Node tail, int key, Relation relation) {
        if (head == null || tail == null) {
            return null;
        }
        // 先在本层找第一个比key大的节点
        Node node = head.next;
        while (node.data < key && node != tail) {
            if(node.data == key) {
                while (node.down == null) {
                    node = node.down;
                }
                return node;
            }
            node = node.next;
        }
        // 找到最后一个节点也没找到
        if(node == tail && tail.down == null) {
            return null;
        }

        // 找到以后，node的前驱和tail往下一层
        Node pre = node.pre;
        Node down = pre.down;
        tail = tail.down;
        return findInternal(down, tail, key, relation);
    }

    public void insert(int data) {
        int level = randomLevel();
        if(level > height) {
            for (int i = 0; i < level-height; i++) {
                Node left = new Node(MIN);
                Node right = new Node(MAX);
                left.down = head;
                head.up = left;
                right.down = tail;
                tail.up = right;

                head = left;
                tail = right;
                head.next = tail;
                tail.pre = head;
            }
        }
    }

    public void insert0(int data) {

    }

    private int randomLevel() {
        // the following implementation is basically as same as Redis ZSET implementation
        // see https://github.com/antirez/redis/blob/4.0/src/t_zset.c
        int newLevel = 1;
        while ((random.nextInt() & 0xFFFF) < (0xFFFF >> 2)) {
            newLevel++;
        }
        return (newLevel < MAX_LEVEL) ? newLevel : MAX_LEVEL;
    }

    /**
     * 用来判断等于还是大于节点值
     */
    private enum Relation {
        EQUAL,
        GREATER_EQUAL;

        public boolean isEqual() {
            return this != null && this == EQUAL;
        }
    }

}
