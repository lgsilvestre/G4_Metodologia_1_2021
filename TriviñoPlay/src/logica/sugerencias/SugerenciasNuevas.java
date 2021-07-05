/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.sugerencias;

import datos.GestorDatos;
import java.util.Comparator;
import logica.media.Multimedia;
import logica.media.Serie;

/**
 *
 * @author Sudaii
 */
public class SugerenciasNuevas extends Sugerencias{
    public SugerenciasNuevas(GestorDatos datos){
        super(datos);
        series.sort(new OrdenarPorFecha());
        peliculas.sort(new OrdenarPorFecha());
        musica.sort(new OrdenarPorFecha());
    }
    
    public class OrdenarPorFecha implements Comparator<Multimedia>{
        @Override
        public int compare(Multimedia a, Multimedia b){
            return b.getFecha().compareTo(a.getFecha());
        }
    }
}
