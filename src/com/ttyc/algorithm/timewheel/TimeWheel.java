package com.ttyc.algorithm.timewheel;

import com.ttyc.chapter3.queue.CycleSequenceQueue;

import java.util.concurrent.TimeUnit;

public class TimeWheel {

    private CycleSequenceQueue queue;

    private int tickMs;

    private int currentTime;

    private long startTime;

    private int wheelSize;

    private TimeUnit unit;

    private int interval;

    /**
     * 直译为溢出的时间轮，再贴切不过
     */
    private TimeWheel overflowWheel;

    public TimeWheel(int wheelSize, int tickMs, long startTime) {
        this.tickMs = tickMs;
        this.wheelSize = wheelSize;
        queue = new CycleSequenceQueue(wheelSize);
        interval = wheelSize * tickMs;
    }


    public void createParent(int wheelSize) {
        overflowWheel = new TimeWheel(wheelSize, interval, currentTime);
    }

    public void addTask(int delay) {
    }

    public void start() {
        Thread pusher = new Thread(() -> {
            for (; ; ) {
                try {
                    currentTime++;
                    unit.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        });
    }

    private void increUpper() {
        if (currentTime == wheelSize) {
            overflowWheel.currentTime++;
            currentTime = 0;
        }
    }

    public int currentTime() {
        return currentTime;
    }
}
