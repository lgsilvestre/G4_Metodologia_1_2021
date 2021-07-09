/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.media;

/**
 * Reproducible implementa aquellos objetos Multimedia que se puedan reproducir
 * mediante un archivo. 
 * @author Sudaii
 */
public abstract class Reproducible extends Multimedia {
    //direccionArchivo: la dirección del archivo reproducible
    protected String direccionArchivo;
    
    /**
     * Constructor Reproducible. Genera un objeto Reproducible con los datos ingresados.
     * @param titulo titulo del objeto Multimedia
     * @param genero genero del objeto Multimedia
     * @param fechaString fecha en la que se producio el objeto Multimedia
     * (formato: "aaaa-mm-dd")
     * @param direccionPortada la direccion de la portada del objeto Multimedia 
     * @param reproducciones numero de veces que se ha reproducido el objeto Multimedia
     * @param direccionArchivo la dirección del archivo reproducible
     */
    protected Reproducible(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String direccionArchivo){
        super(titulo, genero, fechaString, direccionPortada, reproducciones);
        this.direccionArchivo =  direccionArchivo;
    }
    
    /**
     * Cambia la dirección del archivo reproducible a la dirección ingresada.
     * @param direccionArchivo la nueva dirección del archivo reproducible
     */
    public void setDireccionArchivo(String direccionArchivo){
        this.direccionArchivo = direccionArchivo;
    }
    
    /**
     * Retorna la dirección del archivo reproducible.
     * @return la dirección del archivo reproducible
     */
    public String getDireccionArchivo(){
        return direccionArchivo;
    }

    /**
     * Incrementa la cantidad de reproducciones del objeto Reproducible por 1.
     */
    protected void incrementarReproducciones(){
        reproducciones++;
    }
    
    /**
     * El metodo mediante el cual se reproducira el objeto Reproducible.
     */
    public abstract void reproducir();
}
