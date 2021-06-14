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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private FXMLLoader loaderUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestorDatos = new GestorDatos();
        logDatos = new UsuarioLog(gestorDatos);
    }

    @FXML
    private void sobreLog(MouseEvent event) {
        botonLogin.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void fueraLog(MouseEvent event) {
        botonLogin.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void entrar(ActionEvent event) throws IOException {
        String usuario = this.campoUsuario.getText();
        String password = this.campoPassword.getText();
        if (logDatos.ingresarCuenta(usuario, password)) {
            this.labelError.setText("");
            if (logDatos.getCuentaActiva().getAdmin()) {
                loaderAdministracion = new FXMLLoader(getClass().getResource("/vistas/Administracion.fxml"));

                try {
                    Parent raiz = loaderAdministracion.load();
                    VistaAdministracionController controlador = loaderAdministracion.getController();
                    controlador.iniciarAtributos(gestorDatos, logDatos, botonLogin);

                    Scene escenaAdministracion = new Scene(raiz);

                    Stage stage = new Stage();

                    stage.setResizable(true);
                    stage.setScene(escenaAdministracion);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Administracion");
                    stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));

                    Stage loginVentana = (Stage) this.botonLogin.getScene().getWindow();

                    loginVentana.hide();
                    stage.show();

                } catch (IOException ex) {
                }
            } else {
                loaderAdministracion = new FXMLLoader(getClass().getResource("/vistas/PantallaInicial.fxml"));

                try {
                    System.out.println("pasó 1");
                    Parent raiz = loaderAdministracion.load();
                    System.out.println("pasó 2");
                    PantallaInicialController controlador = loaderAdministracion.getController();
                    //controlador.iniciarAtributos(gestorDatos, logDatos, botonLogin);

                    Scene escenaAdministracion = new Scene(raiz);

                    Stage stage = new Stage();

                    stage.setResizable(true);
                    stage.setScene(escenaAdministracion);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Administracion");
                    stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));

                    Stage loginVentana = (Stage) this.botonLogin.getScene().getWindow();

                    loginVentana.hide();
                    stage.show();

                } catch (IOException ex) {
                }

                /*Por implementar, exploracion y reproduccion del contenido*/
                logDatos.salirCuenta();
            }
        } else {
            this.labelError.setText("Usuario y/o contraseña invalido");
        }
    }

    private void cambiarVista(ActionEvent e, Parent vistaNueva) {
        Scene nuevaEscena;
        nuevaEscena = new Scene(vistaNueva);
        Stage vistaActual;
        vistaActual = (Stage) ((Node) e.getSource()).getScene().getWindow();
        vistaActual.setScene(nuevaEscena);
    }

}
