/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class AgregarSerieController implements Initializable {

    @FXML
    private CheckBox checkBoxNuevo;
    @FXML
    private TextField campoTituloSerie;
    @FXML
    private TextField campoGeneroSerie;
    @FXML
    private DatePicker campoFechaSerie;
    @FXML
    private Button botonElegirImagen;
    @FXML
    private Label labelDireccionImagen;
    @FXML
    private TextArea campoDescripcionSerie;
    @FXML
    private ComboBox<?> comboBoxSeries;
    @FXML
    private TextField campoTituloEpisodio;
    @FXML
    private DatePicker campoFechaEpisodio;
    @FXML
    private Button botonElegirArchivo;
    @FXML
    private TextField campoNumeroEpisodio;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void iniciarAtributos(ObservableList Series){
        this.comboBoxSeries.setItems(Series);
    }

    @FXML
    private void nuevaSerie(ActionEvent event) {
    }

    @FXML
    private void elegirImagen(ActionEvent event) {
    }

    @FXML
    private void cambioSeleccion(ActionEvent event) {
    }

    @FXML
    private void agregarSerieEpisodio(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
}
