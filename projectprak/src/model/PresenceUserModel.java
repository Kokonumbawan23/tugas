/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.Connector;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class PresenceUserModel implements PresenceUserInterface{
    
    String[][] user;
    
    Connector con;
    Statement stmt;
    
    public PresenceUserModel(String[][] user){
        con = new Connector();
        this.user = user;
    }
    
    @Override
    public void createPresence(){
        
        try{
            
           String check = "select * from presence where tanggal = '" + LocalDate.now() + "' and user_id = " + user[0][0]; 
           stmt = (Statement) con.koneksi.createStatement();
           ResultSet  rsl = stmt.executeQuery(check);
           
           if(rsl.next()){
               
            JOptionPane.showMessageDialog(null,"Anda sudah absen hari ini");   
           
           }
           else{
               
            LocalDate tanggal = LocalDate.now(); 

            stmt = (Statement) con.koneksi.createStatement();
            String sql = "INSERT INTO presence(user_id,nama,tanggal,presensi) VALUES('"+ user[0][0] + "','"+ user[0][2] +"','"+tanggal+"','"+ 1 +"')";     
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "input berhasil");
            
           }
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
}
