/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay.Logica.Media;

/**
 *
 * @author Sudaii
 */
public class Pelicula extends Multimedia{
    String director, descripcion;
    
    public Pelicula(String direccionArchivo, String titulo, String genero, 
            String fechaString, String direccionPortada, int reproducciones, 
            String director, String descripcion){
        super(direccionArchivo, titulo, genero, fechaString, direccionPortada, reproducciones);
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
    
}
