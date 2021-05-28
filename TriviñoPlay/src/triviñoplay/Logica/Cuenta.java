package triviñoplay.Logica;
import javafx.scene.image.Image;

/**
 *
 * @author Sudaii
 */
public class Cuenta {
    private String nombre;
    private String contraseña;
    private String email;
    private boolean admin;
    private String direccionImagenPerfil;
    private Image imagenPerfil;
    
    public Cuenta(String nombre, String contraseña, String email, boolean admin, String direccionImagenPerfil){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.admin = admin;
        this.direccionImagenPerfil = direccionImagenPerfil;
        imagenPerfil = new Image(direccionImagenPerfil);
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setAdmin(boolean admin){
        this.admin =  admin;
    }
    
    public void setImagenPerfil(String direccionImagenPerfil){
        this.direccionImagenPerfil = direccionImagenPerfil;
        imagenPerfil = new Image(direccionImagenPerfil);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
    }
    
    public boolean getAdmin(){
        return admin;
    }
    
    public Image getImagenPerfil(){
        return imagenPerfil;
    }
    
    /**
     * Retorna si la contraseña ingresada es igual a la contraseña actual del usuario.
     * @param contraseña la contraseña ingresada
     * @return           si la contraseña ingresada es igual a la contraseña actual del usuario
     */
    public boolean esContraseñaActual(String contraseña){
        return contraseña.equals(this.contraseña);
    }
    
    public boolean cambiarContrasena(String contraseñaActual, String contraseñaNueva){
        if(esContraseñaActual(contraseñaActual)){
            contraseña = contraseñaNueva;
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
        String datos = nombre+","+contraseña+","+email+","+adminString+","+direccionImagenPerfil;
        return datos;
    }
}
