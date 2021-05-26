package triviñoplay.Logica;

import triviñoplay.Datos.GestorDatos;
import java.util.ArrayList;

/**
 *
 * @author Sudaii
 */
public class UsuarioLog {
    private final GestorDatos gestorDatos;
    private Cuenta cuentaActiva;
    private boolean ingresado;
    
    public UsuarioLog(GestorDatos gestorDeDatos){
        this.gestorDatos = gestorDeDatos;
        cuentaActiva = null;
        ingresado = false;
    }
    
    public Cuenta getCuentaActiva(){
        if(ingresado){
            return cuentaActiva;
        }
        else{
            return null;
        }
    }
    
    public boolean ingresarCuenta(String email, String contraseña){
        for(int index = 0; index < gestorDatos.getCuentas().size() && !ingresado; index++){
            if(email.equals(gestorDatos.getCuentas().get(index).getEmail())){
                if(gestorDatos.getCuentas().get(index).esContraseñaActual(contraseña)){
                    cuentaActiva = gestorDatos.getCuentas().get(index);
                    ingresado = true;
                    return true;
               }
            }
        }
        return false;
    }
    
    public void salirCuenta(){
        ingresado = false;
    }
}
