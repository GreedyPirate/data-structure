package com.ttyc.algorithm;

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

    /**
     * 元素个数
     */
    private int size;

    /**
     * 跳表高度, 从1开始算
     */
    private int height;

    private Random random = new Random();

    /**
     * 用双链表存储
     */
    class Node {
        private Integer data;

        private Node[] forwards;

        public Node(Integer data, int level) {
            this.data = data;
            // ++level , level层有level+1个后继节点
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            return data == null ? "" : String.valueOf(data);
        }

        /**
         * 获取节点在level层的下一个节点
         */
        public Node boyNextDoor(int level) {
            return forwards[level];
        }

        public Integer getData() {
            return data;
        }

        public Node[] getForwards() {
            return forwards;
        }
    }

    /**
     * 初始化数据
     */
    public SkipList() {
        head = new Node(null, MAX_LEVEL);
        height = 1;
    }

    /**
     * 查找节点
     */
    public Node find(int data) {
        Node node = head;
        int level = height -1;
        // 必须找到最后一层
        while (level >= 0) {
            node = findFirstGreater(data, node, level);
            level--;
        }
        return node;
    }

    /**
     * 无论是查找，插入还是删除，我们都要找到第一个比data大的节点
     * 这里根据层数level，获取每一层第一个比data大的节点的前一个节点
     * @param data 要查找的数据
     * @param current 查询的起始节点
     * @param level 要查找的层数
     * @return 如果当前节点的下一个节点比data大(不能包含等于)，返回当前节点
     * 这个当前节点就可以用于增加，删除节点
     */
    private Node findFirstGreater(int data, Node current, int level) {
        Node nextDoor = current.boyNextDoor(level);
        // 现在的情况是current在后，nextDoor在前，两个同时往右走
        // 只要发现nextDoor比data大，ok，直接返回current，在上一层方法中让current走到下一层
        while (nextDoor != null) {
            if (data < nextDoor.data) {
                break;
            }
            // 往前走一个
            current = nextDoor;
            nextDoor = current.boyNextDoor(level); // 或者nextDoor.boyNextDoor(level)
        }
        // 需要判断current==null吗？ 不需要，当前层没有比data大的，但是下一层可能有
        return current;
    }

    /**
     *
     *
     * @param data
     */
    public void insert(int data) {
        if(contains(data)) {
            return;
        }

        int level = randomLevel();
        Node newNode = new Node(data, level);
        // 必须先赋值，下面开始--了，或者用临时变量保存
        if(level > height) {
            height = level;
        }
        level--;
        // 从上往下插入
        Node current = head;
        while (level >= 0) {
            current = findFirstGreater(data, head, level);
            Node nextDoor = current.boyNextDoor(level);
            newNode.forwards[level] = nextDoor;
            current.forwards[level] = newNode;
            level--;
        }
        size++;

    }

    public boolean contains(int data) {
        Node node = find(data);
        return node != null && node.data != null && data == node.data;
    }

    public void easyPrint() {
        for (int i = height-1; i >= 0; i--) {
            System.out.print("level " + i + ": ");
            Node current = head.forwards[i];
            Node next = current.boyNextDoor(i);

             StringBuilder builder = new StringBuilder();
            if(current.data != head.forwards[0].data) {
                builder.append(whiteSpaceHelper(current.data));
            }
            builder.append(current.data);
            while (next != null) {
                builder.append(whiteSpaceHelper(current.data, next.data)).append(next.data);
                current = current.boyNextDoor(i);
                next = next.boyNextDoor(i);
            }
            System.out.println(builder.toString());
        }
    }

    private String whiteSpaceHelper(int pre, int next) {
        Node current = head.boyNextDoor(0);
        while (current != null) {
            if(current.data == pre) {
                break;
            }
            current = current.boyNextDoor(0);
        }
        Node node = current.boyNextDoor(0);
        int count = 0;
        while (node != null) {
            count++;
            if(node.data == next) {
                break;
            }
            count += node.data.toString().length();
            node = node.boyNextDoor(0);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String whiteSpaceHelper(int next){
        Node node = head.forwards[0];
        int count = 0;
        while(node != null) {
            if(node.data == next) {
                break;
            }
            count += node.data.toString().length();
            count++;
            node = node.boyNextDoor(0);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(" ");
        }
        return builder.toString();
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

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        /*skipList.insert(300);
        skipList.insert(54);
        skipList.insert(14);
        skipList.insert(1010);
        skipList.insert(23);
        skipList.insert(8);
        skipList.insert(325);
        skipList.find(325);
        */
        for (int i = 0; i < 30; i++) {
            int number = skipList.random.nextInt(1000);
            skipList.insert(number);
        }

        skipList.easyPrint();
    }

    public static void testMaxLevel(SkipList skipList) {
        int max = 0;
        while (true) {
            for (int i = 0; i < 1000000; i++) {
                int level = skipList.randomLevel();
                if(level > max)
                    max = level;
            }
            System.out.println(max);
        }
    }

}
