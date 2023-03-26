package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String firstName;
    private final String lastName;
    private int updateCount;

    public Mentor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(TraineeQueue traineeQueue) {
        System.out.println(firstName + ": New task created by - " + traineeQueue.getName() + ", list:" +
                "\n" + traineeQueue.getTraineeTasks() + "\n");
        updateCount++;
    }
}
