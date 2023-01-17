package View;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class DangKy extends JFrame {
    private com.toedter.calendar.JDateChooser ngaysinhCalendar;
    private JButton dangkyButton;
    private JLabel dangnhapLabel;
    private JLabel emailLabel;
    private JLabel hoLabel;
    private JLabel matkhauLabel;
    private JLabel ngaysinhLabel;
    private JLabel nhaplaimatkhauLabel;
    private JLabel tenLabel;
    private JLabel titleDangKyLabel;
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPasswordField matkhauField;
    private JPasswordField nhaplaimatkhauField;
    private JTextField emailField;
    private JTextField hoField;
    private JTextField tenField;

    public DangKy() {
        initComponents();
    }

    public void initComponents() {

        // titleDangKyLabel
        titleDangKyLabel = new JLabel();
        titleDangKyLabel.setFont(new Font("Segoe UI", 1, 25)); 
        titleDangKyLabel.setForeground(new Color(255, 0, 0));
        titleDangKyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleDangKyLabel.setText("Đăng ký");

        titleDangKyLabel.setBounds(90, 20, 140, 50);

        // hoLabel
        hoLabel = new JLabel();
        hoLabel.setText("Họ:");

        hoLabel.setBounds(50, 70, 30, 20);

        // tenLabel
        tenLabel = new JLabel();
        tenLabel.setText("Tên:");

        tenLabel.setBounds(180, 70, 37, 20);

        // hoField
        hoField = new JTextField();

        hoField.setBounds(50, 90, 120, 30);

        // tenField
        tenField = new JTextField();

        tenField.setBounds(180, 90, 120, 30);

        // emailLabel
        emailLabel = new JLabel();
        emailLabel.setText("Email:");

        emailLabel.setBounds(50, 130, 35, 16);

        // emailField
        emailField = new JTextField();

        emailField.setBounds(50, 150, 250, 30);

        // ngaysinhLabel
        ngaysinhLabel = new JLabel();
        ngaysinhLabel.setText("Ngày sinh :");

        ngaysinhLabel.setBounds(50, 190, 70, 16);

        ngaysinhCalendar = new com.toedter.calendar.JDateChooser();

        ngaysinhCalendar.setBounds(50, 210, 250, 30);
        ngaysinhCalendar.setDateFormatString("yyyy-MM-dd");

        // matkhauLabel
        matkhauLabel = new JLabel();
        matkhauLabel.setText("Mật khẩu:");

        matkhauLabel.setBounds(50, 250, 60, 16);

        // matkhauField
        matkhauField = new JPasswordField();

        matkhauField.setBounds(50, 270, 250, 30);

        // nhaplaimatkhauLabel
        nhaplaimatkhauLabel = new JLabel();
        nhaplaimatkhauLabel.setText("Nhập lại mật khẩu:");

        nhaplaimatkhauLabel.setBounds(50, 310, 110, 16);

        // nhaplaimatkhauField
        nhaplaimatkhauField = new JPasswordField();

        nhaplaimatkhauField.setBounds(50, 330, 250, 30);

        // dangnhapButton
        dangkyButton = new JButton();
        dangkyButton.setBackground(new Color(252, 3, 90));
        dangkyButton.setFont(new Font("Segoe UI", 1, 13)); 
        dangkyButton.setForeground(new Color(255, 255, 255));
        dangkyButton.setText("Đăng ký");

        dangkyButton.setBounds(120, 370, 102, 30);

        // dangnhapLabel
        dangnhapLabel = new JLabel();
        dangnhapLabel.setText("Đã có tài khoản. Đăng nhập");

        dangnhapLabel.setBounds(90, 410, 160, 16);

        // panel1
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 350, 450);

        panel1.add(titleDangKyLabel);
        panel1.add(hoLabel);
        panel1.add(tenLabel);
        panel1.add(hoField);
        panel1.add(tenField);
        panel1.add(emailLabel);
        panel1.add(emailField);
        panel1.add(ngaysinhLabel);
        panel1.add(ngaysinhCalendar);
        panel1.add(matkhauLabel);
        panel1.add(matkhauField);
        panel1.add(nhaplaimatkhauLabel);
        panel1.add(nhaplaimatkhauField);
        panel1.add(dangkyButton);
        panel1.add(dangnhapLabel);

        // panel2
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(350, 0, 350, 450);
        panel2.setBackground(new Color(252,3,90));
        // mainPanel
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 700, 450);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(700,480);
        setLocationRelativeTo(null);
        setResizable(false);
        setPreferredSize(getSize());
        pack();
        

    }

    public void addDangNhapListenner(MouseInputAdapter listener){
        dangnhapLabel.addMouseListener(listener);
    }

    public void addDangKyListener(ActionListener listener){
        dangkyButton.addActionListener(listener);
    }

    public String[] getRegisterInfo(){
        String[] info = new String[6];
        info[0] = tenField.getText();
        info[1] = hoField.getText();
        info[2] = emailField.getText();
        info[3] = new SimpleDateFormat("yyyy-mm-dd").format(ngaysinhCalendar.getDate());
        info[4] = String.copyValueOf(matkhauField.getPassword());
        info[5] = String.copyValueOf(nhaplaimatkhauField.getPassword());
        return info;
    }

    public static void main(String[] args) {
        new DangKy();
    }
}
