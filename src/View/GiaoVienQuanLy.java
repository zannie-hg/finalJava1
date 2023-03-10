package View;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class GiaoVienQuanLy extends JFrame {
    private JRadioButton femaleRadioBtn;
    private JRadioButton maleRadioBtn;
    private JLabel helloLabel;
    private JButton xoaDiemButton;
    private JButton dangxuatButton;
    private JTextField diachiHoSoField;
    private JLabel diachiHoSoLabel;
    private JTable diemTable;
    private JTextField diembaitapField;
    private JLabel diembaitapLabel;
    private JTextField diemcuoikyField;
    private JLabel diemcuoikyLabel;
    private JTextField diemgiuakyField;
    private JLabel diemgiuakyLabel;
    private JTextField emailHoSoField;
    private JLabel emailHoSoLabel;
    private JButton exportcsvDiemButton;
    private JButton exportcsvHoSoButton;
    private JTextField hoDiemField;
    private JTextField hoHoSoField;
    private JLabel hoHoSoLabel;
    private JLabel hoDiemLabel;
    private JLabel namhocLabel;
    private JComboBox namhocComboBox;
    private JLabel monhocLabel;
    private JComboBox monhocComboBox;
    private JTable hoSoTable;
    private JTextField idDiemField;
    private JTextField idHoSoField;
    private JLabel idHoSoLabel;
    private JLabel idDiemLabel;
    private JScrollPane diemScrollPane;
    private JScrollPane hosoScrollPane;
    private JPanel mainPanel;
    private JTextField ngaysinhHoSoField;
    private JLabel ngaysinhHoSoLabel;
    private JPanel quanDiemPanel;
    private JPanel quanLyDiemPanel;
    private JPanel quanLyHoSoPanel;
    private JButton themHoSoButton;
    private JButton suaHoSoButton;
    private JButton suaDiemButton;
    private JTabbedPane tabPanel;
    private JTextField tenDiemField;
    private JTextField tenHoSoField;
    private JLabel tenHoSoLabel;
    private JLabel tenDiemLabel;
    private JButton refreshDiemButton;
    private JTextField timkiemDiemField;
    private JTextField timkiemHoSoField;
    private JTextField titleDiemField;
    private JTextField titleHosoField;
    private JLabel titleMainLabel;
    private JTextField genderField;
    private JLabel genderHoSoLabel;
    private JButton xoaHoSoButton;
    private DefaultTableModel tableModelDiem, tableModelHoSo;
    private DefaultComboBoxModel<String> namhocModel, monhocModel;
    private String username;

    public GiaoVienQuanLy(String username) {
        this.username = username;
        initComponents();
    }

    public void initComponents() {
        // diem
        // titleDiemField

        // titleHosoField
        titleDiemField = new JTextField();
        titleDiemField.setEditable(false);
        titleDiemField.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        titleDiemField.setHorizontalAlignment(JTextField.CENTER);
        titleDiemField.setText("??i???m");
        titleDiemField.setBorder(null);
        titleDiemField.setBounds(10, 40, 760, 20);

        // timkiemDiemField
        timkiemDiemField = new JTextField();
        timkiemDiemField.setBackground(new Color(204, 255, 255));
        timkiemDiemField.setFont(new Font("Segoe UI", 2, 12)); // NOI18N
        timkiemDiemField.setHorizontalAlignment(JTextField.CENTER);
        timkiemDiemField.setToolTipText("T??m ki???m");


        timkiemDiemField.setBounds(600, 5, 170, 30);

        // idDiemField
        idDiemField = new JTextField();
        idDiemField.setHorizontalAlignment(JTextField.CENTER);

        idDiemField.setBounds(610, 70, 170, 30);

        // hoDiemField
        hoDiemField = new JTextField();
        hoDiemField.setHorizontalAlignment(JTextField.CENTER);

        hoDiemField.setBounds(610, 120, 170, 30);

        // tenDiemField
        tenDiemField = new JTextField();
        tenDiemField.setHorizontalAlignment(JTextField.CENTER);

        tenDiemField.setBounds(610, 170, 170, 30);

        // diembaitapField
        diembaitapField = new JTextField();
        diembaitapField.setHorizontalAlignment(JTextField.CENTER);

        diembaitapField.setBounds(610, 220, 170, 30);

        // diemgiuakyField
        diemgiuakyField = new JTextField();
        diemgiuakyField.setHorizontalAlignment(JTextField.CENTER);

        diemgiuakyField.setBounds(610, 270, 170, 30);

        // diemcuoikyField
        diemcuoikyField = new JTextField();
        diemcuoikyField.setHorizontalAlignment(JTextField.CENTER);

        diemcuoikyField.setBounds(610, 320, 170, 30);

        // themDiemButton
        refreshDiemButton = new JButton();
        refreshDiemButton.setBackground(new Color(52, 235, 95));
        refreshDiemButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        refreshDiemButton.setForeground(new Color(255, 255, 255));
        refreshDiemButton.setText("H???y");

        refreshDiemButton.setBounds(550, 360, 70, 30);
        refreshDiemButton.setFocusable(false);

        // suaDiemButton
        suaDiemButton = new JButton();
        suaDiemButton.setBackground(new Color(52, 235, 95));
        suaDiemButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        suaDiemButton.setForeground(new Color(255, 255, 255));
        suaDiemButton.setText("S???a");

        suaDiemButton.setBounds(630, 360, 70, 30);
        suaDiemButton.setFocusable(false);

        // xoaDiemButton
        xoaDiemButton = new JButton();
        xoaDiemButton.setBackground(new Color(52, 235, 95));
        xoaDiemButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        xoaDiemButton.setForeground(new Color(255, 255, 255));
        xoaDiemButton.setText("X??a");

        xoaDiemButton.setBounds(710, 360, 70, 30);
        xoaDiemButton.setFocusable(false);

        // namhoLabel
        namhocLabel = new JLabel("N??m h???c:");
        namhocLabel.setBounds(10, 10, 60, 20);

        // namhocComboBox
        namhocComboBox = new JComboBox<>();
        namhocModel = new DefaultComboBoxModel<>();

        namhocComboBox.setModel(namhocModel);

        namhocComboBox.setBounds(70, 10, 100, 22);

        // monhocLabel
        monhocLabel = new JLabel("M??n h???c:");
        monhocLabel.setBounds(200, 10, 60, 20);

        // monhocComboBox
        monhocComboBox = new JComboBox<>();
        monhocModel = new DefaultComboBoxModel<>();
        monhocComboBox.setModel(monhocModel);

        monhocComboBox.setBounds(260, 10, 100, 22);

        // diemTable
        String[] columnNameDiem = { "M?? ??i???m", "H???", "T??n", "??i???m b??i t???p", "Gi???a k???", "Cu???i k???", "M??n h???c", "N??m h???c" };
        tableModelDiem = new DefaultTableModel(columnNameDiem, 0) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        diemTable = new JTable(tableModelDiem);
        // set editable column
        diemTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(idDiemField));

        // diemScrollPane
        diemScrollPane = new JScrollPane();
        diemScrollPane.setViewportView(diemTable);

        diemScrollPane.setBounds(10, 60, 760, 290);

        // exportcsvDiemButton
        exportcsvDiemButton = new JButton();
        exportcsvDiemButton.setBackground(new Color(102, 102, 102));
        exportcsvDiemButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        exportcsvDiemButton.setForeground(new Color(255, 255, 255));
        exportcsvDiemButton.setText("Export csv");
        exportcsvDiemButton.setBorder(BorderFactory.createTitledBorder(""));

        exportcsvDiemButton.setBounds(10, 360, 100, 30);
        exportcsvDiemButton.setFocusable(false);

        // idDiemLabel
        idDiemLabel = new JLabel();
        idDiemLabel.setText("ID:");

        idDiemLabel.setBounds(610, 50, 40, 20);

        // hoDiemLabel
        hoDiemLabel = new JLabel();
        hoDiemLabel.setText("H???");

        hoDiemLabel.setBounds(610, 100, 30, 20);

        // tenDiemLabel
        tenDiemLabel = new JLabel();
        tenDiemLabel.setText("T??n:");

        tenDiemLabel.setBounds(610, 150, 37, 20);

        // diembaitapLabel
        diembaitapLabel = new JLabel();
        diembaitapLabel.setText("??i???m b??i t???p:");

        diembaitapLabel.setBounds(610, 200, 80, 20);

        // diemgiuakyLabel
        diemgiuakyLabel = new JLabel();
        diemgiuakyLabel.setText("??i???m gi???a k???:");

        diemgiuakyLabel.setBounds(610, 250, 80, 20);

        // diemcuoikyLabel
        diemcuoikyLabel = new JLabel();
        diemcuoikyLabel.setText("??i???m cu???i k???:");
        diemcuoikyLabel.setBounds(610, 300, 80, 20);

        // quanLyDiemPanel
        quanLyDiemPanel = new JPanel();
        quanLyDiemPanel.setLayout(null);
        quanLyDiemPanel.setBackground(new Color(252, 202, 207));
        quanLyDiemPanel.add(titleDiemField);
        quanLyDiemPanel.add(timkiemDiemField);
        // quanLyDiemPanel.add(idDiemField);
        // quanLyDiemPanel.add(hoDiemField);
        // quanLyDiemPanel.add(tenDiemField);
        // quanLyDiemPanel.add(diembaitapField);
        // quanLyDiemPanel.add(diemgiuakyField);
        // quanLyDiemPanel.add(diemcuoikyField);
        quanLyDiemPanel.add(refreshDiemButton);
        quanLyDiemPanel.add(suaDiemButton);
        quanLyDiemPanel.add(xoaDiemButton);
        quanLyDiemPanel.add(diemScrollPane);
        quanLyDiemPanel.add(exportcsvDiemButton);
        // quanLyDiemPanel.add(idDiemLabel);
        // quanLyDiemPanel.add(hoDiemLabel);
        // quanLyDiemPanel.add(tenDiemLabel);
        // quanLyDiemPanel.add(diembaitapLabel);
        // quanLyDiemPanel.add(diemgiuakyLabel);
        // quanLyDiemPanel.add(diemcuoikyLabel);
        quanLyDiemPanel.add(namhocLabel);
        quanLyDiemPanel.add(namhocComboBox);
        quanLyDiemPanel.add(monhocLabel);
        quanLyDiemPanel.add(monhocComboBox);

        // hoso
        // titleHosoField
        titleHosoField = new JTextField();
        titleHosoField.setEditable(false);
        titleHosoField.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        titleHosoField.setHorizontalAlignment(JTextField.CENTER);
        titleHosoField.setText("H??? S??");
        titleHosoField.setBorder(null);
        titleHosoField.setBounds(10, 10, 580, 20);

        // timkiemHoSoField
        timkiemHoSoField = new JTextField();
        timkiemHoSoField.setBackground(new Color(204, 255, 255));
        timkiemHoSoField.setFont(new Font("Segoe UI", 2, 12)); // NOI18N
        timkiemHoSoField.setHorizontalAlignment(JTextField.CENTER);
        timkiemHoSoField.setToolTipText("T??m ki???m");

        timkiemHoSoField.setBounds(610, 10, 170, 30);

        // idHoSoField
        idHoSoField = new JTextField();
        idHoSoField.setHorizontalAlignment(JTextField.CENTER);
        idHoSoField.setEditable(false);
        idHoSoField.setBounds(610, 60, 170, 22);

        // hoHoSoField
        hoHoSoField = new JTextField();
        hoHoSoField.setHorizontalAlignment(JTextField.CENTER);

        hoHoSoField.setBounds(610, 100, 170, 20);
        // tenHoSoField
        tenHoSoField = new JTextField();
        tenHoSoField.setHorizontalAlignment(JTextField.CENTER);

        tenHoSoField.setBounds(610, 140, 170, 20);

        // ngaysinhHoSoField
        ngaysinhHoSoField = new JTextField();
        ngaysinhHoSoField.setHorizontalAlignment(JTextField.CENTER);

        ngaysinhHoSoField.setBounds(610, 180, 170, 20);

        // diachiHoSoField
        diachiHoSoField = new JTextField();
        diachiHoSoField.setHorizontalAlignment(JTextField.CENTER);

        diachiHoSoField.setBounds(610, 220, 170, 20);
        // emailHoSoField
        emailHoSoField = new JTextField();
        emailHoSoField.setHorizontalAlignment(JTextField.CENTER);
        emailHoSoField.setBounds(610, 300, 170, 20);

        // gender radio button
        femaleRadioBtn = new JRadioButton();
        femaleRadioBtn.setBounds(720, 260, 98, 21);
        femaleRadioBtn.setText("N???");
        femaleRadioBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                femaleRadioBtnActionPerformed(evt);
            }
        });

        maleRadioBtn = new JRadioButton();
        maleRadioBtn.setBounds(610, 260, 90, 21);
        maleRadioBtn.setText("Nam");
        maleRadioBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                maleRadioBtnActionPerformed(evt);
            }
        });

        // gioitinhHoSoField
        genderField = new JTextField();
        genderField.setHorizontalAlignment(JTextField.CENTER);

        genderField.setBounds(610, 260, 170, 20);

        // themHoSoButton
        themHoSoButton = new JButton();
        themHoSoButton.setBackground(new Color(52, 235, 95));
        themHoSoButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        themHoSoButton.setForeground(new Color(255, 255, 255));
        themHoSoButton.setText("Th??m");
        themHoSoButton.setBounds(550, 360, 70, 30);
        themHoSoButton.setFocusable(false);

        // suaHoSoButton
        suaHoSoButton = new JButton();
        suaHoSoButton.setBackground(new Color(52, 235, 95));
        suaHoSoButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        suaHoSoButton.setForeground(new Color(255, 255, 255));
        suaHoSoButton.setText("S???a");

        suaHoSoButton.setBounds(630, 360, 70, 30);
        suaHoSoButton.setFocusable(false);

        // xoaHoSoButton
        xoaHoSoButton = new JButton();
        xoaHoSoButton.setBackground(new Color(52, 235, 95));
        xoaHoSoButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        xoaHoSoButton.setForeground(new Color(255, 255, 255));
        xoaHoSoButton.setText("X??a");

        xoaHoSoButton.setBounds(710, 360, 70, 30);
        xoaHoSoButton.setFocusable(false);

        // hoSoTable
        String[] columnNameHoSo = { "ID", "H???", "T??n", "Ng??y sinh", "?????a ch???", "Gi???i t??nh", "Email" };
        tableModelHoSo = new DefaultTableModel(columnNameHoSo, 0);
        hoSoTable = new JTable(tableModelHoSo);
        hoSoTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onHoSoClicked(evt);
            }
        });
        // hosoScrollPane
        hosoScrollPane = new JScrollPane();
        hosoScrollPane.setViewportView(hoSoTable);

        hosoScrollPane.setBounds(10, 30, 580, 310);

        // exportcsvHoSoButton
        exportcsvHoSoButton = new JButton();
        exportcsvHoSoButton.setBackground(new Color(102, 102, 102));
        exportcsvHoSoButton.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        exportcsvHoSoButton.setForeground(new Color(255, 255, 255));
        exportcsvHoSoButton.setText("Export csv");
        exportcsvHoSoButton.setBorder(BorderFactory.createTitledBorder(""));
        exportcsvHoSoButton.setBounds(10, 350, 100, 30);
        exportcsvHoSoButton.setFocusable(false);

        // idHoSoLabel
        idHoSoLabel = new JLabel();
        idHoSoLabel.setText("ID:");
        idHoSoLabel.setBounds(610, 40, 40, 20);

        // hoHoSoLabel
        hoHoSoLabel = new JLabel();
        hoHoSoLabel.setText("H???");
        hoHoSoLabel.setBounds(610, 80, 30, 20);

        // tenHoSoLabel
        tenHoSoLabel = new JLabel();
        tenHoSoLabel.setText("T??n:");
        tenHoSoLabel.setBounds(610, 120, 37, 20);

        // ngaysinhHoSoLabel
        ngaysinhHoSoLabel = new JLabel();
        ngaysinhHoSoLabel.setText("Ng??y sinh:");
        ngaysinhHoSoLabel.setBounds(610, 160, 60, 16);

        // diachiHoSoLabel
        diachiHoSoLabel = new JLabel();
        diachiHoSoLabel.setText("?????a ch???:");
        diachiHoSoLabel.setBounds(610, 200, 50, 16);

        // gioitinhHoSoLabel
        genderHoSoLabel = new JLabel();
        genderHoSoLabel.setText("Gi???i t??nh:");
        genderHoSoLabel.setBounds(610, 240, 80, 16);

        // emailHoSoLabel
        emailHoSoLabel = new JLabel();
        emailHoSoLabel.setText("Email");
        emailHoSoLabel.setBounds(610, 280, 80, 16);

        // quanLyHoSoPanel
        quanLyHoSoPanel = new JPanel();
        quanLyHoSoPanel.setBackground(new Color(252, 202, 207));
        quanLyHoSoPanel.setLayout(null);
        quanLyHoSoPanel.add(titleHosoField);
        quanLyHoSoPanel.add(timkiemHoSoField);
        quanLyHoSoPanel.add(idHoSoField);
        quanLyHoSoPanel.add(hoHoSoField);
        quanLyHoSoPanel.add(tenHoSoField);
        quanLyHoSoPanel.add(ngaysinhHoSoField);
        quanLyHoSoPanel.add(diachiHoSoField);
        // quanLyHoSoPanel.add(genderField);
        quanLyHoSoPanel.add(maleRadioBtn);
        quanLyHoSoPanel.add(femaleRadioBtn);
        quanLyHoSoPanel.add(emailHoSoField);
        // quanLyHoSoPanel.add(themHoSoButton);
        quanLyHoSoPanel.add(suaHoSoButton);
        quanLyHoSoPanel.add(xoaHoSoButton);
        quanLyHoSoPanel.add(hosoScrollPane);
        quanLyHoSoPanel.add(exportcsvHoSoButton);
        quanLyHoSoPanel.add(idHoSoLabel);
        quanLyHoSoPanel.add(hoHoSoLabel);
        quanLyHoSoPanel.add(tenHoSoLabel);
        quanLyHoSoPanel.add(ngaysinhHoSoLabel);
        quanLyHoSoPanel.add(diachiHoSoLabel);
        quanLyHoSoPanel.add(genderHoSoLabel);
        quanLyHoSoPanel.add(emailHoSoLabel);

        // tabPanel
        tabPanel = new JTabbedPane();
        tabPanel.setBackground(new Color(255, 255, 255));

        tabPanel.setBounds(20, 40, 790, 430);
        tabPanel.addTab("Qu???n l?? ??i???m", quanLyDiemPanel);
        tabPanel.addTab("Qu???n l?? h??? s??", quanLyHoSoPanel);

        // helloLabel
        helloLabel = new JLabel("Xin ch??o, " + username);
        helloLabel.setBounds(10, 10, 100, 20);

        // titleMainLabel
        titleMainLabel = new JLabel();
        titleMainLabel.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        titleMainLabel.setForeground(new Color(52, 113, 235));
        titleMainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleMainLabel.setText("QU???N L?? ??I???M V?? H??? S??");

        titleMainLabel.setBounds(230, 10, 340, 32);

        // dangxuatButton
        dangxuatButton = new JButton();
        dangxuatButton.setBackground(new Color(255, 102, 102));
        dangxuatButton.setFont(new Font("Segoe UI", 3, 12)); // NOI18N
        dangxuatButton.setForeground(new Color(255, 255, 255));
        dangxuatButton.setText("????ng xu???t");
        dangxuatButton.setBounds(720, 10, 100, 30);
        dangxuatButton.setFocusable(false);

        // mainPanel
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 840, 480);
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(null);
        mainPanel.add(tabPanel);
        mainPanel.add(helloLabel);
        mainPanel.add(titleMainLabel);
        mainPanel.add(dangxuatButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(mainPanel);
        setSize(840, 520);
        setResizable(false);
        setPreferredSize(getSize());
        setLocationRelativeTo(null);
        pack();

    }

    public void refreshDiemTable(ActionListener actionListener) {
        refreshDiemButton.addActionListener(actionListener);
    }

    public void refreshHoSoTable(ActionListener actionListener) {
        //
    }

    public void addChangeNamHocListener(ActionListener actionListener) {
        namhocComboBox.addActionListener(actionListener);
    }

    public void addChangeMonHocListener(ActionListener actionListener) {
        monhocComboBox.addActionListener(actionListener);
    }

    public void addSuaDiemListener(ActionListener actionListener) {
        suaDiemButton.addActionListener(actionListener);
    }

    public void addXoaDiemListener(ActionListener actionListener) {
        xoaDiemButton.addActionListener(actionListener);
    }

    public void addExportcsvDiemListener(ActionListener actionListener) {
        exportcsvDiemButton.addActionListener(actionListener);
    }
    public void addExportcsvHoSoListener(ActionListener actionListener) {
        exportcsvHoSoButton.addActionListener(actionListener);
    }
    public void addHoSoTableListener(MouseListener mouseListener) {
        hoSoTable.addMouseListener(mouseListener);
    }

    public void addSuaHoSoListener(ActionListener actionListener) {
        suaHoSoButton.addActionListener(actionListener);
    }

    public void addXoaHoSoListener(ActionListener actionListener) {
        xoaHoSoButton.addActionListener(actionListener);
    }

    public void addSearchDiemListener(DocumentListener listener){
        timkiemDiemField.getDocument().addDocumentListener(listener);
    }
    public void addSearchHoSoListener(DocumentListener listener){
        timkiemHoSoField.getDocument().addDocumentListener(listener);
    }
    public DefaultTableModel getTableModelDiem() {
        return tableModelDiem;
    }

    public DefaultTableModel getTableModelHoSo() {
        return tableModelHoSo;
    }

    public DefaultComboBoxModel getNamHocBoxModel() {
        return namhocModel;
    }

    public DefaultComboBoxModel getMonHocBoxModel() {
        return monhocModel;
    }

    public void addLogoutListener(ActionListener actionListener) {
        dangxuatButton.addActionListener(actionListener);
    }

    public JComboBox getNamhocComboBox() {
        return namhocComboBox;
    }

    public JComboBox getMonhocComboBox() {
        return monhocComboBox;
    }

    public JTable getDiemTable() {
        return diemTable;
    }

    public JTable getHoSoTable() {
        return hoSoTable;
    }

    public JTextField getDiachiHoSoField() {
        return diachiHoSoField;
    }

    public JTextField getEmailHoSoField() {
        return emailHoSoField;
    }

    public JTextField getHoHoSoField() {
        return hoHoSoField;
    }

    public JTextField getIdHoSoField() {
        return idHoSoField;
    }

    
    public JTextField getTimkiemDiemField() {
        return timkiemDiemField;
    }
    public JTextField getTimkiemHoSoField() {
        return timkiemHoSoField;
    }
    public JTextField getNgaysinhHoSoField() {
        return ngaysinhHoSoField;
    }

    public JTextField getTenHoSoField() {
        return tenHoSoField;
    }

   

    public int getGenderField() {
        if (femaleRadioBtn.isSelected()) {
            return 0;
        } else if (maleRadioBtn.isSelected()) {
            return 1;
        } else {
            return -1;
        }
    }

    private void setGenderBtn(String gender) {
        if (gender.equals("NULL")) {
            maleRadioBtn.setSelected(false);
            femaleRadioBtn.setSelected(false);
        } else if (gender.equals("Nam")) {
            maleRadioBtn.setSelected(true);
            femaleRadioBtn.setSelected(false);
        } else {
            maleRadioBtn.setSelected(false);
            femaleRadioBtn.setSelected(true);
        }
    }

    private void femaleRadioBtnActionPerformed(ActionEvent evt) {
        if (femaleRadioBtn.isSelected()) {
            setGenderBtn("N???");
        }
    }

    private void maleRadioBtnActionPerformed(ActionEvent evt) {
        if (maleRadioBtn.isSelected()) {
            setGenderBtn("Nam");
        }
    }

    private void onHoSoClicked(MouseEvent evt) {
        int row = hoSoTable.getSelectedRow();
        idHoSoField.setText(hoSoTable.getValueAt(row, 0).toString());
        hoHoSoField.setText(hoSoTable.getValueAt(row, 1).toString());
        tenHoSoField.setText(hoSoTable.getValueAt(row, 2).toString());
        ngaysinhHoSoField.setText(hoSoTable.getValueAt(row, 3).toString());
        diachiHoSoField.setText(hoSoTable.getValueAt(row, 4).toString());
        genderField.setText(hoSoTable.getValueAt(row, 5).toString());
        emailHoSoField.setText(hoSoTable.getValueAt(row, 6).toString());
        if (genderField.getText().equals("NULL")) {
            maleRadioBtn.setSelected(false);
            femaleRadioBtn.setSelected(false);
        } else if (genderField.getText().equals("Nam")) {
            maleRadioBtn.setSelected(true);
            femaleRadioBtn.setSelected(false);
        } else {
            femaleRadioBtn.setSelected(true);
            maleRadioBtn.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new GiaoVienQuanLy("Anonymous").setVisible(true);
        ;
    }
}
