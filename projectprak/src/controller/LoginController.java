/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LoginModel;
import model.PresenceAdminModel;
import view.LoginView;

import javax.swing.JOptionPane;

import model.PresenceUserModel;
import view.AdminView;
import view.UserView;

/**
 *
 * @author Lenovo
 */
public class LoginController {
    
    LoginModel model;
    LoginView view;
    
    
    String[][] loginInfo;
    
    public LoginController(LoginModel model,LoginView view){
        this.model = model;
        this.view = view;
        
        loginInfo = new String[1][5];
        
        view.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
              String uname = view.getIuname();
              String pw = view.getIpw();
              
              loginInfo = model.getUserData(uname, pw);
              
              if(loginInfo != null){
                  
                  if(loginInfo[0][4].equals("admin")){
                        new PresenceAdminController(new PresenceAdminModel(loginInfo),new AdminView());
                        view.setVisible(false);
                  }else{
                        new PresenceUserController(new PresenceUserModel(loginInfo),new UserView());
                        view.setVisible(false);
                  }
              }
              else{         
                  JOptionPane.showMessageDialog(null, "Cek kembali id atau password anda");
              }
              
            }
        });
    }
}
