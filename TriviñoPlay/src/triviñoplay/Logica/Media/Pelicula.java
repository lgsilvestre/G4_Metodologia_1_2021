/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay.Logica.Media;

import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;

/**
 *
 * @author Sudaii
 */
public class Pelicula extends Multimedia{
    String director, descripcion;
    
    public Pelicula(String direccionArchivo, String titulo, String genero, 
            String fechaString, String direccionPortada, String director, String descripcion){
        super(direccionArchivo);
        inicializarMetadataPelicula(titulo, genero, fechaString, 
                direccionPortada, director, descripcion);
    }
    
    public Pelicula(String direccionArchivo){
        super(direccionArchivo);
        leerMetadataPelicula();
    }
    
    private void inicializarMetadataPelicula(String titulo, String genero, 
            String fechaString, String direccionPortada, String director, String descripcion){
        inicializarMetadata(titulo, genero, fechaString, direccionPortada);
        setTipo("Pelicula");
        setDirector(director);
        setDescripcion(descripcion);
    }
    
    private void leerMetadataPelicula(){
        leerMetadata();
        director = metadataModificable.getFirst(FieldKey.CONDUCTOR);
        descripcion = metadataModificable.getFirst(FieldKey.COMMENT); 
    }
    
    public void setDirector(String director){
        this.director = director;
        try {
            metadataModificable.setField(FieldKey.CONDUCTOR, director);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
        try {
            metadataModificable.setField(FieldKey.COMMENT, descripcion);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}        
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
