
package controladores;

import datos.GestorDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import logica.UsuarioLog;

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
    
    private GestorDatos gestorDatos;
    private UsuarioLog logDatos;
    
    private ArrayList<Cuenta> arrayList;
    
    private Button heredado;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cuentas = FXCollections.observableArrayList();        
        this.tablaCuentas.setItems(cuentas);
                
        this.colContrasena.setCellValueFactory(new PropertyValueFactory("contraseña"));
        this.colNombreUsuario.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        
        this.colAdministrador.setCellValueFactory(new PropertyValueFactory("admin"));
        this.colImagen.setCellValueFactory(new PropertyValueFactory("direccionImagenPerfil"));
        
        tablaCuentas.refresh();
    }   
    
    public void iniciarAtributos(GestorDatos gestorDatos, UsuarioLog logDatos, Button elementoVentanaHeredada){
        this.gestorDatos=gestorDatos;
        this.logDatos=logDatos;
        setImagenUsuario();
        castArrayAObservable();
        tablaCuentas.refresh();
        
        this.heredado=elementoVentanaHeredada;
    }
    
    private void setImagenUsuario() {
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
        Stage stageGestionCuentas = (Stage) this.botonRetroceso.getScene().getWindow();
        stageGestionCuentas.close();
        
        Stage retorno = (Stage) this.heredado.getScene().getWindow();
        retorno.show();
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
            loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/AgregarCuenta.fxml"));

            Parent raiz = loaderEmergente.load();

            AgregarCuentaController controlador = loaderEmergente.getController();
            controlador.iniciarAtributos(cuentas);            
            
            Scene escena = new Scene(raiz);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Agregar Cuenta");
            stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
            stage.setScene(escena);
            
                        
            stage.showAndWait();              
            
            Cuenta cuentaAgregada = controlador.getCuentaAgregada();
            if (cuentaAgregada!=null){
                this.cuentas.add(cuentaAgregada);
                this.tablaCuentas.refresh();
                actualizarBaseDatosCuentas();               
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
        this.cuentaSeleccionada=this.tablaCuentas.getSelectionModel().getSelectedItem();
        
        if (cuentaSeleccionada == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a editar");
            alert.showAndWait();
        }else{
            try{
                loaderEmergente = new FXMLLoader(getClass().getResource("/vistas/EditarCuenta.fxml"));

                Parent raiz = loaderEmergente.load();

                EditarCuentaController controlador = loaderEmergente.getController();
                controlador.iniciarAtributos(this.cuentas, this.cuentaSeleccionada);            

                Scene escena = new Scene(raiz);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setTitle("Modificar Cuenta");
                stage.getIcons().add(new Image("/recursos/Imagenes/Iconos/LogoGrupoTriviño.png"));
                
                stage.setScene(escena);

                stage.showAndWait();               
                
                Cuenta cuentaModificada = controlador.getCuentaModificada();
                
                if (cuentaModificada != null){
                    this.cuentas.remove(this.cuentaSeleccionada);
                    this.cuentas.add(cuentaModificada);
                    this.tablaCuentas.refresh();
                    actualizarBaseDatosCuentas();                    
                }
                
                            
            }catch(IOException e){
            }
        }
        
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
        this.cuentaSeleccionada=this.tablaCuentas.getSelectionModel().getSelectedItem();
        
        if (cuentaSeleccionada == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Debe seleccionar un elemento a editar");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Se eliminará el elemento seleccionado");
            alert.showAndWait();
            
            this.cuentas.remove(this.cuentaSeleccionada);
            this.tablaCuentas.refresh();
            actualizarBaseDatosCuentas();
        }
    }

    @FXML
    private void seleccion(MouseEvent event) {
        this.cuentaSeleccionada = this.tablaCuentas.getSelectionModel().getSelectedItem();        
    }

    private void castArrayAObservable() {
        for(int i=0;i<this.gestorDatos.getCuentas().size();i++){           
            this.cuentas.add(this.gestorDatos.getCuentas().get(i));
        }
    }
    
    private void castObservableAArray() {
        arrayList = new ArrayList<>();
        for(int i=0;i<this.cuentas.size();i++){
            arrayList.add(this.cuentas.get(i));
        }
        
    }
    
    private void actualizarBaseDatosCuentas(){
        castObservableAArray();
        this.gestorDatos.setCuentas(arrayList);
        this.gestorDatos.almacenarCuentas();
    }
    
    
}
