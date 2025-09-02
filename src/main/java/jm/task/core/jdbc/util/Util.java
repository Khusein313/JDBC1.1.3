package jm.task.core.jdbc.util;

import java.io.IOException;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String USERNAME = "Khusein313";
    private final static String PASSWORD = "1vfvfgfgf";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection()  {
        //Connection to database; Соединение с базой данных
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}