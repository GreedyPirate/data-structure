package com.ttyc.chapter6.binary;

import com.ttyc.chapter3.queue.CycleSequenceQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TODO
 * BinarySearchTree<K extends Comparable<K>, V>
 */
public class BinarySearchTree {

    private Node root;

    class Node {
        private int data;

        private Node left;

        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        insertInternal(root, data);
    }

    private void insertInternal(Node current, int data) {
        Node node = new Node(data);
        if (data > current.data) {
            if (current.right == null) {
                current.right = node;
            } else {
                insertInternal(current.right, data);
            }
        } else if (data < current.data) {
            if (current.left == null) {
                current.left = node;
            } else {
                insertInternal(current.left, data);
            }
        }
    }

    public void add(int data) {
        // 特殊情况，root==null时，创建一个节点，root=该节点
        root = add(root, data);
    }

    private Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data)
            // 在node.left不为空的时候，node.left=node.left,没有变
            // 而在node.left为空的时候，创建节点，node.left=新节点
            node.left = add(node.left, data);
        else if (data > node.data)
            node.right = add(node.right, data);

        return node;
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.data) {
            return true;
        }
        if (data > node.data) {
            return contains(node.right, data);
        } else {
            return contains(node.left, data);
        }
    }

    public void travel() {
        travel(root);
    }

    /**
     * 前序遍历：最常用
     * 中序遍历：按顺序输出
     * 后序遍历：释放资源，左右子节点资源释放完毕，才释放父节点
     *
     * @param node
     */
    private void travel(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        travel(node.left);
        travel(node.right);
    }

    /**
     * 前序遍历的非递归实现
     * 用栈实现，父节点出栈的时候，根据先进后出的特点，要先添加右孩子
     * 想象一个只有3个节点的最简二叉树就可以明白
     */
    public void travelUnrecursion() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node parent = stack.pop();
            System.out.println(parent.data);
            if (parent.right != null) {
                stack.push(parent.right);
            }
            if (parent.left != null) {
                stack.push(parent.left);
            }
        }
    }

    /**
     * 层次遍历
     * 父节点出去的时候，一定要把自己的左孩子，右孩子入队
     */
    public void travelLevel() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            System.out.println(parent.data);
            if (parent.left != null) {
                queue.add(parent.left);
            } else {
                System.out.println(parent.data + "-left-null");
            }
            if (parent.right != null) {
                queue.add(parent.right);
            } else {
                System.out.println(parent.data + "-right-null");
            }
        }
    }

    public int min() {
        Node curr = root.left;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    public int max() {
        Node curr = root.right;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }

    public int min0() {
        return min0(root);
    }

    private int min0(Node node) {
        if(node.left == null) {
            return node.data;
        }
        return min0(node.left);
    }
}
