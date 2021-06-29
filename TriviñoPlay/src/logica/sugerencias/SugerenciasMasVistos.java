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
        series.sort(new OrdenarPorReproducciones());
        peliculas.sort(new OrdenarPorReproducciones());
        musica.sort(new OrdenarPorReproducciones());
    }
    
    public class OrdenarPorReproducciones implements Comparator<Multimedia>{
        @Override
        public int compare(Multimedia a, Multimedia b){
            return b.getReproducciones() - a.getReproducciones();
        }
    }

}
