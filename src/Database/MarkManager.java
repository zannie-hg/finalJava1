package Database;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.Connector;
import View.SinhVienQuanLy;

public class MarkManager {
    Connector connector;
    Connection conn;
    public MarkManager() {
        this.connector = new Connector();
    }
    /* ------------------------------------GIAO VIEN QUERY------------------------------------- */

    public String toDoubleSring(String s) {
        if (s.equals("")) {
            return "NULL";
        } else {
            return "'" + s + "'";
        }
    }

    public void getAllMark(DefaultTableModel model, String yearOption, String subjectOption, String keyword){
        try {
            model.setRowCount(0);
            conn = connector.getConnection();
            String query = String.format("""
                select mark.ID, user.firstname, user.lastname, mark.homework_mark, mark.midtern_mark, mark.final_mark, subject.name, mark.year
                from mark INNER JOIN user ON mark.user_id = user.ID
                INNER JOIN subject ON mark.subject_id = subject.ID
                where mark.year = '%s' and subject.name = '%s' and (user.firstname like '%%%s%%' or user.lastname like '%%%s%%');
                    """, yearOption, subjectOption, keyword, keyword);
            System.out.println(query);
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
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    public void deleteMark(String id){
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
        try {
            conn = connector.getConnection();

            String query = String.format("update mark set homework_mark = %s, midtern_mark = %s, final_mark = %s where ID = '%s';"
            , toDoubleSring(homework), toDoubleSring(midtern), toDoubleSring(finalmark), id);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            System.out.println("Update mark success");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    /* --------------------------------------SINH VIEN QUERY---------------------------------------------- */
    // add mark
    public void addClass(String user_id, String subject, String year){
        try {
            conn = connector.getConnection();
            // get subject id
            String query1 = String.format("select ID from subject where name = '%s';", subject);
            Statement st1 = conn.createStatement();
            ResultSet rs = st1.executeQuery(query1);
            if (!rs.next()) {
                System.out.println("Subject not found");
                JOptionPane.showMessageDialog(null, "Subject not found");
                return;
            }
            String subject_id = rs.getString("ID");
            // get id
            String query2 = "SELECT ID FROM mark ORDER BY create_at DESC LIMIT 1";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(query2);
            rs2.next();
            String id = rs2.getString("ID");
            int idInt = Integer.parseInt(id.substring(2)); //lay phantu thu 2
            idInt++;
            id = "CL" + String.format("%06d", idInt);
            
            // insert mark
            
           
            String query = String.format("insert into mark(ID, user_id, subject_id, year) values('%s','%s', '%s', '%s');",id, user_id, subject_id, year);
            System.out.println(query);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            System.out.println("Add class success");
            JOptionPane.showMessageDialog(null, "Add class success");
        } catch (SQLException e) {
            System.out.println("Error add class" + e);
        }
    }

    // Get my mark
    public void getMyMark(DefaultTableModel myMarkModel
    , String user_id, String year){
        try {
            myMarkModel.setRowCount(0);
            conn = connector.getConnection();
            String query = String.format("""
                select mark.ID, user.firstname, user.lastname, mark.homework_mark, mark.midtern_mark, mark.final_mark, subject.name, mark.year
                from mark INNER JOIN user ON mark.user_id = user.ID
                INNER JOIN subject ON mark.subject_id = subject.ID
                where user.ID = '%s' and mark.year = '%s';
                    """, user_id, year);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                String ID = rs.getString("mark.ID");
                String subject = rs.getString("subject.name");
                String homework = rs.getString("homework_mark");
                String midtern = rs.getString("midtern_mark");
                String finalmark = rs.getString("final_mark");
                if (homework == null) homework = "";
                if (midtern == null) midtern = "";
                if (finalmark == null) finalmark = "";
                String avg = "N/A";
                if (!(homework.equals("") || midtern.equals("") || finalmark.equals(""))){
                    Double average = (Double.parseDouble(homework)*2 + Double.parseDouble(midtern)*2 + Double.parseDouble(finalmark)*6) / 10;
                    avg = String.format("%.2f", average);
                }
                
                myMarkModel.addRow(new Object[]{ID, subject, homework, midtern, finalmark, avg});
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error get my mark" + e);
        }
    }


}
