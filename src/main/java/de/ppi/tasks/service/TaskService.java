package de.ppi.tasks.service;

import de.ppi.tasks.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private de.ppi.tasks.repository.TaskRepository taskRepository;

    public List<Task> getTasksDueSoonComplicated() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);

        List<de.ppi.tasks.model.Task> allTasks = taskRepository.findAll();
        List<Task> tasksDueSoon = new ArrayList<>();

        for (Task task : allTasks) {
            if (task.getDueDate() != null) {
                if (!task.getDueDate().isBefore(today) && !task.getDueDate().isAfter(nextWeek)) {
                    tasksDueSoon.add(task);
                }
            }
        }

        tasksDueSoon.sort(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });

        return tasksDueSoon;
    }
}
