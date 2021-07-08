package logica;

import datos.GestorDatos;
import java.util.ArrayList;
import java.util.List;
import logica.media.Musica;
import logica.media.Pelicula;
import logica.media.Serie;

/**
 *
 * @author Gama
 */
public class Buscador {
    public GestorDatos gestorDatos;
 
    /**
     * Este metodo trae toda la informacion de
     * el contenido multimedia a esta clase
    **/
    public Buscador(GestorDatos gestorDatos){
        this.gestorDatos = gestorDatos;
    }
    
    /**
     * Filtrar lista multimedia dado un parametro
     * @param nombre letra, palabra o frase utilizada
     * como parameto
     * @return Lista que contiene las listas filtradas respectivamente
     * de los distintos tipos de multimedia
     */
    public List<List> buscar(String nombre){
        List<Pelicula> listaFiltradaPeliculas = new ArrayList<>();
        List<Musica> listaFiltradaMusica = new ArrayList<>();
        List<Serie> listaFiltradaSeries = new ArrayList<>();
        List<List> listaDeListas = new ArrayList<>();
        for (int i = 0; i < gestorDatos.getPeliculas().size(); i++) {
            if (nombre.toLowerCase().equals(gestorDatos.getPeliculas().get(i).getTitulo().substring(0, nombre.length()).toLowerCase())) {
                listaFiltradaPeliculas.add(gestorDatos.getPeliculas().get(i));
            }
        }
        for (int i = 0; i < gestorDatos.getSeries().size(); i++) {
            if (nombre.toLowerCase().equals(gestorDatos.getSeries().get(i).getTitulo().substring(0, nombre.length()).toLowerCase())) {
                listaFiltradaSeries.add(gestorDatos.getSeries().get(i));
            }
        }
        for (int i = 0; i < gestorDatos.getMusica().size(); i++) {
            if (nombre.toLowerCase().equals(gestorDatos.getMusica().get(i).getTitulo().substring(0, nombre.length()).toLowerCase())) {
                listaFiltradaMusica.add(gestorDatos.getMusica().get(i));
            }
        }
        listaDeListas.add(listaFiltradaPeliculas);
        listaDeListas.add(listaFiltradaSeries);
        listaDeListas.add(listaFiltradaMusica);
        return listaDeListas;
    }
}
