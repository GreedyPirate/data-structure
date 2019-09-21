package com.ttyc.algorithm.timewheel;

/**
 * 任务包装类, 同时也是任务列表中的节点
 */
public class TaskEntry {

    protected Task task;

    protected TaskEntry next;

    protected TaskEntry prev;

    public TaskEntry() {
    }

    public TaskEntry(Task task) {
        this.task = task;
    }

    public void executeInternal() {
        Thread thread = new Thread(task);
        thread.run();
    }
}