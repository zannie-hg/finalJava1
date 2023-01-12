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
            Statement statement = conn.createStatement();
            String query = "INSERT INTO `user`(`id`, `firstname`, `lastname`, `email`, `password`, `religion`, `address`, `role_id`, `create_at`, `update_at`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]','[value-8]','2023/10/01','2023/10/01')";
            int count =statement.executeUpdate(query);
            if(count==0){
                System.out.println("Record Not Inserted");
            }
            else {
                System.out.println("Record Inserted");
            } 
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return conn;
    }
}
