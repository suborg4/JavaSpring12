package ru.suborg.hw_12.service.data_handlers;

import org.springframework.stereotype.Service;

/**
* Интерфейс DataService представляет общий интерфейс для сервисов обработки данных.
*/

@Service
public interface DataService {

    /**
     * Метод для записи данных в файл.
     * @param filename имя файла
     * @param data данные для записи
     */
    void writeData(String filename, String data);
}
