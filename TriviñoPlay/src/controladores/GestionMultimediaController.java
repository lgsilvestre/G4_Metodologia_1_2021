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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logica.Cuenta;
import logica.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Matias
 */
public class GestionMultimediaController implements Initializable {

    @FXML
    private Label labelNombreUsuario;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Button botonRetroceso;
    @FXML
    private ImageView imagenRetroceso;
    @FXML
    private ComboBox<?> comboBoxMultimedia;
    @FXML
    private Button botonAgregarCuenta;
    @FXML
    private Button botonEditarCuenta;
    @FXML
    private Button botonEliminarCuenta;
    @FXML
    private TableView<?> TablaMultimedia;
    @FXML
    private TableColumn<?, ?> colTitulo;
    @FXML
    private TableColumn<?, ?> colDirArchivo;
    @FXML
    private TableColumn<?, ?> colDirPortada;
    @FXML
    private TableColumn<?, ?> colNumeroReproduccion;
    
    FXMLLoader loaderEmergente;
    
    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    private Button heredado;
    
    private final String colorSobre = "-fx-background-color: #000000";
    private final String colorFuera = "-fx-background-color: #ff9100";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada){
        this.gestorDatos=gestorDatos;
        this.logDatos=logDatos;
        setImagenUsuario();               
        this.heredado=elementoVentanaHeredada;
    }
    
    public void setImagenUsuario(){
        Image imagen = new Image(this.logDatos.getCuentaActiva().getDireccionImagenPerfil());
        imagenPerfil.setImage(imagen);
        labelNombreUsuario.setText(this.logDatos.getCuentaActiva().getNombre());
    }
    
    @FXML
    private void fueraBotonRetroceso(MouseEvent event) {
        imagenRetroceso.setImage(new Image("file:src/recursos/Imagenes/Iconos/back-arrow.png"));        
    }

    @FXML
    private void sobreBotonRetroceso(MouseEvent event) {
        imagenRetroceso.setImage(new Image("file:src/recursos/Imagenes/Iconos/back-arrow-orange.png"));
    }

    @FXML
    private void retroceder(ActionEvent event) {
        Stage stageGestionMultimedia = (Stage) this.botonRetroceso.getScene().getWindow();
        stageGestionMultimedia.close();        
        Stage retorno = (Stage) this.heredado.getScene().getWindow();
        retorno.show();
    }

    @FXML
    private void cambio(ActionEvent event) {
    }

    @FXML
    private void fueraBotonAgregar(MouseEvent event) {
        botonAgregarCuenta.setStyle(colorFuera);
    }

    @FXML
    private void sobreBotonAgregar(MouseEvent event) {
        botonAgregarCuenta.setStyle(colorSobre);
    }

    @FXML
    private void agregarCuenta(ActionEvent event) {
        try{
            loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/AgregarPelicula.fxml"));

            Parent raiz = loaderEmergente.load();

            AgregarPeliculaController controlador = loaderEmergente.getController();
            //controlador.iniciarAtributos(cuentas);            
            
            Scene escena = new Scene(raiz);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Agregar Pelicula");
            stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
            stage.setScene(escena);
            
                        
            stage.showAndWait();              
            
            /*Cuenta cuentaAgregada = controlador.getCuentaAgregada();
            if (cuentaAgregada!=null){
                this.cuentas.add(cuentaAgregada);
                this.tablaCuentas.refresh();
                actualizarBaseDatosCuentas();               
            }  */          
        }catch(IOException e){}       
        
    }

    @FXML
    private void fueraBotonEditar(MouseEvent event) {
        botonEditarCuenta.setStyle(colorFuera);
    }

    @FXML
    private void sobreBotonEditar(MouseEvent event) {
        botonEditarCuenta.setStyle(colorSobre);
    }

    @FXML
    private void editarCuenta(ActionEvent event) {
    }

    @FXML
    private void fueraBotonEliminar(MouseEvent event) {
        botonEliminarCuenta.setStyle(colorFuera);
    }

    @FXML
    private void sobreBotonEliminar(MouseEvent event) {
        botonEliminarCuenta.setStyle(colorSobre);
    }

    @FXML
    private void eliminarCuenta(ActionEvent event) {
    }

    @FXML
    private void seleccion(MouseEvent event) {
    }
    
}
