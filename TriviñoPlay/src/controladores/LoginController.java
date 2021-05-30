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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class LoginController implements Initializable {

    @FXML
    private TextField campoUsuario;
    @FXML
    private PasswordField campoPassword;
    @FXML
    private Button botonLogin;
    @FXML
    private Label labelError;
    
    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    
    private FXMLLoader loaderAdministracion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDatos = new GestorDatos();
        logDatos = new UsuarioLog(gestorDatos);        
    }    

    @FXML
    private void entrar(ActionEvent event) {
        String usuario = this.campoUsuario.getText();
        String password = this.campoPassword.getText();
        if (logDatos.ingresarCuenta(usuario, password)){
            this.labelError.setText("");
            if (logDatos.getCuentaActiva().getAdmin()){
                loaderAdministracion= new FXMLLoader(getClass().getResource("/vistas/Administracion.fxml"));
                
                try {
                    Parent raiz = loaderAdministracion.load();
                    VistaAdministracionController controlador = loaderAdministracion.getController();
                    controlador.iniciarAtributos(gestorDatos, logDatos);
                    
                    Scene escenaAdministracion = new Scene(raiz);
                    
                    Stage stage = new Stage();  
                    
                    stage.setResizable(true);                    
                    stage.setScene(escenaAdministracion);           
                    
                    Stage loginVentana = (Stage) this.botonLogin.getScene().getWindow();                    
                    
                    loginVentana.hide();                    
                    
                    stage.showAndWait();
                    logDatos.salirCuenta();
                    
                    loginVentana.show();
                    
                } catch (IOException ex) {
                }                
            }
            else{
                System.out.println("Usuario comun");
                /*Por implementar, exploracion y reproduccion del contenido*/
            }
        }else{
            this.labelError.setText("Usuario y/o contraseña invalido");
        }
    }
    
}
