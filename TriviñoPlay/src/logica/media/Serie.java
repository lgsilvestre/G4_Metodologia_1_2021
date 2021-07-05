/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.media;

import java.util.ArrayList;

/**
 *
 * @author Sudaii
 */
public class Serie extends Multimedia {
    private ArrayList<Episodio> episodios;
    private String descripcion;
    
    public Serie(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String descripcion){
        super(titulo, genero, fechaString, direccionPortada, reproducciones);
        tipo = "Serie";
        this.descripcion = descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public ArrayList<Episodio> getEpisodios(){
        return episodios;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    public void agregarEpisodio(Episodio episodio){
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
        actualizarReproducciones();
    }
    
    public boolean removerEpisodio(int numEpisodio){
        boolean removido = false;
        if(existeEpisodio(numEpisodio)){
            episodios.remove(numEpisodio);
                actualizarReproducciones();
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
    
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+descripcion;
        return datos;
    }
}
