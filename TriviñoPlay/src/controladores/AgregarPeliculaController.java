/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import logica.media.Pelicula;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class AgregarPeliculaController implements Initializable {

    @FXML
    private Button botonArchivo;
    @FXML
    private Label labelArchivo;
    @FXML
    private Button botonImagen;
    @FXML
    private Label labelImagen;
    @FXML
    private TextField campoTitulo;
    @FXML
    private TextField campoDirector;
    @FXML
    private TextField campoGenero;
    @FXML
    private DatePicker campoFecha;
    @FXML
    private TextArea campoDescripcion;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonCancelar;
    
    private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";
    
    private File seleccionArchivo;
    private File seleccionImagen;
    private final ExtensionFilter all = new ExtensionFilter("Todos los archivos","*.*");
    private final ExtensionFilter video1 = new ExtensionFilter("Archivo mp4","*mp4");
    private final ExtensionFilter video2 = new ExtensionFilter("Archivo avi","*avi");
    
    private final ExtensionFilter imagen1 = new ExtensionFilter("Archivo jpg","*jpg");
    private final ExtensionFilter imagen2 = new ExtensionFilter("Archivo jpg","*jpeg");
    private final ExtensionFilter imagen3 = new ExtensionFilter("Archivo png","*png");
    
    private Pelicula nuevaPelicula;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campoFecha.setValue(LocalDate.now());
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
        Stage emergente = new Stage();
        FileChooser elector = new FileChooser();
        elector.getExtensionFilters().addAll(video1,video2,all);
        
        seleccionArchivo = elector.showOpenDialog(emergente);
        
        if (seleccionArchivo != null){
            labelArchivo.setText(seleccionArchivo.getAbsolutePath());
        }
        
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
        Stage emergente = new Stage();
        FileChooser elector = new FileChooser();
        elector.getExtensionFilters().addAll(imagen1,imagen2, imagen3,all);        
        
        seleccionImagen = elector.showOpenDialog(emergente);        
        
        if (seleccionImagen != null){
            labelImagen.setText(seleccionImagen.getAbsolutePath());
        }
        
    }

    @FXML
    private void fueraAgregar(MouseEvent event) {
        botonAgregar.setStyle(colorFuera);
    }

    @FXML
    private void sobreAgregar(MouseEvent event) {
        botonAgregar.setStyle(colorSobre);
    }

    @FXML
    private void agregar(ActionEvent event) {
        String titulo = campoTitulo.getText().trim();
        String genero = campoGenero.getText().trim();
        String fecha = campoFecha.getValue().toString().trim();
        String direccionPortada = labelImagen.getText().trim();
        String direccionArchivo = labelArchivo.getText().trim();
        String director = campoDirector.getText().trim();
        String descripcion = campoDescripcion.getText().trim();
        int reproduccion = 0;
                
        Pelicula comprobarPelicula = new Pelicula (titulo,genero,fecha,direccionPortada,reproduccion,direccionArchivo,director,descripcion);
        
        if (comprobarExistencia(comprobarPelicula)){
            this.nuevaPelicula = comprobarPelicula;
            Alert confirmacion = new Alert (Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Agregado");
            confirmacion.setContentText("Se ha ingresado la pelicula correctamente");
            confirmacion.showAndWait();
            
            Stage stage = (Stage) this.botonAgregar.getScene().getWindow();
            stage.close();
        }else{
            Alert error = new Alert (Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle("Error!");
            error.setContentText("Hay un campo vacio, favor rellenar todos los datos");
            error.showAndWait();
        }
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
       Stage stageAgregarPelicula = (Stage) botonCancelar.getScene().getWindow();
       stageAgregarPelicula.close();
    }
    
    private boolean comprobarExistencia(Pelicula pelicula) {
        if (pelicula.getTitulo().equalsIgnoreCase("") ||
                pelicula.getGenero().equalsIgnoreCase("") ||
                pelicula.getFechaString().equalsIgnoreCase("") ||
                pelicula.getDireccionPortada().equalsIgnoreCase("textoDireccion")||
                pelicula.getDireccionArchivo().equalsIgnoreCase("textoDireccion") ||
                pelicula.getDirector().equalsIgnoreCase("")||
                pelicula.getDescripcion().equalsIgnoreCase("")
                ){
            return false;
        }
        else {
            return true;
        }        
    }
    
    public Pelicula getPeliculaAgregada(){
        return this.nuevaPelicula;
    }
    
}
