package DAO;

import java.sql.*;

import javax.swing.DefaultComboBoxModel;

import Controller.Connector;

public class SubjectManager {
    Connector connector;
    Connection conn;
    private DefaultComboBoxModel<String> namhocModel, monhocModel;
    public SubjectManager(DefaultComboBoxModel<String> namhocModel, DefaultComboBoxModel<String> monhocModel) {
        this.namhocModel = namhocModel;
        this.monhocModel = monhocModel;
        this.connector = new Connector();
    }

    public void getAllSubject(){
        try {
            monhocModel.removeAllElements();
            conn = connector.getConnection();
            String query = "Select ID, name from subject;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("name");
                monhocModel.addElement(name);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error get subject" + e);
        }
    }

    //get year of all class
    public void getAllYear(){
        try {
            namhocModel.removeAllElements();
            conn = connector.getConnection();
            String query = "SELECT  DISTINCT  year FROM `mark`;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("year");
                //get 4 first character
                namhocModel.addElement(name.substring(0, 4));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error get year" + e);
        }
    }


}
