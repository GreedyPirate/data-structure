package com.ttyc.algorithm.timewheel;

import com.ttyc.chapter3.queue.CycleSequenceQueue;

import java.util.concurrent.TimeUnit;

public class TimeWheel {

    private CycleSequenceQueue queue;

    private int tickMs;

    private int currentTime;

    private int wheelSize;

    private int interval;

    /**
     * 直译为溢出的时间轮，再贴切不过
     */
    private TimeWheel overflowWheel;

    public TimeWheel(int wheelSize, int tickMs) {
        this.tickMs = tickMs;
        this.wheelSize = wheelSize;
        interval = wheelSize * tickMs;
        queue = new CycleSequenceQueue(wheelSize);
    }


    public void createParent(int wheelSize) {
        overflowWheel = new TimeWheel(wheelSize, interval);
    }

    public void addTask(int delay) {
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
