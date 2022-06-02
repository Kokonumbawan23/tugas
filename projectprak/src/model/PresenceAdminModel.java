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
public class PresenceAdminModel implements PresenceAdminInterface{

    String[][] user;
    
    Connector con;
    Statement stmt;
    
    public PresenceAdminModel(String[][] user) {
        
        con = new Connector();
        this.user = user;
    }
    
    
    @Override
    public String[][] readPresence(){
        
        try{
        
        int jmlData = 0;
        
        String data[][] = new String[getBanyakData()][5];
            
        String sql = "Select * from presence order by tanggal desc";
        
        stmt = (Statement) con.koneksi.createStatement();
        ResultSet rsl = stmt.executeQuery(sql);
        
         while (rsl.next()){
                data[jmlData][0] = String.valueOf(rsl.getDouble("id")); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(rsl.getDouble("user_id"));
                data[jmlData][2] = rsl.getString("nama");                
                data[jmlData][3] = String.valueOf(rsl.getDate("tanggal"));
                data[jmlData][4] = String.valueOf(rsl.getBoolean("presensi"));
                jmlData++;
            }
         
         return data;
        
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        } 
    }
    
    @Override
    public void createPresence(double user_id){
        
        try{
            
            //ambil data user yang akan diabsen
            
           String[][] dataUser = new String[1][5]; 
            
           String check = "select * from presence where tanggal = '" + LocalDate.now() + "' and user_id = " + user_id; 
           stmt = (Statement) con.koneksi.createStatement();
           ResultSet rsl = stmt.executeQuery(check);
           
           if(rsl.next()){
               
            JOptionPane.showMessageDialog(null,"Anda sudah absen hari ini");   
           
           }
           else{
                 
            String getUser = "select * from user where id = " + user_id;
            stmt = (Statement) con.koneksi.createStatement();
            ResultSet userRes = stmt.executeQuery(getUser);
            
            while(userRes.next()){
                dataUser[0][0] = String.valueOf(userRes.getInt("id"));
                dataUser[0][1] = userRes.getString("username");
                dataUser[0][2] = userRes.getString("nama");
                dataUser[0][3] = userRes.getString("password");
                dataUser[0][4] = userRes.getString("role");
            }
            
            //query ke db
               
            LocalDate tanggal = LocalDate.now(); 

            stmt = (Statement) con.koneksi.createStatement();
            String sql = "INSERT INTO presence(user_id,nama,tanggal,presensi) VALUES('"+ dataUser[0][0] + "','"+ dataUser[0][2] +"','"+tanggal+"','"+ 1 +"')";     
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "input berhasil");
            
           }
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    
    
    }
    
    @Override
    public void updatePresence(double id){
        
        try{    
            
            double presensiValue = 0;
            
            String check = "select presensi from presence where id = "+ id;
            stmt = (Statement) con.koneksi.createStatement();
            ResultSet rsl = stmt.executeQuery(check);
            
            while(rsl.next()){
                presensiValue = (double) rsl.getDouble("presensi");        
            }
            
            presensiValue =(presensiValue==1)? 0 : 1;
              
            
            String sql = "update presence set presensi = '"+ presensiValue +"' where id = " + id; 

            stmt = (Statement) con.koneksi.createStatement();
            
            stmt.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Berhasil mengubah data");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,  e.getMessage(),"alert", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    @Override
    public void deletePresence(double id){
    
     try{
            String query = "DELETE FROM presence WHERE id = '"+ id +"'";
            stmt = con.koneksi.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    
    }
    
    public int getBanyakData(){
           int jmlData = 0;
           try{
               stmt = con.koneksi.createStatement();
               String query = "Select * from presence";
               ResultSet resultSet = stmt.executeQuery(query);
               while (resultSet.next()){ 
                   jmlData++;
               }
               return jmlData;

           }catch(SQLException e){
               System.out.println(e.getMessage());
               System.out.println("SQL Error");
               return 0;
           }
       }
    
    
    
}
