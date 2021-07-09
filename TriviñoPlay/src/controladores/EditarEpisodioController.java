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
public class EditarEpisodioController implements Initializable {

    @FXML
    private Label labelArchivoActual;
    @FXML
    private Button botonArchivo;
    @FXML
    private Label labelArchivoNuevo;
    @FXML
    private TextField campoTituloActual;
    @FXML
    private TextField campoTituloNuevo;
    @FXML
    private TextField campoNumeroActual;
    @FXML
    private TextField campoNumeroNuevo;
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
    
    private Serie serieSeleccionada;
    private Serie serieEpisodiosMod;
    private Episodio episodioActual;
    private Episodio episodioNuevo;
    
    private File seleccionArchivo;
    private final FileChooser.ExtensionFilter all = new FileChooser.ExtensionFilter("Todos los archivos","*.*");
    private final FileChooser.ExtensionFilter video1 = new FileChooser.ExtensionFilter("Archivo mp4","*mp4");
    private final FileChooser.ExtensionFilter video2 = new FileChooser.ExtensionFilter("Archivo avi","*avi");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void iniciarAtributos(Serie serieElegida, Episodio episodioElegido){
        this.serieSeleccionada = serieElegida;
        this.episodioActual = episodioElegido;
        
        this.campoTituloActual.setText(this.episodioActual.getTitulo());
        this.campoFechaActual.setValue(LocalDate.of(this.episodioActual.getFecha()[0],this.episodioActual.getFecha()[1],this.episodioActual.getFecha()[2]));
        this.labelArchivoActual.setText(this.episodioActual.getDireccionArchivo());
        int numeroEp = this.episodioActual.getNumEpisodio();
        this.campoNumeroActual.setText(numeroEp+"");
        
        this.campoTituloNuevo.setText(this.episodioActual.getTitulo());
        this.campoFechaNuevo.setValue(LocalDate.of(this.episodioActual.getFecha()[0],this.episodioActual.getFecha()[1],this.episodioActual.getFecha()[2]));
        this.labelArchivoNuevo.setText(this.episodioActual.getDireccionArchivo());
        this.campoNumeroNuevo.setText(numeroEp+"");

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
    private void fueraModificar(MouseEvent event) {
        botonModificar.setStyle(colorFuera);
    }

    @FXML
    private void sobreModificar(MouseEvent event) {
        botonModificar.setStyle(colorSobre);
    }

    @FXML
    private void modificar(ActionEvent event) {
        String tituloEpisodio = this.campoTituloNuevo.getText().trim();
        String generoEpisodio = this.serieSeleccionada.getGenero();
        String fechaEpisodio = this.campoFechaNuevo.getValue().toString().trim();
        String portadaEpisodio = this.serieSeleccionada.getDireccionPortada();
        String archivoEpisodio = this.labelArchivoNuevo.getText().trim();
        String serieEpisodio = this.serieSeleccionada.getTitulo();
        int numeroEpisodio;
        int reproduccionesEpisodio = this.episodioActual.getReproducciones();
        try{
            numeroEpisodio = Integer.parseInt(this.campoNumeroNuevo.getText().trim());
        }catch(NumberFormatException e){
            numeroEpisodio =-1;
        }
        Episodio comprobarEpisodio = new Episodio(tituloEpisodio, generoEpisodio, fechaEpisodio, portadaEpisodio, reproduccionesEpisodio, archivoEpisodio, serieEpisodio, numeroEpisodio);
        
        if (comprobarExistenciaEpisodio(comprobarEpisodio)){
            this.episodioNuevo = comprobarEpisodio;
            Alert confirmacion = new Alert (Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Agregado");
            confirmacion.setContentText("Se ha modificado el episodio correctamente");
            confirmacion.showAndWait();
            cambiarEpisodios();
            Stage stage = (Stage) this.botonModificar.getScene().getWindow();
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
    private void fueraCancelar(MouseEvent event) {
        botonCancelar.setStyle(colorFuera);
    }

    @FXML
    private void sobreCancelar(MouseEvent event) {
        botonCancelar.setStyle(colorSobre);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stageActual = (Stage) botonCancelar.getScene().getWindow();
        stageActual.close();
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
            for (int i=0; i<this.serieSeleccionada.getEpisodios().size(); i++){
                if (!this.serieSeleccionada.getEpisodios().get(i).equals(this.episodioActual)
                        && this.serieSeleccionada.getEpisodios().get(i).getNumEpisodio()== episodio.getNumEpisodio()){
                    return false;
                }
            }
            return true;
        }        
    }
    
    private void cambiarEpisodios(){
        this.serieEpisodiosMod = this.serieSeleccionada;
        ArrayList<Episodio> nuevaListaEpisodios = new ArrayList<>();
        for (int i =0; i<this.serieEpisodiosMod.getEpisodios().size();i++){
            if (this.serieEpisodiosMod.getEpisodios().get(i).equals(this.episodioActual)){
                nuevaListaEpisodios.add(this.episodioNuevo);
            }else{
                nuevaListaEpisodios.add(this.serieEpisodiosMod.getEpisodios().get(i));
            }
        }
        this.serieEpisodiosMod.setEpisodios(nuevaListaEpisodios);
        
    }
    
    public Serie getEpisodioModificado(){
        return this.serieEpisodiosMod;
    }
}
