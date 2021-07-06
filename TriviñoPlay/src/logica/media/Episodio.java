/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.media;

/**
 * Episodio implementa un episodio de una Serie, un recurso multimedia audiovisual.
 * @author Sudaii
 */
public class Episodio extends Reproducible{
    //serie: titulo de la serie a la cual pertenece el episodio
    String serie;
    //numEpisodio: el número del episodio
    int numEpisodio;
    
    /**
     * Constructor Episodio. Genera un Episodio con los datos ingresados.
     * @param titulo titulo del objeto Multimedia
     * @param genero genero del objeto Multimedia
     * @param fechaString fecha en la que se producio el objeto Multimedia
     * (formato: "aaaa-mm-dd")
     * @param direccionPortada la direccion de la portada del objeto Multimedia 
     * @param reproducciones numero de veces que se ha reproducido el objeto Multimedia
     * @param direccionArchivo la dirección del archivo reproducible
     * @param serie titulo de la serie a la cual pertenece el episodio
     * @param numEpisodio el número del episodio
     */
    public Episodio(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String direccionArchivo,
            String serie, int numEpisodio){
        super(titulo, genero, fechaString, direccionPortada, reproducciones, direccionArchivo);
        tipo = "Episodio";
        this.serie = serie;
        this.numEpisodio = numEpisodio;
    }

    /**
     * Retorna la serie a la que corresponde el episodio.
     * @return la serie a la que corresponde el episodio
     */
    public String getSerie(){
        return serie;
    }
    
    /**
     * Retorna el numero del episodio.
     * @return el numero del episodio
     */
    public int getNumEpisodio(){
        return numEpisodio;
    }
    
    /**
     * Reproduce el Episodio.
     */
    @Override
    public void reproducir() {
        incrementarReproducciones();
        //TODO: el decidir como se reproducira
    }
    
    /**
     * Retorna los datos del Episodio, separados por comas, en forma de String.
     * @return los datos del Episodio, separados por comas, en forma de String
     */
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+direccionArchivo+","+serie+","+String.valueOf(numEpisodio);
        return datos;
    }
    
}
