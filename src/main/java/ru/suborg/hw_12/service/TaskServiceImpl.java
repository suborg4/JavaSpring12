package ru.suborg.hw_12.service;

import ru.suborg.hw_12.entity.Status;
import ru.suborg.hw_12.entity.Task;
import ru.suborg.hw_12.exception.TaskNotFoundException;
import ru.suborg.hw_12.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service // сервисный класс в Spring-приложении
@RequiredArgsConstructor // создание конструктора с полями, помеченными как final

public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository; // Инъекция зависимости для работы с репозиторием

    @Override
    public boolean createTask(Task task) { 
        if (task != null || task.getDescription() != null) { // Проверка на валидность данных
            LocalDateTime date = LocalDateTime.now(); 
            task.setCreateAt(date); 
            task.setChangesAt(date); 
            task.setStatus(Status.TODO); 

            repository.save(task); // Сохранение задачи в репозитории
            return true; 
        } 
        return false; 
    } 

    @Override 
    public boolean deleteTask(Long id) { 
        Optional<Task> task = repository.findById(id); 
        if (task.isPresent()) { 
            repository.deleteById(id); 
            return true; 
        } 
        throw new TaskNotFoundException(); // Исключение если задача не найдена
    } 

    @Override 
    public List<Task> getAllTask() { 
        List<Task> tasks = repository.findAll(); 
        if (!tasks.isEmpty()) { 
            return tasks; 
        } 
        return Collections.emptyList(); 
    } 

    @Override 
    public Task getTaskById(Long id) { 
        Optional<Task> task = repository.findById(id); 
        if (task.isPresent()) { 
            return task.get(); 
        } 
        throw new TaskNotFoundException(); 
    } 

    @Override 
    public List<Task> getTaskByStatus(Status status) { 
        //return repository.getAllTaskByStatus(status);  
        return repository.findAll().stream().filter(s -> s.getStatus().equals(status)).toList(); // Получение задач по статусу
    } 

    @Override 
    public boolean updateTaskStatus(Long id, Status status) { 
        Optional<Task> optionalTask = repository.findById(id); 
        if (optionalTask.isPresent()) { 
            Task updatedTask = optionalTask.get(); 
            updatedTask.setStatus(status); 
            updatedTask.setChangesAt(LocalDateTime.now()); 
            repository.save(updatedTask); // Обновление статуса задачи
            return true; 
        } 
        throw new TaskNotFoundException(); 
    } 
}
