package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {

        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.getTask(TaskFactory.DRIVINGTASK);
        boolean before = task.isTaskExecuted();
        task.executeTask();
        boolean after = task.isTaskExecuted();

        //Then
        assertFalse(before);
        assertTrue(after);
        assertNotEquals(before, after);
        assertEquals("trip", task.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {

        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.getTask(TaskFactory.PAINTINGTASK);
        boolean before = task.isTaskExecuted();
        task.executeTask();
        boolean after = task.isTaskExecuted();

        //Then
        assertFalse(before);
        assertTrue(after);
        assertNotEquals(before, after);
        assertEquals("flat", task.getTaskName());
    }

    @Test
    void testFactoryShoppingTask() {

        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.getTask(TaskFactory.SHOPPINGTASK);
        boolean before = task.isTaskExecuted();
        task.executeTask();
        boolean after = task.isTaskExecuted();

        //Then
        assertFalse(before);
        assertTrue(after);
        assertNotEquals(before, after);
        assertEquals("bakery", task.getTaskName());
    }
}
