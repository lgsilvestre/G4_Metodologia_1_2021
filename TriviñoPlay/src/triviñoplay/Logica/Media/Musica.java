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
public class Musica extends Multimedia{
    String album, artista;
    
    public Musica(String direccionArchivo, String titulo, String genero, 
            String fechaString, String direccionPortada, int reproducciones, String album, String artista){
        super(direccionArchivo, titulo, genero, fechaString, direccionPortada, reproducciones);
        this.album = album;
        this.artista = artista;
    }
    
    public String getAlbum(){
        return album;
    }
    
    public String getArtista(){
        return artista;
    }
    
    public void setAlbum(String album){
        this.album = album;
    }
    
    public void setArtista(String artista){
        this.artista = artista;
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se reproducira
    }
    
}
