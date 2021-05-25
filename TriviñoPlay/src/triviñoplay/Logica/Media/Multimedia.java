/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay.Logica.Media;

import java.io.File;
import java.io.IOException;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Calendar;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.*;


/**
 *
 * @author Sudaii
 */
public class Multimedia {
    private File archivo;
    private AudioFile archivoMultimedia;
    private Tag metadata;
    private String titulo;
    private ArrayList<String> generos;
    private Calendar fechaLanzamiento;
    private Image portada;
    private int reproducciones, duracionSegundos;
    
    public Multimedia(String direccionArchivo, String direccionPortada){
        this.archivo =  new File(direccionArchivo);
        try {
            archivoMultimedia = AudioFileIO.read(archivo);
            metadata = archivoMultimedia.getTag();
        } catch (CannotReadException | IOException | TagException | 
                ReadOnlyFileException | InvalidAudioFrameException ex){}
        portada = new Image(direccionPortada);
    }
        
    private void leerMetadata(){
        
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setGeneros(ArrayList<String> generos){
        this.generos = generos;
    }
    
    public void setPortada(String direccionPortada){
       portada = new Image(direccionPortada); 
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public ArrayList<String> getGeneros(){
        return generos;
    }
    
    public Image getPortada(){
        return portada;
    }
    
    public int getReproducciones(){
        return reproducciones;
    }
    
    public int getDuracion(){
        return duracionSegundos;
    }
    
    public void reproducir(){
        reproducciones++;
    }

}
