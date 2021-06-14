/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;


/**
 * FXML Controller class
 *
 * @author murasaki
 */
public class ReproductorController implements Initializable {

    @FXML
    private Button botonReset;
    @FXML
    private Button botonNext;
    @FXML
    private Button botonPlay;
    @FXML
    private Button botonStop;
    @FXML
    private Button botonPause;
    @FXML
    private Button botonPrev;
    @FXML
    private Slider slider;
    @FXML
    private MediaView media;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void next(MouseEvent event) {
    }

    @FXML
    private void play(MouseEvent event) {
    }

    @FXML
    private void stop(MouseEvent event) {
    }

    @FXML
    private void reset(MouseEvent event) {
    }

    @FXML
    private void pause(MouseEvent event) {
    }

    @FXML
    private void prev(MouseEvent event) {
    }
    
}
