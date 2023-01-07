package View;

import javax.swing.*;
import java.awt.*;

public class GiaoVienQuanLy extends JFrame {
    private JButton xoaDiemButton;
    private JButton dangxuatButton;
    private JTextField diaChiHoSoTextField;
    private JTextField finalTextField;
    private JTable diemTable;
    private JTextField midternTextField;
    private JTextField homeworkTextField;
    private JTextField emailTextField;
    private JButton exportcsvDiemButton;
    private JButton exportcsvHoSoButton;
    private JTextField idDiemTextField;
    private JTextField hoDiemTextField;
    private JTextField hoHoSoTextField;
    private JTable hoSoTable;
    private JTextField idHoSoTextField;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel mainPanel;
    private JTextField ngaysinhTextField;
    private JPanel quanLyDiemPanel;
    private JPanel quanLyHoSoPanel;
    private JPanel quanLyHoSoPanel2;
    private JTextField sodienthoaiTextField;
    private JButton suaHoSoButton;
    private JButton suaDiemButton;
    private JTabbedPane tabPanel;
    private JTextField tenDiemTextField;
    private JTextField tenHoSoTextField;
    private JButton themHoSoButton;
    private JButton themDiemButton;
    private JTextField timkiemDiemTextField;
    private JTextField timkiemHoSoTextField;
    private JTextField titleDiemTextField;
    private JTextField titleHosoTextField;
    private JLabel titleLabel;
    private JButton xoaHoSoButton;

    public GiaoVienQuanLy() {
        initComponents();
    }

    public void initComponents() {
        // titleLabel
        titleLabel = new javax.swing.JLabel();
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(52, 113, 235));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("QUẢN LÝ ĐIỂM VÀ HỒ SƠ");
        mainPanel.add(titleLabel);
        titleLabel.setBounds(230, 10, 340, 32);

        // xoaDiemButton
        xoaDiemButton = new javax.swing.JButton();
        xoaDiemButton.setBackground(new java.awt.Color(52, 235, 95));
        xoaDiemButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        xoaDiemButton.setForeground(new java.awt.Color(255, 255, 255));
        xoaDiemButton.setText("Xóa");
        quanLyHoSoPanel2.add(xoaDiemButton);
        xoaDiemButton.setBounds(710, 360, 70, 30);

        // suaDiemButton
        suaDiemButton = new javax.swing.JButton();
        suaDiemButton.setBackground(new java.awt.Color(52, 235, 95));
        suaDiemButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suaDiemButton.setForeground(new java.awt.Color(255, 255, 255));
        suaDiemButton.setText("Sửa");
        quanLyHoSoPanel2.add(suaDiemButton);
        suaDiemButton.setBounds(630, 360, 70, 30);

        // themDiemButton
        themDiemButton = new javax.swing.JButton();
        themDiemButton.setBackground(new java.awt.Color(52, 235, 95));
        themDiemButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themDiemButton.setForeground(new java.awt.Color(255, 255, 255));
        themDiemButton.setText("Thêm");
        quanLyHoSoPanel2.add(themDiemButton);
        themDiemButton.setBounds(550, 360, 70, 30);
        
        //exportcsvDiemButton
        exportcsvDiemButton = new javax.swing.JButton();
        exportcsvDiemButton.setBackground(new java.awt.Color(102, 102, 102));
        exportcsvDiemButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exportcsvDiemButton.setForeground(new java.awt.Color(255, 255, 255));
        exportcsvDiemButton.setText("Export csv");
        exportcsvDiemButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        quanLyHoSoPanel2.add(exportcsvDiemButton);
        exportcsvDiemButton.setBounds(10, 350, 100, 30);
        
        // idDiemTextField
        idDiemTextField = new javax.swing.JTextField();
        idDiemTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idDiemTextField.setText("ID");
        quanLyHoSoPanel2.add(idDiemTextField);
        idDiemTextField.setBounds(610, 60, 170, 30);

        // hoDiemTextField
        hoDiemTextField = new javax.swing.JTextField();
        hoDiemTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hoDiemTextField.setText("Họ");
        quanLyHoSoPanel2.add(hoDiemTextField);
        hoDiemTextField.setBounds(610, 100, 170, 30);

