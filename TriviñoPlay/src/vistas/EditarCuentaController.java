/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.SeleccionFotoPerfilController;
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


public class EditarCuentaController implements Initializable {

    @FXML
    private TextField campoNombreActual;
    @FXML
    private TextField campoNombreNuevo;
    @FXML
    private TextField campoEmailActual;
    @FXML
    private TextField campoEmailNuevo;
    @FXML
    private TextField campoContrasenaActual;
    @FXML
    private TextField campoContrasenaNueva;
    @FXML
    private ImageView imagenActual;
    @FXML
    private ImageView imagenNueva;
    @FXML
    private Button botonElegirImagen;
    @FXML
    private Label labelTextoImagen;
    @FXML
    private CheckBox checkAdministradorActual;
    @FXML
    private CheckBox checkAdministradorNuevo;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCancelar;
    
    private Cuenta cuentaActual;
    private Cuenta cuentaNueva;
    private ObservableList<Cuenta> listaCuentas;
    
    private FXMLLoader loaderSeleccionImagen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
    }    
    
    public void iniciarAtributos(ObservableList<Cuenta>cuentas,Cuenta cuentaEditar){
        this.listaCuentas = cuentas;
        this.cuentaActual = cuentaEditar;
        /*Parametros actuales no modificables*/
        this.campoNombreActual.setText(this.cuentaActual.getNombre());
        this.campoEmailActual.setText(this.cuentaActual.getEmail());
        this.campoContrasenaActual.setText(this.cuentaActual.getContraseña());
        this.checkAdministradorActual.setSelected(this.cuentaActual.getAdmin());
        this.labelTextoImagen.setText(this.cuentaActual.getDireccionImagenPerfil());
        this.imagenActual.setImage(new Image(cuentaActual.getDireccionImagenPerfil()));
        
        /*Parametros nuevos modificables*/
        this.campoNombreNuevo.setText(this.cuentaActual.getNombre());
        this.campoEmailNuevo.setText(this.cuentaActual.getEmail());
        this.campoContrasenaNueva.setText(this.cuentaActual.getContraseña());
        this.checkAdministradorNuevo.setSelected(this.cuentaActual.getAdmin());
        this.labelTextoImagen.setText(this.cuentaActual.getDireccionImagenPerfil());
        this.imagenNueva.setImage(new Image(cuentaActual.getDireccionImagenPerfil()));       
    }

    @FXML
    private void fueraElegirImagen(MouseEvent event) {
        this.botonElegirImagen.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreElegirImagen(MouseEvent event) {
        this.botonElegirImagen.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void elegirImagen(ActionEvent event) {
        loaderSeleccionImagen = new FXMLLoader(getClass().getResource("/vistas/seleccionFotoPerfil.fxml"));
        
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
            
            this.labelTextoImagen.setText(controlador.getUrlImagen());
            this.imagenNueva.setImage(new Image(this.labelTextoImagen.getText()));
            
        } catch (IOException ex) {
            
        }
        
    }

    @FXML
    private void fueraModificar(MouseEvent event) {
        this.botonModificar.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreModificar(MouseEvent event) {
        this.botonModificar.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void modificarCuenta(ActionEvent event) {
        String nombreUsuario = this.campoNombreNuevo.getText();
        String email = this.campoEmailNuevo.getText();
        String contrasena = this.campoContrasenaNueva.getText();
        boolean admin = this.checkAdministradorNuevo.isSelected();
        String direccionImagenPerfil = this.labelTextoImagen.getText();
        
        Cuenta cuentaComprobar = new Cuenta(nombreUsuario.trim(),contrasena.trim(),email.trim(),admin,direccionImagenPerfil);
        
        if (comprobarExistencia(cuentaComprobar)){
            this.cuentaNueva = cuentaComprobar;
            Alert confirmacion = new Alert (Alert.AlertType.CONFIRMATION);
            confirmacion.setHeaderText(null);
            confirmacion.setTitle("Modificado");
            confirmacion.setContentText("Se ha modificado la cuenta correctamente");
            confirmacion.showAndWait();
            
            Stage stage = (Stage) this.botonModificar.getScene().getWindow();
            stage.close();
        }else{
            Alert error = new Alert (Alert.AlertType.ERROR);
            error.setHeaderText(null);
            error.setTitle("Error!");
            error.setContentText("Hay un campo vacio o se esta usando un Email de otro usuario");
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
    private void cancelarModificacion(ActionEvent event) {
        this.cuentaNueva=this.cuentaActual;
        Stage ventanaActual = (Stage) this.botonCancelar.getScene().getWindow();
        ventanaActual.close();
    }
    
    public Cuenta getCuentaModificada(){
        return this.cuentaNueva;
    }
    
    private boolean comprobarExistencia(Cuenta cuenta) {
        if(cuenta.getNombre().equalsIgnoreCase("") ||
                cuenta.getEmail().equalsIgnoreCase("") ||
                cuenta.getContraseña().equalsIgnoreCase("") ||
                cuenta.getDireccionImagenPerfil().equalsIgnoreCase("")){
                
                return false;
        }
      
        for(int i=0;i<this.listaCuentas.size();i++){            
            if(this.listaCuentas.get(i).getEmail().equalsIgnoreCase(cuenta.getEmail())){
                if (!this.cuentaActual.getEmail().equalsIgnoreCase(cuenta.getEmail())){
                    return false;
                }
               
                               
            }
        }
        return true;
    }
}
