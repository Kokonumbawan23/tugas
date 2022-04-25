/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas4;


import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener{

    Konektor konek  = new Konektor();
    
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel usernameRegister = new JLabel("Username");
    JLabel passwordRegister = new JLabel("Password");
    JLabel loginTitle = new JLabel("Login");
    
    JTextField usernameText = new JTextField();
    JTextField passwordText = new JTextField();
    JTextField usernameRegText = new JTextField();
    JTextField passwordRegText = new JTextField();
    JLabel registerTitle = new JLabel("Register");
    
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    public LoginGUI() {
        
        setTitle("JDBC Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,350);
        
        setLayout(null);
        
        add(usernameLabel);
        add(passwordLabel);
        add(usernameRegister);
        add(passwordRegister);
       
        add(usernameText);
        add(passwordText);
        add(usernameRegText);
        add(passwordRegText);
        
        add(loginButton);
        add(loginTitle);
        add(registerButton);
        add(registerTitle);
        
        //Set up lokasi login
        
        usernameLabel.setBounds(80, 80, 60, 20);
        passwordLabel.setBounds(80, 130, 60, 20);
        
        usernameText.setBounds(150, 80, 110, 20);
        passwordText.setBounds(150, 130, 110, 20);
        
        loginButton.setBounds(150, 175, 80, 30);
        loginTitle.setBounds(170, 40, 70, 30);
        
        //set up lokasi register
        
        usernameRegister.setBounds(320, 80, 60, 20);
        passwordRegister.setBounds(320, 130, 60, 20);
        
        usernameRegText.setBounds(390, 80, 110, 20);
        passwordRegText.setBounds(390, 130, 110, 20);
        
        registerButton.setBounds(390, 175, 85, 30);
        registerTitle.setBounds(410, 40, 70, 30);
        
        
        //event handler
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
      
        if(e.getSource() == loginButton){
            
            try{
            
                if(getUsernameText().isBlank()){              
                    throw new IllegalArgumentException("Username tidak boleh kosong");
                }
                if(getPasswordText().isBlank()){              
                    throw new IllegalArgumentException("Password tidak boleh kosong");
                }
                
                //melaksanakan query username
                
                String query = "SELECT * FROM users WHERE username = '" + getUsernameText() + "'";
                konek.statement = konek.koneksi.createStatement();
                ResultSet result = konek.statement.executeQuery(query);
                
                if(result.next()){
                    
                    String pass = result.getString("password");
                    
                    if(pass.equals(getPasswordText())){
                        JOptionPane.showMessageDialog(new JFrame(), "Login Berhasil");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Login Gagal");
                    } 
                }
            }catch(Exception ex){
            
              JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());  
            
            }
            finally{
            
                try {
                    konek.statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());;
                }
            }
        }
        
        if(e.getSource() == registerButton){
            
             try{
            
                if(getUsernameRegText().isBlank()){              
                    throw new IllegalArgumentException("Username tidak boleh kosong");
                }
                if(getPasswordRegText().isBlank()){              
                    throw new IllegalArgumentException("Password tidak boleh kosong");
                }
                
                //melaksanakan query username
                
                String query = "SELECT * FROM users WHERE username = '" + getUsernameRegText() + "'";
                konek.statement = konek.koneksi.createStatement();
                ResultSet result = konek.statement.executeQuery(query);
                
                if(result.next()){  
                   JOptionPane.showMessageDialog(new JFrame(), "Maaf Username Sudah Dipakai ");   
                }
                else{
                    String insert = "INSERT INTO users (username,password) VALUES ( '" + getUsernameRegText() + "','" + getPasswordRegText() +"')";
                    konek.statement = konek.koneksi.createStatement();
                    konek.statement.executeUpdate(insert);
                    JOptionPane.showMessageDialog(new JFrame(), "Register Berhasil");         
                }
            }catch(Exception ex){
            
              JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());  
            
            }
            finally{
            
                try {
                    konek.statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());;
                }
            }
        
        
        }
        
        
    }

    public String getUsernameText() {
        return usernameText.getText();
    }

    public String getPasswordText() {
        return passwordText.getText();
    }

    public String getUsernameRegText() {
        return usernameRegText.getText();
    }

    public String getPasswordRegText() {
        return passwordRegText.getText();
    }
    
    
}
