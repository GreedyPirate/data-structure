package com.ttyc.algorithm.timewheel;

import java.util.concurrent.TimeUnit;

public class TestCase {
    public static void main(String[] args) {
        TimingScheduler scheduler = new TimingScheduler();
    }


    class TestTask extends Task {
        public TestTask(long delayMills) {
            super(delayMills);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("test scheduler");
            }
        }
    }

}
