package View;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

import com.toedter.calendar.JDateChooser;
public class SinhVienQuanLy extends JFrame {
    private DefaultTableModel myClassTableModel;
    private DefaultTableModel markTableModel;
    private DefaultComboBoxModel<String> namHoComboBoxModel;
    private DefaultComboBoxModel<String> monhocComboBoxModel;
    private JDateChooser birthdayCalendar;
    private JButton addClassBtn;
    private JButton changePassBtn;
    private JButton exportCSVBtn;
    private JButton logoutBtn;
    private JButton removeClassBtn;
    private JButton updateProfileBtn;
    private JComboBox<String> chooseClassComboBox;
    private JComboBox<String> namhocComboBox;
    private JLabel addressLabel;
    private JLabel birthdayLabel;
    private JLabel chooseClassLabel1;
    private JLabel confirmPassLabel;
    private JLabel currentPassLabel;
    private JLabel emaillabel;
    private JLabel firstNameLabel;
    private JLabel genderLabel;
    private JLabel lastNameLabel;
    private JLabel myClassTitle;
    private JLabel namhocLabel;
    private JLabel newPassLabel;
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JPanel myClassPanel;
    private JPanel profilePanel;
    private JPasswordField confirmPassField;
    private JPasswordField currentPassField;
    private JPasswordField newPassField;
    private JRadioButton femaleRadioBtn;
    private JRadioButton maleRadioBtn;
    private JScrollPane myClassScrollPane;
    private JTabbedPane mainTabbedPanel;
    private JTable markTable;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField firstNameField;
    private JTextField lastNameField;

    public SinhVienQuanLy() {
        initComponents();
    }

    public void initComponents() {

        /*-----------------------MARK PANEL----------------------------- */

        // exportCSV
        exportCSVBtn = new JButton();
        exportCSVBtn.setBackground(new Color(134, 134, 134));
        exportCSVBtn.setBounds(10, 10, 120, 23);
        exportCSVBtn.setForeground(new Color(255, 255, 255));
        exportCSVBtn.setText("Export CSV");

        // namhoc combobox
        namhocComboBox = new JComboBox<>();
        namhocComboBox.setBounds(650, 10, 120, 22);
        namHoComboBoxModel = new DefaultComboBoxModel<>();
        namhocComboBox.setModel(namHoComboBoxModel);

        // namhoc label
        namhocLabel = new JLabel();
        namhocLabel.setBounds(570, 10, 70, 20);
        namhocLabel.setLabelFor(namhocComboBox);
        namhocLabel.setText("Năm học:");
        namhocLabel.setToolTipText("");

        // mark table
        markTable = new JTable();
        String[] markColums = {"ID","Môn học", "Điểm bài tập", "Điểm giữa kỳ", "Điểm cuối kỳ", "Tổng"};
        markTableModel = new DefaultTableModel(markColums, 0){
            boolean[] canEdit = new boolean[] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columIndex){
                return canEdit[columIndex];
            }
        };
        markTable.setModel(markTableModel);

        // add class button
        addClassBtn = new JButton();
        addClassBtn.setBackground(new Color(120, 208, 255));
        addClassBtn.setBounds(610, 290, 150, 40);
        addClassBtn.setText("Đăng ký");

        // remove class button
        removeClassBtn = new JButton();
        removeClassBtn.setBackground(new Color(255, 127, 120));
        removeClassBtn.setBounds(610, 340, 150, 40);
        removeClassBtn.setText("Nghỉ học");

        // choose class combobox
        monhocComboBoxModel = new DefaultComboBoxModel<>();
        chooseClassComboBox = new JComboBox<>();
        chooseClassComboBox.setBounds(610, 230, 150, 40);
        chooseClassComboBox.setModel(monhocComboBoxModel);

        // choose class label
        chooseClassLabel1 = new JLabel();
        chooseClassLabel1.setBounds(610, 210, 80, 16);
        chooseClassLabel1.setText("Chọn lớp :");

        // my class title
        myClassTitle = new JLabel();
        myClassTitle.setBounds(210, 10, 180, 30);
        myClassTitle.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        myClassTitle.setText("Các lớp đã đăng ký");


        // my class scroll pane
        myClassScrollPane = new JScrollPane();
        myClassScrollPane.setBounds(20, 50, 560, 330);
        myClassScrollPane.setViewportView(markTable);

        // my class panel
        myClassPanel = new JPanel();
        myClassPanel.add(addClassBtn);
        myClassPanel.add(chooseClassComboBox);
        myClassPanel.add(chooseClassLabel1);
        myClassPanel.add(myClassScrollPane);
        myClassPanel.add(myClassTitle);
        myClassPanel.add(removeClassBtn);
        myClassPanel.add(namhocComboBox);
        myClassPanel.add(namhocLabel);
        myClassPanel.setLayout(null);

