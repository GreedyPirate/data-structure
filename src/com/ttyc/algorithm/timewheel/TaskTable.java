package com.ttyc.algorithm.timewheel;

public class TaskTable {

    private TaskEntry head;

    private TaskEntry tail;

    public TaskTable() {
        tail = head;
    }

    public void addTask(Task task) {
        TaskEntry taskEntry = new TaskEntry(task, null);
        if(head == null) {
            head = new TaskEntry(null, taskEntry);
        }else {

        }
        taskEntry = tail;
    }

    public void execute() {
        TaskEntry task = head.next;
        while (task != null) {
            task.executeInternal();
        }
    }
}
