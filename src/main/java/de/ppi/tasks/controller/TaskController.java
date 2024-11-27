package de.ppi.tasks.controller;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ppi.tasks.model.Task;
import de.ppi.tasks.repository.TaskRepository;


/**
 * REST-Controller für Aufgabenverwaltung.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Gibt alle Aufgaben zurück.
     *
     * @return Liste aller Aufgaben
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Erstellt eine neue Aufgabe.
     *
     * @param task Die zu erstellende Aufgabe
     * @return Die erstellte Aufgabe
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    /**
     * Aktualisiert eine bestehende Aufgabe.
     *
     * @param id   Die ID der zu aktualisierenden Aufgabe
     * @param task Die aktualisierten Aufgabendaten
     * @return Die aktualisierte Aufgabe
     */
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    /**
     * Löscht eine Aufgabe.
     *
     * @param id Die ID der zu löschenden Aufgabe
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Gibt Aufgaben basierend auf ihrem Status zurück.
     *
     * @param completed Der Status der Aufgaben (abgeschlossen oder nicht)
     * @return Liste der Aufgaben mit dem angegebenen Status
     */
    @GetMapping("/status/{completed}")
    public List<Task> getTasksByStatus(@PathVariable boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    /**
     * Gibt Aufgaben zurück, die in Kürze fällig sind.
     *
     * @return Liste der Aufgaben, die innerhalb einer Woche fällig sind, sortiert
     *         nach Priorität
     */
    @GetMapping("/due-soon")
    public List<Task> getTasksDueSoon() {
        LocalDate today = LocalDate.now();
        LocalDate oneWeekFromNow = today.plusDays(7);

        return taskRepository.findAll().stream()
                .filter(task -> {
                    LocalDate dueDate = task.getDueDate();
                    return dueDate != null && dueDate.isAfter(today) && dueDate.isBefore(oneWeekFromNow);
                })
                .sorted(Comparator.comparingInt(Task::getPriority))
                .toList();
    }


    @GetMapping("/group-by-priority")
    public Map<Integer, List<Task>> getTasksGroupedByPriority() {
        return taskRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Task::getPriority,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Task::getDueDate))
                                        .collect(Collectors.toList())
                        )
                ));
    }

}