        // tenDiemTextField
        tenDiemTextField = new javax.swing.JTextField();
        tenDiemTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tenDiemTextField.setText("Tên");
        quanLyHoSoPanel2.add(tenDiemTextField);
        tenDiemTextField.setBounds(610, 140, 170, 30);

        //homeworkTextField
        homeworkTextField = new javax.swing.JTextField();
        homeworkTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        homeworkTextField.setText("Điểm Toán");
        quanLyHoSoPanel2.add(homeworkTextField);
        homeworkTextField.setBounds(610, 220, 170, 30);

        //finalTextField
        
        //idHoSoTextField

        // diaChiHoSoTextField
        diaChiHoSoTextField = new javax.swing.JTextField();
        diaChiHoSoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanLyHoSoPanel.add(diaChiHoSoTextField);
        diaChiHoSoTextField.setBounds(590, 220, 190, 30);

        // 
        mainPanel = new javax.swing.JPanel();
        tabPanel = new javax.swing.JTabbedPane();
        quanLyDiemPanel = new javax.swing.JPanel();
        quanLyHoSoPanel2 = new javax.swing.JPanel();
        titleDiemTextField = new javax.swing.JTextField();
        timkiemDiemTextField = new javax.swing.JTextField();
        midternTextField = new javax.swing.JTextField();
        finalTextField = new javax.swing.JTextField();

        jScrollPane1 = new javax.swing.JScrollPane();
        diemTable = new javax.swing.JTable();
        
        
        quanLyHoSoPanel = new javax.swing.JPanel();
        titleHosoTextField = new javax.swing.JTextField();
        timkiemHoSoTextField = new javax.swing.JTextField();
        hoHoSoTextField = new javax.swing.JTextField();
        tenHoSoTextField = new javax.swing.JTextField();
        idHoSoTextField = new javax.swing.JTextField();
        ngaysinhTextField = new javax.swing.JTextField();
        
        sodienthoaiTextField = new javax.swing.JTextField();
        themHoSoButton = new javax.swing.JButton();
        suaHoSoButton = new javax.swing.JButton();
        emailTextField = new javax.swing.JTextField();
        xoaHoSoButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        hoSoTable = new javax.swing.JTable();
        exportcsvHoSoButton = new javax.swing.JButton();

        dangxuatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(null);

        tabPanel.setBackground(new java.awt.Color(255, 255, 255));

        quanLyDiemPanel.setLayout(null);

        quanLyHoSoPanel2.setBackground(new java.awt.Color(204, 204, 204));
        quanLyHoSoPanel2.setLayout(null);

        titleDiemTextField.setEditable(false);
        titleDiemTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleDiemTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleDiemTextField.setText("Điểm");
        titleDiemTextField.setBorder(null);
        quanLyHoSoPanel2.add(titleDiemTextField);
        titleDiemTextField.setBounds(10, 10, 580, 20);

        timkiemDiemTextField.setBackground(new java.awt.Color(204, 255, 255));
        timkiemDiemTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        timkiemDiemTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timkiemDiemTextField.setText("Tìm kiếm");
        quanLyHoSoPanel2.add(timkiemDiemTextField);
        timkiemDiemTextField.setBounds(610, 10, 170, 40);



        midternTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        midternTextField.setText("Điểm Văn");
        quanLyHoSoPanel2.add(midternTextField);
        midternTextField.setBounds(610, 180, 170, 30);


        finalTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalTextField.setText("Điểm Anh");
        quanLyHoSoPanel2.add(finalTextField);
        finalTextField.setBounds(610, 260, 170, 30);

        diemTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {

                }));
        jScrollPane1.setViewportView(diemTable);

        quanLyHoSoPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 580, 310);

        
        
        
        
        
        
        

        
        
        
        

        quanLyDiemPanel.add(quanLyHoSoPanel2);
        quanLyHoSoPanel2.setBounds(0, 0, 790, 399);

        tabPanel.addTab("Quản lý điểm", quanLyDiemPanel);

        quanLyHoSoPanel.setBackground(new java.awt.Color(204, 204, 204));
        quanLyHoSoPanel.setLayout(null);

        titleHosoTextField.setEditable(false);
        titleHosoTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleHosoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleHosoTextField.setText("Hồ Sơ");
        titleHosoTextField.setBorder(null);
        quanLyHoSoPanel.add(titleHosoTextField);
        titleHosoTextField.setBounds(10, 10, 570, 20);

        timkiemHoSoTextField.setBackground(new java.awt.Color(204, 255, 255));
        timkiemHoSoTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        timkiemHoSoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timkiemHoSoTextField.setText("Tìm kiếm");
        quanLyHoSoPanel.add(timkiemHoSoTextField);
        timkiemHoSoTextField.setBounds(590, 10, 190, 40);

        hoHoSoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanLyHoSoPanel.add(hoHoSoTextField);
        hoHoSoTextField.setBounds(590, 100, 190, 30);

        tenHoSoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanLyHoSoPanel.add(tenHoSoTextField);
        tenHoSoTextField.setBounds(590, 140, 190, 30);

        idHoSoTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        idHoSoTextField.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        idHoSoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idHoSoTextFieldKeyTyped(evt);
            }
        });
        quanLyHoSoPanel.add(idHoSoTextField);
        idHoSoTextField.setBounds(590, 60, 190, 30);

        ngaysinhTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanLyHoSoPanel.add(ngaysinhTextField);
        ngaysinhTextField.setBounds(590, 180, 190, 30);

        
        
        

        sodienthoaiTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanLyHoSoPanel.add(sodienthoaiTextField);
        sodienthoaiTextField.setBounds(590, 260, 190, 30);

        themHoSoButton.setBackground(new java.awt.Color(52, 235, 95));
        themHoSoButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themHoSoButton.setForeground(new java.awt.Color(255, 255, 255));
        themHoSoButton.setText("Thêm");
        quanLyHoSoPanel.add(themHoSoButton);
        themHoSoButton.setBounds(550, 360, 70, 30);

        suaHoSoButton.setBackground(new java.awt.Color(52, 235, 95));
        suaHoSoButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suaHoSoButton.setForeground(new java.awt.Color(255, 255, 255));
        suaHoSoButton.setText("Sửa");
        quanLyHoSoPanel.add(suaHoSoButton);
        suaHoSoButton.setBounds(630, 360, 70, 30);

        emailTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quanLyHoSoPanel.add(emailTextField);
        emailTextField.setBounds(590, 300, 190, 30);

        xoaHoSoButton.setBackground(new java.awt.Color(52, 235, 95));
        xoaHoSoButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        xoaHoSoButton.setForeground(new java.awt.Color(255, 255, 255));
        xoaHoSoButton.setText("Xóa");
        quanLyHoSoPanel.add(xoaHoSoButton);
        xoaHoSoButton.setBounds(710, 360, 70, 30);

        hoSoTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String[] {

                }));
        jScrollPane2.setViewportView(hoSoTable);

        quanLyHoSoPanel.add(jScrollPane2);
        jScrollPane2.setBounds(10, 30, 570, 310);

        exportcsvHoSoButton.setBackground(new java.awt.Color(102, 102, 102));
        exportcsvHoSoButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exportcsvHoSoButton.setForeground(new java.awt.Color(255, 255, 255));
        exportcsvHoSoButton.setText("Export csv");
        exportcsvHoSoButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        quanLyHoSoPanel.add(exportcsvHoSoButton);
        exportcsvHoSoButton.setBounds(10, 350, 100, 30);

        tabPanel.addTab("Quản lý hồ sơ", quanLyHoSoPanel);

        mainPanel.add(tabPanel);
        tabPanel.setBounds(20, 40, 790, 430);

        dangxuatButton.setBackground(new java.awt.Color(255, 102, 102));
        dangxuatButton.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dangxuatButton.setForeground(new java.awt.Color(255, 255, 255));
        dangxuatButton.setText("Đăng xuất");
        mainPanel.add(dangxuatButton);
        dangxuatButton.setBounds(720, 10, 90, 30);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 840, 480);

        pack();
    }
}