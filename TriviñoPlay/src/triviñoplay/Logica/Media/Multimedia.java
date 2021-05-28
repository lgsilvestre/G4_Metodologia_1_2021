/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay.Logica.Media;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author Sudaii
 */
public abstract class Multimedia {
    private String direccionArchivo, direccionPortada, titulo, genero;
    private Calendar fechaLanzamiento;
    private Image portada;
    private int reproducciones;
    
    protected Multimedia(String direccionArchivo, String titulo, 
            String genero, String fechaLanzamientoString, 
            String direccionPortada, int reproducciones){
        this.direccionArchivo =  direccionArchivo;
        this.direccionPortada = direccionPortada;
        this.titulo = titulo;
        this.genero = genero;
        setFechaLanzamiento(fechaLanzamientoString);
        portada = new Image(direccionPortada);
        reproducciones = this.reproducciones;
    }
    
    public void setDireccionArchivo(String direccionArchivo){
        this.direccionArchivo = direccionArchivo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    private void setFechaLanzamiento(String fechaString){
        stringACalendario(fechaString);
    }
    
    public void setPortada(String direccionPortada){
       this.direccionPortada = direccionPortada;
       portada = new Image(direccionPortada);
    }
    
    public String getDireccionArchivo(){
        return direccionArchivo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public Calendar getFechaLanzamiento(){
        return fechaLanzamiento;
    }
    
    public String getFechaLanzamientoString(){
        return fechaLanzamiento.toString();
    }
    
    public Image getPortada(){
        return portada;
    }
    
    public int getReproducciones(){
        return reproducciones;
    }
    
    private void stringACalendario(String fechaString){
        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(fechaString.split("-")));
        int año = Integer.valueOf(datosSeparados.get(0));
        int mes = Integer.valueOf(datosSeparados.get(1));
        int dia = Integer.valueOf(datosSeparados.get(2));
        fechaLanzamiento.set(año, mes, dia, 0, 0, 0);
    }
    
    protected void incrementarReproducciones(){
        reproducciones++;
    }
    
    public abstract void reproducir();

}
