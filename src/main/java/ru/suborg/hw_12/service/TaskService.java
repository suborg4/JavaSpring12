package ru.suborg.hw_12.service;

import ru.suborg.hw_12.entity.Task;
import ru.suborg.hw_12.entity.Status;
import java.util.List;

public interface TaskService {

    // Методы интерфейса для работы с задачами
    
    List<Task> getAllTask(); // Получение всех задач
    
    List<Task> getTaskByStatus(Status status); // Получение задач по статусу
    
    Task getTaskById(Long id); // Получение задачи по идентификатору
    
    boolean createTask(Task task); // Создание новой задачи
    
    boolean updateTaskStatus(Long id, Status status); // Обновление статуса задачи
    
    boolean deleteTask(Long id); // Удаление задачи
}