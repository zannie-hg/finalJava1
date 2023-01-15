package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class SinhVienQuanLy extends JFrame {
    private JButton dangkyButton;
    private JButton dangxuatButton;
    private JLabel matkhauLabel;
    private JLabel diachiLabel;
    private JTextField diachiField;
    private JTable diemTable;
    private JPasswordField doimatkhauField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JButton exportcsvButton;
    private JLabel hovatenLabel;
    private JTextField hovatenField;
    private JScrollPane diemScrollPane;
    private JPanel mainPanel;
    private JPasswordField matkhauField;
    private JRadioButton namRadioButton;
    private JComboBox<String> namhocComboBox;
    private JLabel namhocLabel;
    private JLabel ngaysinhLabel;
    private JTextField ngaysinhField;
    private JRadioButton nuRadioButton;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel sodienthoaiLabel;
    private JTextField sodienthoaiField;
    private JTextField titleDiemField;
    private JLabel titleMainLabel;
    private JLabel doimatkhauLabel;
    public DefaultTableModel tableModel;

    public SinhVienQuanLy() {
        initComponents();
    }

    public void initComponents() {

        // 1
        // hovatenLabel
        hovatenLabel = new JLabel();
        hovatenLabel.setText("Họ và tên:");

        hovatenLabel.setBounds(20, 50, 80, 16);

        // ngaysinhLabel
        ngaysinhLabel = new JLabel();
        ngaysinhLabel.setText("Ngày sinh:");

        ngaysinhLabel.setBounds(20, 90, 80, 16);

        // diachiLabel
        diachiLabel = new JLabel();
        diachiLabel.setText("Địa chỉ:");

        diachiLabel.setBounds(20, 130, 80, 16);

        // emailLabel
        emailLabel = new JLabel();
        emailLabel.setText("Email:");

        emailLabel.setBounds(20, 170, 80, 16);
        // sodienthoaiLabel
        sodienthoaiLabel = new JLabel();
        sodienthoaiLabel.setText("Số điện thoại:");
        sodienthoaiLabel.setBounds(20, 210, 80, 16);

        // matkhauLabel
        matkhauLabel = new JLabel();
        matkhauLabel.setText("Mật khẩu:");

        matkhauLabel.setBounds(20, 260, 80, 16);

        // doimatkhauLabel
        doimatkhauLabel = new JLabel();
        doimatkhauLabel.setText("Đổi mật khẩu");

        doimatkhauLabel.setBounds(20, 300, 80, 16);

        // hovatenField
        hovatenField = new JTextField();

        hovatenField.setBounds(110, 40, 160, 30);

        // ngaysinhField
        ngaysinhField = new JTextField();

        ngaysinhField.setBounds(110, 80, 160, 30);

        // diachiField
        diachiField = new JTextField();

        diachiField.setBounds(110, 120, 160, 30);

        // emailField
        emailField = new JTextField();

        emailField.setBounds(110, 160, 160, 30);

        // sodienthoaiField
        sodienthoaiField = new JTextField();

        sodienthoaiField.setBounds(110, 200, 160, 30);

        // namRadioButton
        namRadioButton = new JRadioButton();
        namRadioButton.setText("Nam");
        namRadioButton.setBounds(90, 230, 60, 21);
        namRadioButton.setBackground(getForeground());
        namRadioButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onNamRadio(e);
            }
        });

        // nuRadioButton
        nuRadioButton = new JRadioButton();
        nuRadioButton.setText("Nữ");
        nuRadioButton.setBounds(170, 230, 60, 21);
        nuRadioButton.setBackground(getForeground());
        nuRadioButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onNuRadio(e);
            }
        });
        // matkhauField
        matkhauField = new JPasswordField();

        matkhauField.setBounds(110, 250, 160, 30);

        // doimatkhauField
        doimatkhauField = new JPasswordField();

        doimatkhauField.setBounds(110, 290, 160, 30);

        // dangkyButton
        dangkyButton = new JButton();
        dangkyButton.setBackground(new Color(51, 255, 153));
        dangkyButton.setFont(new Font("Segoe UI", 1, 12));
        dangkyButton.setText("Đăng ký");

        dangkyButton.setBounds(100, 343, 80, 30);

        // panel1
        panel1 = new JPanel();

        panel1.setBounds(10, 60, 290, 410);
        panel1.setBackground(new Color(255, 204, 204));
        panel1.setLayout(null);
        panel1.add(hovatenLabel);
        panel1.add(ngaysinhLabel);
        panel1.add(diachiLabel);
        panel1.add(sodienthoaiLabel);
        panel1.add(emailLabel);
        panel1.add(matkhauLabel);
        panel1.add(doimatkhauLabel);
        panel1.add(hovatenField);
        panel1.add(ngaysinhField);
        panel1.add(diachiField);
        panel1.add(emailField);
        panel1.add(sodienthoaiField);
        panel1.add(namRadioButton);
        panel1.add(nuRadioButton);
        panel1.add(matkhauField);
        panel1.add(doimatkhauField);
        panel1.add(dangkyButton);

        // 2
        // titleDiemField
        titleDiemField = new JTextField();
        titleDiemField.setEditable(false);
        titleDiemField.setFont(new Font("Segoe UI", 1, 14));
        titleDiemField.setHorizontalAlignment(JTextField.CENTER);
        titleDiemField.setText("Điểm");

        titleDiemField.setBounds(30, 40, 450, 26);

        // namhocLabel
        namhocLabel = new JLabel();
        namhocLabel.setText("Năm học:");

        namhocLabel.setBounds(240, 10, 60, 20);

        // namhocComboBox
        namhocComboBox = new JComboBox<>();
        namhocComboBox.setModel(new DefaultComboBoxModel<>(
                new String[] { "2022-2023", "2023-2024", "2024-2025", "2025-2026" }));

        namhocComboBox.setBounds(300, 10, 100, 22);

        // exportcsvButton
        exportcsvButton = new JButton();
        exportcsvButton.setBackground(new Color(102, 102, 102));
        exportcsvButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        exportcsvButton.setForeground(new Color(255, 255, 255));
        exportcsvButton.setText("Export csv");
        exportcsvButton.setBorder(BorderFactory.createTitledBorder(""));

        exportcsvButton.setBounds(410, 5, 70, 30);

        // diemTable
        String[] columnName = {};
        tableModel = new DefaultTableModel(columnName, 0);
        diemTable = new JTable(tableModel);
        Object[] row = {};

        // diemScrollPane
        diemScrollPane = new JScrollPane();
        diemScrollPane.setViewportView(diemTable);

        diemScrollPane.setBounds(30, 60, 450, 330);

        // panel2

        panel2 = new JPanel();
        panel2.setBackground(new java.awt.Color(204, 204, 204));
        panel2.setLayout(null);
        panel2.add(titleDiemField);
        panel2.add(namhocLabel);
        panel2.add(namhocComboBox);
        panel2.add(exportcsvButton);
        panel2.add(diemScrollPane);
        panel2.setBounds(310, 60, 500, 410);

        // titleMainLabel
        titleMainLabel = new JLabel();
        titleMainLabel.setFont(new Font("Segoe UI", 1, 24));
        titleMainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleMainLabel.setText("QUẢN LÝ HỒ SƠ");
        titleMainLabel.setBounds(240, 20, 350, 32);

        // dangxuatButton
        dangxuatButton = new JButton();
        dangxuatButton.setBackground(new Color(255, 102, 102));
        dangxuatButton.setFont(new Font("Segoe UI", 3, 12));
        dangxuatButton.setForeground(new Color(255, 255, 255));
        dangxuatButton.setText("Đăng xuất");
        dangxuatButton.setBorder(BorderFactory.createTitledBorder(""));
        dangxuatButton.setBounds(715, 30, 90, 30);

        // mainPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(titleMainLabel);
        mainPanel.add(dangxuatButton);

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.setBounds(0, 0, 840, 480);
        getContentPane().add(mainPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(840,520);
        setPreferredSize(getSize());
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }

    public void addLogoutListener(ActionListener listener){
        dangxuatButton.addActionListener(listener);
    }

    public void onNamRadio(ActionEvent e){
        if (namRadioButton.isSelected() && nuRadioButton.isSelected()){
            nuRadioButton.setSelected(false);
        }
    }

    public void onNuRadio(ActionEvent e){
        if (namRadioButton.isSelected() && nuRadioButton.isSelected()){
            namRadioButton.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new SinhVienQuanLy().setVisible(true);;
    }
}
