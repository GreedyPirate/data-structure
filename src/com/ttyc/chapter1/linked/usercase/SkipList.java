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

    private Random random;

    /**
     * 用双链表存储
     */
    class Node {
        private int data;
    }

    /**
     * 初始化数据
     */
    public SkipList() {
        size = 0;
        height = 1;
        random = new Random();
    }

    /**
     * 查找节点
     * 增删都依赖于此
     */
    public Node find(int key) {
        return null;
    }



    public void insert(int data) {
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
