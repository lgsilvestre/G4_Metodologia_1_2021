/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.sugerencias;

import datos.GestorDatos;
import logica.Cuenta;
import logica.media.Multimedia;
import logica.media.Serie;
import java.util.ArrayList;

/**
 *
 * @author Sudaii
 */
public class SugerenciasPersonalizadas extends Sugerencias{
    ArrayList<String> generos;
    ArrayList<Integer> cantidad;
    
    public SugerenciasPersonalizadas (GestorDatos datos, Cuenta usuario){
        super(datos);
        generos = new ArrayList<>();
        cantidad = new ArrayList<>();
    }
    
    private void determinarGenerosMasVistos(){
        
    }
    
}
