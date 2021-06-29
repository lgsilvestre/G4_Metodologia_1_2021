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
public class Pelicula extends Reproducible{
    private String director, descripcion;
    
    public Pelicula(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String direccionArchivo,
            String director, String descripcion){
        super(titulo, genero, fechaString, direccionPortada, reproducciones, direccionArchivo);
        tipo = "Pelicula";
        this.director = director;
        this.descripcion = descripcion;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;      
    }
    
    public String getDirector(){
        return director;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se rePRoducira
    }
    
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+direccionArchivo+","
                +director+","+descripcion;
        return datos;
    }
    
}
