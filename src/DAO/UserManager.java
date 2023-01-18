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

    public void getAllUser() {
        try {
            model.setRowCount(0);
            conn = connector.getConnection();
            String query = "Select ID, lastname, firstname, birthday, address, sex, email from user ORDER by create_at;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("ID");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String birthday = rs.getString("birthday");
                String address = rs.getString("address");
                String gender = rs.getString("sex").equals("-1") ? "NULL"
                        : rs.getString("sex").equals("0") ? "Nữ" : "Nam";
                String email = rs.getString("email");
                model.addRow(new Object[] { id, lastname, firstname, birthday, address, gender, email });
            }

        } catch (Exception e) {
            System.out.println("Error get user " + e);
        }
    }

    public void updateUser(String id, String lastname, String firstname, String birthday, String address, String gender,
            String email) {
        try {
            conn = connector.getConnection();
            String query = String.format(
                    "update user set lastname = '%s', firstname = '%s', birthday = '%s', address = '%s', sex = '%s', email = '%s' where ID = '%s';",
                    lastname, firstname, birthday, address, gender, email, id);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    public void deleteUser(String id) {
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
