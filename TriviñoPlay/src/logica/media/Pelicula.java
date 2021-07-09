package logica.media;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import controladores.ReproductorController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Pelicula implementa una pelicula, un recurso audiovisual por lo general
 * hecho de forma de que se pueda consumir sin necesidad de ver "partes" anteriores.
 * @author Sudaii
 */
public class Pelicula extends Reproducible{
    //director: nombre de la persona que dirigio la pelicula.
    //descripcion: de que trata la pelicula.
    private final String director, descripcion;
    
    /**
     * Constructor Pelicula. Genera una Pelicula con los datos ingresados.
     * @param titulo titulo del objeto Multimedia
     * @param genero genero del objeto Multimedia
     * @param fechaString fecha en la que se producio el objeto Multimedia
     * (formato: "aaaa-mm-dd")
     * @param direccionPortada la direccion de la portada del objeto Multimedia 
     * @param reproducciones numero de veces que se ha reproducido el objeto Multimedia
     * @param direccionArchivo la dirección del archivo reproducible
     * @param director nombre de la persona que dirigio la pelicula
     * @param descripcion de que trata la pelicula
     */
    public Pelicula(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String direccionArchivo,
            String director, String descripcion){
        super(titulo, genero, fechaString, direccionPortada, reproducciones, direccionArchivo);
        tipo = "Pelicula";
        this.director = director;
        this.descripcion = descripcion;
    }
    
    /**
     * Retorna el nombre de la persona que dirigio la pelicula.
     * @return el nombre de la persona que dirigio la pelicula
     */
    public String getDirector(){
        return director;
    }
    
    /**
     * Retorna de que trata la pelicula.
     * @return de que trata la pelicula
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Reproduce la Pelicula.
     */
    @Override
    public void reproducir() {
        incrementarReproducciones();
        FXMLLoader loaderReproductor = new FXMLLoader(getClass().getResource("/vistas/Reproduccion.fxml"));
        try{
            Parent raiz = loaderReproductor.load();
            ReproductorController player = loaderReproductor.getController();
            player.reproduccion(direccionArchivo);
            Stage stage = new Stage();
            Scene scene = new Scene(raiz);
            stage.setScene(scene);
            stage.setTitle(this.getTitulo());            
            stage.show();
           
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                player.parar();
                stage.close();
            }
            });
        }catch(Exception e){
            System.out.println("Error carga de reproductor");
        };
    }
    
     /**
     * Retorna los datos de la Pelicula, separados por comas, en forma de String.
     * @return los datos de la Pelicula, separados por comas, en forma de String
     */
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+direccionArchivo+","
                +director+","+descripcion;
        return datos;
    }
    
}
