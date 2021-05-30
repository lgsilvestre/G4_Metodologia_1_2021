package principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controladores.VistaAdministracionController;
import javafx.stage.StageStyle;


public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/GestionCuentas.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);

            stage.setScene(scene);
            

            //stage.setResizable(false);
            //VistaAdministracionController controlador = loader.getController();
           // controlador.setImagenUsuario();
            stage.show();
        }catch(Exception e){
            System.out.println("Error carga de vista principal");
        };
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}

