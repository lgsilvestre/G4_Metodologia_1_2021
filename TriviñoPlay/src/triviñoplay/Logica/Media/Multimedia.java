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
import java.util.Arrays;
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
public abstract class Multimedia {
    private File archivo;
    protected AudioFile archivoMultimedia;
    protected Tag metadataModificable;
    protected AudioHeader metadataNoModificable;
    private String titulo, genero, tipo;
    private Calendar fechaLanzamiento;
    private Image portada;
    private int reproducciones, duracionSegundos;
    
    protected Multimedia(String direccionArchivo){
        this.archivo =  new File(direccionArchivo);
        try {
            archivoMultimedia = AudioFileIO.read(archivo);
            metadataModificable = archivoMultimedia.getTag();
            metadataNoModificable = archivoMultimedia.getAudioHeader();
        } catch (CannotReadException | IOException | TagException | 
                ReadOnlyFileException | InvalidAudioFrameException ex){}
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
        try {
            metadataModificable.setField(FieldKey.TITLE, titulo);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    public void setGenero(String genero){
        this.genero = genero;
        try {
            metadataModificable.setField(FieldKey.GENRE, genero);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    protected void setTipo(String tipo){
        this.tipo = tipo;
        try {
            metadataModificable.setField(FieldKey.CUSTOM4, tipo);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    private void setFechaLanzamiento(String fechaString){
        stringACalendario(fechaString);
        try {
            metadataModificable.setField(FieldKey.CUSTOM1, fechaString);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    public void setPortada(String direccionPortada){
       portada = new Image(direccionPortada);
       try {
            metadataModificable.setField(FieldKey.CUSTOM2, direccionPortada);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public Calendar getFechaLanzamiento(){
        return fechaLanzamiento;
    }
    
    public String getFechaLanzamientoString(){
        return fechaLanzamiento.toString();
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
    
    protected void inicializarMetadata(String titulo, String genero, 
            String fechaString, String direccionPortada){
        setTitulo(titulo);
        setGenero(genero);
        setFechaLanzamiento(fechaString);
        setPortada(direccionPortada);
        reproducciones = 0;
        String reproduccionesString = String.valueOf(reproducciones);
        try {
            metadataModificable.setField(FieldKey.CUSTOM3, reproduccionesString);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
        try {
            metadataModificable.setField(FieldKey.CUSTOM5, "Inicializado");
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
        
    protected void leerMetadata(){
        titulo = metadataModificable.getFirst(FieldKey.TITLE);
        genero = metadataModificable.getFirst(FieldKey.GENRE);
        String fechaString = metadataModificable.getFirst(FieldKey.CUSTOM1);
        stringACalendario(fechaString);
        portada = new Image(metadataModificable.getFirst(FieldKey.CUSTOM2));
        reproducciones = Integer.valueOf(metadataModificable.getFirst(FieldKey.CUSTOM3));
        duracionSegundos = metadataNoModificable.getTrackLength();
    }
    
    private void stringACalendario(String fechaString){
        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(fechaString.split("-")));
        int año = Integer.valueOf(datosSeparados.get(0));
        int mes = Integer.valueOf(datosSeparados.get(1));
        int dia = Integer.valueOf(datosSeparados.get(2));
        fechaLanzamiento.set(año, mes, dia, 0, 0, 0);
    }
    
    protected void incrementarReproducciones(){
        reproducciones++;
                String reproduccionesString = String.valueOf(reproducciones);
        try {
            metadataModificable.setField(FieldKey.CUSTOM3, reproduccionesString);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    public abstract void reproducir();

}
