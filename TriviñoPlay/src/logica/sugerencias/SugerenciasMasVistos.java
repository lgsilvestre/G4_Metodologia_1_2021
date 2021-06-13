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
 *
 * @author Sudaii
 */
public class SugerenciasMasVistos extends Sugerencias{
    public SugerenciasMasVistos(GestorDatos datos){
        super(datos);
        peliculas.sort(new OrdenarMultimediaPorReproducciones());
        musica.sort(new OrdenarMultimediaPorReproducciones());
        series.sort(new OrdenarSeriePorReproducciones());
    }
    
    public class OrdenarMultimediaPorReproducciones implements Comparator<Multimedia>{
        @Override
        public int compare(Multimedia a, Multimedia b){
            return b.getReproducciones() - a.getReproducciones();
        }
    }
    
    public class OrdenarSeriePorReproducciones implements Comparator<Serie>{
        @Override
        public int compare(Serie a, Serie b){
            return b.getReproducciones() - a.getReproducciones();
        }
    }
}
