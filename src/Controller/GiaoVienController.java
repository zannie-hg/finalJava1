package Controller;

import View.GiaoVienQuanLy;
import java.awt.event.*;

import javax.swing.event.MouseInputAdapter;

public class GiaoVienController {
    GiaoVienQuanLy giaoVienQuanLy;
    AuthenController authenController;
    public GiaoVienController(AuthenController authenController){
        this.authenController = authenController;
        giaoVienQuanLy = new GiaoVienQuanLy();
        initAction();
        giaoVienQuanLy.setVisible(true);
        
    }

    public void initAction(){
        giaoVienQuanLy.addLogoutListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogout(e);
                
            }
        });
    }

    public void onLogout(ActionEvent e){
        authenController.dangNhapView.setVisible(true);
        giaoVienQuanLy.dispose();
    }
}
