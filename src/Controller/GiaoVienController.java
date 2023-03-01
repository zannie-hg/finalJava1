package Controller;

import View.GiaoVienQuanLy;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import Database.MarkManager;
import Database.SubjectManager;
import Database.UserManager;

public class GiaoVienController {
    GiaoVienQuanLy giaoVienQuanLy;
    AuthenController authenController;
    UserManager userManager;
    MarkManager markManager;
    SubjectManager subjectManager;
    DefaultTableModel tableModelDiem;
    public GiaoVienController(AuthenController authenController, String username) {
        this.authenController = authenController;
        giaoVienQuanLy = new GiaoVienQuanLy(username);
        initAction();
        giaoVienQuanLy.setVisible(true);
        userManager = new UserManager();
        markManager = new MarkManager();
        subjectManager = new SubjectManager();

        subjectManager.getAllSubject(giaoVienQuanLy.getMonHocBoxModel());
        subjectManager.getAllYear(giaoVienQuanLy.getNamHocBoxModel());
        userManager.getAllUser(giaoVienQuanLy.getTableModelHoSo(), "");
        markManager.getAllMark(giaoVienQuanLy.getTableModelDiem(), "2023", "Ngữ Văn", "");
    }

    public void initAction() {

        giaoVienQuanLy.addSearchDiemListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                reloadTableDiem();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                reloadTableDiem();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                reloadTableDiem();

            }


        });
        giaoVienQuanLy.addSearchHoSoListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                reloadTableHoSo();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                reloadTableHoSo();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                reloadTableHoSo();

            }


        });
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
        giaoVienQuanLy.addExportcsvDiemListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExportDiem(e);
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

    public void onSuaDiem(ActionEvent e) {
        int[] editRows = giaoVienQuanLy.getDiemTable().getSelectedRows();
        DefaultTableModel homeTable = giaoVienQuanLy.getTableModelDiem();
        for (int i = editRows.length - 1; i >= 0; i--) {
            String id = String.valueOf(homeTable.getValueAt(editRows[i], 0));
            String homework = String.valueOf(homeTable.getValueAt(editRows[i], 3));
            String midtern = String.valueOf(homeTable.getValueAt(editRows[i], 4));
            String finalmark = String.valueOf(homeTable.getValueAt(editRows[i], 5));

            markManager.updateMark(id, homework, midtern, finalmark);
        }
        reloadTableDiem();
    }

    public void onXoaDiem(ActionEvent e) {
        int[] deleteRows = giaoVienQuanLy.getDiemTable().getSelectedRows();
        DefaultTableModel homeTable = giaoVienQuanLy.getTableModelDiem();
        for (int i = deleteRows.length - 1; i >= 0; i--) {
            markManager.deleteMark(homeTable.getValueAt(deleteRows[i], 0).toString());
        }
        reloadTableDiem();
    };

    public void onRefeshDiemTable(ActionEvent e) {
        reloadTableDiem();
    }

    public void reloadTableDiem() {
        markManager.getAllMark(giaoVienQuanLy.getTableModelDiem(),
                String.valueOf(giaoVienQuanLy.getNamhocComboBox().getSelectedItem()),
                String.valueOf(giaoVienQuanLy.getMonhocComboBox().getSelectedItem()),
                giaoVienQuanLy.getTimkiemDiemField().getText());
    }
public void onExportDiem(ActionEvent e){
   
    // DefaultTableModel tableModel = (DefaultTableModel) tableModelDiem.getTableModelDiem();
    // String filename = "filediem.csv";
    
    // try {
    //     FileWriter fw = new FileWriter(new File(filename));
    
    //     // Ghi tên cột
    //     for (int i = 0; i < tableModel.getColumnCount(); i++) {
    //         fw.write(tableModel.getColumnName(i));
    //         if (i != tableModel.getColumnCount() - 1) {
    //             fw.write(",");
    //         }
    //     }
    //     fw.write("\n");
    
    //     // Ghi dữ liệu bảng
    //     for (int row = 0; row < tableModel.getRowCount(); row++) {
    //         for (int col = 0; col < tableModel.getColumnCount(); col++) {
    //             Object value = tableModel.getValueAt(row, col);
    //             if (value != null) {
    //                 fw.write(value.toString());
    //             }
    //             if (col != tableModel.getColumnCount() - 1) {
    //                 fw.write(",");
    //             }
    //         }
    //         fw.write("\n");
    //     }
    
    //     fw.close();
    //     System.out.println("Bảng điểm đã được xuất ra tệp CSV thành công.");
    // } catch (IOException evt) {
    //     System.err.println("Lỗi xuất bảng điểm ra tệp CSV: " + evt.getMessage());
    // }
}
    public void onUpdateHoSo(ActionEvent e) {
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

    public void onDeleteHoSo(ActionEvent e) {
        String id = giaoVienQuanLy.getIdHoSoField().getText();
        userManager.deleteUser(id);
        reloadTableHoSo();

    }

    public void reloadTableHoSo() {
        userManager.getAllUser(giaoVienQuanLy.getTableModelHoSo(), giaoVienQuanLy.getTimkiemHoSoField().getText());

    }
   
}
