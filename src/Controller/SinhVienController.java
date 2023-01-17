package Controller;

import View.SinhVienQuanLy;

public class SinhVienController {
    AuthenController authenController;
    SinhVienQuanLy sinhVienQuanLy;
    public SinhVienController(AuthenController authenController) {
        this.authenController = authenController;
        sinhVienQuanLy = new SinhVienQuanLy();
        sinhVienQuanLy.setVisible(true);
    }
}
