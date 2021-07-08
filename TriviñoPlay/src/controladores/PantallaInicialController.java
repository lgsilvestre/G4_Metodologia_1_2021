/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorDatos;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import logica.Buscador;
import logica.UsuarioLog;
import logica.media.Musica;
import logica.media.Pelicula;
import logica.media.Serie;

/**
 * FXML Controller class
 *
 * @author Admn
 */
public class PantallaInicialController implements Initializable {
    
    @FXML
    private Label labelNombreUsuario;

    @FXML
    private TextField browser;
    
    @FXML
    private GridPane gridPelis;
    
    @FXML
    private GridPane gridSeries;
    
    @FXML
    private GridPane gridCanciones;
    
    private ImageView imagenPerfil;
    @FXML
    private GridPane grid2;
    @FXML
    private GridPane grid1;
    @FXML
    private ScrollPane browserPane;

    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    
    private Button heredado;
    
    private static final String PRINCIPAL_BOTON = ""
            + "-fx-background-color: transparent;"
            + "-fx-text-fill: transparent;"; //Estilo CSS para volver los botones del Gridpane transparentes.

    //Estilos css para los botones Hover del contenido multimedia
    private static final String HOVER_BOTON = ""
            + "-fx-background-color: black;\n"
            + "    -fx-opacity: 0.8;\n"
            + " -fx-border-color: black;";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void irSeries(ActionEvent event) {
    }

    @FXML
    private void irPeliculas(ActionEvent event) {
    }

    @FXML
    private void irMusicales(ActionEvent event) {
    }

    @FXML
    private void irDocumentales(ActionEvent event) {
    }

    @FXML
    private void irResultadoBusqueda(ActionEvent event) {
        GestorDatos datos = new GestorDatos();
        Buscador filtro = new Buscador(datos);
        List<Pelicula> pelisFiltradas = filtro.buscar(browser.getText()).get(0);
        List<Serie> seriesFiltradas = filtro.buscar(browser.getText()).get(1);
        List<Musica> cancionesFiltradas = filtro.buscar(browser.getText()).get(2);
        if (browser.getText().isEmpty()) {
            browserPane.setVisible(false);
        }
        else{           
            browserPane.setVisible(true);    
            for (int i = 0; i < pelisFiltradas.size(); i++) {
                ImageView imagen = new ImageView("recursos/Imagenes/Miniaturas/Peliculas/" + pelisFiltradas.get(i).getTitulo() + ".png");
                imagen.setFitWidth(110);
                imagen.setFitHeight(110);
                imagen.setFocusTraversable(true);
                imagen.setSmooth(true);
                gridPelis.add(imagen, i, 0);
            }
            for (int i = 0; i < seriesFiltradas.size(); i++) {
                ImageView imagen = new ImageView("recursos/Imagenes/Miniaturas/Series/" + seriesFiltradas.get(i).getTitulo() + ".png");
                imagen.setFitWidth(110);
                imagen.setFitHeight(110);
                imagen.setFocusTraversable(true);
                imagen.setSmooth(true);
                gridSeries.add(imagen, i, 0);
            }   
            for (int i = 0; i < cancionesFiltradas.size(); i++) {
                ImageView imagen = new ImageView("recursos/Imagenes/Miniaturas/Canciones/" + cancionesFiltradas.get(i).getTitulo() + ".png");
                imagen.setFitWidth(110);
                imagen.setFitHeight(110);
                imagen.setFocusTraversable(true);
                imagen.setSmooth(true);
                gridCanciones.add(imagen, i, 0);
            }   
        } 
    }

    /*public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada) {
        this.gestorDatos = gestorDatos;
        this.logDatos = logDatos;
        setImagenUsuario();

        this.heredado = elementoVentanaHeredada;
    }
    
    private void setImagenUsuario() {
        Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        imagenPerfil.setImage(imagen);
        labelNombreUsuario.setText(this.logDatos.getCuentaActiva().getNombre());
    }*/

}