        /*-----------------------PROFILE PANEL----------------------------- */

        // address field label
        addressField = new JTextField();
        addressField.setBounds(20, 170, 340, 40);
        addressLabel = new JLabel();
        addressLabel.setBounds(20, 150, 130, 20);
        addressLabel.setText("Địa chỉ");

        // birthday field label
        birthdayCalendar = new JDateChooser();
        birthdayCalendar.setBounds(20, 300, 340, 40);
        birthdayCalendar.setDateFormatString("yyyy-MM-dd");
        birthdayLabel = new JLabel();
        birthdayLabel.setBounds(20, 280, 130, 20);
        birthdayLabel.setText("Ngày sinh:");
        // email field label
        emailField = new JTextField();
        emailField.setBounds(20, 100, 340, 40);
        emaillabel = new JLabel();
        emaillabel.setBounds(20, 80, 130, 20);
        emaillabel.setText("Email");

        // lastname field label
        lastNameField = new JTextField();
        lastNameField.setBounds(20, 30, 160, 40);
        lastNameLabel = new JLabel();
        lastNameLabel.setBounds(20, 10, 19, 20);
        lastNameLabel.setText("Họ:");

        // firstname field label
        firstNameField = new JTextField();
        firstNameField.setBounds(200, 30, 160, 40);
        firstNameLabel = new JLabel();
        firstNameLabel.setBounds(200, 10, 60, 20);
        firstNameLabel.setText("Tên:");

        // gender label
        genderLabel = new JLabel();
        genderLabel.setBounds(20, 220, 130, 20);
        genderLabel.setText("Giới tính");

