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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import logica.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Admn
 */
public class PantallaInicialController implements Initializable {
    
    @FXML
    private Label labelNombreUsuario;

    @FXML
    private TextField browser;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private GridPane grid2;
    @FXML
    private GridPane grid1;

    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    
    private Button heredado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void irSeries(ActionEvent event) {
    }

    @FXML
    private void irPeliculas(ActionEvent event) {
    }

    @FXML
    private void irMusicales(ActionEvent event) {
    }

    @FXML
    private void irDocumentales(ActionEvent event) {
    }

    @FXML
    private void irResultadoBusqueda(ActionEvent event) {
    }

    /*public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada) {
        this.gestorDatos = gestorDatos;
        this.logDatos = logDatos;
        setImagenUsuario();

        this.heredado = elementoVentanaHeredada;
    }
    
    private void setImagenUsuario() {
        Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        imagenPerfil.setImage(imagen);
        labelNombreUsuario.setText(this.logDatos.getCuentaActiva().getNombre());
    }*/

}
