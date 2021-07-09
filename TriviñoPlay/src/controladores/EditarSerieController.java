/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import logica.media.Episodio;
import logica.media.Serie;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class EditarSerieController implements Initializable {

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
    
    private Serie serieActual;
    private Serie serieNueva;
    
    ArrayList<Episodio> cambioEpisodios;
    
    private File seleccionImagen;
    private final FileChooser.ExtensionFilter all = new FileChooser.ExtensionFilter("Todos los archivos","*.*");
    private final FileChooser.ExtensionFilter imagen1 = new FileChooser.ExtensionFilter("Archivo jpg","*jpg");
    private final FileChooser.ExtensionFilter imagen2 = new FileChooser.ExtensionFilter("Archivo jpg","*jpeg");
    private final FileChooser.ExtensionFilter imagen3 = new FileChooser.ExtensionFilter("Archivo png","*png");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cambioEpisodios = new ArrayList<>();
    }

    public void iniciarAtributos(Serie serieModificar){
        this.serieActual=serieModificar;
        
        this.campoTituloActual.setText(this.serieActual.getTitulo());
        this.campoGeneroActual.setText(this.serieActual.getGenero());
        this.campoFechaActual.setValue(LocalDate.of(this.serieActual.getFecha()[0], this.serieActual.getFecha()[1], this.serieActual.getFecha()[2]));
        this.labelImagenActual.setText(this.serieActual.getDireccionPortada());
        this.campoDescripcionActual.setText(this.serieActual.getDescripcion());
        
        this.campoTituloNuevo.setText(this.serieActual.getTitulo());
        this.campoGeneroNuevo.setText(this.serieActual.getGenero());
        this.campoFechaNuevo.setValue(LocalDate.of(this.serieActual.getFecha()[0], this.serieActual.getFecha()[1], this.serieActual.getFecha()[2]));
        this.labelImagenNuevo.setText(this.serieActual.getDireccionPortada());
        this.campoDescripcionNueva.setText(this.serieActual.getDescripcion());
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
            this.labelImagenNuevo.setText(seleccionImagen.getAbsolutePath());
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
        String genero = campoGeneroNuevo.getText().trim();
        String fecha = campoFechaNuevo.getValue().toString().trim();
        String direccionPortada = labelImagenNuevo.getText().trim();
        String descripcion = campoDescripcionNueva.getText().trim();
        int reproduccion = this.serieActual.getReproducciones();
        
                
        Serie comprobarSerie = new Serie (titulo,genero,fecha,direccionPortada,reproduccion,descripcion);
        cambiarRelacionEpisodios(titulo);
        comprobarSerie.setEpisodios(this.cambioEpisodios);
        
        if (comprobarExistencia(comprobarSerie)){
            this.serieNueva = comprobarSerie;
            Alert confirmacion = new Alert (Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Modificado");
            confirmacion.setContentText("Se ha modificado la serie correctamente");
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
        Stage stageActual = (Stage) botonCancelar.getScene().getWindow();
        stageActual.close();
    }
    
    private boolean comprobarExistencia(Serie serie) {
        if (serie.getTitulo().equalsIgnoreCase("") ||
                serie.getGenero().equalsIgnoreCase("") ||
                serie.getFechaString().equalsIgnoreCase("") ||
                serie.getDireccionPortada().equalsIgnoreCase("textoDireccion")||
                serie.getDescripcion().equalsIgnoreCase("")
                ){
            return false;
        }
        else {
            return true;
        }        
    }
    
    public Serie getSerieModificada(){
        return this.serieNueva;
    }

    private void cambiarRelacionEpisodios(String titulo) {
        for(int i=0; i<this.serieActual.getEpisodios().size();i++){
            this.cambioEpisodios.add(this.serieActual.getEpisodios().get(i));
            this.cambioEpisodios.get(i).setSerie(titulo);
        }
        
    }
    
}
