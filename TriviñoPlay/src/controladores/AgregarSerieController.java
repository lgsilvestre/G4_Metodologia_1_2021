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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
    private ComboBox<Serie> comboBoxSeries;
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

    private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";
    
    private File seleccionArchivo;
    private File seleccionImagen;
    
    private final FileChooser.ExtensionFilter all = new FileChooser.ExtensionFilter("Todos los archivos","*.*");
    private final FileChooser.ExtensionFilter video1 = new FileChooser.ExtensionFilter("Archivo mp4","*mp4");
    private final FileChooser.ExtensionFilter video2 = new FileChooser.ExtensionFilter("Archivo avi","*avi");
    
    private final FileChooser.ExtensionFilter imagen1 = new FileChooser.ExtensionFilter("Archivo jpg","*jpg");
    private final FileChooser.ExtensionFilter imagen2 = new FileChooser.ExtensionFilter("Archivo jpg","*jpeg");
    private final FileChooser.ExtensionFilter imagen3 = new FileChooser.ExtensionFilter("Archivo png","*png");
    @FXML
    private Label labelDireccionArchivo;
   
    Serie serieElegida;
    Episodio episodioNuevo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.checkBoxNuevo.setSelected(true);
        this.comboBoxSeries.setDisable(true);
        this.campoFechaSerie.setValue(LocalDate.now());
        this.campoFechaEpisodio.setValue(LocalDate.now());
    }

    public void iniciarAtributos(ObservableList Series){
        this.comboBoxSeries.setItems(Series);
    }

    @FXML
    private void nuevaSerie(ActionEvent event) {
        if (this.checkBoxNuevo.isSelected()){
            this.campoTituloSerie.setDisable(false);
            this.campoGeneroSerie.setDisable(false);
            this.campoFechaSerie.setDisable(false);
            this.campoDescripcionSerie.setDisable(false);
            this.botonElegirImagen.setDisable(false);
            this.comboBoxSeries.setDisable(true);
        }else {
            this.campoTituloSerie.setDisable(true);
            this.campoGeneroSerie.setDisable(true);
            this.campoFechaSerie.setDisable(true);
            this.campoDescripcionSerie.setDisable(true);
            this.botonElegirImagen.setDisable(true);
            this.comboBoxSeries.setDisable(false);
        }
    }

    @FXML
    private void elegirImagen(ActionEvent event) {
        Stage emergente = new Stage();
        FileChooser elector = new FileChooser();
        elector.getExtensionFilters().addAll(imagen1,imagen2, imagen3,all);        
        
        seleccionImagen = elector.showOpenDialog(emergente);        
        
        if (seleccionImagen != null){
            this.labelDireccionImagen.setText(seleccionImagen.getAbsolutePath());
        }
    }
    
    @FXML
    private void elegirArchivo(ActionEvent event) {
        Stage emergente = new Stage();
        FileChooser elector = new FileChooser();
        elector.getExtensionFilters().addAll(video1,video2,all);
        
        seleccionArchivo = elector.showOpenDialog(emergente);
        
        if (seleccionArchivo != null){
            this.labelDireccionArchivo.setText(seleccionArchivo.getAbsolutePath());
        }
    }
    
    @FXML
    private void cambioSeleccion(ActionEvent event) {
    }

    @FXML
    private void agregarSerieEpisodio(ActionEvent event) {
        if (this.checkBoxNuevo.isSelected()){
            String tituloSerie = this.campoTituloSerie.getText().trim();
            String generoSerie = this.campoGeneroSerie.getText().trim();
            String fechaSerie = this.campoFechaSerie.getValue().toString().trim();
            String portadaSerie = this.labelDireccionImagen.getText().trim();
            String descripcionSerie = this.campoDescripcionSerie.getText().trim();
            int reproduccionesSerie = 0;
            
            Serie serieComprobar = new Serie(tituloSerie,generoSerie,fechaSerie,portadaSerie,reproduccionesSerie,descripcionSerie);
            
            if (comprobarExistenciaSerie(serieComprobar)){
                this.serieElegida = serieComprobar;
                asignarEpisodio(true);
            }else{
                asignarEpisodio(false);
            }
        }else{
            this.serieElegida = this.comboBoxSeries.getSelectionModel().getSelectedItem();
            if (serieElegida == null || serieElegida.getTitulo()==null){
                this.serieElegida = new Serie("","","1-1-1","",0,"");
            }
            asignarEpisodio(true);
        }
    }
    
    private void asignarEpisodio(boolean valido){
        String tituloEpisodio = this.campoTituloEpisodio.getText().trim();
        String generoEpisodio = this.serieElegida.getGenero();
        String fechaEpisodio = this.campoFechaEpisodio.getValue().toString().trim();
        String portadaEpisodio = this.serieElegida.getDireccionPortada();
        String archivoEpisodio = this.labelDireccionArchivo.getText().trim();
        String serieEpisodio = this.serieElegida.getTitulo();
        int numeroEpisodio;
        int reproduccionesEpisodio = 0;
        try{
            numeroEpisodio = Integer.parseInt(this.campoNumeroEpisodio.getText().trim());
        }catch(NumberFormatException e){
            numeroEpisodio =-1;
        }
        Episodio comprobarEpisodio = new Episodio(tituloEpisodio, generoEpisodio, fechaEpisodio, portadaEpisodio, reproduccionesEpisodio, archivoEpisodio, serieEpisodio, numeroEpisodio);
        
        if (comprobarExistenciaEpisodio(comprobarEpisodio) && valido){
            this.episodioNuevo = comprobarEpisodio;
            Alert confirmacion = new Alert (Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Agregado");
            confirmacion.setContentText("Se ha ingresado el episodio y serie correctamente");
            confirmacion.showAndWait();
            
            Stage stage = (Stage) this.botonAgregar.getScene().getWindow();
            stage.close();
        }else{
            Alert error = new Alert (Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle("Error!");
            error.setContentText("Hay un campo vacio o un elemento mal ingresado (valor repetido), favor llenar correctamente los datos");
            error.showAndWait();
        }      
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stageAgregarPelicula = (Stage) botonCancelar.getScene().getWindow();
        stageAgregarPelicula.close();
    }

    @FXML
    private void fueraImagen(MouseEvent event) {
        this.botonElegirImagen.setStyle(colorFuera);
    }

    @FXML
    private void sobreImagen(MouseEvent event) {
        this.botonElegirImagen.setStyle(colorSobre);
    }

    @FXML
    private void fueraArchivo(MouseEvent event) {
        this.botonElegirArchivo.setStyle(colorFuera);
    }

    @FXML
    private void sobreArchivo(MouseEvent event) {
        this.botonElegirArchivo.setStyle(colorSobre);
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
    private void fueraCancelar(MouseEvent event) {
        this.botonCancelar.setStyle(colorFuera);
    }

    @FXML
    private void sobreCancelar(MouseEvent event) {
        this.botonCancelar.setStyle(colorSobre);
    }
    
    
    private boolean comprobarExistenciaSerie(Serie serie) {
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
    
    private boolean comprobarExistenciaEpisodio(Episodio episodio) {
        if (episodio.getTitulo().equalsIgnoreCase("") ||
                episodio.getGenero().equalsIgnoreCase("") ||
                episodio.getFechaString().equalsIgnoreCase("") ||
                episodio.getDireccionPortada().equalsIgnoreCase("textoDireccion")||
                episodio.getDireccionArchivo().equalsIgnoreCase("textoDireccion") ||
                episodio.getSerie().equalsIgnoreCase("")||
                (episodio.getNumEpisodio() == -1)
                ){
            return false;
        }
        else {
            for (int i=0; i<this.serieElegida.getEpisodios().size(); i++){
                if (this.serieElegida.getEpisodios().get(i).getNumEpisodio()== episodio.getNumEpisodio()){
                    return false;
                }
            }
            return true;
        }        
    }
    
    public Episodio getEpisodioAgregado(){
        return this.episodioNuevo;
    }
    
    public Serie getSerieRelacionada(){
        return this.serieElegida;
    }
    
    
    
}
