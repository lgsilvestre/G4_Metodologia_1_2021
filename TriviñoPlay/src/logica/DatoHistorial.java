/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.media.*;

/**
 *
 * @author Sudaii
 */
public class DatoHistorial {
    Multimedia media;
    boolean completado;
    
    public DatoHistorial(Multimedia media, boolean completado){
        this.media = media;
        this.completado = completado;
    }
    
    public Multimedia getMedia(){
        return media;
    }
    
    public boolean getCompletado(){
        return completado;
    }
}
