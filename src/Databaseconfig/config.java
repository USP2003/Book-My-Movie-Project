package Databaseconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class config {
    static String url="jdbc:mysql://localhost:3306/bookmymovies";
    static  String username="root";
    static String password="SwissVisa@2027";

    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
