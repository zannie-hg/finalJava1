package Controller;

import java.sql.*;
import java.util.logging.*;

public class Connector {
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/final1";
        String user = "root";
        String pwd = "";
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return conn;
    }
}
