/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class LoginView extends JFrame{
    
    private JLabel lLogin = new JLabel("Login");
    
    private JLabel luname = new JLabel("Username");
    private JLabel lpw = new JLabel("Password");
    
    private JTextField Iuname = new JTextField();
    private JTextField Ipw = new JTextField();
    
    public JButton loginButton = new JButton("Login");

 
    
    public LoginView(){
        
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        
        add(lLogin);
        add(luname);
        add(lpw);
        add(Iuname);
        add(Ipw);
        add(loginButton);
        
        lLogin.setBounds(300, 40 ,150,90);
        luname.setBounds(210, 130, 90, 20);
        lpw.setBounds(210,180,90,20);
        Iuname.setBounds(320, 130, 150, 20);
        Ipw.setBounds(320, 180, 150, 20);
        loginButton.setBounds(280, 230, 100, 30);
       
        
    }

    public String getIuname() {
        return Iuname.getText();
    }

    public String getIpw() {
        return Ipw.getText();
    }
    
    
    
    
}
