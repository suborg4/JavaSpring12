package ru.suborg.hw_12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.suborg.hw_12.entity.Status;
import ru.suborg.hw_12.entity.Task;

/**
* Интерфейс TaskRepository предоставляет методы для работы с задачами в базе данных.
*/

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    /**
     * Получение всех задач по указанному статусу.
     * @param status статус задачи
     * @return список задач с указанным статусом
     */
    @Query(value = "SELECT * FROM tasks WHERE status=:status", nativeQuery = true)
    List<Task> getAllTaskByStatus(Status status);
}
