/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.sugerencias;

import datos.GestorDatos;
import logica.DatoHistorial;
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
        determinarGenerosVistos();
        ordenarGenerosMasVistos();
        determinarSugerencias();
    }
    
    private void determinarGenerosVistos(){
        for(DatoHistorial datoHistorial: usuario.getHistorial()){
            Multimedia media = datoHistorial.getMedia();
            int indiceTipo;
            switch (media.getTipo()) {
                case "Serie":
                    indiceTipo = 0;
                    break;
                case "Pelicula":
                    indiceTipo = 1;
                    break;
                case "Musica":
                    indiceTipo = 2;
                    break;
                default:
                    indiceTipo = 3;
                    break;
            }
            if(indiceTipo != 3){
                String genero = media.getGenero();
                if(generos.get(indiceTipo).contains(genero)){
                    int indice = generos.get(indiceTipo).indexOf(genero);
                    cantidad.get(indiceTipo).set(indice, cantidad.get(indiceTipo).get(indice)+1);
                }
                else{
                    generos.get(indiceTipo).add(genero);
                    cantidad.get(indiceTipo).add(0);
                }                
            }
        }
    }
    
    private void ordenarGenerosMasVistos(){
        for(int i = 0; i < cantidad.size(); i++){
            insertionSort(i);
            if(generos.get(i).size() > 3){
                generos.get(i).subList(3, generos.get(i).size()).clear();
                cantidad.get(i).subList(3, generos.get(i).size()).clear();
                generos.get(i).trimToSize();
                cantidad.get(i).trimToSize();
            }
        }
    }
    
    private void determinarSugerencias(){
        determinarSeries();
        determinarPeliculas();
        determinarMusica();
    }
    
    private void determinarSeries(){
        int indiceMultimedia = 0;
        while(indiceMultimedia < series.size()){
            boolean repetido = false;
            for(int indiceHistorial = 0; indiceHistorial < usuario.getHistorial().size() && !repetido; indiceHistorial++){
                if(series.get(indiceMultimedia).equals(usuario.getHistorial().get(indiceHistorial).getMedia())){
                    repetido = true;
                }
            }
            if(!generos.get(0).contains(series.get(indiceMultimedia).getGenero()) || repetido){ 
                series.remove(indiceMultimedia);
            }
            else{
                indiceMultimedia++;
            }
        }
    }
    
    private void determinarPeliculas(){
        int indiceMultimedia = 0;
        while(indiceMultimedia < series.size()){
            boolean repetido = false;
            for(int indiceHistorial = 0; indiceHistorial < usuario.getHistorial().size() && !repetido; indiceHistorial++){
                if(peliculas.get(indiceMultimedia).equals(usuario.getHistorial().get(indiceHistorial).getMedia())){
                    repetido = true;
                }
            }
            if(!generos.get(1).contains(series.get(indiceMultimedia).getGenero()) || repetido){ 
                peliculas.remove(indiceMultimedia);
            }
            else{
                indiceMultimedia++;
            }
        }
    }
    
    private void determinarMusica(){
        int indiceMultimedia = 0;
        while(indiceMultimedia < series.size()){
            boolean repetido = false;
            for(int indiceHistorial = 0; indiceHistorial < usuario.getHistorial().size() && !repetido; indiceHistorial++){
                if(musica.get(indiceMultimedia).equals(usuario.getHistorial().get(indiceHistorial).getMedia())){
                    repetido = true;
                }
            }
            if(!generos.get(2).contains(series.get(indiceMultimedia).getGenero()) || repetido){ 
                musica.remove(indiceMultimedia);
            }
            else{
                indiceMultimedia++;
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
