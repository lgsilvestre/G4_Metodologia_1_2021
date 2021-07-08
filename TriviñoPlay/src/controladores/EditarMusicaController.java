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
import logica.media.Pelicula;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class EditarMusicaController implements Initializable {

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
    private TextField campoArtistaActual;
    @FXML
    private TextField campoArtistaNuevo;
    @FXML
    private TextField campoAlbumActual;
    @FXML
    private TextField campoAlbumNuevo;
    @FXML
    private TextField campoGeneroActual;
    @FXML
    private TextField campoGeneroNuevo;
    @FXML
    private DatePicker campoFechaActual;
    @FXML
    private DatePicker campoFechaNuevo;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCancelar;
    
     private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";
    
    private Musica musicaActual;
    private Musica musicaNueva;
    
    private File seleccionArchivo;
    private File seleccionImagen;
    
    private final FileChooser.ExtensionFilter all = new FileChooser.ExtensionFilter("Todos los archivos","*.*");
    private final FileChooser.ExtensionFilter musica1 = new FileChooser.ExtensionFilter("Archivo mp3","*mp3");
    private final FileChooser.ExtensionFilter musica2 = new FileChooser.ExtensionFilter("Archivo wav","*wav");
    
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
    
    public void iniciarAtributos(Musica musicaActual){
        this.musicaActual= musicaActual;
        
        // Elementos de la musica actual no modificables
        this.labelArchivoActual.setText(this.musicaActual.getDireccionArchivo());
        this.labelImagenActual.setText(this.musicaActual.getDireccionPortada());
        this.campoTituloActual.setText(this.musicaActual.getTitulo());
        this.campoArtistaActual.setText(this.musicaActual.getArtista());
        this.campoAlbumActual.setText(this.musicaActual.getAlbum());
        this.campoGeneroActual.setText(this.musicaActual.getGenero());
        this.campoFechaActual.setValue(LocalDate.of(this.musicaActual.getFecha()[0], this.musicaActual.getFecha()[1], this.musicaActual.getFecha()[2]));
        
        // Elementos de la musica nueva modificables
        this.labelArchivoNuevo.setText(this.musicaActual.getDireccionArchivo());
        this.labelImagenNuevo.setText(this.musicaActual.getDireccionPortada());
        this.campoTituloNuevo.setText(this.musicaActual.getTitulo());
        this.campoArtistaNuevo.setText(this.musicaActual.getArtista());
        this.campoAlbumNuevo.setText(this.musicaActual.getAlbum());
        this.campoGeneroNuevo.setText(this.musicaActual.getGenero());
        this.campoFechaNuevo.setValue(LocalDate.of(this.musicaActual.getFecha()[0], this.musicaActual.getFecha()[1], this.musicaActual.getFecha()[2]));
        
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
            labelArchivoNuevo.setText(seleccionArchivo.getAbsolutePath());
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
            labelImagenNuevo.setText(seleccionImagen.getAbsolutePath());
        }
    }

    @FXML
    private void fueraModificar(MouseEvent event) {
        this.botonModificar.setStyle(colorFuera);
    }

    @FXML
    private void sobreModificar(MouseEvent event) {
        this.botonModificar.setStyle(colorSobre);
    }

    @FXML
    private void modificar(ActionEvent event) {
        String titulo = campoTituloNuevo.getText().trim();
        String artista = campoArtistaNuevo.getText().trim();
        String album = campoAlbumNuevo.getText().trim();
        String genero = campoGeneroNuevo.getText().trim();
        String fecha = campoFechaNuevo.getValue().toString().trim();
        String direccionPortada = labelImagenNuevo.getText().trim();
        String direccionArchivo = labelArchivoNuevo.getText().trim();
        int reproduccion = this.musicaActual.getReproducciones();
                
        Musica comprobarMusica = new Musica (titulo,genero,fecha,direccionPortada,reproduccion,direccionArchivo,album,artista);
        
        if (comprobarExistencia(comprobarMusica)){
            this.musicaNueva = comprobarMusica;
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
        this.botonCancelar.setStyle(colorFuera);
    }

    @FXML
    private void sobreCancelar(MouseEvent event) {
        this.botonCancelar.setStyle(colorSobre);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stageModificarPelicula = (Stage) botonCancelar.getScene().getWindow();
        stageModificarPelicula.close();
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
    
    public Musica getMusicaModificada(){
        return this.musicaNueva;
    }
}
