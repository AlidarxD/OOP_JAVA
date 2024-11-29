import java.sql.*;

public class JDBCDatabaseExample {
 
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASSWORD = "30112005aLIDAR!";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to database...");
            createTable(statement);
            insertRecords(statement);
            selectAndDisplayRecords(statement);
            updateRecords(statement);
            System.out.println("Updated!");
            deleteRecords(statement);
            selectAndDisplayRecords(statement);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Goodbye!");
    }

    private static void createTable(Statement statement) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "first VARCHAR(50), " +
                "last VARCHAR(50), " +
                "age INT)";
        statement.executeUpdate(createTableSQL);
    }

    private static void insertRecords(Statement statement) throws SQLException {
        String insertSQL = "INSERT INTO Employees (first, last, age) VALUES " +
                "('Alan', 'Sheep', 18), " +
                "('Alidar', 'Cool', 19), " +
                "('Magzhan', 'AlsoCool', 18), " +
                "('NoName', 'norm', 18)";
        statement.executeUpdate(insertSQL);
    }

    private static void selectAndDisplayRecords(Statement statement) throws SQLException {
        String selectSQL = "SELECT id, first, last, age FROM Employees";
        try (ResultSet rs = statement.executeQuery(selectSQL)) {
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.print(", Last: " + rs.getString("last"));
                System.out.println(", Age: " + rs.getInt("age"));
            }
        }
    }

    private static void updateRecords(Statement statement) throws SQLException {
        String updateSQL = "UPDATE Employees SET first = 'Almat' WHERE last = 'norm'";
        statement.executeUpdate(updateSQL);
    }

    private static void deleteRecords(Statement statement) throws SQLException {
        String deleteSQL = "DELETE FROM Employees WHERE last = 'Sheep'";
        statement.executeUpdate(deleteSQL);
    }
}
