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
public class Musica extends Multimedia{
    String album, artista;
    
    public Musica(String direccionArchivo, String titulo, String genero, 
            String fechaString, String direccionPortada, String album, String artista){
        super(direccionArchivo);
        inicializarMetadataMusica(titulo, genero, fechaString, direccionPortada, album, artista);
    }
    
    public Musica(String direccionArchivo){
        super(direccionArchivo);
        leerMetadataMusica();
    }
    
    private void inicializarMetadataMusica(String titulo, String genero, 
            String fechaString, String direccionPortada, String album, String artista){
        inicializarMetadata(titulo, genero, fechaString, direccionPortada);
        setTipo("Musica");
        setAlbum(album);
        setArtista(artista);
    }
    
    private void leerMetadataMusica(){
        leerMetadata();
        album = metadataModificable.getFirst(FieldKey.ALBUM);
        artista = metadataModificable.getFirst(FieldKey.ARTIST);        
    }
    
    public void setAlbum(String album){
        this.album = album;
        try {
            metadataModificable.setField(FieldKey.ALBUM, album);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    public void setArtista(String artista){
        this.artista = artista;
        try {
            metadataModificable.setField(FieldKey.ARTIST, artista);
        } catch (KeyNotFoundException | FieldDataInvalidException ex){}
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        ///???
    }
    
}
