# Vacation-Calculator

## Описание

Vacation Calculator — это приложение, разработанное на Spring Boot, которое позволяет пользователям рассчитывать количество дней отпуска, основываясь на различных критериях. 

Приложение принимает среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.

![calculate1](https://github.com/user-attachments/assets/f10b02c8-169a-4d50-811b-7c453884082b)

Если при запросе указать точные дни ухода в отпуск, рассчет отпускных проводиться с учётом праздников и выходных.

![calculate2](https://github.com/user-attachments/assets/7d733d04-189e-4227-9051-d8e604c0fe2f)

Для тестирования функционала используются  интеграционные и юнит-тесты. Тестовое покрытие - 98%.

![jacoco](https://github.com/user-attachments/assets/7ab9ea01-58ca-4cdf-9faa-f850f870d93a)


## Технологии

- Java 11
- Spring
- Maven
- Docker
- Swagger
- Jacoco

## Начало работы

1. Установите на свой компьютер [JDK](https://www.oracle.com/cis/java/technologies/downloads/) и среду
разработки [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/download/?section=windows), если они ещё не 
установлены.

2. Загрузите проект-заготовку из Git-репозитория.

3. Запустите класс `VacationcalculatorApplication`.

Вы также можете запустить приложение в Docker. Для этого в терминале выполните следующие команды:

- для сборки приложения: `mvn clean package`.

- для сборки Docker-образа: `docker build -t vacationcalculator`

- для запуска контейнера: `docker run -p 8080:8080 vacationcalculator`


Теперь приложение будет доступно по адресу http://localhost:8080.

После запуска всех сервисов документацию по API можно увидеть в [Swagger](http://localhost:8086/swagger-ui/index.html).  

## Контакты

Если у вас есть вопросы или вам нужна помощь, вы можете связаться со мной в telegram - @oksana_buivarenko 

