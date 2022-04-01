/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3;

import javax.swing.*;
import Bangun.Balok;
import java.awt.event.*;

/**
 *
 * @author Lenovo
 */
public class GUI extends JFrame implements ActionListener{
   
    JLabel lpanjang = new JLabel(" panjang ");
    JLabel llebar = new JLabel(" lebar ");
    JLabel ltinggi = new JLabel(" tinggi ");
    JLabel lkel = new JLabel();
    JLabel lluas = new JLabel();
    JLabel llp = new JLabel();
    JLabel lvol = new JLabel();
    
    JTextField ipanjang = new JTextField();
    JTextField ilebar = new JTextField();
    JTextField itinggi = new JTextField();
    
    JButton hitung = new JButton("hitung");
    JButton reset = new JButton("reset");
    
    public GUI(){
    
        setTitle("Perhitungan Balok");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);
        
        setLayout(null);
        
        add(lpanjang);
        add(llebar);
        add(ltinggi);
        
        add(ipanjang);
        add(ilebar);
        add(itinggi);
        
        add(hitung);
        add(reset);
        
        add(lkel);
        add(lluas);
        add(llp);
        add(lvol);

                
        lpanjang.setBounds(120, 40, 100, 60);
        llebar.setBounds(120, 80, 100, 60);
        ltinggi.setBounds(120, 120, 100, 60);
        
        ipanjang.setBounds(250, 55, 100, 30);
        ilebar.setBounds(250, 95, 100, 30);
        itinggi.setBounds(250, 135, 100, 30);
        
        hitung.setBounds(140, 190, 80, 30);
        reset.setBounds(250, 190, 80, 30);
        
        lkel.setBounds(40, 240, 200, 30);
        lluas.setBounds(40, 270, 200, 30);
        llp.setBounds(250, 240, 200, 30);
        lvol.setBounds(250, 270, 200, 30);
        
        hitung.addActionListener(this);
        reset.addActionListener(this);
        
        setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == hitung){
        
            String p = ipanjang.getText();
            String l = ilebar.getText();
            String t = itinggi.getText();
            
            try {
                
            Double pjg = Double.parseDouble(p);
            Double lbr = Double.parseDouble(l);
            Double tg = Double.parseDouble(t);
            
            Balok balok = new Balok(pjg,lbr,tg);
            lkel.setText("Keliling Persegi Panjang : " + String.valueOf(balok.getKeliling()));
            lluas.setText("Luas Persegi Panjang    : " + String.valueOf(balok.getLuas()));
            llp.setText("Luas Permukaan Balok      : " + String.valueOf(balok.getLuasPermukaan()));
            lvol.setText("Volume Balok             : " + String.valueOf(balok.getVolume()));
                
            } catch (NumberFormatException er) {
                JOptionPane.showMessageDialog(new JFrame(), "Masukkan Angka dan Jangan kosongi field"); 
            }   
        }
        
        if(e.getSource() == reset){
            ipanjang.setText("");
            ilebar.setText("");
            itinggi.setText("");
            lkel.setText("");
            lluas.setText("");
            llp.setText("");
            lvol.setText("");
            
        }
    }
}
    
    
   
    
    
    
    
    
    
   
