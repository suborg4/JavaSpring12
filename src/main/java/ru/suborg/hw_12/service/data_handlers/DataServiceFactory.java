package ru.suborg.hw_12.service.data_handlers;

import org.springframework.stereotype.Service;
import java.util.Map;

/**
* Класс DataServiceFactory представляет фабрику сервисов для обработки данных различных типов.
*/


@Service
public class DataServiceFactory {

    private final Map<String, DataService> dataServiceMap;

    public DataServiceFactory(Map<String, DataService> dataServiceMap) {
        this.dataServiceMap = dataServiceMap;
    }

    /**
     * Возвращает сервис обработки данных соответствующего типа.
     * @param dataType тип данных
     * @return сервис обработки данных
     */
    public DataService getService(String dataType) {
        return dataServiceMap.get(dataType);
    }
}

