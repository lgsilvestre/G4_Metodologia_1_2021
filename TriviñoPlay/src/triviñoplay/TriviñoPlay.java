/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TriviñoPlay extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Reproductor.fxml"));
            
            Parent root = loader.load();
            
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("TriviñoPlay - Bienvenido");
            stage.show();
        }catch(Exception e){
            System.out.println("Error carga de vista principal");
        };
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
