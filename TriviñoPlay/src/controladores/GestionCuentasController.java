
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class GestionCuentasController implements Initializable {

    @FXML
    private Label labelNombreUsuario;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Button botonRetroceso;
    @FXML
    private ImageView imagenRetroceso;
    @FXML
    private Button botonAgregarCuenta;
    @FXML
    private Button botonEditarCuenta;
    @FXML
    private Button botonEliminarCuenta;
    @FXML
    private TableView<Cuenta> tablaCuentas;
    @FXML
    private TableColumn colNombreUsuario;
    @FXML
    private TableColumn colEmail;
    @FXML
    private TableColumn colContrasena;
    @FXML
    private TableColumn colImagen;
    @FXML
    private TableColumn colAdministrador;
    
    private ObservableList<Cuenta> cuentas;
    
    private Cuenta cuentaSeleccionada;
    FXMLLoader loaderEmergente;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cuentas = FXCollections.observableArrayList();
        this.tablaCuentas.setItems(cuentas);
                
        this.colContrasena.setCellValueFactory(new PropertyValueFactory("contrasena"));
        this.colNombreUsuario.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        
        this.colAdministrador.setCellValueFactory(new PropertyValueFactory("admin"));
        this.colImagen.setCellValueFactory(new PropertyValueFactory("direccionImagenPerfil"));
        
        tablaCuentas.refresh();
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
    }

    @FXML
    private void fueraBotonAgregar(MouseEvent event) {
        botonAgregarCuenta.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreBotonAgregar(MouseEvent event) {
        botonAgregarCuenta.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void agregarCuenta(ActionEvent event) {
        try{
            loaderEmergente = new FXMLLoader(getClass().getResource("../vistas/AgregarCuenta.fxml"));

            Parent raiz = loaderEmergente.load();

            AgregarCuentaController controlador = loaderEmergente.getController();
            controlador.iniciarAtributos(cuentas);
            
            
            //Stage stageContenedor = (Stage) this.botonAgregarCuenta.getScene().getWindow();
            
            
            Scene escena = new Scene(raiz);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(escena);
            
            //stageContenedor.hide();
            
            stage.showAndWait();           
            
            //stageContenedor.show();
            
            
            Cuenta cuentaAgregada = controlador.getCuentaAgregada();
            if (cuentaAgregada!=null){
                this.cuentas.add(cuentaAgregada);
                this.tablaCuentas.refresh();
                
            }
            
            
        }catch(IOException e){}
        
    }

    @FXML
    private void fueraBotonEditar(MouseEvent event) {
        botonEditarCuenta.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreBotonEditar(MouseEvent event) {
        botonEditarCuenta.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void editarCuenta(ActionEvent event) {
    }

    @FXML
    private void fueraBotonEliminar(MouseEvent event) {
        botonEliminarCuenta.setStyle("-fx-background-color: #ff9100");
    }

    @FXML
    private void sobreBotonEliminar(MouseEvent event) {
        botonEliminarCuenta.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void eliminarCuenta(ActionEvent event) {
    }

    @FXML
    private void seleccion(MouseEvent event) {
    }
    
}
