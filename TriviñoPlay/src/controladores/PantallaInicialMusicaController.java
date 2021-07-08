/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Juan
 */
public class PantallaInicialMusicaController implements Initializable {

    @FXML
    private TextField browser;
    @FXML
    private Button cerrarsesion;
    @FXML
    private ImageView banner1;
    @FXML
    private ImageView banner3;
    @FXML
    private ImageView banner2;
    @FXML
    private ImageView lmp1;
    @FXML
    private ImageView lmp2;
    @FXML
    private ImageView lmp3;
    @FXML
    private ImageView lmp4;
    @FXML
    private Label correo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void irPeliculas(ActionEvent event) {
    }

    @FXML
    private void irMusicales(ActionEvent event) {
    }

    @FXML
    private void irResultadoBusqueda(ActionEvent event) {
    }

    @FXML
    private void retroceder(ActionEvent event) {
    }
    
}
