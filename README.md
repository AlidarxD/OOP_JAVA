# README для JDBCDatabaseExample


## Пояснение к коду
Создание базы данных: Если база данных testdb еще не существует, вам нужно создать её вручную перед запуском программы
CREATE DATABASE testdb;

Подключение к базе данных: В коде используется строка подключения JDBC_URL, которая указывает на локальную базу данных testdb с пользователем root и паролем 30112005aLIDAR!.
static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
static final String USER = "root";
static final String PASSWORD = "30112005aLIDAR!";

Подключение и создание объектов: В методе main создается подключение к базе данных с использованием DriverManager.getConnection() и объект Statement, который используется для выполнения SQL-запросов.

try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
     Statement statement = connection.createStatement()) {
    Class.forName("com.mysql.cj.jdbc.Driver");

Методы:

createTable(Statement statement) — создает таблицу Employees, если она не существует. В таблице есть четыре поля: id, first, last, age.
insertRecords(Statement statement) — вставляет несколько записей в таблицу Employees.
selectAndDisplayRecords(Statement statement) — выбирает и отображает все записи из таблицы Employees.
updateRecords(Statement statement) — обновляет запись в таблице, изменяя значение поля first для записи, у которой фамилия norm.
deleteRecords(Statement statement) — удаляет запись с фамилией Sheep. Алан ғой
Пример кода для создания таблицы:

private static void createTable(Statement statement) throws SQLException {
    String createTableSQL = "CREATE TABLE IF NOT EXISTS Employees (" +
                            "id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "first VARCHAR(50), " +
                            "last VARCHAR(50), " +
                            "age INT)";
    statement.executeUpdate(createTableSQL);
}

Обработка исключений: Программа обрабатывает два типа исключений:

SQLException — ошибки, связанные с SQL-запросами и взаимодействием с базой данных.
ClassNotFoundException — если класс драйвера MySQL не найден.


Закрытие ресурсов: Используется конструкция try-with-resources, чтобы автоматически закрыть соединение и другие ресурсы после выполнения.
try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
     Statement statement = connection.createStatement()) {
}

![Screenshot 2024-11-29 141825](https://github.com/user-attachments/assets/529d55ae-0d05-4a8f-8122-f3bc81db2bd0)


![Screenshot 2024-11-28 165419](https://github.com/user-attachments/assets/a5235a0c-ffb0-4450-b9fd-b79639610631)

![Screenshot 2024-11-28 165524](https://github.com/user-attachments/assets/b8f21716-2e53-4342-8769-5fdebc91495c)

