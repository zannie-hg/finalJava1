import java.sql.Connection;

import Controller.Connector;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = new Connector().getConnection();
        System.out.println("Hello, World!");
    }
}
