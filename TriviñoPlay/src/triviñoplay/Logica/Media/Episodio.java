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
public class Episodio extends Multimedia{
    String serie;
    int numEpisodio;
    
    public Episodio(String direccionArchivo, String titulo, 
            String fechaString, String direccionPortada, int reproducciones, String serie, int numEpisodio){
        super(direccionArchivo, titulo, fechaString, direccionPortada, reproducciones);
        this.serie = serie;
        this.numEpisodio = numEpisodio;
    }
    
    public void setSerie(String serie){
        this.serie = serie;
    }
    
    private void setNumEpisodio(int numEpisodio){
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
        //TODO: el decidir como se rePRoducira
    }
    
}
