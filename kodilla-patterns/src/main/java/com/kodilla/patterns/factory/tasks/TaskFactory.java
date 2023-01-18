package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVINGTASK = "DRIVINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String SHOPPINGTASK = "SHOPPINGTASK";

    public final Task getTask(final String taskName) {
        return switch (taskName) {
            case DRIVINGTASK -> new DrivingTask("trip", "Krakow", "car");
            case PAINTINGTASK -> new PaintingTask("flat", "white", "wall");
            case SHOPPINGTASK -> new ShoppingTask("bakery", "bread", 3);
            default -> null;
        };
    }
}
