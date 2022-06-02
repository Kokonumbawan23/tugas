/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 *
 * @author Lenovo
 */
public class UserView extends JFrame{
    
    public JLabel presenceTitle = new JLabel("Presensi");
    public JButton btnPresent = new JButton("Presensi");
    public JLabel presenceStatus = new JLabel("Sudahkah Anda Absen Hari Ini?");
    
    public UserView(){
    
        setTitle("Presensi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
    
        add(presenceTitle);
        presenceTitle.setBounds(300, 40, 150, 90);
        
        add(presenceStatus);
        presenceStatus.setBounds(235,90, 190, 80);
        
        add(btnPresent);
        btnPresent.setBounds(270, 170, 110, 60);
    }
}
