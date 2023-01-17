package DAO;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.Connector;

public class UserManager {
    Connector connector;
    Connection conn;
    DefaultTableModel model;
    public UserManager(DefaultTableModel model) {
        this.model = model;
        this.connector = new Connector();
    }

    public void getAllUser(){
        try {
            model.setRowCount(0);
            conn = connector.getConnection();
            String query = "Select ID, lastname, firstname, birthday, address, religion, email from user;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("ID");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String birthday = rs.getString("birthday");
                String address = rs.getString("address");
                String religion = rs.getString("religion");
                String email = rs.getString("email");
                model.addRow(new Object[]{id, lastname, firstname, birthday, address, religion, email});
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void updateUser(String id, String lastname, String firstname, String birthday, String address, String religion, String email){
        try {
            conn = connector.getConnection();
            String query = String.format("update user set lastname = '%s', firstname = '%s', birthday = '%s', address = '%s', religion = '%s', email = '%s' where ID = '%s';", lastname, firstname, birthday, address, religion, email, id);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    public void deleteUser(String id){
        try {
            conn = connector.getConnection();
            String query = String.format("delete from user where ID = '%s';", id);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            JOptionPane.showMessageDialog(null, "Đã xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
    
}
