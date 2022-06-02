/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PresenceAdminModel;
import view.AdminView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author Lenovo
 */
public class PresenceAdminController {
    
    PresenceAdminModel model;
    AdminView view;
    Double data;

    public PresenceAdminController(PresenceAdminModel model,AdminView view) {
        this.model = model;
        this.view = view;
        
        if (model.getBanyakData()!=0) {
            String dataPresence[][] = model.readPresence();
            
            view.tabel.setModel((new JTable(dataPresence, view.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        view.btnPresent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String userId  = view.userIdInput.getText();
                
                if(userId.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    Double convertUserId = (Double) Double.parseDouble(userId);
                    model.createPresence(convertUserId);
                    String dataPresence[][] = model.readPresence();
                    view.tabel.setModel((new JTable(dataPresence, view.namaKolom)).getModel());
                }
            }
        });
        
        view.btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               int input = JOptionPane.showConfirmDialog(null,"Apa anda ingin mengubah data presensi?", 
                 "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
               
               if(input == 0){
                   model.updatePresence(data);
                   String dataMovie[][] = model.readPresence();
                   view.tabel.setModel((new JTable(dataMovie, view.namaKolom)).getModel());
               }else{
                JOptionPane.showMessageDialog(null, "Tidak Jadi Diubah");
                }
            
            }
        });
       
        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus data presensi?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                model.deletePresence(data);
                String dataPresence[][] = model.readPresence();
                view.tabel.setModel((new JTable(dataPresence, view.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });
    
          view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int row = view.tabel.getSelectedRow();
                data = Double.parseDouble(view.tabel.getValueAt(row, 0).toString());
                String dataUpdate[] = new String[4];
                dataUpdate[0] = view.tabel.getValueAt(row, 0).toString();
                dataUpdate[1] = view.tabel.getValueAt(row, 1).toString();
                
                
                System.out.println(data);
                
            }
           });
    }
    
    
    
}
