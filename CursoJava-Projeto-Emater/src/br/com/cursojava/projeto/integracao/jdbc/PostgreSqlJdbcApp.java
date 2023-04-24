package br.com.cursojava.projeto.integracao.jdbc;

import java.sql.*;

public class PostgreSqlJdbcApp {
    public static void testJdbc() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String password, user = password = "postgres";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()){
                String sql = "SELECT 1 AS TEST";
                try (ResultSet resultSet = statement.executeQuery(sql)){
                    while (resultSet.next()){
                        byte test = resultSet.getByte("test");
                        System.out.printf("SQL Result: %s", String.valueOf(test));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}