package triviñoplay.Logica;
import javafx.scene.image.Image;

/**
 *
 * @author Sudaii
 */
public class Cuenta {
    private String nombre;
    private String contrasena;
    private String email;
    private boolean admin;
    private String direccionImagenPerfil;
    private Image imagenPerfil;
    
    
    public Cuenta(String nombre, String contrasena, String email, boolean admin, String direccionImagenPerfil){
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.admin = admin;
        this.direccionImagenPerfil = direccionImagenPerfil;
        imagenPerfil = new Image(direccionImagenPerfil);
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setAdmin(boolean admin){
        this.admin =  admin;
    }
    
    public void setImagenPerfil(Image imagen){
        imagenPerfil = imagen;
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
    
    public Image getImage(){
        return imagenPerfil;
    }
    
    /**
     * Retorna si la contraseña ingresada es igual a la contraseña actual del usuario.
     * @param contrasena la contraseña ingresada
     * @return           si la contraseña ingresada es igual a la contraseña actual del usuario
     */
    public boolean esContrasenaActual(String contrasena){
        return contrasena.equals(this.contrasena);
    }

    public String datosEnString(){
        String adminString = false;
        if(admin){
            adminString = true;
        }
        String datos = nombre+","+contrasena+","+email+","+direccionImagenPerfil;
        return datos;
    }
    
//    public boolean cambiarContrasena(String contrasenaActual, String contrasenaNueva){
//        if(validarContrasena(contrasenaActual)){
//            contrasena = contrasenaNueva;
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
}
