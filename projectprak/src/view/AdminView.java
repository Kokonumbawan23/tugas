/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orenji
 */
public class AdminView extends JFrame{
 
    public JLabel presenceTitle = new JLabel("Presensi");
    public JLabel userIdTitle = new JLabel("Input User Id");
    
    public JTextField userIdInput = new JTextField("");
    
    public JButton btnPresent = new JButton("Presensi");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnUpdate = new JButton("Ubah Status");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"id","user_id","nama","tanggal","presensi"};

    public AdminView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Presence");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        
      
        add(presenceTitle);
        presenceTitle.setBounds(560, 40, 90, 30);
        
        add(userIdTitle);
        userIdTitle.setBounds(550,80,110,30);
        
        add(userIdInput);
        userIdInput.setBounds(550,110,70,20);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(btnPresent);
        btnPresent.setBounds(540, 140, 90, 30);
        
        add(btnUpdate);
        btnUpdate.setBounds(530, 230, 110, 30);
        
        add(btnDelete);
        btnDelete.setBounds(540, 280, 90, 30);
    
    }

}

