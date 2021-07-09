/*
 * Controlador para el reproductor del sistema TrivinoPlay, contiene las funcionalidades
 * para reproducir, pausar, parar, adelantar, retrasar y reiniciar el contenido.
 */
package controladores;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Fernando
 * 
 */
public class ReproductorController implements Initializable {
    private File file;
    private String path;
    private MediaPlayer mediaPlayer;
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider progressBar;
    @FXML
    private VBox VboxControl;
    @FXML
    private Label totalTime;
    @FXML
    private Label timeCurrent;
    @FXML
    private Button botonReset;
    @FXML
    private Button botonStop;
    @FXML
    private Button botonPlay;
    @FXML
    private Button botonPause;
    @FXML
    private Button botonPrev;
    @FXML
    private Button botonNext;

    /**
     * Se inicializa el reproductor. 
     * Se crea la variable media usando la ruta del archivo multimedia.
     * Se crea la variable mediaplayer para reproducir la media.
     * Se crea la barra de progreso de la reproduccion, junto con su interaccion
     * con el mouse.
     * Se activa la reproduccion del archivo automaticamente.
     */
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    public void reproduccion(String direccionArchivo){
        file = new File(direccionArchivo);//path para los archivos
        path = file.toURI().toString();
        if(path != null){
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            DoubleProperty widthProp = mediaView.fitWidthProperty();
            DoubleProperty heightProp = mediaView.fitHeightProperty();
            /**
             * Se determina el ancho y alto del contenido, si es video.
             */
            widthProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            heightProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<javafx.util.Duration>() {
                @Override
                public void changed(ObservableValue<? extends javafx.util.Duration> observable, javafx.util.Duration oldValue, javafx.util.Duration newValue) {
                    progressBar.setValue(newValue.toSeconds());
                }
            }
            );
           /**
            * Metodo para presionar sobre la barra de proceso del reproductor.
            */
            progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });
            /**
             * Metodo para arrastrar sobre la barra de proceso del reproductor.
             */
            progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });
            /**
             * Hilo para la reproduccion del contenido multimedia, se obtiene el tiempo actual de reproduccion
             * y el tiempo total del contenido
             */
            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    javafx.util.Duration total = media.getDuration();
                    mediaPlayer.currentTimeProperty().addListener((p, o, value) -> {
                    timeCurrent.setText(String.format("%4d:%02d:%02d",(int)value.toHours(),(int)value.toMinutes()%60,(int)value.toSeconds()%60));
                    });
                    totalTime.setText(String.format("%4d:%02d:%02d", (int)mediaPlayer.getTotalDuration().toHours(),
                            (int)mediaPlayer.getTotalDuration().toMinutes()%60,(int)mediaPlayer.getTotalDuration().toSeconds()%60)); 
                    progressBar.setMax(total.toSeconds());
                }
            });
            /**
             *Permite reproducir el contenido inmediatamente.
             */
            mediaPlayer.play();
        }
        
    }
    /**
     * Metodo para parar el contenido cuando se presione el boton stop.
     **/
    @FXML
    private void StopMedia(ActionEvent event) {
        mediaPlayer.stop();
    }

    @FXML
    /**
     * Metodo para reproducir el contenido cuando se presione el boton play.
     **/
    private void playMedia(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    /**
     * Metodo para pausar el contenido cuando se presione el boton pause.
     **/
    private void pauseMedia(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    /**
     * Metodo para reiniciar el contenido cuando se presione el boton reset.
     **/
    private void resetMedia(ActionEvent event) {
        mediaPlayer.seek(Duration.ZERO);
        mediaPlayer.play();
    }

    @FXML
    /**
     * Metodo para atrasar en 5 seg el contenido cuando se presione el boton prev.
     **/
    private void prevMedia(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    @FXML
    /**
     * Metodo para adelantar en 5 seg el contenido cuando se presione el boton next.
     **/
    private void nextMedia(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    @FXML
    /**
     * Metodo para esconder los controles cuando el mouse esta fuera de la ventana.
     **/
    private void hideControl(MouseEvent event) {
        VboxControl.setVisible(false);
    }

    @FXML
    /**
     * Metodo para mostrar los controles cuando el mouse esta dentro de la ventana .
     **/
    private void showControl(MouseEvent event) {
        VboxControl.setVisible(true);
    }

    /**
     * Metodo para cambiar el color de los botones cuando el mouse pase por encima de ellos
     */
    @FXML
    private void saleReset(MouseEvent event) {
        botonReset.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void entraReset(MouseEvent event) {
        botonReset.setStyle("-fx-background-color: #3A50FA");
    }

    @FXML
    private void saleStop(MouseEvent event) {
        botonStop.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void entraStop(MouseEvent event) {
        botonStop.setStyle("-fx-background-color: #3A50FA");
    }

    @FXML
    private void salePlay(MouseEvent event) {
        botonPlay.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void entraPlay(MouseEvent event) {
        botonPlay.setStyle("-fx-background-color: #3A50FA");
    }

    @FXML
    private void salePause(MouseEvent event) {
        botonPause.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void entraPause(MouseEvent event) {
        botonPause.setStyle("-fx-background-color: #3A50FA");
    }

    @FXML
    private void salePrev(MouseEvent event) {
        botonPrev.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void entraPrev(MouseEvent event) {
        botonPrev.setStyle("-fx-background-color: #3A50FA");
    }

    @FXML
    private void saleNext(MouseEvent event) {
        botonNext.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void entraNext(MouseEvent event) {
        botonNext.setStyle("-fx-background-color: #3A50FA");
    }
    
    //metodo para detener cuando se cierra la ventana
    public void parar() {
        mediaPlayer.stop();
    }
    


    

    
 

    
   
    
    
 

    
}
