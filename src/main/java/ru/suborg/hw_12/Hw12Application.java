package ru.suborg.hw_12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication //  класс представляет Spring Boot приложение
@EnableTransactionManagement //  включение управления транзакциями

public class Hw12Application { 

    public static void main(String[] args) { 
        SpringApplication.run(Hw12Application.class, args); // Запуск приложения Spring Boot
    } 
}