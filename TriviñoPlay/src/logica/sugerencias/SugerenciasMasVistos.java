/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.sugerencias;

import datos.GestorDatos;
import logica.media.*;
import java.util.Comparator;

/**
 * SugerenciasMasVistos implementa un algoritmo de Sugerencias que ordena
 * los objetos Multimedia en base a que tanto han sido reproducidos.
 * Los mas reproducidos estan mas cercanos al tope de la lissta.
 * @author Sudaii
 */
public class SugerenciasMasVistos extends Sugerencias{
    
    /**
     * Constructor de SugerenciasMasVistos. Ordena la lista de objetos Multimedia
     * en base a la cantidad de reproducciones de cada uno.
     * @param datos gestor de datos con las listas de objetos Multimedia en la
     * base de datos
     */
    public SugerenciasMasVistos(GestorDatos datos){
        super(datos);
        series.sort(new OrdenarPorReproducciones());
        peliculas.sort(new OrdenarPorReproducciones());
        musica.sort(new OrdenarPorReproducciones());
    }
    
    /**
     * Compara elementos Multimedia en base a sus reproducciones.
     */
    private class OrdenarPorReproducciones implements Comparator<Multimedia>{
        @Override
        public int compare(Multimedia a, Multimedia b){
            return b.getReproducciones() - a.getReproducciones();
        }
    }

}
