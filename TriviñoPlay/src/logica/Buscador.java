package logica;

import datos.GestorDatos;
import java.util.ArrayList;
import java.util.List;
import logica.Media.Musica;
import logica.Media.Pelicula;
import logica.Media.Serie;

/**
 *
 * @author Gama
 */
public class Buscador {
    private final GestorDatos gestorDatos;
 
    /**
     * Este metodo trae toda la informacion de
     * el contenido multimedia a esta clase
    **/
    Buscador(GestorDatos gestorDatos){
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
        for (int i = 0; i < gestorDatos.getPelicula().size(); i++) {
            if (nombre.equals(gestorDatos.getPelicula().get(i).getTitulo().substring(0, nombre.length()))) {
                listaFiltradaPeliculas.add(gestorDatos.getPelicula().get(i));
            }
        }
        for (int i = 0; i < gestorDatos.getSeries().size(); i++) {
            if (nombre.equals(gestorDatos.getSeries().get(i).getTitulo().substring(0, nombre.length()))) {
                listaFiltradaSeries.add(gestorDatos.getSeries().get(i));
            }
        }
        for (int i = 0; i < gestorDatos.getMusica().size(); i++) {
            if (nombre.equals(gestorDatos.getMusica().get(i).getTitulo().substring(0, nombre.length()))) {
                listaFiltradaMusica.add(gestorDatos.getMusica().get(i));
            }
        }
        listaDeListas.add(listaFiltradaPeliculas);
        listaDeListas.add(listaFiltradaSeries);
        listaDeListas.add(listaFiltradaMusica);
        return listaDeListas;
    }
}
