package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskQueueTestSuite {

    @Test
    void updateTest() {

        //Given
        Mentor mentor1 = new Mentor("Johny", "Garcia");
        Mentor mentor2 = new Mentor("Bob", "White");
        TraineeQueue queue1 = new TraineeQueue("trainee1");
        TraineeQueue queue2 = new TraineeQueue("trainee2");
        TraineeQueue queue3 = new TraineeQueue("trainee3");
        queue1.registerMentor(mentor1);
        queue2.registerMentor(mentor1);
        queue3.registerMentor(mentor2);
        queue1.addTask("24.1_task");
        queue1.addTask("24.2_task");
        queue1.addTask("24.3_task");

        queue2.addTask("25.4_task");
        queue2.addTask("25.6_task");

        queue3.addTask("21.4_task");
        queue3.addTask("21.5_task");
        queue3.addTask("21.2_task");
        //When
        //Then
        assertEquals(5, mentor1.getUpdateCount());
        assertEquals(3, mentor2.getUpdateCount());
    }
}
