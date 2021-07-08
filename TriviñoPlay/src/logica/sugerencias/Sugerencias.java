package logica.sugerencias;

import logica.media.Serie;
import logica.media.Musica;
import logica.media.Pelicula;
import datos.GestorDatos;
import java.util.ArrayList;


/**
 * Sugerencias implementa la base para los algoritmos de selección de sugerencias
 * de objetos Multimedia para los usuarios.
 * @author Sudaii
 */
public abstract class Sugerencias {
    //series: lista de series sugeridas.
    protected ArrayList<Serie> series;
    //peliculas: lista de peliculas sugeridas.
    protected ArrayList<Pelicula> peliculas;
    //musica: lista de música sugerida.
    protected ArrayList<Musica> musica;
    
    /**
     * Constructor de Sugerencias. Inicializa las listas iniciales
     * de objetos Multimedia.
     * @param datos gestor de datos con las listas de objetos Multimedia en la
     * base de datos
     */
    protected Sugerencias(GestorDatos datos){
        this.series = new ArrayList(datos.getSeries());
        this.peliculas = new ArrayList(datos.getPeliculas());
        this.musica = new ArrayList(datos.getMusica());
    }
    
    /**
     * Retorna la lista de series sugeridas.
     * @return la lista de series sugeridas
     */
    public ArrayList<Serie> getSeries(){
        return series;
    }
    
    /**
     * Retorna la lista de peliculas sugeridas.
     * @return la lista de peliculas sugeridas
     */
    public ArrayList<Pelicula> getPeliculas(){
        return peliculas;
    }
    
    /**
     * Retorna la lista de música sugerida.
     * @return la lista de música sugerida
     */
    public ArrayList<Musica>  getMusica(){
        return musica;
    }    
}
