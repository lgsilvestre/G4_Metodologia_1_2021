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
    String serie;
    int numEpisodio;
    
    public Episodio(String direccionArchivo, String titulo, String genero, 
            String fechaString, String direccionPortada, String serie, int numEpisodio){
        super(direccionArchivo);
        inicializarMetadataEpisodio(titulo, genero, fechaString, 
                direccionPortada, serie, numEpisodio);
    }
    
    public Episodio(String direccionArchivo){
        super(direccionArchivo);
        leerMetadataEpisodio();
    }
    
    public void setSerie(String serie){
        this.serie = serie;
        try {
            metadataModificable.setField(FieldKey.SUBTITLE, serie);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    private void setNumEpisodio(int numEpisodio){
        this.numEpisodio = numEpisodio;
        String numString = String.valueOf(numEpisodio);
        try {
            metadataModificable.setField(FieldKey.KEY, numString);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}        
    }
    
    public String getSerie(){
        return serie;
    }
    
    public int getNumEpisodio(){
        return numEpisodio;
    }
    
    private void inicializarMetadataEpisodio(String titulo, String genero, 
            String fechaString, String direccionPortada, String serie, int numEpisodio){
        inicializarMetadata(titulo, genero, fechaString, direccionPortada);
        setTipo("Episodio");
        setSerie(serie);
        setNumEpisodio(numEpisodio);
    }
    
    private void leerMetadataEpisodio(){
        leerMetadata();
        serie = metadataModificable.getFirst(FieldKey.SUBTITLE);
        String numString = metadataModificable.getFirst(FieldKey.KEY); 
        numEpisodio = Integer.valueOf(numString);
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se rePRoducira
    }
    
}
