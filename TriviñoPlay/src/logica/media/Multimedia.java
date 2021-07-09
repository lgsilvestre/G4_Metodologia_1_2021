package logica.media;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Multimedia sirve como base a todo objeto que represente un objeto Multimedia.
 * Un objeto Multimedia es algún medio de transferencia de información mediante
 * recursos audiovisuales. Bajo el alcance de este proyecto, estos serian
 * objetos como Peliculas, Series, Musica, y otras cosas similares.
 * @author Sudaii
 */
public abstract class Multimedia {
    //direccionPortada: la direccion de la portada del objeto Multimedia
    //titulo: titulo del objeto Multimedia
    //genero: genero del objeto Multimedia
    private String direccionPortada, titulo, genero;
    //tipo: tipo del objeto Multimedia 
    //(por lo general contiene el nombre de la clase que extiende Multimedia)
    protected String tipo;
    //fecha: fecha en la que se producio el objeto Multimedia.
    //fecha[0] = año
    //fecha[1] = mes
    //fecha[2] = día
    private int[] fecha;
    //reproducciones: numero de veces que se ha reproducido el objeto Multimedia
    protected int reproducciones;
    private String fechaString;
    
    /**
     * Constructor Multimedia. Genera un objeto Multimedia con los datos ingresados.
     * @param titulo titulo del objeto Multimedia
     * @param genero genero del objeto Multimedia
     * @param fechaString fecha en la que se producio el objeto Multimedia
     * (formato: "aaaa-mm-dd")
     * @param direccionPortada la direccion de la portada del objeto Multimedia 
     * @param reproducciones numero de veces que se ha reproducido el objeto Multimedia
     */
    protected Multimedia(String titulo, String genero,
            String fechaString, String direccionPortada, int reproducciones){
        this.titulo = titulo;
        this.genero = genero;
        fecha = new int[3];
        setFecha(fechaString);
        this.fechaString = fechaString;
        this.direccionPortada = direccionPortada;
        reproducciones = this.reproducciones;        
    }
    
    /**
     * Cambia el titulo del objeto Multimedia al titulo ingresado.
     * @param titulo nuevo titulo del objeto Multimedia
     */
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    /**
     * Cambia el genero del objeto Multimedia al genero ingresado.
     * @param genero nuevo genero del objeto Multimedia
     */
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    /**
     * Cambia la fecha en la que se produjo el objeto Multimedia a la fecha ingresada.
     * @param fechaString nueva fecha del objeto Multimedia (formato: "aaaa-mm-dd")
     */
    private void setFecha(String fechaString){
        stringAFecha(fechaString);
    }
    
    /**
     * Cambia la dirección de la portada del objeto Multimedia a la dirección ingresda.
     * @param direccionPortada nueva dirección del objeto Multimedia
     */
    public void setDireccionPortada(String direccionPortada){
       this.direccionPortada = direccionPortada;
    }
    
    /**
     * Retorna el tipo del objeto Multimedia.
     * @return el tipo del objeto Multimedia
     */
    public String getTipo(){
        return tipo;
    }
    
    /**
     * Retorna el titulo del objeto Multimedia.
     * @return el titulo del objeto Multimedia
     */
    public String getTitulo(){
        return titulo;
    }
    
    /**
     * Retorna el genero del objeto Multimedia.
     * @return el genero del objeto Multimedia
     */
    public String getGenero(){
        return genero;
    }
    
    /**
     * Retorna la fecha en la que se produjo el objeto Multimedia.
     * @return la fecha en la que se produjo el objeto Multimedia
     * fecha[0] = año
     * fecha[1] = mes
     * fecha[2] = día
     */
    public int[] getFecha(){
        return fecha;
    }
    
    /**
     * Retorna como String la fecha en la que se produjo el objeto Multimedia.
     * @return la fecha en la que se produjo el objeto Multimedia en forma de String
     * (formato: "aaaa-mm-dd")
     */
    public String getFechaString(){
        fechaString = fecha[0]+"-"+fecha[1]+"-"+fecha[2];
        return fechaString;
    }
    
    /**
     * Retorna la dirección de la portada del objeto Multimedia.
     * @return la dirección de la portada del objeto Multimedia
     */
    public String getDireccionPortada(){
        return direccionPortada;
    }
    
    /**
     * Retorna el numero de veces que se ha reproducido el objeto Multimedia.
     * @return el numero de veces que se ha reproducido el objeto Multimedia
     */
    public int getReproducciones(){
        return reproducciones;
    }
    
    /**
     * Convierte una fecha en String de formato "aaaa-mm-dd" a una fecha en forma de arreglo.
     * @param fechaString fecha en String de formato "aaaa-mm-dd" 
     */
    private void stringAFecha(String fechaString){
        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(fechaString.split("-")));
        fecha[0] = Integer.valueOf(datosSeparados.get(0));
        fecha[1] = Integer.valueOf(datosSeparados.get(1));
        fecha[2] = Integer.valueOf(datosSeparados.get(2));
    }
    
    /**
     * Retorna los datos exclusivos a la clase Multimedia, separados por comas, en forma de String.
     * @return los datos exclusivos a la clase Multimedia, separados por comas, en forma de String
     */
    protected String datosComunesEnString(){
        String datos = titulo+","+genero+","+getFechaString()+","
                +direccionPortada+","+String.valueOf(getReproducciones());
        return datos;
    }
        
     /**
      * Retorna los datos del objeto Multimedia, separados por comas, en forma de String.
      * @return los datos completos del objeto Multimedia, separados por comas, en forma de String
      */
    public abstract String datosEnString();
}
