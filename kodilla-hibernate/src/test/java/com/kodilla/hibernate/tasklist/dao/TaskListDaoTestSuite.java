package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;

    private static String LISTNAME = "kodillaTasks";

    @Test
    void testFindByListName() {

        //Given
        TaskList taskList = new TaskList(LISTNAME, "17.2_Task");
        TaskList taskList2 = new TaskList(LISTNAME, "17.2_Tests");
        taskListDao.save(taskList);
        taskListDao.save(taskList2);

        //When
        List<TaskList> readTasks = taskListDao.findByListName(LISTNAME);

        //Then
        assertEquals(2, readTasks.size());
        assertEquals(LISTNAME, readTasks.get(0).getListName());
        assertEquals(LISTNAME, readTasks.get(1).getListName());

        //CleanUp
        int id1 = readTasks.get(0).getId();
        int id2 = readTasks.get(1).getId();
        taskListDao.deleteById(id1);
        taskListDao.deleteById(id2);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        try {
            assertNotEquals(0, id);
        } finally {
            //CleanUp
            taskListDao.deleteById(id);
        }
    }
}
