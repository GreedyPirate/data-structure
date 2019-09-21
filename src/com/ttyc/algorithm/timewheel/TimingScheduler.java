package com.ttyc.algorithm.timewheel;

import java.util.concurrent.TimeUnit;

/**
 * 定时调度器
 */
public class TimingScheduler {

    /**
     * 首层时间轮
     */
    private TimeWheel timeWheel;


    public TimingScheduler() {
    }

    public boolean addTask(Task task) {
        return true;
    }
}
