package com.ttyc.recursion.leetcode;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar2 {

    private int n;

    private Lock lock = new ReentrantLock();

    private Condition fooTurn = lock.newCondition();

    private Condition barTurn = lock.newCondition();


    private volatile boolean isFooTurn = true;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            lock.lock();
            try {
                while (!isFooTurn) {
                    fooTurn.await();
                }
                printFoo.run();
                isFooTurn = false;
                barTurn.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            lock.lock();
            try {
                while (isFooTurn) {
                    barTurn.await();
                }
                printBar.run();
                isFooTurn = true;
                fooTurn.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);


        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();

    }
}
