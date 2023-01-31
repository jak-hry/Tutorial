package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName() {

        //Given
        String listName = "taskInProgress";
        TaskList taskList = new TaskList(listName, "17.2_Task");
        TaskList taskList2 = new TaskList(listName, "17.2_Tests");
        taskListDao.save(taskList);
        taskListDao.save(taskList2);

        //When
        List<TaskList> readTasks = taskListDao.findByListName(listName);

        //Then
        assertEquals(2, readTasks.size());
        assertEquals(listName, readTasks.get(0).getListName());
        assertEquals(listName, readTasks.get(1).getListName());

        //CleanUp
        int id1 = readTasks.get(0).getId();
        int id2 = readTasks.get(1).getId();
        taskListDao.deleteById(id1);
        taskListDao.deleteById(id2);
    }
}
