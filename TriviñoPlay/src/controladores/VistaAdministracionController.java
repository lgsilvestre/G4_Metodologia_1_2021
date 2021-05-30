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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class VistaAdministracionController implements Initializable {

    @FXML
    private Label labelNombreUsuario;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Button botonRetroceso;
    @FXML
    private Button botonGestorCuentas;
    @FXML
    private Button botonGestorMultimedia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retroceder(ActionEvent event) {
    }

    @FXML
    private void gestionarCuentas(ActionEvent event) {
    }

    @FXML
    private void gestionarMultimedia(ActionEvent event) {
    }
    
    public void setImagenUsuario() {
        Image imagen = new Image("file:src/recursos/imagendefecto.jpg");
        imagenPerfil.setImage(imagen);
        labelNombreUsuario.setText("Matias el autoreferente");
    }
}
