package com.ttyc.chapter3.stack.usecase;

import com.ttyc.chapter3.stack.SequenceStack;

/**
 * 浏览器前进后退功能
 */
public class BrowserHistory {
    private static SequenceStack<String> left = new SequenceStack<>();
    private static SequenceStack<String> right = new SequenceStack<>();

    public static void main(String[] args) {
        left.push("a");
        left.push("b");
        left.push("c");

        System.out.println("后退，当前为：" + back());
        System.out.println("后退，当前为：" + back());
        System.out.println("前进，当前为：" + forward());
    }

    public static String back() {
        if(left.isEmpty()) {
            throw new IllegalStateException("当前为空页面，无法后退");
        }
        right.push(left.pop());
        return left.peek();
    }

    public static String forward() {
        if(right.isEmpty()) {
            throw new IllegalStateException("当前为最新页面，无法前进");
        }
        left.push(right.pop());
        return left.peek();
    }

}
