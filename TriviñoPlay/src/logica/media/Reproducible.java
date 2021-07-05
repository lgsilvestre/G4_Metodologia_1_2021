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
public abstract class Reproducible extends Multimedia {
    protected String direccionArchivo;
    
    protected Reproducible(String titulo, String genero, String fechaLanzamientoString, 
            String direccionPortada, int reproducciones, String direccionArchivo){
        super(titulo, genero, fechaLanzamientoString, direccionPortada, reproducciones);
        this.direccionArchivo =  direccionArchivo;
    }
    
    public void setDireccionArchivo(String direccionArchivo){
        this.direccionArchivo = direccionArchivo;
    }
    
    public String getDireccionArchivo(){
        return direccionArchivo;
    }

    protected void incrementarReproducciones(){
        reproducciones++;
    }
    
    public abstract void reproducir();
}
