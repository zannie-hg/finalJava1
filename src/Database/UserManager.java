package Database;

import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Connector;
import View.SinhVienQuanLy;

public class UserManager {
    Connector connector;
    Connection conn;
    SinhVienQuanLy sinhVienQuanLy;

    public UserManager() {
        this.connector = new Connector();
    }

    /* ------------------------GIAO VIEN QUERY----------------------------- */
    public void getAllUser(DefaultTableModel model, String keyword) {
        try {
            model.setRowCount(0);
            conn = connector.getConnection();
            String query = String.format("Select ID, lastname, firstname, birthday, address, sex, email  from user WHERE   (user.firstname like '%%%s%%' or user.lastname like '%%%s%%');", keyword, keyword );
            System.out.println(query);
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

    /* ------------------------SINH VIEN QUERY----------------------------- */

    public void updatePassword(String user_id, String currentPass, String newPass, String confirmPass) {
        try {
            conn = connector.getConnection();
            // check confirm password
            if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(null, "Xác nhận mật khẩủ không khớp");
                return;
            }
            // check current password
            String crPass = "";
            ResultSet rs1 = conn.createStatement()
                    .executeQuery(String.format("SELECT password FROM user WHERE ID = '%s'", user_id));
            if (rs1.next()) {
                crPass = rs1.getString("password");
            } else {
                JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại!");
                return;
            }
            // check current pass
            if (!crPass.equals(currentPass)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không đúng");
                return;
            }

            // update pass word
            String query = String.format("UPDATE user SET password = '%s' WHERE ID = '%s'", newPass, user_id);
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công");
            conn.close();

        } catch (Exception e) {
            System.out.println("Error to update pass " + e);
        }
    }

    public void updateMyInfo(String user_id, String firstname, String lastname, String email, String gender,
            String birthday,
            String address) {
        try {
            conn = connector.getConnection();
            String sql = String.format(
                    "update user set firstname = '%s', lastname = '%s', email = '%s', sex = '%s', birthday = '%s', address = '%s' where ID = '%s';",
                    firstname, lastname, email, gender, birthday, address, user_id);
            Statement st = conn.createStatement();
            st.executeUpdate(sql);

            conn.close();
            JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
            System.out.println("Error " + e);
        }
    }

    public void getMyUserInfo(String user_id, JTextField firstNameField, JTextField lastNameField,
            JTextField emailField, JTextField addressField, JDateChooser birthdayCalendar, JRadioButton maleRadioBtn,
            JRadioButton femaleRadioBtn) {
        try {
            conn = connector.getConnection();
            String sql = String.format(
                    "Select  firstname, lastname, email, address, sex, birthday from user where ID='%s';", user_id);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            firstNameField.setText(rs.getString("firstname"));
            lastNameField.setText(rs.getString("lastname"));
            emailField.setText(rs.getString("email"));
            addressField.setText(rs.getString("address"));
            if (rs.getString("sex").equals("-1")) {
                maleRadioBtn.setSelected(false);
                femaleRadioBtn.setSelected(false);
            } else if (rs.getString("sex").equals("0")) {
                femaleRadioBtn.setSelected(true);
                maleRadioBtn.setSelected(false);
            } else {
                femaleRadioBtn.setSelected(true);
                maleRadioBtn.setSelected(false);
            }
            birthdayCalendar.setDate(new SimpleDateFormat("yyyy-MM-dd")
            .parse(rs.getString("birthday")));


        } catch (Exception e) {
            System.out.println("Error to getMyInfo");
            System.out.println(e.getMessage());
        }
    }

   
}