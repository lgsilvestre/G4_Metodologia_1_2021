package logica;

import java.util.ArrayList;
import logica.media.Multimedia;
        
/**
 * Cuenta implementa la cuenta de un usuario del sistema
 * @author Sudaii
 */
public class Cuenta {
    //nombre: Nombre del usuario
    //contrasenna: Contraseña del usuario
    //email: Correo del usuario
    //direccionImagenPerfil: La dirección a la imagen de perfil del usuario
    private String nombre, contrasenna, email, direccionImagenPerfil;
    //Si el usuario es administrador
    private boolean admin;
    //Historial de objetos Multimedia reproducidos por el usuario
    private final ArrayList<DatoHistorial> historial; 
    
    /**
     * Constructor de Cuenta. Recibe cada uno de los datos que debe tener una cuenta.
     * @param nombre nombre del usuario
     * @param contrasenna contraseña del usuario
     * @param email correo del usuario
     * @param admin si el usuario es administrador
     * @param direccionImagenPerfil la dirección de la imagen de perfil del usuario
     */
    public Cuenta(String nombre, String contrasenna, String email, boolean admin, String direccionImagenPerfil){
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.email = email;
        this.admin = admin;
        this.direccionImagenPerfil = direccionImagenPerfil;
        historial = new ArrayList<>();        
    }
    
    /**
     * Cambia el nombre del usuario al nombre ingresado
     * @param nombre el nuevo nombre del usuario
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Cambia la contraseña del usuario a la contraseña ingresada
     * @param contrasenna la nueva contraseña del usuario
     */
    public void setContrasenna(String contrasenna){
        this.contrasenna = contrasenna;
    }
    
    /**
     * Cambia el correo del usuario al correo ingresado
     * @param email el nuevo correo del usuario
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * Cambia si el usuario es administrador en base al booleano ingresado
     * @param admin si el usuario sera administrador
     */
    public void setAdmin(boolean admin){
        this.admin =  admin;
    }
    
    /**
     * Cambia la direccion de la imagen de perfil a la direccion ingresada
     * @param direccionImagenPerfil la nueva direccion de imagen de perfil
     */
    public void setImagenPerfil(String direccionImagenPerfil){
        this.direccionImagenPerfil = direccionImagenPerfil;
    }
    
    /**
     * Retorna el nombre del usuario
     * @return nombre del usuario
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Retorna la contraseña del usuario
     * @return contraseña del usuario
     */
    public String getContrasenna(){
        return contrasenna;
    }
    
    /**
     * Retorna el correo del usuario
     * @return correo del usuario
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Retorna si el usuario es administrador
     * @return si el usuario es administrador
     */
    public boolean getAdmin(){
        return admin;
    }
    
    /**
     * Retorna la direccion de la imagen de perfil del usuario
     * @return direccion de la imagen de perfil del usuario
     */
    public String getDireccionImagenPerfil(){
        return direccionImagenPerfil;
    }
    
    /**
     * Retorna el historial del usuario
     * @return el historial del usuario
     */
    public ArrayList<DatoHistorial> getHistorial(){
        return historial;
    }
    
    /**
     * Retorna si la contraseña ingresada es igual a la contraseña actual del usuario.
     * @param contrasenna la contraseña ingresada
     * @return           si la contraseña ingresada es igual a la contraseña actual del usuario
     */
    public boolean esContrasennaActual(String contrasenna){
        return contrasenna.equals(this.contrasenna);
    }
    
    /**
     * Agrega un objeto Multimedia al historial de reproducción del usuario
     * @param media objeto multimedia a agregar al historial
     * @param completado si el usuario completo su reproduccion
     */
    public void agregarAHistorial(Multimedia media, boolean completado){
        boolean repetido = false;
        int indice = 0;
        while(indice < historial.size() && !repetido){
            if(media.equals(historial.get(indice).getMedia())){
                repetido = true;
            }
            else{
                indice++;
            }
        }
        if(repetido){
            historial.get(indice).setCompletado(completado);
        }
        else{
            historial.add(new DatoHistorial(media, completado));
        }
    }
    
    /**
     * Retorna los datos del usuario, separados por comas, en un String 
     * @return los datos del usuario, separados por comas, en un String
     */
    public String datosEnString(){
        String adminString = "false";
        if(admin){
            adminString = "true";
        }
        String datos = nombre+","+contrasenna+","+email+","+adminString+","+direccionImagenPerfil;
        return datos;
    }
}
