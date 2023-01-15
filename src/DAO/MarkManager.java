package DAO;

import java.sql.Connection;

import Controller.Connector;

public class MarkManager {
    Connector connector;
    Connection conn;
    public MarkManager(Connector connector) {
        this.connector = connector;
    }

    
}
