/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

/**`
 *
 * @author Sudaii
 */
public abstract class Multimedia {
    private String direccionPortada, titulo, genero;
    protected String tipo;
    private Calendar fecha;
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
    
    private void setFecha(String fechaString){
        stringACalendario(fechaString);
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
    
    public Calendar getFecha(){
        return fecha;
    }
    
    public String getFechaString(){
        Date fechaDate = fecha.getTime();
        DateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        String fechaString = formato.format(fecha);
        return fechaString;
    }
    
    public String getDireccionPortada(){
        return direccionPortada;
    }
    
    public int getReproducciones(){
        return reproducciones;
    }
    
    private void stringACalendario(String fechaString){
        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(fechaString.split("-")));
        int año = Integer.valueOf(datosSeparados.get(0));
        int mes = Integer.valueOf(datosSeparados.get(1));
        int dia = Integer.valueOf(datosSeparados.get(2));
        fecha.set(año, mes, dia, 0, 0, 0);
    }
    
    protected String datosComunesEnString(){
        String datos = titulo+","+genero+","+getFechaString()+","
                +direccionPortada+","+String.valueOf(getReproducciones());
        return datos;
    }
        
    public abstract String datosEnString();
}
