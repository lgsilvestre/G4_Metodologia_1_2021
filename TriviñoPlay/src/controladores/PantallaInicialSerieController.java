/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.GestorDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logica.Contenido;
import logica.Cuenta;
import logica.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Admn
 */
public class PantallaInicialSerieController implements Initializable {
    
    Contenido listas = new Contenido() {};
    
    private ObservableList<Cuenta> cuentas;
    
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
    private Label correo;
    @FXML
    private Text nombreUser;
    @FXML
    private ImageView UltimaSerieAgregada1;
    @FXML
    private ImageView UltimaSerieAgregada2;
    @FXML
    private ImageView UltimaSerieAgregada3;
    @FXML
    private ImageView UltimaSerieAgregada4;
    @FXML
    private ImageView UltimaSerieAgregada5;
    @FXML
    private ImageView UltimaSerieAgregada6;
    @FXML
    private ImageView UltimaSerieAgregada7;
    @FXML
    private ImageView UltimaSerieAgregada8;
    
    
    
    

    
    
    
    
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
        
        
        
        
        bannersSeries();
        SeriesAgregadasRecientemente();
        SeriesMasPopulares();
        //listas.getAutor();
        //System.out.println(listas.getAutor());
        //System.out.println("hola");
        
        
    }
    
    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada){
        this.gestorDatos=gestorDatos;
        this.logDatos=logDatos;
        setImagenUsuario();

        
        this.heredado=elementoVentanaHeredada;
    }
    
    private void setImagenUsuario() {
        Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        nombreUser.setText(this.logDatos.getCuentaActiva().getNombre());
    }

    private void accionImagen() {
        nombreUser.setText(this.logDatos.getCuentaActiva().getNombre());
        System.out.println(logDatos.getCuentaActiva().getNombre());
    }

    @FXML
    private void retroceder(ActionEvent event) {
        Stage stageUser = (Stage) this.cerrarsesion.getScene().getWindow();
        this.logDatos.salirCuenta();
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
    public static void cambiarVista(ActionEvent e, Parent vistaNueva) {
        
        
        Scene nuevaEscena;
        nuevaEscena = new Scene(vistaNueva);
        Stage vistaActual;
        vistaActual = (Stage) ((Node) e.getSource()).getScene().getWindow();
        vistaActual.setScene(nuevaEscena);
    }
    
    
    @FXML
    private void irPeliculas(ActionEvent event) throws IOException {
        
        Parent vista;
        vista = (AnchorPane) FXMLLoader.load(getClass().getResource("/vistas/PantallaInicial.fxml"));
        cambiarVista(event, vista);
        
    
    }

    @FXML
    private void irMusicales(ActionEvent event) throws IOException {  
        Parent vista;
        vista = (AnchorPane) FXMLLoader.load(getClass().getResource("/vistas/PantallaInicialMusica.fxml"));
        cambiarVista(event, vista);
    
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
    
    

    public void bannersSeries() {
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

                    izq = new Image("/recursos/Imagenes/Miniaturas/Series/banner" + izquierda + "Series.png");
                    slide = new Image("/recursos/Imagenes/Miniaturas/Series/banner" + medio + "Series.png");
                    der = new Image("/recursos/Imagenes/Miniaturas/Series/banner" + derecho + "Series.png");

                    Image i2 = new Image("/recursos/Imagenes/Miniaturas/Series/bannerHover" + medio + "Series.png");
                    Image i3 = new Image("/recursos/Imagenes/Miniaturas/Series/banner" + medio + "Series.png");

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

    int j = 3;
    
    
    public void SeriesMasPopulares(){
        
        Image im1 = null;
        Image im2 = null;
        Image im3 = null;
        Image im4 = null;

        im1 = new Image("/recursos/Imagenes/Miniaturas/Series/lmn" + 1 + ".png");
        lmp1.setImage(im1);

        lmp1.setOnMouseEntered(e -> {
            System.out.println("Sobre1");
        });

        im2 = new Image("/recursos/Imagenes/Miniaturas/Series/lmn" + 2 + ".png");
        lmp2.setImage(im2);
        lmp2.setOnMouseEntered(e -> {
            System.out.println("Sobre2");
        });

        im3 = new Image("/recursos/Imagenes/Miniaturas/Series/lmn" + 3 + ".png");
        lmp3.setImage(im3);
        lmp3.setOnMouseEntered(e -> {
            System.out.println("Sobre3");
        });

        im4 = new Image("/recursos/Imagenes/Miniaturas/Series/lmn" + 4 + ".png");
        lmp4.setImage(im4);
        lmp4.setOnMouseEntered(e -> {
            System.out.println("Sobre4");
        });
        
    }
    
    
    
    
    public void SeriesAgregadasRecientemente(){
        Image Usa1 = null;
        Image Usa2 = null;
        Image Usa3 = null;
        Image Usa4 = null;
        Image Usa5 = null;
        Image Usa6 = null;
        Image Usa7 = null;
        Image Usa8 = null;

        Usa1 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 1 + ".png");
        UltimaSerieAgregada1.setImage(Usa1);

        UltimaSerieAgregada1.setOnMouseEntered(e -> {
            System.out.println("Sobre1");
        });

        Usa2 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 2 + ".png");
        UltimaSerieAgregada2.setImage(Usa2);
        UltimaSerieAgregada2.setOnMouseEntered(e -> {
            System.out.println("Sobre2");
        });

        Usa3 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 3 + ".png");
        UltimaSerieAgregada3.setImage(Usa3);
        UltimaSerieAgregada3.setOnMouseEntered(e -> {
            System.out.println("Sobre3");
        });

        Usa4 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 4 + ".png");
        UltimaSerieAgregada4.setImage(Usa4);
        UltimaSerieAgregada4.setOnMouseEntered(e -> {
            System.out.println("Sobre4");
        });
        
        Usa5 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 5 + ".png");
        UltimaSerieAgregada5.setImage(Usa5);
        UltimaSerieAgregada5.setOnMouseEntered(e -> {
            System.out.println("Sobre5");
        });
        
        Usa6 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 6 + ".png");
        UltimaSerieAgregada6.setImage(Usa6);
        UltimaSerieAgregada6.setOnMouseEntered(e -> {
            System.out.println("Sobre6");
        });
        
        Usa7 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 7 + ".png");
        UltimaSerieAgregada7.setImage(Usa7);
        UltimaSerieAgregada7.setOnMouseEntered(e -> {
            System.out.println("Sobre7");
        });
        
        Usa8 = new Image("/recursos/Imagenes/Miniaturas/Series/UltimasSerieAgregadas" + 8 + ".png");
        UltimaSerieAgregada8.setImage(Usa8);
        UltimaSerieAgregada8.setOnMouseEntered(e -> {
            System.out.println("Sobre8");
        });
        
    }
    
    
    
    
}
