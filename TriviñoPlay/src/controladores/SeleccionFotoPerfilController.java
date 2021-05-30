/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class SeleccionFotoPerfilController implements Initializable {

    @FXML
    private VBox grilla00;
    @FXML
    private ImageView imagen00;
    @FXML
    private VBox grilla01;
    @FXML
    private ImageView imagen01;
    @FXML
    private VBox grilla02;
    @FXML
    private ImageView imagen02;
    @FXML
    private VBox grilla10;
    @FXML
    private ImageView imagen10;
    @FXML
    private VBox grilla11;
    @FXML
    private ImageView imagen11;
    @FXML
    private VBox grilla12;
    @FXML
    private ImageView imagen12;
    @FXML
    private VBox grilla20;
    @FXML
    private ImageView imagen20;
    @FXML
    private VBox grilla21;
    @FXML
    private ImageView imagen21;
    @FXML
    private VBox grilla22;
    @FXML
    private ImageView imagen22;
    @FXML
    private VBox grilla30;
    @FXML
    private ImageView imagen30;
    @FXML
    private VBox grilla31;
    @FXML
    private ImageView imagen31;
    @FXML
    private Button botonSeleccion;
    
    private boolean [][]grillaSeleccion= new boolean[3][4];
    
    private String urlImagen="file:src/recursos/Imagenes/Perfil/imagendefecto.jpg";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void fuera00(MouseEvent event) {
        if (!grillaSeleccion[0][0]){
            grilla00.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre00(MouseEvent event) {
        if (!grillaSeleccion[0][0]){
            grilla00.setStyle("-fx-background-color: #c0c0c0");
        }
        
    }

    @FXML
    private void presionar00(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffaa00");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[0][0]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/imagendefecto.jpg";
        
    }

    @FXML
    private void fuera01(MouseEvent event) {
        if (!grillaSeleccion[1][0]){
            grilla01.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre01(MouseEvent event) {
        if (!grillaSeleccion[1][0]){
            grilla01.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar01(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffaa00");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[1][0]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Tulio.png";
    }

    @FXML
    private void fuera02(MouseEvent event) {
        if (!grillaSeleccion[2][0]){
            grilla02.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre02(MouseEvent event) {
        if (!grillaSeleccion[2][0]){
            grilla02.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar02(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffaa00");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[2][0]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Bodoque.jpg";
    }

    @FXML
    private void fuera10(MouseEvent event) {
        if (!grillaSeleccion[0][1]){
            grilla10.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre10(MouseEvent event) {
        if (!grillaSeleccion[0][1]){
            grilla10.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar10(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffaa00");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[0][1]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Juanin.png";
    }

    @FXML
    private void fuera11(MouseEvent event) {
        if (!grillaSeleccion[1][1]){
            grilla11.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre11(MouseEvent event) {
        if (!grillaSeleccion[1][1]){
            grilla11.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar11(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffaa00");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[1][1]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Patana.png";
    }

    @FXML
    private void fuera12(MouseEvent event) {
        if (!grillaSeleccion[2][1]){
            grilla12.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre12(MouseEvent event) {
        if (!grillaSeleccion[2][1]){
            grilla12.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar12(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffaa00");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[2][1]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/MarioHugo.jpg";
    }

    @FXML
    private void fuera20(MouseEvent event) {
        if (!grillaSeleccion[0][2]){
            grilla20.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre20(MouseEvent event) {
        if (!grillaSeleccion[0][2]){
            grilla20.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar20(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffaa00");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[0][2]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Policarpo.png";
    }

    @FXML
    private void fuera21(MouseEvent event) {
        if (!grillaSeleccion[1][2]){
            grilla21.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre21(MouseEvent event) {
        if (!grillaSeleccion[1][2]){
            grilla21.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar21(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffaa00");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[1][2]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Guaripolo.png";
    }

    @FXML
    private void fuera22(MouseEvent event) {
        if (!grillaSeleccion[2][2]){
            grilla22.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre22(MouseEvent event) {
        if (!grillaSeleccion[2][2]){
            grilla22.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar22(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffaa00");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[2][2]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Huachimingo.png";
    }

    @FXML
    private void fuera30(MouseEvent event) {
        if (!grillaSeleccion[0][3]){
            grilla30.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre30(MouseEvent event) {
        if (!grillaSeleccion[0][3]){
            grilla30.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar30(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffaa00");
        grilla31.setStyle("-fx-background-color: #ffffff");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[0][3]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Calcetin.png";
    }

    @FXML
    private void fuera31(MouseEvent event) {
        if (!grillaSeleccion[1][3]){
            grilla31.setStyle("-fx-background-color: #ffffff");
        }
    }

    @FXML
    private void sobre31(MouseEvent event) {
        if (!grillaSeleccion[1][3]){
            grilla31.setStyle("-fx-background-color: #c0c0c0");
        }
    }

    @FXML
    private void presionar31(MouseEvent event) {
        grilla00.setStyle("-fx-background-color: #ffffff");
        grilla01.setStyle("-fx-background-color: #ffffff");
        grilla02.setStyle("-fx-background-color: #ffffff");
        grilla10.setStyle("-fx-background-color: #ffffff");
        grilla11.setStyle("-fx-background-color: #ffffff");
        grilla12.setStyle("-fx-background-color: #ffffff");
        grilla20.setStyle("-fx-background-color: #ffffff");
        grilla21.setStyle("-fx-background-color: #ffffff");
        grilla22.setStyle("-fx-background-color: #ffffff");
        grilla30.setStyle("-fx-background-color: #ffffff");
        grilla31.setStyle("-fx-background-color: #ffaa00");
        
        grillaSeleccion = null;
        grillaSeleccion = new boolean[3][4];
        grillaSeleccion[1][3]=true;
        
        urlImagen="file:src/recursos/Imagenes/Perfil/Tramoyas.png";
    }

    @FXML
    private void fueraBotonSeleccion(MouseEvent event) {
        botonSeleccion.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreBotonSeleccion(MouseEvent event) {
        botonSeleccion.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void seleccionar(ActionEvent event) {
        Stage stage = (Stage) this.botonSeleccion.getScene().getWindow();
        stage.close();
    }
    
    public String getUrlImagen(){
        return this.urlImagen;
    }
    
}
