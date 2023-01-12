package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    final List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public boolean addTask(String taskDescription) {
        return tasks.add(taskDescription);
    }

    @Override
    public String toString() {
        return "tasks - " + tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
