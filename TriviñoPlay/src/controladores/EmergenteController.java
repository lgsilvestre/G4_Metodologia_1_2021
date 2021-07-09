/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logica.media.Episodio;
import logica.media.Musica;
import logica.media.Serie;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class EmergenteController implements Initializable {

    @FXML
    private Label labelPregunta;
    @FXML
    private Button botonSerie;
    @FXML
    private Button botonEpisodio;

    private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";

    Serie serieElegida;
    Episodio episodioElegido;
    
    Serie serieNuevo;
    Episodio episodioNuevo;

    int opcion;

    FXMLLoader loaderEmergente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void iniciarAtributos(Integer opcion, Serie serieElegida, Episodio episodioElegido) {
        this.opcion = opcion;
        if (this.opcion == 1) {
            this.labelPregunta.setText("Seleccione elemento a editar:");
            this.episodioElegido = episodioElegido;
            this.serieElegida = serieElegida;
        } else {
            this.labelPregunta.setText("Seleccione elemento a eliminar:");
        }

    }

    @FXML
    private void fueraSerie(MouseEvent event) {
        this.botonSerie.setStyle(colorFuera);
    }

    @FXML
    private void sobreSerie(MouseEvent event) {
        this.botonSerie.setStyle(colorSobre);
    }

    @FXML
    private void presionarSerie(ActionEvent event) {
        if (this.opcion == 1) {
            try {
                loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/EditarSerie.fxml"));

                Parent raiz = loaderEmergente.load();

                EditarSerieController controlador = loaderEmergente.getController();
                controlador.iniciarAtributos(serieElegida);

                Scene escena = new Scene(raiz);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setTitle("Editar Serie");
                stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                stage.setScene(escena);

                stage.showAndWait();
                
                Serie serieModificada = controlador.getSerieModificada();
                if (serieModificada != null) {
                    this.serieNuevo=serieModificada;
                }
                Stage stageActual = (Stage) botonSerie.getScene().getWindow();
                stageActual.close();

            } catch (IOException e) {
            }
        } else {
            this.opcion=-1;
            Stage stageActual = (Stage) botonSerie.getScene().getWindow();
            stageActual.close();
        }
    }

    @FXML
    private void fueraEpisodio(MouseEvent event) {
        this.botonEpisodio.setStyle(colorFuera);
    }

    @FXML
    private void sobreEpisodio(MouseEvent event) {
        this.botonEpisodio.setStyle(colorSobre);
    }

    @FXML
    private void presionarEpisodio(ActionEvent event) {
        if (this.opcion == 1) {
            try {
                loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/EditarEpisodio.fxml"));

                Parent raiz = loaderEmergente.load();

                EditarEpisodioController controlador = loaderEmergente.getController();
                controlador.iniciarAtributos(serieElegida, episodioElegido);
                
                Scene escena = new Scene(raiz);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setTitle("Editar Episodio");
                stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                stage.setScene(escena);

                stage.showAndWait();
                
                Serie serieEpisodioModificado = controlador.getEpisodioModificado();
                if (serieEpisodioModificado != null) {
                    this.serieNuevo=serieEpisodioModificado;
                }
                Stage stageActual = (Stage) botonSerie.getScene().getWindow();
                stageActual.close();
                

            } catch (IOException e) {
            }
        }else{
            this.opcion = -2;
            Stage stageActual = (Stage) botonSerie.getScene().getWindow();
            stageActual.close();
        }
    }
    
    public Serie getSerieModificada(){
        return this.serieNuevo;
    }
    
    public Serie getEpisodioModificado(){
        return this.serieNuevo;
    }
    
    public int getOpcion(){
        return this.opcion;
    }

}
