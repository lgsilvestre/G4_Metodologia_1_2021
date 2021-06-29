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
public class Episodio extends Reproducible{
    String serie;
    int numEpisodio;
    
    public Episodio(String titulo, String genero, String fechaLanzamientoString, 
            String direccionPortada, int reproducciones, String direccionArchivo,
            String serie, int numEpisodio){
        super(titulo, genero, fechaLanzamientoString, direccionPortada, reproducciones, direccionArchivo);
        tipo = "Episodio";
        this.serie = serie;
        this.numEpisodio = numEpisodio;
    }
    
    public void setSerie(String serie){
        this.serie = serie;
    }
    
    public void setNumEpisodio(int numEpisodio){
        this.numEpisodio = numEpisodio;
    }
    
    public String getSerie(){
        return serie;
    }
    
    public int getNumEpisodio(){
        return numEpisodio;
    }
    
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se reproducira
    }
    
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+direccionArchivo+","+serie+","+String.valueOf(numEpisodio);
        return datos;
    }
    
}
