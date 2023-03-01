package Controller;

import View.SinhVienQuanLy;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import Database.MarkManager;
import Database.SubjectManager;
import Database.UserManager;

import java.awt.*;
public class SinhVienController {
    AuthenController authenController;
    SinhVienQuanLy sinhVienQuanLy;
    UserManager userManager;
    private String username;
    private String user_id;
    private MarkManager markManager;
    private SubjectManager subjectManager;
    public SinhVienController(AuthenController authenController, String username, String user_id) {
        this.username = username;
        this.user_id = user_id;

        markManager = new MarkManager();
        subjectManager = new SubjectManager(); 
        userManager = new UserManager();

        this.authenController = authenController;
        sinhVienQuanLy = new SinhVienQuanLy();
        initListener();
        sinhVienQuanLy.setVisible(true);

        subjectManager.getMyYear(sinhVienQuanLy.getNamHoComboBoxModel(), user_id);
        markManager.getMyMark(sinhVienQuanLy.getMarkTableModel(), user_id, "2023");
        userManager.getMyUserInfo(user_id,sinhVienQuanLy.getFirstNameField(),
            sinhVienQuanLy.getLastNameField(),
            sinhVienQuanLy.getEmailField(), 
            sinhVienQuanLy.getAddressField(), 
            sinhVienQuanLy.getBirthdayCalendar(), sinhVienQuanLy.getMaleRadioBtn(), sinhVienQuanLy.getFemaleRadioBtn()
        );
    }

    public void initListener(){
        sinhVienQuanLy.addLogoutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogout(e);
            }
        });

        sinhVienQuanLy.addNamHocComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChangeFilterMark(e);
            }
        });

        sinhVienQuanLy.addAddClassListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddClass(e);
            }
        });

        sinhVienQuanLy.addRemoveClassListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRemoveClass(e);
            }
        });

        sinhVienQuanLy.addChangePassListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                onChangePassword(e);
                
            }

        });

        sinhVienQuanLy.addUpdateProfileListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                onUpdateProfile(e);
                
            }

        });
       
    }

    public void onLogout(ActionEvent e){
        authenController.dangNhapView.setVisible(true);
        sinhVienQuanLy.dispose(); 
    }

    public void onAddClass(ActionEvent e){
        String year = sinhVienQuanLy.getNamhocComboBox().getSelectedItem().toString();
        String subject = sinhVienQuanLy.getChooseClassComboBox().getSelectedItem().toString();
        markManager.addClass(user_id, subject, year);
        onChangeFilterMark(e); 
    }

    public void onRemoveClass(ActionEvent e){
        int id = sinhVienQuanLy.getMarkTable().getSelectedRow();
        if(id == -1){
            JOptionPane.showMessageDialog(null, "Chưa chọn môn học để xóa");
            return;
        }
        String ID = sinhVienQuanLy.getMarkTableModel().getValueAt(id, 0).toString();
        markManager.deleteMark(ID);
        onChangeFilterMark(e);
    }

    public void onChangePassword(ActionEvent e){
        String current = String.copyValueOf(sinhVienQuanLy.getCurrentPassField().getPassword());
        String newPass = String.copyValueOf(sinhVienQuanLy.getNewPassField().getPassword());
        String confirmPass = String.copyValueOf(sinhVienQuanLy.getConfirmPassField().getPassword());
        userManager.updatePassword(user_id ,current, newPass, confirmPass);
    }   

    public void onUpdateProfile(ActionEvent e){
        String firstname = sinhVienQuanLy.getFirstNameField().getText();
        String lastname = sinhVienQuanLy.getLastNameField().getText();
        String email = sinhVienQuanLy.getEmailField().getText();
        String gender = sinhVienQuanLy.getGenderField() + "";
        String birthday = new SimpleDateFormat("yyyy-MM-dd")
        .format(sinhVienQuanLy.getBirthdayCalendar().getDate());
        String address = sinhVienQuanLy.getAddressField().getText();
        userManager.updateMyInfo(user_id, firstname, lastname, email, gender, birthday, address);
    }

    public void onChangeFilterMark(ActionEvent e){
        String year = sinhVienQuanLy.getNamhocComboBox().getSelectedItem().toString();
        markManager.getMyMark(sinhVienQuanLy.getMarkTableModel(), user_id, year);
        subjectManager.getOtherSubject(sinhVienQuanLy.getMonhocComboBoxModel(), user_id, year);
    }
    
}
