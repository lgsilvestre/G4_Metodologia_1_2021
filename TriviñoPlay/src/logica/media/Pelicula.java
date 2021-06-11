/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.media;

/**
 *
 * @author Sudaii
 */
public class Pelicula extends Multimedia{
    String director, descripcion, generoPelicula;
    
    public Pelicula(String direccionArchivo, String titulo, 
            String fechaString, String direccionPortada, int reproducciones, 
            String director, String descripcion, String generoPelicula){
        super(direccionArchivo, titulo, fechaString, direccionPortada, reproducciones);
        tipo = "Pelicula";
        this.director = director;
        this.descripcion = descripcion;
        this.generoPelicula = generoPelicula;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;      
    }
    
    public void setGeneroPelicula(String generoPelicula){
        this.generoPelicula = generoPelicula;
    }
    
    public String getDirector(){
        return director;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getGeneroPelicula(){
        return generoPelicula;
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se rePRoducira
    }
    
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+director+","
                +descripcion+","+generoPelicula;
        return datos;
    }
    
}
