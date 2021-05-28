/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay.Logica.Media;

import java.util.ArrayList;
import java.util.Calendar;
import javafx.scene.image.Image;

/**
 *
 * @author Sudaii
 */
public class Serie {
    private ArrayList<Episodio> episodios;
    private String titulo, genero, descripcion;
    private Calendar primerLanzamiento, ultimoLanzamiento;
    private int reproducciones;
    private Image portada;
    
    public Serie(String titulo, String genero, String descripcion, String direccionPortada){
        this.titulo = titulo;
        setGenero(genero);
        this.descripcion = descripcion;
        portada = new Image(direccionPortada);
        primerLanzamiento.set(0, 0, 0, 0, 0, 0);
        ultimoLanzamiento.set(0, 0, 0, 0, 0, 0);
        reproducciones = 0;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
        episodios.forEach((episodio) -> {
            episodio.setSerie(titulo);
        });
    }
    
    public void setGenero(String genero){
        this.genero = genero;
        episodios.forEach((episodio) -> {
            episodio.setGenero(genero);
        });
    }
    
    public void setPortada(String direccionPortada){
        portada = new Image(direccionPortada);
    }
    
    public ArrayList<Episodio> getEpisodios(){
        return episodios;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public int getReproducciones(){
        return reproducciones;
    }
    
    public Image getPortada(){
        return portada;
    }
    
    public void agregarEpisodio(Episodio episodio){
        episodio.setGenero(genero);
        if(existeEpisodio(episodio.getNumEpisodio())){
            episodios.remove(episodio.getNumEpisodio());
            episodios.add(episodio.getNumEpisodio(), episodio);
        }
        else{
            int index;
            for(index = 0; 
                    index < episodios.size() && episodios.get(index).getNumEpisodio() < episodio.getNumEpisodio(); 
                    index++){}
            episodios.add(index, episodio);
        }
        actualizarFechas();
        actualizarReproducciones();
    }
    
    public boolean removerEpisodio(int numEpisodio){
        boolean removido = false;
        if(existeEpisodio(numEpisodio)){
            episodios.remove(numEpisodio);
        }
        return removido;
    }
    
    private boolean existeEpisodio(int numEpisodio){
        boolean existeEpisodio = false;
        for(int index = 0; index < episodios.size() && !existeEpisodio; index++){
            if(numEpisodio == episodios.get(index).getNumEpisodio()){
                existeEpisodio = true;
            }
        }
        return existeEpisodio;        
    }
    
    public void reproducirEpisodio(int numEpisodio){
        episodios.get(numEpisodio).reproducir();
        actualizarReproducciones();
    }
    
    private void actualizarReproducciones(){
        reproducciones = 0;
        episodios.forEach((episodio) -> {
            reproducciones+=episodio.getReproducciones();
        });
    }
    
    private void actualizarFechas(){
        for (Episodio episodio : episodios) {
            if(primerLanzamiento.after(episodio.getFechaLanzamiento())){
                primerLanzamiento = episodio.getFechaLanzamiento();
            }
            if(episodio.getFechaLanzamiento().after(ultimoLanzamiento)){
                ultimoLanzamiento = episodio.getFechaLanzamiento();
            }
        }
    }
}
