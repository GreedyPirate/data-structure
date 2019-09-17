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

    private static final int WHEEL_SIZE = 60;

    public TimingScheduler() {
        timeWheel = new TimeWheel(WHEEL_SIZE,1, TimeUnit.NANOSECONDS.toMillis(System.nanoTime()));
    }

    public boolean addTask(Task task) {
/*        if(task.delayMills > WHEEL_SIZE) {
            timeWheel.createParent(WHEEL_SIZE);
        }*/
        TaskEntry taskEntry = new TaskEntry();
        return true;
    }
}
