package com.ttyc.recursion;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class JiaoTiPrint {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(1);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(2);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(3);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}

class Foo {

    private CountDownLatch countDownLatchA;
    private CountDownLatch countDownLatchB;

    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public Foo() {
        countDownLatchA = new CountDownLatch(1);
        countDownLatchB = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchA.countDown();

//        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        countDownLatchA.await();
        printSecond.run();
        countDownLatchB.countDown();

        // 要想获取s1，要等上面first释放
//        s1.acquire();
//        printSecond.run();
//        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        countDownLatchB.await();
        printThird.run();

        // 要想获取s2，要等上面second释放
//        s2.acquire();
//        printThird.run();
    }

}

