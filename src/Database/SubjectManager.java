package Database;

import java.sql.*;

import javax.swing.DefaultComboBoxModel;

import Controller.Connector;

public class SubjectManager {
    Connector connector;
    Connection conn;

    public SubjectManager() {
        this.connector = new Connector();
    }

    /*
     * ---------------------------GIAO VIEN
     * QUERY-----------------------------------------
     */
    public void getAllSubject(DefaultComboBoxModel<String> monhocModel) {
        try {
            monhocModel.removeAllElements();
            conn = connector.getConnection();
            String query = "Select ID, name from subject;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                monhocModel.addElement(name);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error get subject" + e);
        }
    }

    // get year of all class
    public void getAllYear(DefaultComboBoxModel<String> namhocModel) {
        try {
            namhocModel.removeAllElements();
            conn = connector.getConnection();
            String query = "SELECT  DISTINCT  year FROM `mark`;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("year");
                // get 4 first character
                namhocModel.addElement(name.substring(0, 4));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error get year" + e);
        }
    }

    /*
     * ------------------------------- SINH VIEN
     * QUERY------------------------------------------
     */
    // get my year
    public void getMyYear(DefaultComboBoxModel<String> namhocBox, String user_id) {
        try {
            namhocBox.addElement("2020");
            namhocBox.addElement("2021");
            namhocBox.addElement("2022");
            namhocBox.addElement("2023");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error get year" + e);
        }
    }

    // get subject which i not have
    public void getOtherSubject(DefaultComboBoxModel<String> monhocBox, String user_id, String year) {
        try {
            monhocBox.removeAllElements();
            conn = connector.getConnection();
            String query = String.format("""
                        SELECT name FROM `subject` WHERE name not IN (
                    	    SELECT subject.name from subject inner join mark on subject.ID = mark.subject_id
                            where mark.user_id = '%s' and mark.year = '%s'
                    );
                                    """, user_id, year);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                monhocBox.addElement(name);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error get subject" + e);
        }
    }
}
