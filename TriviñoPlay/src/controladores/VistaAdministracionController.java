/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorDatos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logica.UsuarioLog;

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
    
    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos){
        this.gestorDatos=gestorDatos;
        this.logDatos=logDatos;
        setImagenUsuario();
    }

    @FXML
    private void retroceder(ActionEvent event) {
    }

    @FXML
    private void gestionarCuentas(ActionEvent event) {
    }

    @FXML
    private void gestionarMultimedia(ActionEvent event) {
        System.out.println("Gestion Multimedia");
    }
    
    private void setImagenUsuario() {
        System.out.println(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        imagenPerfil.setImage(imagen);
        labelNombreUsuario.setText(this.logDatos.getCuentaActiva().getNombre());
    }
}
