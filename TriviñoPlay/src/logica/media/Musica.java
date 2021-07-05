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
public class Musica extends Reproducible{
    private String album, artista;
    
    public Musica(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String direccionArchivo,
            String album, String artista){
        super(titulo, genero, fechaString, direccionPortada, reproducciones, direccionArchivo);
        tipo = "Musica";
        this.album = album;
        this.artista = artista;
    }
    
    public void setAlbum(String album){
        this.album = album;
    }
    
    public void setArtista(String artista){
        this.artista = artista;
    }

    public String getAlbum(){
        return album;
    }
    
    public String getArtista(){
        return artista;
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se reproducira
    }
    
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+direccionArchivo+","
                +album+","+artista;
        return datos;
    }
}
