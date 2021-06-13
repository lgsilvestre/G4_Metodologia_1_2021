package logica;

import datos.GestorDatos;

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
    
    public boolean getIngresado(){
        return ingresado;
    }
    
    public boolean ingresarCuenta(String email, String contrasenna){
        boolean emailExiste = false;
        for(int index = 0; index < gestorDatos.getCuentas().size() && !emailExiste && !ingresado; index++){
            if(email.equalsIgnoreCase(gestorDatos.getCuentas().get(index).getEmail())){                
                emailExiste = true;
                if(gestorDatos.getCuentas().get(index).esContrasennaActual(contrasenna)){
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
