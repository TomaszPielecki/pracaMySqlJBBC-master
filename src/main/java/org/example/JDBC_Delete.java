package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteka", "root", "");
            if (connection == null) {
                System.out.println("Brak połączenia z bazą danych.");
            } else {
                System.out.println("Jest połączenie.");
            }
            statement = connection.createStatement();

            String sqlUpdate = "DELETE FROM kategoria  WHERE id=1;";

            statement.executeUpdate(sqlUpdate);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // zamykanie bazy danych
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
