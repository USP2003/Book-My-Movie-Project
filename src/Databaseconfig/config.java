package Databaseconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class config {
    static String url="jdbc:mysql://localhost:3306/bookmymovies";
    static  String username="username";
    static String password="password";

    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
