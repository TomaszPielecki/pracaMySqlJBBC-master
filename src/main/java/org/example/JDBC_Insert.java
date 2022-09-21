package org.example;

import java.sql.*;

public class JDBC_Insert {
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

            String sqlInsert = "INSERT INTO ksiazki(autor,tytul,wydawnictwo,stron,rok)VALUES"
                    + "('Aleksander Fredro','Zemsta','Helion',90,1920),"
                    + "('Katarzyna Nosowska','Ale ja żem jej powiedziała','Wielka Literatura',202,2020)";

            statement.executeUpdate(sqlInsert);

            String sqlSelect = "SELECT * FROM ksiazki";

            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String autor = resultSet.getString("autor");
                String tytul = resultSet.getString("tytul");
                String wydawnictwo = resultSet.getString("wydawnictwo");
                int stron = resultSet.getInt("stron");
                int rok = resultSet.getInt("rok");
                System.out.println(" id " + id + " autor " + autor + " tytul "
                        + tytul + " wydawnictwo " + wydawnictwo + " stron " + stron + " rok " + rok);

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
