package View;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import java.awt.event.*;

public class DangNhap extends JFrame {
    private JLabel dangkyLabel;
    private JButton dangnhapButton;
    private JTextField emailField;
    private JLabel emailLabel;
    private JPasswordField matkhauField;
    private JLabel matkhauLabel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel mainPanel;
    
    private JLabel titleDangNhapLabel;

    public DangNhap() {
        initComponents();
    }

    public void initComponents() {

        // titleMainLabel
        titleDangNhapLabel = new JLabel();
        titleDangNhapLabel.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        titleDangNhapLabel.setForeground(new Color(255, 0, 0));
        titleDangNhapLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleDangNhapLabel.setText("Đăng nhập");

        titleDangNhapLabel.setBounds(60, 20, 140, 50);

        // emailLabel
        emailLabel = new JLabel();
        emailLabel.setText("Email:");

        emailLabel.setBounds(50, 90, 40, 20);

        // matkhauLabel
        matkhauLabel = new JLabel();
        matkhauLabel.setText("Mật khẩu:");

        matkhauLabel.setBounds(50, 150, 60, 16);
        // emailField
        emailField = new JTextField();

        emailField.setBounds(50, 110, 160, 30);

        // matkhauField
        matkhauField = new JPasswordField();

        matkhauField.setBounds(50, 170, 160, 30);

        // dangnhapButton
        dangnhapButton = new JButton();
        dangnhapButton.setBackground(new Color(252, 3, 90));
        dangnhapButton.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        dangnhapButton.setForeground(new Color(255, 255, 255));
        dangnhapButton.setText("Đăng nhập");

        dangnhapButton.setBounds(80, 220, 102, 30);

        // dangkyLabel
        dangkyLabel = new JLabel();
        dangkyLabel.setText("Không có tài khoản? Đăng ký");
        dangkyLabel.setBounds(50, 270, 180, 16);
        
        // panel1
        panel1 = new JPanel();
        panel1.setBackground(new Color(255, 255, 255));
        panel1.setBounds(0, 0, 280, 350);
        panel1.setLayout(null);
        panel1.add(titleDangNhapLabel);
        panel1.add(emailLabel);
        panel1.add(matkhauLabel);
        panel1.add(emailField);
        panel1.add(matkhauField);
        panel1.add(dangnhapButton);
        panel1.add(dangkyLabel);

        // panel2
        panel2 = new JPanel();
        panel2.setBackground(new Color(252, 3, 90));
        panel2.setBounds(280, 0, 280, 350);
        
        //mainPanel
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,550,350);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(564,370);
        setPreferredSize(getSize());
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }
    
    public void addDangKyListener(MouseInputAdapter listener){
        dangkyLabel.addMouseListener(listener);
    }

    public void addDangNhapListenner(ActionListener listener){
        dangnhapButton.addActionListener(listener);
    }

    public String[] getLoginInfo(){
        String[] field = {emailField.getText(), String.copyValueOf(matkhauField.getPassword())};
        return field;
    }

    public static void main(String[] args) {
        new DangNhap().setVisible(true);
    }

}
