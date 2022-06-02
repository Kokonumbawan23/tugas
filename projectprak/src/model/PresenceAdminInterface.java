/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public interface PresenceAdminInterface {
    public String[][] readPresence();
    public void createPresence(double user_id);
    public void updatePresence(double id);
    public void deletePresence(double id);
}
