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
import javafx.stage.Stage;
import logica.media.Pelicula;

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
    
    private Pelicula peliculaActual;
    private Pelicula peliculaNueva;
    
    private File seleccionArchivo;
    private File seleccionImagen;
    private final FileChooser.ExtensionFilter all = new FileChooser.ExtensionFilter("Todos los archivos","*.*");
    private final FileChooser.ExtensionFilter video1 = new FileChooser.ExtensionFilter("Archivo mp4","*mp4");
    private final FileChooser.ExtensionFilter video2 = new FileChooser.ExtensionFilter("Archivo avi","*avi");
    
    private final FileChooser.ExtensionFilter imagen1 = new FileChooser.ExtensionFilter("Archivo jpg","*jpg");
    private final FileChooser.ExtensionFilter imagen2 = new FileChooser.ExtensionFilter("Archivo jpg","*jpeg");
    private final FileChooser.ExtensionFilter imagen3 = new FileChooser.ExtensionFilter("Archivo png","*png");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void iniciarAtributos(Pelicula peliculaActual){
        this.peliculaActual = peliculaActual;
        // Elementos de la pelicula actual no modificables
        this.labelArchivoActual.setText(this.peliculaActual.getDireccionArchivo());
        this.labelImagenActual.setText(this.peliculaActual.getDireccionPortada());
        this.campoTituloActual.setText(this.peliculaActual.getTitulo());
        this.campoGeneroActual.setText(this.peliculaActual.getGenero());
        this.campoDirectorActual.setText(this.peliculaActual.getDirector());
        this.campoFechaActual.setValue(LocalDate.of(this.peliculaActual.getFecha()[0],this.peliculaActual.getFecha()[1], this.peliculaActual.getFecha()[2]));
        this.campoDescripcionActual.setText(this.peliculaActual.getDescripcion());
        
        // Elementos de la pelicula nueva modificables
        this.labelArchivoNuevo.setText(this.peliculaActual.getDireccionArchivo());
        this.labelImagenNuevo.setText(this.peliculaActual.getDireccionPortada());
        this.campoTituloNuevo.setText(this.peliculaActual.getTitulo());
        this.campoGeneroNuevo.setText(this.peliculaActual.getGenero());
        this.campoDirectorNuevo.setText(this.peliculaActual.getDirector());
        this.campoFechaNuevo.setValue(LocalDate.of(this.peliculaActual.getFecha()[0],this.peliculaActual.getFecha()[1], this.peliculaActual.getFecha()[2]));
        this.campoDescripcionNueva.setText(this.peliculaActual.getDescripcion());
        
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
            this.labelArchivoNuevo.setText(seleccionArchivo.getAbsolutePath());
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
            this.labelImagenNuevo.setText(seleccionImagen.getAbsolutePath());
        }
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
        String titulo = campoTituloNuevo.getText().trim();
        String genero = campoGeneroNuevo.getText().trim();
        String fecha = campoFechaNuevo.getValue().toString().trim();
        String direccionPortada = labelImagenNuevo.getText().trim();
        String direccionArchivo = labelArchivoNuevo.getText().trim();
        String director = campoDirectorNuevo.getText().trim();
        String descripcion = campoDescripcionNueva.getText().trim();
        int reproduccion = this.peliculaActual.getReproducciones();
                
        Pelicula comprobarPelicula = new Pelicula (titulo,genero,fecha,direccionPortada,reproduccion,direccionArchivo,director,descripcion);
        
        if (comprobarExistencia(comprobarPelicula)){
            this.peliculaNueva = comprobarPelicula;
            Alert confirmacion = new Alert (Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Agregado");
            confirmacion.setContentText("Se ha ingresado la pelicula correctamente");
            confirmacion.showAndWait();
            
            Stage stage = (Stage) this.botonModificar.getScene().getWindow();
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
    
    public Pelicula getPeliculaModificada(){
        return this.peliculaNueva;
    }
    
}
