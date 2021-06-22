package logica;

import logica.media.*;
import java.util.ArrayList;
        
/**
 *
 * @author Sudaii
 */
public class Cuenta {
    private String nombre;
    private String contrasenna;
    private String email;
    private boolean admin;
    private String direccionImagenPerfil;
    private final ArrayList<Serie> historialSeries;
    private final ArrayList<Pelicula> historialPeliculas;
    private final ArrayList<Musica> historialMusica;    
    
    public Cuenta(String nombre, String contrasenna, String email, boolean admin, String direccionImagenPerfil){
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.email = email;
        this.admin = admin;
        this.direccionImagenPerfil = direccionImagenPerfil;
        historialSeries = new ArrayList<>();        
        historialPeliculas = new ArrayList<>();
        historialMusica = new ArrayList<>();
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setContrasenna(String contrasenna){
        this.contrasenna = contrasenna;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setAdmin(boolean admin){
        this.admin =  admin;
    }
    
    public void setImagenPerfil(String direccionImagenPerfil){
        this.direccionImagenPerfil = direccionImagenPerfil;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getContrasenna(){
        return contrasenna;
    }
    
    public String getEmail(){
        return email;
    }
    
    public boolean getAdmin(){
        return admin;
    }
    
    public String getDireccionImagenPerfil(){
        return direccionImagenPerfil;
    }
    
    public ArrayList<Serie> getHistorialSeries(){
        return historialSeries;
    }
    
    public ArrayList<Pelicula> getHistorialPeliculas(){
        return historialPeliculas;
    }
    
    public ArrayList<Musica> getHistorialMusica(){
        return historialMusica;
    }
    
    public void agregarSerie(Serie serie){
        historialSeries.add(serie);  
    }
    
    public void agregarPelicula(Pelicula pelicula){
        historialPeliculas.add(pelicula);        
    }
    
    public void agregarMusica(Musica musica){
        historialMusica.add(musica);  
    }
    
    /**
     * Retorna si la contrasenna ingresada es igual a la contrasenna actual del usuario.
     * @param contrasenna la contrasenna ingresada
     * @return           si la contrasenna ingresada es igual a la contrasenna actual del usuario
     */
    public boolean esContrasennaActual(String contrasenna){
        return contrasenna.equals(this.contrasenna);
    }
    
    public boolean cambiarContrasena(String contrasennaActual, String contrasennaNueva){
        if(esContrasennaActual(contrasennaActual)){
            contrasenna = contrasennaNueva;
            return true;
        }
        else{
            return false;
        }
    }
    
    public String datosEnString(){
        String adminString = "false";
        if(admin){
            adminString = "true";
        }
        String datos = nombre+","+contrasenna+","+email+","+adminString+","+direccionImagenPerfil;
        return datos;
    }
}
