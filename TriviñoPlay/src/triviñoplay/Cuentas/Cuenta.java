package triviñoplay.Cuentas;
import javafx.scene.image.Image;

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
    
    public boolean validarContrasena(String contrasena){
        return contrasena.equals(this.contrasena);
    }
    
    public boolean cambiarContrasena(String contrasenaActual, String contrasenaNueva){
        if(validarContrasena(contrasenaActual)){
            contrasena = contrasenaNueva;
            return true;
        }
        else{
            return false;
        }
    }
}
