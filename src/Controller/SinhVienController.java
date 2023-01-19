package Controller;

import View.SinhVienQuanLy;
import java.awt.event.*;

import javax.swing.JOptionPane;

import Database.MarkManager;
import Database.SubjectManager;

import java.awt.*;
public class SinhVienController {
    AuthenController authenController;
    SinhVienQuanLy sinhVienQuanLy;
    private String username;
    private String user_id;
    private MarkManager markManager;
    private SubjectManager subjectManager;
    public SinhVienController(AuthenController authenController, String username, String user_id) {
        this.username = username;
        this.user_id = user_id;

        markManager = new MarkManager();
        subjectManager = new SubjectManager(); 

        this.authenController = authenController;
        sinhVienQuanLy = new SinhVienQuanLy();
        initListener();
        sinhVienQuanLy.setVisible(true);

        subjectManager.getMyYear(sinhVienQuanLy.getNamHoComboBoxModel(), user_id);
        markManager.getMyMark(sinhVienQuanLy.getMarkTableModel(), user_id, "2023");
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

    public void onChangeFilterMark(ActionEvent e){
        String year = sinhVienQuanLy.getNamhocComboBox().getSelectedItem().toString();
        markManager.getMyMark(sinhVienQuanLy.getMarkTableModel(), user_id, year);
        subjectManager.getOtherSubject(sinhVienQuanLy.getMonhocComboBoxModel(), user_id, year);
    }
    
}
