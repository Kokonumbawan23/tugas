/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import Util.Connector;
import javax.swing.JOptionPane;
import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class LoginModel implements LoginInterface{
    
    int id;
    String username;
    String nama;
    String password;
    
    Connector con;
    Statement stmt;
    
    public LoginModel(){
        
        con = new Connector();
    
    }
    
    @Override
    public String[][] getUserData(String uname,String password){
        
        try{
            
            String[][] data = new String[1][5];
            
            String sql = "select * from user where username = '" + uname + "' and password = '" + password + "'";
            stmt = (Statement) con.koneksi.createStatement();
            ResultSet rsl = stmt.executeQuery(sql);
           
            while(rsl.next()){
                data[0][0] = String.valueOf(rsl.getInt("id"));
                data[0][1] = rsl.getString("username");
                data[0][2] = rsl.getString("nama");
                data[0][3] = rsl.getString("password");
                data[0][4] = rsl.getString("role");
            }
            
            return data;
        
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
        
    }
    
}
