
package logica;

import logica.media.*;

/**
 * DatoHistorial representa una entrada o tupla del historial de reproducción
 * de objetos Multimedia de un usuario
 * @author Sudaii
 */
public class DatoHistorial {
    //media: Objeto Multimedia reproducido
    Multimedia media;
    //completado: Si el usuario completo la reproducción del objeto Multimedia
    boolean completado;
    
    /**
     * Constructor de DatoHistorial
     * @param media objeto Multimedia reproducido
     * @param completado si el usuario completo la reproducción del objeto Multimedia
     */
    public DatoHistorial(Multimedia media, boolean completado){
        this.media = media;
        this.completado = completado;
    }
    
    /**
     * Cambia si el usuario completo la reproduccioön del objeto Multimedia
     * @param completado si el usuario completo la reproduccioön del objeto Multimedia 
     */
    public void setCompletado(boolean completado){
        this.completado = completado;
    }
    
    /**
     * Retorna el objeto Multimedia reproducido
     * @return el objeto Multimedia reproducido
     */
    public Multimedia getMedia(){
        return media;
    }
    
    /**
     * Retorna si el usuario completo la reproduccioön del objeto Multimedia
     * @return si el usuario completo la reproduccioön del objeto Multimedia 
     */
    public boolean getCompletado(){
        return completado;
    }
}
