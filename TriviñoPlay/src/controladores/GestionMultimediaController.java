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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class GestionMultimediaController implements Initializable {

    @FXML
    private Label labelNombreUsuario;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Button botonRetroceso;
    @FXML
    private ImageView imagenRetroceso;
    @FXML
    private ComboBox<?> comboBoxMultimedia;
    @FXML
    private Button botonAgregarCuenta;
    @FXML
    private Button botonEditarCuenta;
    @FXML
    private Button botonEliminarCuenta;
    @FXML
    private TableView<?> TablaMultimedia;
    @FXML
    private TableColumn<?, ?> colTitulo;
    @FXML
    private TableColumn<?, ?> colDirArchivo;
    @FXML
    private TableColumn<?, ?> colDirPortada;
    @FXML
    private TableColumn<?, ?> colNumeroReproduccion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fueraBotonRetroceso(MouseEvent event) {
    }

    @FXML
    private void sobreBotonRetroceso(MouseEvent event) {
    }

    @FXML
    private void retroceder(ActionEvent event) {
    }

    @FXML
    private void cambio(ActionEvent event) {
    }

    @FXML
    private void fueraBotonAgregar(MouseEvent event) {
    }

    @FXML
    private void sobreBotonAgregar(MouseEvent event) {
    }

    @FXML
    private void agregarCuenta(ActionEvent event) {
    }

    @FXML
    private void fueraBotonEditar(MouseEvent event) {
    }

    @FXML
    private void sobreBotonEditar(MouseEvent event) {
    }

    @FXML
    private void editarCuenta(ActionEvent event) {
    }

    @FXML
    private void fueraBotonEliminar(MouseEvent event) {
    }

    @FXML
    private void sobreBotonEliminar(MouseEvent event) {
    }

    @FXML
    private void eliminarCuenta(ActionEvent event) {
    }

    @FXML
    private void seleccion(MouseEvent event) {
    }
    
}
