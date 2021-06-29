/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.sugerencias;

import datos.GestorDatos;
import logica.Cuenta;
import logica.media.*;
import java.util.ArrayList;

/**
 *
 * @author Sudaii
 */
public class SugerenciasPersonalizadas extends Sugerencias{
    //0 = Series, 1 = Peliculas, 2 = Musica
    private final ArrayList<ArrayList<String>> generos;
    private final ArrayList<ArrayList<Integer>> cantidad;
    private final Cuenta usuario;
    
    public SugerenciasPersonalizadas (GestorDatos datos, Cuenta usuario){
        super(datos);
        generos = new ArrayList<>();
        cantidad = new ArrayList<>();
        this.usuario = usuario;
        determinarGenerosMasVistos();
        determinarSugerencias();
    }
    
    private void determinarGenerosMasVistos(){
        determinarGenerosSerieMasVistos();
        determinarGenerosPeliculaMasVistos();
        determinarGenerosMusicaMasVistos();
        for(int i = 0; i < cantidad.size(); i++){
            insertionSort(i);
            if(generos.get(i).size() > 3){
                generos.get(i).subList(3, generos.get(0).size()).clear();
                cantidad.get(i).subList(3, generos.get(0).size()).clear();
                generos.get(i).trimToSize();
                cantidad.get(i).trimToSize();
            }
        }
    }
    
    private void determinarGenerosSerieMasVistos(){
        for(Serie serie: usuario.getHistorialSeries()){
            String genero = serie.getGenero();
            if(generos.get(0).contains(genero)){
                int indice = generos.get(0).indexOf(genero);
                cantidad.get(0).set(indice, cantidad.get(0).get(indice)+1);
            }
            else{
                generos.get(0).add(genero);
                cantidad.get(0).add(0);
            }
        }
    }
    
    private void determinarGenerosPeliculaMasVistos(){
        for(Pelicula pelicula: usuario.getHistorialPeliculas()){
            String genero = pelicula.getGenero();
            if(generos.get(1).contains(genero)){
                int indice = generos.get(1).indexOf(genero);
                cantidad.get(1).set(indice, cantidad.get(1).get(indice)+1);
            }
            else{
                generos.get(1).add(genero);
                cantidad.get(1).add(0);
            }
        }
    }
    
    private void determinarGenerosMusicaMasVistos(){
        for(Musica cancion: usuario.getHistorialMusica()){
            String genero = cancion.getGenero();
            if(generos.get(2).contains(genero)){
                int indice = generos.get(2).indexOf(genero);
                cantidad.get(2).set(indice, cantidad.get(2).get(indice)+1);
            }
            else{
                generos.get(2).add(genero);
                cantidad.get(2).add(0);
            }
        }
    }
    
    private void determinarSugerencias(){
        determinarSeries();
        determinarPeliculas();
        determinarMusica();
    }
    
    private void determinarSeries(){
        int i = 0;
        while(i < series.size()){
            if(!(generos.get(0).contains(series.get(i).getGenero()) 
                    || usuario.getHistorialSeries().contains(series.get(i)))){
                series.remove(i);
            }
            else{
                i++;
            }
        }
    }
    
    private void determinarPeliculas(){
        int i = 0;
        while(i < peliculas.size()){
            if(!(generos.get(1).contains(peliculas.get(i).getGenero()) 
                    || usuario.getHistorialPeliculas().contains(peliculas.get(i)))){
                peliculas.remove(i);
            }
            else{
                i++;
            }
        }
    }
    
    private void determinarMusica(){
        int i = 0;
        while(i < musica.size()){
            if(!(generos.get(2).contains(musica.get(i).getGenero()) 
                    || usuario.getHistorialMusica().contains(musica.get(i)))){
                musica.remove(i);
            }
            else{
                i++;
            }
        }
    }
    
    private void insertionSort(int numLista){
        for(int i = 1; i < cantidad.get(numLista).size(); i++){
            int j;
            for(j = i-1; j >= 0 && cantidad.get(numLista).get(j) > cantidad.get(numLista).get(i); j--){
                cantidad.get(numLista).set(j+1, cantidad.get(numLista).get(j));
                generos.get(numLista).set(j+1, generos.get(numLista).get(j));
                
            }
            cantidad.get(numLista).set(j+1, cantidad.get(numLista).get(i));
            generos.get(numLista).set(j+1, generos.get(numLista).get(i));

        }
    }
}
