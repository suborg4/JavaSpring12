package ru.suborg.hw_12.service.data_handlers;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

/**
* Интерфейс TxtFileService представляет сервис для записи данных в текстовые файлы.
*/

@Service("txtWriter")
@MessagingGateway(defaultRequestChannel = "textInputChannel")

public interface TxtFileService extends DataService {
    @Override
    void writeData(@Header(FileHeaders.FILENAME) String filename, String data);
}
