package Controller;

import View.GiaoVienQuanLy;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;

import DAO.MarkManager;
import DAO.SubjectManager;
import DAO.UserManager;

public class GiaoVienController {
    GiaoVienQuanLy giaoVienQuanLy;
    AuthenController authenController;
    UserManager userManager;
    MarkManager markManager;
    SubjectManager subjectManager;

    public GiaoVienController(AuthenController authenController, String username) {
        this.authenController = authenController;
        giaoVienQuanLy = new GiaoVienQuanLy(username);
        initAction();
        giaoVienQuanLy.setVisible(true);
        userManager = new UserManager(giaoVienQuanLy.getTableModelHoSo());
        markManager = new MarkManager(giaoVienQuanLy.getTableModelDiem());
        subjectManager = new SubjectManager(giaoVienQuanLy.getNamHocBoxModel(), giaoVienQuanLy.getMonHocBoxModel());

        subjectManager.getAllSubject();
        subjectManager.getAllYear();
        userManager.getAllUser();
        markManager.getAllMark("2023", "Ngữ Văn");
    }

    public void initAction() {
        giaoVienQuanLy.addLogoutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogout(e);

            }
        });

        giaoVienQuanLy.addChangeMonHocListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChangeFilter(e);
            }
        });

        giaoVienQuanLy.addChangeNamHocListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChangeFilter(e);
            }
        });

        giaoVienQuanLy.addSuaDiemListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSuaDiem(e);
            }
        });

        giaoVienQuanLy.addXoaDiemListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onXoaDiem(e);
            }
        });

        giaoVienQuanLy.refreshDiemTable(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRefeshDiemTable(e);
            }
        });

        giaoVienQuanLy.addSuaHoSoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUpdateHoSo(e);
            }
        });

        giaoVienQuanLy.addXoaHoSoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteHoSo(e);
            }
        });

    }

    public void onLogout(ActionEvent e) {
        authenController.dangNhapView.setVisible(true);
        giaoVienQuanLy.dispose();
    }

    public void onChangeFilter(ActionEvent e) {
        reloadTableDiem();
    }

    public void onSuaDiem(ActionEvent e){
        int[] editRows = giaoVienQuanLy.getDiemTable().getSelectedRows();
        DefaultTableModel homeTable = giaoVienQuanLy.getTableModelDiem();
        for (int i = editRows.length - 1; i >= 0; i--) {
            String id = String.valueOf(homeTable.getValueAt(editRows[i], 0));
            String homework = String.valueOf(homeTable.getValueAt(editRows[i], 3));
            String midtern = String.valueOf(homeTable.getValueAt(editRows[i], 4));
            String finalmark = String.valueOf(homeTable.getValueAt(editRows[i], 5));

            markManager.updateMark(id, homework, midtern, finalmark);
            System.out.println("Sua diem thanh cong" + id);
        }
        reloadTableDiem();
    }

    public void onXoaDiem(ActionEvent e) {
        int[] deleteRows = giaoVienQuanLy.getDiemTable().getSelectedRows();
        DefaultTableModel homeTable = giaoVienQuanLy.getTableModelDiem();
        for (int i = deleteRows.length - 1; i >= 0; i--) {
            markManager.deleteMark(homeTable.getValueAt(deleteRows[i], 0).toString());
            System.out.println("Xoa diem thanh cong" + homeTable.getValueAt(deleteRows[i], 0).toString());
        }
        reloadTableDiem();
    };

    public void onRefeshDiemTable(ActionEvent e){
        reloadTableDiem();
    }

    public void reloadTableDiem(){
        markManager.getAllMark(String.valueOf(giaoVienQuanLy.getNamhocComboBox().getSelectedItem()),String.valueOf(giaoVienQuanLy.getMonhocComboBox().getSelectedItem()));
    }

    public void onUpdateHoSo(ActionEvent e){
        String id = giaoVienQuanLy.getIdHoSoField().getText();
        String lastname = giaoVienQuanLy.getHoHoSoField().getText();
        String firstname = giaoVienQuanLy.getTenHoSoField().getText();
        String birthday = giaoVienQuanLy.getNgaysinhHoSoField().getText();
        String address = giaoVienQuanLy.getDiachiHoSoField().getText();
        String gender = giaoVienQuanLy.getGenderField() + "";
        String email = giaoVienQuanLy.getEmailHoSoField().getText();
        userManager.updateUser(id, lastname, firstname, birthday, address, gender, email);
        reloadTableHoSo();
    }

    public void onDeleteHoSo(ActionEvent e){
        String id = giaoVienQuanLy.getIdHoSoField().getText();
        userManager.deleteUser(id);
        reloadTableHoSo();
        
    }

    public void reloadTableHoSo(){
        userManager.getAllUser();
    }
}
