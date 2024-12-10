package com;

import com.opencsv.CSVReader; // Импорт библиотеки для работы с CSV-файлами

import java.io.FileReader; // Импорт для чтения файла
import java.io.IOException; // Импорт для обработки исключений ввода-вывода
import java.io.Reader; // Импорт интерфейса Reader
import java.text.ParseException; // Импорт для обработки исключений парсинга
import java.text.SimpleDateFormat; // Импорт для форматирования дат
import java.util.Date; // Импорт класса для работы с датами
import java.util.LinkedList; // Импорт класса LinkedList для хранения пользователей
import java.util.List; // Импорт интерфейса List
import java.util.Locale; // Импорт для работы с локалями

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        // Попытка открыть файл и создать CSVReader для чтения
        try (Reader reader = new FileReader("src/main/resources/foreign_names.csv");
             CSVReader csvReader = new CSVReader(reader, ';')) { // Разделитель ';'

            // Установка формата даты
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            // Массив для временного хранения данных из CSV
            String[] buffer = new String[5];

            // Чтение заголовка (первой строки) и игнорирование
            csvReader.readNext();

            // Пример даты для парсинга
            Date d = formatter.parse("23.01.2023");

            // Создание списка для хранения пользователей
            List<User> users = new LinkedList<>();

            // Чтение данных из CSV в цикле
            while ((buffer = csvReader.readNext()) != null) {
                // Чтение каждого элемента из текущей строки
                String id = buffer[0]; // ID пользователя
                String name = buffer[1]; // Имя пользователя
                String gender = buffer[2]; // Пол пользователя
                Date date = formatter.parse(buffer[3]); // Дата
                char div = buffer[4].charAt(0); // Символ разделителя
                Integer salary = Integer.parseInt(buffer[5]); // Зарплата

                // Создание нового объекта пользователя
                User user = new User(id, name, gender, date, div, salary);
                // Добавление пользователя в список
                users.add(user);
            }

            // Вывод информации о пользователях в консоль
            users.stream().forEach(System.out::println);
        } // Ресурсы автоматически закрываются здесь
    }
}