        // gender radio button
        femaleRadioBtn = new JRadioButton();
        femaleRadioBtn.setBounds(150, 250, 98, 21);
        femaleRadioBtn.setText("Nữ");
        femaleRadioBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                femaleRadioBtnActionPerformed(e);
                
            }

        });
        maleRadioBtn = new JRadioButton();
        maleRadioBtn.setBounds(40, 250, 90, 21);
        maleRadioBtn.setText("Nam");
        maleRadioBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                maleRadioBtnActionPerformed(e);
                
            }

        });
        // current password field label
        currentPassField = new JPasswordField();
        currentPassField.setBounds(460, 30, 290, 40);
        currentPassLabel = new JLabel();
        currentPassLabel.setBounds(460, 10, 190, 20);
        currentPassLabel.setText("Mật khẩu hiện tại:");

        // new password field label
        newPassField = new JPasswordField();
        newPassField.setBounds(460, 100, 290, 40);
        newPassLabel = new JLabel();
        newPassLabel.setBounds(460, 80, 190, 20);
        newPassLabel.setText("Mật khẩu mới");

        // confirm password field label
        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(460, 170, 290, 40);
        confirmPassLabel = new JLabel();
        confirmPassLabel.setBounds(460, 150, 190, 20);
        confirmPassLabel.setText("Nhập lại mật khẩu:");

        // update profile button
        updateProfileBtn = new JButton();
        updateProfileBtn.setBackground(new Color(52, 235, 95));
        updateProfileBtn.setBounds(210, 360, 150, 30);
        updateProfileBtn.setText("Cập nhật tài khoản");

        // change password button
        changePassBtn = new JButton();
        changePassBtn.setBackground(new Color(66, 135, 245));
        changePassBtn.setBounds(620, 220, 130, 23);
        changePassBtn.setText("Đổi mật khẩu");

        // profile panel
        profilePanel = new JPanel();
        profilePanel.add(addressField);
        profilePanel.add(addressLabel);
        profilePanel.add(birthdayCalendar);
        profilePanel.add(birthdayLabel);
        profilePanel.add(changePassBtn);
        profilePanel.add(confirmPassField);
        profilePanel.add(confirmPassLabel);
        profilePanel.add(currentPassField);
        profilePanel.add(currentPassLabel);
        profilePanel.add(emailField);
        profilePanel.add(emaillabel);
        profilePanel.add(femaleRadioBtn);
        profilePanel.add(firstNameField);
        profilePanel.add(firstNameLabel);
        profilePanel.add(genderLabel);
        profilePanel.add(lastNameField);
        profilePanel.add(lastNameLabel);
        profilePanel.add(maleRadioBtn);
        profilePanel.add(newPassField);
        profilePanel.add(newPassLabel);
        profilePanel.add(updateProfileBtn);
        profilePanel.setBackground(new Color(230, 230, 230));
        profilePanel.setLayout(null);
        
        // title label
        titleLabel = new JLabel();
        titleLabel.setBounds(270, 10, 300, 30);
        titleLabel.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setText("Trung tâm đào tạo ABC");

        // logout button
        logoutBtn = new JButton();
        logoutBtn.setBackground(new Color(255, 102, 102));
        logoutBtn.setBounds(690, 20, 100, 30);
        logoutBtn.setText("Đăng xuất");

        // main tabbed panel
        mainTabbedPanel = new JTabbedPane();
        mainTabbedPanel.addTab("Kết quả học tập", myClassPanel);
        // mainTabbedPanel.addTab("Lớp học của tôi", myClassPanel);
        mainTabbedPanel.addTab("Thay đổi lý lịch", profilePanel);
        mainTabbedPanel.setBounds(10, 50, 780, 440);

        // main panel
        mainPanel = new JPanel();
        mainPanel.add(logoutBtn);
        mainPanel.add(mainTabbedPanel);
        mainPanel.add(titleLabel);
        mainPanel.getAccessibleContext().setAccessibleName("");
        mainPanel.setBounds(0, 0, 820, 540);
        mainPanel.setLayout(null);

        getContentPane().add(mainPanel);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(820, 540);
        setPreferredSize(getSize());
        setLocationRelativeTo(null);
        pack();

    }
    // add Listener
    public void addLogoutListener(ActionListener listener){
        logoutBtn.addActionListener(listener);
    }

    public void addNamHocComboBoxListener(ActionListener listener){
        namhocComboBox.addActionListener(listener);
    }

    public void addAddClassListener(ActionListener listener){
        addClassBtn.addActionListener(listener);
    }

    public void addRemoveClassListener(ActionListener listener){
        removeClassBtn.addActionListener(listener);
    }

    public void addUpdateProfileListener(ActionListener listener){
        updateProfileBtn.addActionListener(listener);
    }
    
    public void addChangePassListener(ActionListener listener){
        changePassBtn.addActionListener(listener);
    }
    public void addChangeBirthdayListener(PropertyChangeListener listener) {
        birthdayCalendar.addPropertyChangeListener(listener);
    }

    // Setter getter

    

    public DefaultTableModel getMyClassTableModel() {
        return myClassTableModel;
    }

    public JTable getMarkTable() {
        return markTable;
    }

    public void setMarkTable(JTable markTable) {
        this.markTable = markTable;
    }

    public void setMyClassTableModel(DefaultTableModel myClassTableModel) {
        this.myClassTableModel = myClassTableModel;
    }

    public DefaultTableModel getMarkTableModel() {
        return markTableModel;
    }

    public void setMarkTableModel(DefaultTableModel markTableModel) {
        this.markTableModel = markTableModel;
    }

    public JComboBox<String> getChooseClassComboBox() {
        return chooseClassComboBox;
    }

    public void setChooseClassComboBox(JComboBox<String> chooseClassComboBox) {
        this.chooseClassComboBox = chooseClassComboBox;
    }

    public JComboBox<String> getNamhocComboBox() {
        return namhocComboBox;
    }

    public void setNamhocComboBox(JComboBox<String> namhocComboBox) {
        this.namhocComboBox = namhocComboBox;
    }

    public JPasswordField getConfirmPassField() {
        return confirmPassField;
    }

    public void setConfirmPassField(JPasswordField confirmPassField) {
        this.confirmPassField = confirmPassField;
    }

    public JPasswordField getCurrentPassField() {
        return currentPassField;
    }

    public void setCurrentPassField(JPasswordField currentPassField) {
        this.currentPassField = currentPassField;
    }

    public JPasswordField getNewPassField() {
        return newPassField;
    }

    public void setNewPassField(JPasswordField newPassField) {
        this.newPassField = newPassField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public void setAddressField(JTextField addressField) {
        this.addressField = addressField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public void setFirstNameField(JTextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public void setLastNameField(JTextField lastNameField) {
        this.lastNameField = lastNameField;
    }

    public JDateChooser getBirthdayCalendar() {
        return birthdayCalendar;
    }

    public void setBirthdayCalendar(JDateChooser birthdayCalendar) {
        this.birthdayCalendar = birthdayCalendar;
    }

    public DefaultComboBoxModel<String> getNamHoComboBoxModel() {
        return namHoComboBoxModel;
    }

    

    public DefaultComboBoxModel<String> getMonhocComboBoxModel() {
        return monhocComboBoxModel;
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

    

    public JRadioButton getFemaleRadioBtn() {
        return femaleRadioBtn;
    }

    public JRadioButton getMaleRadioBtn() {
        return maleRadioBtn;
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
            setGenderBtn("Nữ");
        }
    }

    private void maleRadioBtnActionPerformed(ActionEvent evt) {
        if (maleRadioBtn.isSelected()) {
            setGenderBtn("Nam");
        }
    }



    public static void main(String[] args) {
        new SinhVienQuanLy().setVisible(true);
        ;
    }
}
