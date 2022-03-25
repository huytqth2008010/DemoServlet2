package com.example.DemoServlet2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public Connection getConnection() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/t2008m_sem4",
                        "root",
                        "");
        System.out.println("Connect success !");
        return connection;
    }
}
