/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static controladores.PantallaInicialController.cambiarVista;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logica.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Juan
 */
public class PantallaInicialMusicaController implements Initializable {

    
    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    
    Timer movimiento = new Timer();
    @FXML
    private TextField browser;
    @FXML
    private Button cerrarsesion;
    @FXML
    private ImageView banner1;
    @FXML
    private ImageView banner3;
    @FXML
    private ImageView banner2;
    @FXML
    private ImageView lmp1;
    @FXML
    private ImageView lmp2;
    @FXML
    private ImageView lmp3;
    @FXML
    private ImageView lmp4;
    
    FXMLLoader loaderGestion;
    @FXML
    private Text nombreUser;
    @FXML
    private ImageView UltimaCancionAgregada1;
    @FXML
    private ImageView UltimaCancionAgregada2;
    @FXML
    private ImageView UltimaCancionAgregada3;
    @FXML
    private ImageView UltimaCancionAgregada4;
    @FXML
    private ImageView UltimaCancionAgregada5;
    @FXML
    private ImageView UltimaCancionAgregada6;
    @FXML
    private ImageView UltimaCancionAgregada7;
    @FXML
    private ImageView UltimaCancionAgregada8;
    
    
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
        
        bannersMusicas();
        ultimasCancionesAgregadas();
        cancionesMasPopulares();
        
    }

    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada){
        this.gestorDatos=gestorDatos;
        this.logDatos=logDatos;   
         System.out.println("IMPRIMIENDO MAIL ACTIVO");
         if (this.logDatos == null) {
                System.out.println("nulo");
            } else {
                System.out.println("datos");
            }
        System.out.println(this.logDatos.getCuentaActiva().getEmail());
        setCorreoUsuario();
        
        this.cerrarsesion=elementoVentanaHeredada;
    }
     
    private void setCorreoUsuario() {
        //Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        nombreUser.setText(this.logDatos.getCuentaActiva().getNombre());
    }
    
    public static void cambiarVista(ActionEvent e, Parent vistaNueva) {
        Scene nuevaEscena;
        nuevaEscena = new Scene(vistaNueva);
        Stage vistaActual;
        vistaActual = (Stage) ((Node) e.getSource()).getScene().getWindow();
        vistaActual.setScene(nuevaEscena);
    }


    

    @FXML
    private void irPeliculas(ActionEvent event) throws IOException{
        Parent vista;
        vista = (AnchorPane) FXMLLoader.load(getClass().getResource("/vistas/PantallaInicial.fxml"));
        cambiarVista(event, vista);
    }


    @FXML
    private void irResultadoBusqueda(ActionEvent event) {
    }

    @FXML
    private void retroceder(ActionEvent event) {
    }

    @FXML
    private void irSerie(ActionEvent event) throws IOException{
        Parent vista;
        vista = (AnchorPane) FXMLLoader.load(getClass().getResource("/vistas/PantallaInicialSerie.fxml"));
        cambiarVista(event, vista);
    }
    
    
    
    
    
    
    
    int medio = 0;
    int derecho = 0;
    int izquierda = 0;
    /**
     * Metodo para que los banners en pantalla se vean en movimiento
     */
   
    public void bannersMusicas() {
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

                    izq = new Image("/recursos/Imagenes/Miniaturas/Musica/banner" + izquierda + "Musica.png");
                    slide = new Image("/recursos/Imagenes/Miniaturas/Musica/banner" + medio + "Musica.png");
                    der = new Image("/recursos/Imagenes/Miniaturas/Musica/banner" + derecho + "Musica.png");

                    Image i2 = new Image("/recursos/Imagenes/Miniaturas/Musica/bannerHover" + medio + "Musica.png");
                    Image i3 = new Image("/recursos/Imagenes/Miniaturas/Musica/banner" + medio + "Musica.png");

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
    
    
    public void cancionesMasPopulares(){
        Image im1 = null;
        Image im2 = null;
        Image im3 = null;
        Image im4 = null;
        
        im1 = new Image("/recursos/Imagenes/Miniaturas/Musica/lmn1.png");
        lmp1.setImage(im1);

        
        lmp1.setOnMouseEntered(e -> {     
                        System.out.println("Sobre1");
                    });
        
        im2 = new Image("/recursos/Imagenes/Miniaturas/Musica/lmn2.png");
        lmp2.setImage(im2);
        lmp2.setOnMouseEntered(e -> {     
                        System.out.println("Sobre2");
                    });
        
        im3 = new Image("/recursos/Imagenes/Miniaturas/Musica/lmn3.png");
        lmp3.setImage(im3);
        lmp3.setOnMouseEntered(e -> {     
                        System.out.println("Sobre3");
                    });
        
        im4 = new Image("/recursos/Imagenes/Miniaturas/Musica/lmn4.png");
        lmp4.setImage(im4);
        lmp4.setOnMouseEntered(e -> {     
                        System.out.println("Sobre4");
                    });
        
    }
    
    
    
    
    
    public void ultimasCancionesAgregadas(){
        
        Image uc1 = null;
        Image uc2 = null;
        Image uc3 = null;
        Image uc4 = null;
        Image uc5 = null;
        Image uc6 = null;
        Image uc7 = null;
        Image uc8 = null;

        uc1 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 1 + ".png");
        UltimaCancionAgregada1.setImage(uc1);

        UltimaCancionAgregada1.setOnMouseEntered(e -> {
            System.out.println("Sobre1");
        });

        uc2 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 2 + ".png");
        UltimaCancionAgregada2.setImage(uc2);
        UltimaCancionAgregada2.setOnMouseEntered(e -> {
            System.out.println("Sobre2");
        });

        uc3 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 3 + ".png");
        UltimaCancionAgregada3.setImage(uc3);
        UltimaCancionAgregada3.setOnMouseEntered(e -> {
            System.out.println("Sobre3");
        });

        uc4 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 4 + ".png");
        UltimaCancionAgregada4.setImage(uc4);
        UltimaCancionAgregada4.setOnMouseEntered(e -> {
            System.out.println("Sobre4");
        });
        
        uc5 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 5 + ".png");
        UltimaCancionAgregada5.setImage(uc5);
        UltimaCancionAgregada5.setOnMouseEntered(e -> {
            System.out.println("Sobre5");
        });

        uc6 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 6 + ".png");
        UltimaCancionAgregada6.setImage(uc6);
        UltimaCancionAgregada6.setOnMouseEntered(e -> {
            System.out.println("Sobre6");
        });

        uc7 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 7 + ".png");
        UltimaCancionAgregada7.setImage(uc7);
        UltimaCancionAgregada7.setOnMouseEntered(e -> {
            System.out.println("Sobre7");
        });

        uc8 = new Image("/recursos/Imagenes/Miniaturas/Musica/UltimasCancionesAgregadas" + 8 + ".png");
        UltimaCancionAgregada8.setImage(uc8);
        UltimaCancionAgregada8.setOnMouseEntered(e -> {
            System.out.println("Sobre8");
        });
        
        
    }
    
    
    
    
    public void cerrarsesion(){
        
    }
    
    public void usuario(){
        
    }
    
}
