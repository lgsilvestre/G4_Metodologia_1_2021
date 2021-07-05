/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.media;

import java.util.ArrayList;
import java.util.Arrays;

/**`
 *
 * @author Sudaii
 */
public abstract class Multimedia {
    private String direccionPortada, titulo, genero;
    protected String tipo;
    private int[] fecha;
    protected int reproducciones;
    
    protected Multimedia(String titulo, String genero,
            String fechaString, String direccionPortada, int reproducciones){
        this.titulo = titulo;
        this.genero = genero;
        setFecha(fechaString);
        this.direccionPortada = direccionPortada;
        reproducciones = this.reproducciones;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    private void setFecha(String fechaString){
        stringAFecha(fechaString);
    }
    
    public void setDireccionPortada(String direccionPortada){
       this.direccionPortada = direccionPortada;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public int[] getFecha(){
        return fecha;
    }
    
    public String getFechaString(){
        String fechaString = fecha[0]+"-"+fecha[1]+"-"+fecha[2];
        return fechaString;
    }
    
    public String getDireccionPortada(){
        return direccionPortada;
    }
    
    public int getReproducciones(){
        return reproducciones;
    }
    
    private void stringAFecha(String fechaString){
        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(fechaString.split("-")));
        fecha[0] = Integer.valueOf(datosSeparados.get(0));
        fecha[1] = Integer.valueOf(datosSeparados.get(1));
        fecha[2] = Integer.valueOf(datosSeparados.get(2));
    }
    
    protected String datosComunesEnString(){
        String datos = titulo+","+genero+","+getFechaString()+","
                +direccionPortada+","+String.valueOf(getReproducciones());
        return datos;
    }
        
    public abstract String datosEnString();
}
