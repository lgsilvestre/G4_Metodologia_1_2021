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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class EditarPeliculaController implements Initializable {

    @FXML
    private Label labelArchivoActual;
    @FXML
    private Button botonArchivo;
    @FXML
    private Label labelArchivoNuevo;
    @FXML
    private Label labelImagenActual;
    @FXML
    private Button botonImagen;
    @FXML
    private Label labelImagenNuevo;
    @FXML
    private TextField campoTituloActual;
    @FXML
    private TextField campoTituloNuevo;
    @FXML
    private TextField campoDirectorActual;
    @FXML
    private TextField campoDirectorNuevo;
    @FXML
    private TextField campoGeneroActual;
    @FXML
    private TextField campoGeneroNuevo;
    @FXML
    private DatePicker campoFechaActual;
    @FXML
    private DatePicker campoFechaNuevo;
    @FXML
    private TextArea campoDescripcionActual;
    @FXML
    private TextArea campoDescripcionNueva;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCancelar;
    
    private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fueraArchivo(MouseEvent event) {
        botonArchivo.setStyle(colorFuera);
    }

    @FXML
    private void sobreArchivo(MouseEvent event) {
        botonArchivo.setStyle(colorSobre);
    }

    @FXML
    private void elegirArchivo(ActionEvent event) {
        
    }

    @FXML
    private void fueraImagen(MouseEvent event) {
        botonImagen.setStyle(colorFuera);
    }

    @FXML
    private void sobreImagen(MouseEvent event) {
        botonImagen.setStyle(colorSobre);
    }

    @FXML
    private void elegirImagen(ActionEvent event) {
    }

    @FXML
    private void fueraModificar(MouseEvent event) {
        botonModificar.setStyle(colorFuera);
    }

    @FXML
    private void sobreModificar(MouseEvent event) {
        botonModificar.setStyle(colorSobre);
    }

    @FXML
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void fueraCancelar(MouseEvent event) {
        botonCancelar.setStyle(colorFuera);
    }

    @FXML
    private void sobreCancelar(MouseEvent event) {
        botonCancelar.setStyle(colorSobre);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        
    }
    
}
