package org.example;

import java.sql.*;

public class JDBC_Like {
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
            //String sql = "SELECT autor,tytul,wydawnictwo FROM ksiazki WHERE autor like '%usz%';";
            String sql1 = "SELECT autor,tytul,wydawnictwo FROM ksiazki WHERE autor like 'L%';";// autorzy zaczynajacy sie na litere L

            //resultSet = statement.executeQuery(sql);
            resultSet = statement.executeQuery(sql1);


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
