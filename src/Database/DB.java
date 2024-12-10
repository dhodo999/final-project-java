package Database;

import java.sql.*;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/final_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection connect() throws SQLException {

        if (connection == null || connection.isClosed()) {
            try {
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Failed to close connection" + e.getMessage());
        }

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.err.println("Failed to close prepared statement" + e.getMessage());
        }

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.err.println("Failed to close result set" + e.getMessage());
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement) {

        close(connection, preparedStatement, null);
    }

    public static void close(PreparedStatement preparedStatement) {

        try {
            if(preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Failed to close prepared statement" + e.getMessage());
        }
    }
}