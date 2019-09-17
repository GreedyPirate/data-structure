package com.ttyc.algorithm.timewheel;

public abstract class Task implements Runnable {

    protected long delayMills;

    public Task(long delayMills) {
        this.delayMills = delayMills;
    }
}
