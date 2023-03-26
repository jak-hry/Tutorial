package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraineeQueue implements Observable {

    private final Queue<String> traineeTasks;
    private final List<Observer> mentors;
    private String name;

    public TraineeQueue(String task) {
        this.traineeTasks = new LinkedList<>();
        this.mentors = new ArrayList<>();
        this.name = task;
    }

    @Override
    public void registerMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    @Override
    public void notifyMentor() {
        for (Observer mentor : mentors) {
            mentor.update(this);
        }
    }

    @Override
    public void removeMentor(Mentor mentor) {
        mentors.remove(mentor);
    }

    public void addTask(String task) {
        traineeTasks.add(task);
        notifyMentor();
    }

    public Queue<String> getTraineeTasks() {
        return traineeTasks;
    }

    public List<Observer> getMentors() {
        return mentors;
    }

    public String getName() {
        return name;
    }
}
