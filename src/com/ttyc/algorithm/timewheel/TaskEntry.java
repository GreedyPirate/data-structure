package com.ttyc.algorithm.timewheel;

/**
 * 任务包装类, 同时也是任务列表中的节点
 */
public class TaskEntry {

    private Task task;

    protected TaskEntry next;

    public TaskEntry() {
    }

    public TaskEntry(Task task, TaskEntry next) {
        this.task = task;
        this.next = next;
    }

    public void executeInternal() {
        Thread thread = new Thread(task);
        thread.run();
    }
}