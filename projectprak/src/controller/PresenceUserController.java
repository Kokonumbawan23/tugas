/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PresenceUserModel;
import view.UserView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Lenovo
 */
public class PresenceUserController {

    PresenceUserModel model;
    UserView view;
    
    public PresenceUserController(PresenceUserModel model,UserView view) {
        this.model = model;
        this.view = view;
    
        view.btnPresent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                model.createPresence();
         
                
            }
        });
    }
    
}
