package triviñoplay.Cuentas;
import javafx.scene.image.Image;

/**
 *
 * @author Sudaii
 */
public class Cuenta {
    private boolean admin;
    private String nombre;
    private String email;
    private String contrasena;
    private Image imagenPerfil;
    
    public Cuenta(boolean admin, String nombre, String email, String contrasena){
        this.admin = admin;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        imagenPerfil = new Image("../imagendefecto.jpg");
    }
    
    public void setAdmin(boolean admin){
        this.admin =  admin;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    public void setImagenPerfil(Image imagen){
        imagenPerfil = imagen;
    }
    
    public boolean getAdmin(){
        return admin;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
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
