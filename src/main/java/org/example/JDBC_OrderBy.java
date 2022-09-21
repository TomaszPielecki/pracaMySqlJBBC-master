package org.example;

import java.sql.*;

public class JDBC_OrderBy {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteka",
                            "root", "");
            if (connection == null) {
                System.out.println("Brak połączenia z bazą danych.");
            } else {
                System.out.println("Jest połączenie.");
            }
            statement = connection.createStatement();
            String sql = "SELECT autor,tytul,wydawnictwo FROM ksiazki WHERE id > 1 Order by id desc;"; //sortowanie malejaco

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                String autor = resultSet.getString("autor");
                String tytul = resultSet.getString("tytul");
                String wydawnictwo = resultSet.getString("wydawnictwo");
                System.out.println(" autor " + autor + " tytul "
                        + tytul + " wydawnictwo " + wydawnictwo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // zamykanie bazy danych
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
