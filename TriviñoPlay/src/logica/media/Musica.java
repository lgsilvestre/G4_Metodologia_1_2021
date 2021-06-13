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
public class Musica extends Multimedia{
    String album, artista, generoMusica;
    
    public Musica(String direccionArchivo, String titulo, 
            String fechaString, String direccionPortada, int reproducciones, 
            String album, String artista, String generoMusica){
        super(direccionArchivo, titulo, fechaString, direccionPortada, reproducciones);
        tipo = "Musica";
        this.album = album;
        this.artista = artista;
        this.generoMusica = generoMusica;
    }
    
    public void setAlbum(String album){
        this.album = album;
    }
    
    public void setArtista(String artista){
        this.artista = artista;
    }
    
    public void setGeneroMusica(String generoMusica){
        this.generoMusica = generoMusica;
    }
    
    public String getAlbum(){
        return album;
    }
    
    public String getArtista(){
        return artista;
    }
    
    public String generoMusica(){
        return generoMusica;
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se reproducira
    }
    
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+album+","+artista+","+generoMusica;
        return datos;
    }
}
