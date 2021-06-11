/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.sugerencias;

import logica.media.Serie;
import logica.media.Musica;
import logica.media.Pelicula;
import datos.GestorDatos;
import java.util.ArrayList;


/**
 *
 * @author Sudaii
 */
public abstract class Sugerencias {
    private ArrayList<Serie> series;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Musica> musica;
    
    protected Sugerencias(GestorDatos datos){
        this.series = datos.getSeries();
        this.peliculas = datos.getPeliculas();
        this.musica = datos.getMusica();
    }
    
    public ArrayList<Serie> getSeries(){
        return series;
    }
    
    public ArrayList<Pelicula> getPeliculas(){
        return peliculas;
    }
    
    public ArrayList<Musica>  getMusica(){
        return musica;
    }
    
    abstract void ordenar();
    
}
