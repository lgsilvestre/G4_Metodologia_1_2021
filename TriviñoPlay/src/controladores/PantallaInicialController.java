/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import logica.Contenido;
import logica.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Admn
 */
public class PantallaInicialController implements Initializable {

    Contenido listas = new Contenido() {
    };

    @FXML
    private TextField browser;

    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;

    private Button heredado;
    @FXML
    private ImageView banner2;
    Timer movimiento = new Timer();
    @FXML
    private ImageView banner3;
    @FXML
    private ImageView banner1;
    @FXML
    private ImageView lmp1;
    @FXML
    private ImageView lmp3;
    @FXML
    private ImageView lmp4;
    @FXML
    private ImageView lmp2;
    @FXML
    private Button cerrarsesion;
    @FXML
    private Label correo;

    FXMLLoader loaderGestion;
    @FXML
    private Button botonSerie;
    @FXML
    private Button botonPeliculas;
    @FXML
    private Button botonMusica;

    public void cargarIconos() {
        for (int i = 1; i < 7; i++) {
            ImageView imagen = null;// Se inicializa una imageView para usarlo como miniatura
            // Se carga la miniatura de la serie

            imagen = new ImageView("/recursos/Imagenes/Miniaturas/Lomasnuevo/Lanana.png");
        }
    }

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //bannersSeries();
        //Peliculaslomaspopular();
        listas.getAutor();
        System.out.println(listas.getAutor());
        System.out.println("hola");

    }

    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada) {
        this.gestorDatos = gestorDatos;
        this.logDatos = logDatos;
        setCorreoUsuario();
        this.heredado = elementoVentanaHeredada;
        
    }

    private void setCorreoUsuario() {
        //Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        correo.setText(this.logDatos.getCuentaActiva().getNombre());  
    }

    @FXML
    private void retroceder(ActionEvent event) {
        Stage stageUser = (Stage) this.cerrarsesion.getScene().getWindow();
        //this.logDatos.salirCuenta();
        stageUser.close();

        Stage retorno = (Stage) this.heredado.getScene().getWindow();
        retorno.show();
    }

    /**
     * Metodo que se encarga de cambiar de una escena a otra dentro de la
     * plataforma.
     *
     * @param e
     * @param vistaNueva
     */
    /*public static void cambiarVista(ActionEvent e, Parent vistaNueva) {
        Scene nuevaEscena;
        nuevaEscena = new Scene(vistaNueva);
        Stage vistaActual;
        vistaActual = (Stage) ((Node) e.getSource()).getScene().getWindow();
        vistaActual.setScene(nuevaEscena);
    }*/
    @FXML
    private void irPeliculas(ActionEvent event) {
        System.out.println("LOGDATOS");
    }

    @FXML
    private void irSeries(ActionEvent event) throws IOException {
        /*Parent vista;
        vista = (AnchorPane) FXMLLoader.load(getClass().getResource("/vistas/PantallaInicialSerie.fxml"));
        cambiarVista(event, vista);*/
        
        System.out.println(this.logDatos.getCuentaActiva().getNombre());
        loaderGestion = new FXMLLoader(getClass().getResource("/vistas/PantallaInicialSerie.fxml"));
        
        try {
            Parent raiz = loaderGestion.load();

            PantallaInicialSerieController controlador = loaderGestion.getController();
            controlador.iniciarAtributos(this.gestorDatos, this.logDatos, this.botonSerie);

            Scene escenaSeries = new Scene(raiz);
            Stage stage = new Stage();
            stage.setTitle("Series");
            stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));

            Stage ventanaInicial = (Stage) this.cerrarsesion.getScene().getWindow();
            ventanaInicial.hide();

            stage.setScene(escenaSeries);
            stage.show();

        } catch (IOException ex) {

        }

    }

    @FXML
    private void irMusicales(ActionEvent event) {
    }

    @FXML
    private void irResultadoBusqueda(ActionEvent event) {
    }

    int medio = 0;
    int derecho = 0;
    int izquierda = 0;

    /**
     * Metodo para que los banners en pantalla se vean en movimiento
     */

    /*public void bannersSeries() {
        long delay = 4000;
        movimiento.schedule(new TimerTask() {
            @Override
            public void run() {

                if (j < 5) {
                    Image izq = null;
                    Image slide = null;
                    Image der = null;

                    switch (j) {
                        case 1:

                            medio = 1;
                            derecho = 2;
                            izquierda = 4;
                            break;
                        case 2:

                            medio = 2;
                            derecho = 3;
                            izquierda = 1;
                            break;
                        case 3:

                            medio = 3;
                            derecho = 4;
                            izquierda = 2;
                            break;
                        case 4:

                            medio = 4;
                            derecho = 1;
                            izquierda = 3;
                            break;
                        default:
                            break;
                    }

                    //Cargar Banners
                    System.out.println("cargando siguiente banner");

                    izq = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/banner" + izquierda + ".png");
                    slide = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/banner" + medio + ".png");
                    der = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/banner" + derecho + ".png");

                    Image i2 = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/bannerHover" + medio + ".png");
                    Image i3 = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/banner" + medio + ".png");

                    banner1.setImage(slide);
                    banner1.setOnMouseEntered(e -> {

                        banner1.setImage(i2);
                        System.out.println("Sobre");
                    }
                    );
                    banner1.setOnMouseExited(e -> {
                        System.out.println("Salir");
                        banner1.setImage(i3);

                    });
                    banner1.setOnMouseClicked(e -> {
                        System.out.println("Presionado");

                        //contenidoBanner(medio, e);
                    });

                    banner2.setImage(izq);
                    banner1.translateXProperty().set(700);
                    banner3.setImage(der);

                    Timeline time = new Timeline();
                    KeyValue k = new KeyValue(banner1.translateXProperty(), 0, Interpolator.EASE_IN);
                    KeyFrame f = new KeyFrame(Duration.seconds(1), k);
                    time.getKeyFrames().add(f);
                    time.play();

                    banner2.translateXProperty().set(700);

                    Timeline time2 = new Timeline();
                    KeyValue k2 = new KeyValue(banner2.translateXProperty(), 0, Interpolator.EASE_IN);
                    KeyFrame f2 = new KeyFrame(Duration.seconds(1), k2);
                    time2.getKeyFrames().add(f2);
                    time2.play();

                    j++;
                    if (j >= 5) {
                        j = 1;
                    }
                }
            }
        }, 0, delay);
        
    }

    int j = 3;*/
    

    public void Peliculaslomaspopular() {
        Image im1 = null;
        Image im2 = null;
        Image im3 = null;
        Image im4 = null;

        im1 = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/lmn" + 1 + ".png");
        lmp1.setImage(im1);

        lmp1.setOnMouseEntered(e -> {
            System.out.println("Sobre1");
        });

        im2 = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/lmn" + 2 + ".png");
        lmp2.setImage(im2);
        lmp2.setOnMouseEntered(e -> {
            System.out.println("Sobre2");
        });

        im3 = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/lmn" + 3 + ".png");
        lmp3.setImage(im3);
        lmp3.setOnMouseEntered(e -> {
            System.out.println("Sobre3");
        });

        im4 = new Image("/recursos/Imagenes/Miniaturas/Lomasnuevo/lmn" + 4 + ".png");
        lmp4.setImage(im4);
        lmp4.setOnMouseEntered(e -> {
            System.out.println("Sobre4");
        });

    }

    public void cerrarsesion() {

    }

    public void usuario() {

    }
}
