package ru.suborg.hw_12.controller;

import ru.suborg.hw_12.entity.Status;
import ru.suborg.hw_12.entity.Task;
import ru.suborg.hw_12.service.data_handlers.DataServiceFactory;
import ru.suborg.hw_12.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Класс TaskController представляет контроллер для работы с задачами.
*/
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    private final DataServiceFactory dataService;

    private final static String LOG_FILE = "log.txt";


    /**
    * Метод для получения всех задач.
    */
    @GetMapping
    public ResponseEntity<?> getAllTask() {
        dataService.getService("txtWriter").writeData(LOG_FILE, "Call GET method: getAllTask");
        List<Task> tasks = taskService.getAllTask();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }


    /**
    * Метод для получения задач по статусу.
    */
    @GetMapping("/{status}")
    public ResponseEntity<?> getAllTaskByStatus(@PathVariable("status") Status status) {
        dataService.getService("txtWriter").writeData(LOG_FILE, "Call GET method: getAllTaskByStatus");
        List<Task> tasks = taskService.getTaskByStatus(status);
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }


    /**
    * Метод для добавления новой задачи.
    */
    @PostMapping("/new")
    public ResponseEntity<?> addTask(@RequestParam String description) {
        dataService.getService("txtWriter").writeData(LOG_FILE, "Call POST method: addTask with parameter's " + description);
        Task task = new Task();
        task.setDescription(description);
        if (taskService.createTask(task)) {
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}