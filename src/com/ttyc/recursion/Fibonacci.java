package com.ttyc.recursion;

/**
 * 斐波那契数列 Fibonacci sequence
 * 1、1、2、3、5、8、13、21、34
 * 人脑是无法模拟出递归的，所以递归编程思想是这样的
 * 第5位的值是多少，假设我们知道了第3位和第4位分别是3和5，
 * 我们只需要知道递归关系即可，第5位=第4位+第3位，千万不要去思考第4位和第3位怎么计算，人脑无法模拟
 */
public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long num = reduce(i);
            System.out.print(num + " ");
        }
    }

    public static int reduce(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return reduce(n - 1) + reduce(n - 2);
    }
}
