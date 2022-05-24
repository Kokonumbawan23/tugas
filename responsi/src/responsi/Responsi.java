/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import view.MovieView;
import Util.Connector;
import controller.MovieController;
import model.MovieModel;

/**
 *
 * @author Lenovo
 */
public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MovieView view = new MovieView();
        MovieModel model = new MovieModel();
        MovieController controller = new MovieController(model, view);
    }
    
}
