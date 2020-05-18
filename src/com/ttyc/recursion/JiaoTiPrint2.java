package com.ttyc.recursion;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JiaoTiPrint2 {
    public static void main(String[] args) {
        FooBar2 fooBar = new FooBar2(3);


        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> {
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

class FooBar {

    private int n;

    private Lock lock = new ReentrantLock();

    private Condition cond1 = lock.newCondition();
    private Condition cond2 = lock.newCondition();

    private boolean isFirst = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (isFirst) {
                System.out.println("1");
                cond1.await();
            } else {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                System.out.println("2");
                printFoo.run();
                isFirst = false;
                cond2.signalAll();

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            cond2.await();
            System.out.println("3");
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            cond1.signalAll();
        }
    }
}

class FooBar2 {

    private int n;

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
