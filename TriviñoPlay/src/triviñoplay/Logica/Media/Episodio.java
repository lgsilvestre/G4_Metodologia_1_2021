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
public class Episodio extends Multimedia{
    String series, descripcion;
    
    public Pelicula(String direccionArchivo, String titulo, String genero, 
            String fechaString, String direccionPortada, String series, String descripcion){
        super(direccionArchivo);
        inicializarMetadataPelicula(titulo, genero, fechaString, 
                direccionPortada, series, descripcion);
    }
    
    public Pelicula(String direccionArchivo){
        super(direccionArchivo);
        leerMetadataPelicula();
    }
    
    private void inicializarMetadataPelicula(String titulo, String genero, 
            String fechaString, String direccionPortada, String series, String descripcion){
        inicializarMetadata(titulo, genero, fechaString, direccionPortada);
        setTipo("Pelicula");
        setDirector(series);
        setDescripcion(descripcion);
    }
    
    private void leerMetadataPelicula(){
        leerMetadata();
        series = metadataModificable.getFirst(FieldKey.CONDUCTOR);
        descripcion = metadataModificable.getFirst(FieldKey.COMMENT); 
    }
    
    public void setDirector(String series){
        this.series = series;
        try {
            metadataModificable.setField(FieldKey.CONDUCTOR, series);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
        try {
            metadataModificable.setField(FieldKey.COMMENT, descripcion);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}        
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se rePRoducira
    }
    
}
