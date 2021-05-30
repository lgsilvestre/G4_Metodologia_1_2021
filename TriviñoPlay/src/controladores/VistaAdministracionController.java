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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logica.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class VistaAdministracionController implements Initializable {

    @FXML
    private Label labelNombreUsuario;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Button botonRetroceso;
    @FXML
    private Button botonGestorCuentas;
    @FXML
    private Button botonGestorMultimedia;
    
    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    
    FXMLLoader loaderGestion;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos){
        this.gestorDatos=gestorDatos;
        this.logDatos=logDatos;
        setImagenUsuario();
    }

    @FXML
    private void retroceder(ActionEvent event) {
        Stage stageAdministracion = (Stage)this.botonRetroceso.getScene().getWindow();
        stageAdministracion.close();
    }

    @FXML
    private void gestionarCuentas(ActionEvent event) {
        loaderGestion = new FXMLLoader(getClass().getResource("/vistas/GestionCuentas.fxml"));
        
        try {
            Parent raiz = loaderGestion.load();            
            GestionCuentasController controlador = loaderGestion.getController();
            controlador.iniciarAtributos(gestorDatos, logDatos);
            
            Scene escenaGestionCuentas = new Scene(raiz);
            Stage stage = new Stage();
            
            Stage ventanaAdministracion = (Stage)this.botonGestorCuentas.getScene().getWindow();
            ventanaAdministracion.hide();
            
            stage.setScene(escenaGestionCuentas);
            stage.show();
            //ventanaAdministracion.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(VistaAdministracionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void gestionarMultimedia(ActionEvent event) {
        System.out.println("Gestion Multimedia");
    }
    
    private void setImagenUsuario() {
        Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        imagenPerfil.setImage(imagen);
        labelNombreUsuario.setText(this.logDatos.getCuentaActiva().getNombre());
    }
}
