/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.media;

import controladores.ReproductorController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Musica implementa objetos Multimedia auditivos artisticos.
 * @author Sudaii
 */
public class Musica extends Reproducible{
    //album: album al que pertenece la música.
    //artista: el artista que hizo la música.
    private final String album, artista;
    
    /**
     * Constructor Musica. Genera Musica con los datos ingresados.
     * @param titulo titulo del objeto Multimedia
     * @param genero genero del objeto Multimedia
     * @param fechaString fecha en la que se producio el objeto Multimedia
     * (formato: "aaaa-mm-dd")
     * @param direccionPortada la direccion de la portada del objeto Multimedia 
     * @param reproducciones numero de veces que se ha reproducido el objeto Multimedia
     * @param direccionArchivo la dirección del archivo reproducible
     * @param album al que pertenece la música
     * @param artista el artista que hizo la música
     */
    public Musica(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String direccionArchivo,
            String album, String artista){
        super(titulo, genero, fechaString, direccionPortada, reproducciones, direccionArchivo);
        tipo = "Musica";
        this.album = album;
        this.artista = artista;
    }
    
    /**
     * Retorna el album al que pertenece la música.
     * @return el album al que pertenece la música
     */
    public String getAlbum(){
        return album;
    }
    
    /**
     * Retorna el artista que hizo la música.
     * @return el artista que hizo la música
     */
    public String getArtista(){
        return artista;
    }
    
    /**
     * Reproduce la Música.
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
     * Retorna los datos de la Musica, separados por comas, en forma de String.
     * @return los datos de la Musica, separados por comas, en forma de String
     */
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+direccionArchivo+","
                +album+","+artista;
        return datos;
    }
}
