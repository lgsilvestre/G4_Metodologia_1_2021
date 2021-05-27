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
    String idSerie;
    int numEpisodio;
    
    public Episodio(String direccionArchivo, String titulo, String genero, 
            String fechaString, String direccionPortada, String idSerie, int numEpisodio){
        super(direccionArchivo);
        inicializarMetadataEpisodio(titulo, genero, fechaString, 
                direccionPortada, idSerie, numEpisodio);
    }
    
    public Episodio(String direccionArchivo){
        super(direccionArchivo);
        leerMetadataEpisodio();
    }
    
    private void inicializarMetadataEpisodio(String titulo, String genero, 
            String fechaString, String direccionPortada, String idSerie, int numEpisodio){
        inicializarMetadata(titulo, genero, fechaString, direccionPortada);
        setTipo("Episodio");
        setIdSerie(idSerie);
        setNumEpisodio(numEpisodio);
    }
    
    private void leerMetadataEpisodio(){
        leerMetadata();
        idSerie = metadataModificable.getFirst(FieldKey.SUBTITLE);
        String numString = metadataModificable.getFirst(FieldKey.KEY); 
        numEpisodio = Integer.valueOf(numString);
    }
    
    private void setIdSerie(String idSerie){
        this.idSerie = idSerie;
        try {
            metadataModificable.setField(FieldKey.SUBTITLE, idSerie);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    private void setNumEpisodio(int numEpisodio){
        this.numEpisodio = numEpisodio;
        String numString = String.valueOf(numEpisodio);
        try {
            metadataModificable.setField(FieldKey.KEY, numString);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}        
    }
    
    public String getIdSerie(){
        return idSerie;
    }
    
    public int getNumEpisodio(){
        return numEpisodio;
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se rePRoducira
    }
    
}
