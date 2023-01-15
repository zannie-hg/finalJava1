package Controller;

import java.awt.event.*;

import javax.swing.event.MouseInputAdapter;

import View.DangKy;
import View.DangNhap;
import View.GiaoVienQuanLy;

public class AuthenController {
    DangNhap dangNhapView;
    DangKy dangKyView;

    public AuthenController(){
        dangNhapView = new DangNhap();
        dangKyView = new DangKy();
        initAction();
        dangNhapView.setVisible(true);
        dangKyView.setVisible(false);
    }

    public void initAction(){
        dangNhapView.addDangNhapListenner(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onDangNhap(e);
            }
        });
        dangKyView.addDangKyListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onDangKy(e);
            }
        });
        dangNhapView.addDangKyListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                onSwDangKy(e);
            }
        });
        dangKyView.addDangNhapListenner(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                onSwDangNhap(e);
            }
        });
    }

    public void onDangNhap(ActionEvent e){
        new GiaoVienController(this);
        System.out.println(dangNhapView.getLoginInfo()[1]);
        dangNhapView.setVisible(false);
    }

    public void onDangKy(ActionEvent e){

    }

    public void onSwDangKy(MouseEvent e){
        dangKyView.setVisible(true);
        dangNhapView.setVisible(false);
    }

    public void onSwDangNhap(MouseEvent e){
        dangKyView.setVisible(false);
        dangNhapView.setVisible(true);
    }
}
