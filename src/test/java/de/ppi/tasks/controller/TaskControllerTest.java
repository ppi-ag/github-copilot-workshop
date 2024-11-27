package de.ppi.tasks.controller;

import de.ppi.tasks.model.Task;
import de.ppi.tasks.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TaskControllerTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTasksDueSoon_returnsTasksDueWithinAWeek() {
        Task task1 = new Task();
        task1.setDueDate(LocalDate.now().plusDays(3));
        task1.setPriority(3);

        Task task2 = new Task();
        task2.setDueDate(LocalDate.now().plusDays(5));
        task2.setPriority(2);

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> result = taskController.getTasksDueSoon();

        assertEquals(2, result.size());
        assertEquals(task1, result.get(0));
        assertEquals(task2, result.get(1));
    }

    @Test
    void getTasksDueSoon_excludesTasksDueAfterAWeek() {
        Task task1 = new Task();
        task1.setDueDate(LocalDate.now().plusDays(8));
        task1.setPriority(1);

        when(taskRepository.findAll()).thenReturn(Collections.singletonList(task1));

        List<Task> result = taskController.getTasksDueSoon();

        assertEquals(0, result.size());
    }

    @Test
    void getTasksDueSoon_excludesTasksWithoutDueDate() {
        Task task1 = new Task();
        task1.setDueDate(null);
        task1.setPriority(1);

        when(taskRepository.findAll()).thenReturn(Collections.singletonList(task1));

        List<Task> result = taskController.getTasksDueSoon();

        assertEquals(0, result.size());
    }

    @Test
    void getTasksDueSoon_sortsTasksByPriority() {
        Task task1 = new Task();
        task1.setDueDate(LocalDate.now().plusDays(3));
        task1.setPriority(2);

        Task task2 = new Task();
        task2.setDueDate(LocalDate.now().plusDays(3));
        task2.setPriority(1);

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> result = taskController.getTasksDueSoon();

        assertEquals(2, result.size());
        assertEquals(task2, result.get(0));
        assertEquals(task1, result.get(1));
    }
}