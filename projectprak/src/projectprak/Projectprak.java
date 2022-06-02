/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprak;

import controller.LoginController;
import model.LoginModel;
import view.LoginView;
import view.UserView;

/**
 *
 * @author Lenovo
 */
public class Projectprak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       LoginModel model = new LoginModel();
       LoginView view = new LoginView();
       LoginController controller = new LoginController(model,view);

        
    
    }
    
}
