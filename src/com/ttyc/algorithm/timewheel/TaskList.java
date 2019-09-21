package com.ttyc.algorithm.timewheel;

import com.ttyc.chapter3.queue.CycleSequenceQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TaskList extends CycleSequenceQueue implements Delayed   {

    private TaskEntry head;

    private TaskEntry tail;

    public TaskList() {
        tail = head;
    }

    public void addTask(Task task) {
        TaskEntry taskEntry = new TaskEntry(task);
        if(head == null) {
            head.next = taskEntry;
            taskEntry.prev = head;
        }else {
            tail.next = taskEntry;
            taskEntry.prev = tail;
        }
        tail = taskEntry;
    }

    public void execute() {
        TaskEntry task = head.next;
        while (task != null) {
            task.executeInternal();
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
