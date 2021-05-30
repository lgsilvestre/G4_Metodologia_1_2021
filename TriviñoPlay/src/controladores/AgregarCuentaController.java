/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.Cuenta;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class AgregarCuentaController implements Initializable {

    @FXML
    private TextField campoUsuario;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoContrasena;
    @FXML
    private Button botonSeleccionImagen;
    @FXML
    private Label labelSeleccion;
    @FXML
    private CheckBox checkAdministrador;
    @FXML
    private Button botonAgregarUsuario;
    @FXML
    private Button botonCancelar;
    @FXML
    private ImageView previewPerfil;
    
    private Cuenta cuenta;
    private ObservableList<Cuenta> listaCuentas;
    
    private FXMLLoader loaderSeleccionImagen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void iniciarAtributos(ObservableList<Cuenta> cuentas){
        this.listaCuentas=cuentas;
        this.labelSeleccion.setText("file:src/recursos/Imagenes/Perfil/imagendefecto.jpg");
        this.previewPerfil.setImage(new Image(this.labelSeleccion.getText()));
        
    }

    @FXML
    private void fueraSeleccionImagen(MouseEvent event) {
        this.botonSeleccionImagen.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreSeleccionImagen(MouseEvent event) {
        this.botonSeleccionImagen.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void seleccionarImagen(ActionEvent event) {
        loaderSeleccionImagen = new FXMLLoader(getClass().getResource("../vistas/seleccionFotoPerfil.fxml"));
        
        try {
            Parent raiz = loaderSeleccionImagen.load();
            SeleccionFotoPerfilController controlador = loaderSeleccionImagen.getController();
            
            Scene escenaImagenPerfil = new Scene(raiz);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(escenaImagenPerfil);
            
            stage.showAndWait();
            
            this.labelSeleccion.setText(controlador.getUrlImagen());
            this.previewPerfil.setImage(new Image(this.labelSeleccion.getText()));
            
            
        } catch (IOException ex) {
            
        }
        
        
        
    }

    @FXML
    private void fueraAgregar(MouseEvent event) {
        this.botonAgregarUsuario.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreAgregar(MouseEvent event) {
        this.botonAgregarUsuario.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void agregar(ActionEvent event) {
        String nombreUsuario = this.campoUsuario.getText();
        String email = this.campoEmail.getText();
        String contrasena = this.campoContrasena.getText();
        boolean admin = this.checkAdministrador.isSelected();
        String direccionImagenPerfil = this.labelSeleccion.getText();
        
        Cuenta cuentaComprobar = new Cuenta(nombreUsuario.trim(),contrasena.trim(),email.trim(),admin,direccionImagenPerfil);
        
        if (comprobarExistencia(cuentaComprobar)){
            this.cuenta = cuentaComprobar;
            Alert confirmacion = new Alert (Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Agregado");
            confirmacion.setContentText("Se ha ingresado la cuenta correctamente");
            confirmacion.showAndWait();
            
            Stage stage = (Stage) this.botonAgregarUsuario.getScene().getWindow();
            stage.close();
        }else{
            Alert error = new Alert (Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle("Error!");
            error.setContentText("La cuenta ya se encuentra ingresada o hay un campo vacio");
            error.showAndWait();
        }      
        
    }

    @FXML
    private void fueraCancelar(MouseEvent event) {
        this.botonCancelar.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreCancelar(MouseEvent event) {
        this.botonCancelar.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) this.botonCancelar.getScene().getWindow();
        stage.close();
    }
    
    public Cuenta getCuentaAgregada(){
        return cuenta;
    }

    private boolean comprobarExistencia(Cuenta cuenta) {
        if(cuenta.getNombre().equalsIgnoreCase("") ||
                cuenta.getEmail().equalsIgnoreCase("") ||
                cuenta.getContrasena().equalsIgnoreCase("") ||
                cuenta.getDireccionImagenPerfil().equalsIgnoreCase("")){
                
                return false;
        }
        for(int i=0;i<this.listaCuentas.size();i++){            
            if(this.listaCuentas.get(i).getEmail().equalsIgnoreCase(cuenta.getEmail())){
                return false;
            }
        }
        return true;
    }
    
}
