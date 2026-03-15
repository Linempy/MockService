# Mock Service API

Микросервис для имитации API Центрального Банка России (https://www.cbr.ru/scripts/XML_daily.asp).
Предоставляет курсы валют в формате XML с возможностью симуляции различных сценариев ответа.

## Содержание
- Технологии
- Запуск проекта
- Примеры запросов

## Технологии

- **Java 17** - основной язык
- **Spring Boot 3.0.6** - фреймворк
- **PostgreSQL 15** - база данных
- **Liquibase** - миграции БД
- **MapStruct** - маппинг DTO
- **SpringDoc OpenAPI** - Swagger документация
- **Docker / Docker Compose** - контейнеризация
- **Taskfile** - автоматизация задач
- **Checkstyle** - проверка стиля кода

### Слои приложения:
- **Controller** - обработка HTTP запросов
- **Service** - бизнес-логика
- **Repository** - работа с БД (Spring Data JPA)
- **Mapper** - преобразование Entity ↔ DTO (MapStruct)
- **DTO** - объекты передачи данных
- **Entity** - сущности БД

## Запуск проекта

### Предварительные требования
- Java 17+
- Docker и Docker Compose
- PostgreSQL 15 (если запуск без Docker)
- Gradle
- Task

### Запуск

#### Для Windows
Если запускать проект через Taskfile, то необходимо:
- **Docker Desktop** должен быть запущен
- **Taskfile** установлен (можно через `winget install Task.Task`)

```bash
# Клонировать репозиторий
git clone https://github.com/Linempy/MockService.git
cd MockService

# Собрать и запустить, используя Taskfile:
task start

# Или вручную:
# 1. Собрать JAR
./gradlew clean build

# 2. Запустить контейнеры
docker-compose up -d
```

## Команды Taskfile:
```txt
task start    # Сборка + запуск
task up       # Только запуск контейнеров
task down     # Остановка контейнеров
task restart  # Перезапуск
task build    # Сборка JAR
task clean    # Полная очистка
task info     # Информация о проекте
```

## Примеры запросов

### Успешный запрос
curl -X GET "http://localhost:8080/scripts/XML_daily.asp?date_req=02/03/2002"

#### Ответ (XML)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<ValCurs Date="02/03/2002" name="Foreign Currency Market">
    <Valute ID="R01235">
        <NumCode>840</NumCode>
        <CharCode>USD</CharCode>
        <Nominal>1</Nominal>
        <Name>Доллар США</Name>
        <Value>30,9436</Value>
        <VunitRate>30,9436</VunitRate>
    </Valute>
    <!-- другие валюты -->
</ValCurs>
```

### Ошибка 400 (неверная дата)
curl -X GET "http://localhost:8080/scripts/XML_daily.asp?date_req=02/03/20"

#### Ответ (JSON)
{
    "code": 400,
    "message": "Неверный формат даты. Используйте dd/MM/yyyy"
}

### Симуляция ошибки 500
curl -X GET "http://localhost:8080/scripts/XML_daily.asp?date_req=02/03/2002&status=500"

#### Ответ (JSON)
{
    "code": 500,
    "message": "Симулированная ошибка сервера"
}
