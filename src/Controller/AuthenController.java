package Controller;

import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;

import View.DangKy;
import View.DangNhap;
import View.GiaoVienQuanLy;

public class AuthenController {
    DangNhap dangNhapView;
    DangKy dangKyView;
    Connector connector;
    Connection conn;

    String username;
    String role;
    String ID;

    public AuthenController() {
        connector = new Connector();
        dangNhapView = new DangNhap();
        dangKyView = new DangKy();
        initAction();
        dangNhapView.setVisible(true);
        dangKyView.setVisible(false);
    }

    public void initAction() {
        dangNhapView.addDangNhapListenner(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDangNhap(e);
            }
        });
        dangKyView.addDangKyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDangKy(e);
            }
        });
        dangNhapView.addDangKyListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onSwDangKy(e);
            }
        });
        dangKyView.addDangNhapListenner(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onSwDangNhap(e);
            }
        });
    }

    public void onDangNhap(ActionEvent e) {
        try {
            conn = connector.getConnection();
            String email = dangNhapView.getLoginInfo()[0];
            String password = dangNhapView.getLoginInfo()[1];

            // check email and password in table user
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select ID, email, password, role_id, firstname, lastname from user where email = '" + email + "'");
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    username = rs.getString("firstname");
                    ID = rs.getString("ID");
                    if (rs.getString("role_id").equals("r1")) {
                        role = "Giáo viên";
                        new GiaoVienController(this, username);
                        dangNhapView.setVisible(false);
                    } else {
                        role = "Sinh viên";
                        new SinhVienController(this, username, ID);
                        dangNhapView.setVisible(false);
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu");
                    System.out.println("Login fail");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại");
                System.out.println("Login fail");
            }

            conn.close();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối");
            e1.printStackTrace();
        }

    }

    public void onDangKy(ActionEvent e) {
        
        try {
            conn = connector.getConnection();
            String[] info = dangKyView.getRegisterInfo();
            String firstname = info[0];
            String lastname = info[1];
            String email = info[2];
            String birthday = info[3];
            String password = info[4];
            String repassword = info[5];


            if (!password.equals(repassword)) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không khớp","Eror", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")){
                JOptionPane.showMessageDialog(null, "Email không hợp lệ","Eror", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (password.length() < 8) {
                JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ","Eror", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // check email and password in table user
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select email from user where email = '" + email + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại");
            } else {
                ResultSet rs1 = st.executeQuery("SELECT ID FROM user ORDER BY create_at DESC LIMIT 1");
                rs1.next();
                String ID = rs1.getString("ID");
                int id = Integer.parseInt(ID.substring(2));
                id++;
                ID = "SV" + String.format("%03d", id);
                String query = String.format("INSERT INTO `user` (`ID`, `firstname`, `lastname`, `email`, `role_id`, `password`, `sex`, `birthday`, `address`) VALUES ('%s', '%s', '%s', '%s', 'r2', '%s', null, '%s', '');", ID, firstname, lastname, email, password, birthday);
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                dangKyView.setVisible(false);
                dangNhapView.setVisible(true);
            }

            conn.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
    }

    public void onSwDangKy(MouseEvent e) {
        dangKyView.setVisible(true);
        dangNhapView.setVisible(false);
    }

    public void onSwDangNhap(MouseEvent e) {
        dangKyView.setVisible(false);
        dangNhapView.setVisible(true);
    }

    
}
