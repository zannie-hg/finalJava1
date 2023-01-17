package DAO;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

import Controller.Connector;

public class MarkManager {
    Connector connector;
    Connection conn;
    DefaultTableModel model;
    public MarkManager(DefaultTableModel model) {
        this.model = model;
        this.connector = new Connector();
    }

    public void getAllMark(String yearOption, String subjectOption){
        System.out.println("Get all mark");
        try {
            model.setRowCount(0);
            conn = connector.getConnection();
            String query = String.format("""
                select mark.ID, user.firstname, user.lastname, mark.homework_mark, mark.midtern_mark, mark.final_mark, subject.name, mark.year
                from mark INNER JOIN user ON mark.user_id = user.ID
                INNER JOIN subject ON mark.subject_id = subject.ID
                where mark.year = '%s' and subject.name = '%s';
                    """, yearOption, subjectOption);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("ID");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String homework_mark = rs.getString("homework_mark");
                String midtern_mark = rs.getString("midtern_mark");
                String final_mark = rs.getString("final_mark");
                String subject_name = rs.getString("name");
                String year = rs.getString("year").substring(0, 4);
                model.addRow(new Object[]{id, lastname, firstname, homework_mark, midtern_mark, final_mark, subject_name, year});
            }
            conn.close();
            System.out.println("Get all mark success");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    public void deleteMark(String id){
        System.out.println("Delete mark");
        try {
            conn = connector.getConnection();
            String query = String.format("delete from mark where ID = '%s';", id);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            System.out.println("Delete mark success");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public void updateMark(String id, String homework, String midtern, String finalmark){
        System.out.println("Update mark");
        try {
            conn = connector.getConnection();
            String query = String.format("update mark set homework_mark = '%s', midtern_mark = '%s', final_mark = '%s' where ID = '%s';", homework, midtern, finalmark, id);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            System.out.println("Update mark success");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    
}
