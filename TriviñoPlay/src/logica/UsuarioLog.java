package logica;

import datos.GestorDatos;

/**
 * UsuarioLog gestiona la cuenta de usuario activa, incluyendo el inicio y salida
 * de sesión.
 * @author Sudaii
 */
public class UsuarioLog {
    //gestorDatos: el gestor de datos con la lista de cuentas en el sistema
    private final GestorDatos gestorDatos;
    //cuentaActiva: la cuenta con sesión activa
    private Cuenta cuentaActiva;
    //ingresado: si hay una sesión activa
    private boolean ingresado;
    
    /**
     * Constructor de UsuarioLog. Se inicializa sin una sesión activa.
     * @param gestorDeDatos el gestor de datos con la lista de cuentas en el sistema
     */
    public UsuarioLog(GestorDatos gestorDeDatos){
        this.gestorDatos = gestorDeDatos;
        cuentaActiva = null;
        ingresado = false;
    }
    
    /**
     * Si hay una sesión activa, retorna la cuenta activa.
     * @return la cuenta activa (null si no hay sesión activa)
     */
    public Cuenta getCuentaActiva(){
        if(ingresado){
            return cuentaActiva;
        }
        else{
            return null;
        }
    }
    
    /**
     * Retorna si hay una sesión activa
     * @return si hay una sesión activa
     */
    public boolean getIngresado(){
        return ingresado;
    }
    
    /**
     * Inicia sesión con la cuenta ingresada siempre y cuando la contraseña
     * ingresada sea correcta
     * @param email correo de la cuenta a ingresar
     * @param contrasenna contraseña de la cuenta a ingresar
     * @return si se inicio sesión con exito
     */
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
    
    /**
     * Finaliza la sesión activa.
     */
    public void salirCuenta(){
        ingresado = false;
    }
}
