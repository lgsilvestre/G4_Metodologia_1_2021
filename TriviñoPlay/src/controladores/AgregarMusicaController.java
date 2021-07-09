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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logica.media.Musica;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class AgregarMusicaController implements Initializable {

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
    private TextField campoGenero;
    @FXML
    private DatePicker campoFecha;
    @FXML
    private TextField campoArtista;
    @FXML
    private TextField campoAlbum;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonCancelar;
    
    private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";
    
    private File seleccionArchivo;
    private File seleccionImagen;
    
    private final FileChooser.ExtensionFilter all = new FileChooser.ExtensionFilter("Todos los archivos","*.*");
    private final FileChooser.ExtensionFilter musica1 = new FileChooser.ExtensionFilter("Archivo mp3","*mp3");
    private final FileChooser.ExtensionFilter musica2 = new FileChooser.ExtensionFilter("Archivo wav","*wav");
    
    private final FileChooser.ExtensionFilter imagen1 = new FileChooser.ExtensionFilter("Archivo jpg","*jpg");
    private final FileChooser.ExtensionFilter imagen2 = new FileChooser.ExtensionFilter("Archivo jpg","*jpeg");
    private final FileChooser.ExtensionFilter imagen3 = new FileChooser.ExtensionFilter("Archivo png","*png");
    
    private Musica nuevaMusica;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.campoFecha.setValue(LocalDate.now());
    }

    @FXML
    private void fueraArchivo(MouseEvent event) {
        this.botonArchivo.setStyle(colorFuera);
    }

    @FXML
    private void sobreArchivo(MouseEvent event) {
        this.botonArchivo.setStyle(colorSobre);
    }

    @FXML
    private void elegirArchivo(ActionEvent event) {
        Stage emergente = new Stage();
        FileChooser elector = new FileChooser();
        elector.getExtensionFilters().addAll(musica1,musica2,all);
        
        seleccionArchivo = elector.showOpenDialog(emergente);
        
        if (seleccionArchivo != null){
            labelArchivo.setText(seleccionArchivo.getAbsolutePath());
        }
    }

    @FXML
    private void fueraImagen(MouseEvent event) {
        this.botonImagen.setStyle(colorFuera);
    }

    @FXML
    private void sobreImagen(MouseEvent event) {
        this.botonImagen.setStyle(colorSobre);
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
        this.botonAgregar.setStyle(colorFuera);
    }

    @FXML
    private void sobreAgregar(MouseEvent event) {
        this.botonAgregar.setStyle(colorSobre);
    }

    @FXML
    private void agregar(ActionEvent event){
        String titulo = campoTitulo.getText().trim();
        String genero = campoGenero.getText().trim();
        String fecha = campoFecha.getValue().toString().trim();
        String direccionPortada = labelImagen.getText().trim();
        String direccionArchivo = labelArchivo.getText().trim();
        String artista = campoArtista.getText().trim();
        String album = campoAlbum.getText().trim();
        int reproduccion = 0;
        
        Musica comprobarMusica = new Musica(titulo,genero,fecha,direccionPortada,reproduccion,direccionArchivo,album,artista);
        
         if (comprobarExistencia(comprobarMusica)){
            this.nuevaMusica = comprobarMusica;
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
        this.botonCancelar.setStyle(colorFuera);
    }

    @FXML
    private void sobreCancelar(MouseEvent event) {
        this.botonCancelar.setStyle(colorSobre);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stageAgregarPelicula = (Stage) botonCancelar.getScene().getWindow();
        stageAgregarPelicula.close();
    }
    
    private boolean comprobarExistencia(Musica musica) {
        if (musica.getTitulo().equalsIgnoreCase("") ||
                musica.getGenero().equalsIgnoreCase("") ||
                musica.getFechaString().equalsIgnoreCase("") ||
                musica.getDireccionPortada().equalsIgnoreCase("textoDireccion")||
                musica.getDireccionArchivo().equalsIgnoreCase("textoDireccion") ||
                musica.getAlbum().equalsIgnoreCase("")||
                musica.getAlbum().equalsIgnoreCase("")
                ){
            return false;
        }
        else {
            return true;
        }        
    }
    
    public Musica getMusicaAgregada(){
        return this.nuevaMusica;
    }
    
}
