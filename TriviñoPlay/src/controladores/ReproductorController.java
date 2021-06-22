/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

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
 */
public class ReproductorController implements Initializable {
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        path = "File:/C:/Users/Fernando/woman.mp4"; //para testear cambiar path, se puede reproducir mp3 y mp4
        if(path != null){
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            DoubleProperty widthProp = mediaView.fitWidthProperty();
            DoubleProperty heightProp = mediaView.fitHeightProperty();
           
            widthProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            heightProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<javafx.util.Duration>() {
                @Override
                public void changed(ObservableValue<? extends javafx.util.Duration> observable, javafx.util.Duration oldValue, javafx.util.Duration newValue) {
                    progressBar.setValue(newValue.toSeconds());
                }
            }
            );
           
            progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });
            
            progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });
            
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
            
            mediaPlayer.play();
        }
    }    
    @FXML
    private void StopMedia(ActionEvent event) {
        mediaPlayer.stop();
    }

    @FXML
    private void playMedia(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void pauseMedia(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void resetMedia(ActionEvent event) {
        mediaPlayer.seek(Duration.ZERO);
        mediaPlayer.play();
    }

    @FXML
    private void prevMedia(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    @FXML
    private void nextMedia(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    @FXML
    private void hideControl(MouseEvent event) {
        VboxControl.setVisible(false);
    }

    @FXML
    private void showControl(MouseEvent event) {
        VboxControl.setVisible(true);
    }
    


    

    
 

    
   
    
    
 

    
}
