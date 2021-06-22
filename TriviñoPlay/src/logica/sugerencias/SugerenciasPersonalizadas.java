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
    }
    
    private void determinarGenerosMasVistos(){
        determinarGenerosSerieMasVistos();
        determinarGenerosPeliculaMasVistos();
        determinarGenerosMusicaMasVistos();
        for(int i = 0; i < cantidad.size(); i++){
            insertionSort(i);
        }

    }
    
    private void determinarGenerosSerieMasVistos(){
        for(Serie serie: usuario.getHistorialSeries()){
            String genero = serie.getGeneroSerie();
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
            String genero = pelicula.getGeneroPelicula();
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
            String genero = cancion.getGeneroMusica();
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
