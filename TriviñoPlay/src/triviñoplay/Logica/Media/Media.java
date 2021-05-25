/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay.Logica.Media;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Sudaii
 */
public class Media {
    String titulo, autor, estudio;
    ArrayList<String> generos;
    Calendar fechaLanzamiento;
    Image portada;
    int reproducciones;
    
    public Media(String titulo, String autor, String estudio, ArrayList<String> generos, Calendar fechaLanzamiento, String direccionPortada){
        this.titulo = titulo;
        this.autor = autor;
        this.estudio = estudio;
        this.generos = generos;
        this.fechaLanzamiento = fechaLanzamiento;
        portada = new Image(direccionPortada);
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public void setEstudio(String estudio){
        this.estudio = estudio;
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
    
    public String getAutor(){
        return autor;
    }
    
    public String getEstudio(){
        return estudio;
    }
    
    public ArrayList<String> getGeneros(){
        return generos;
    }
    
    public Image getPortada(){
        return portada;
    }
}
