/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.GestorDatos;

/**
 *
 * @author Sudaii
 */
public class LogicaCuentas {
    private final GestorDatos gestorDatos;
    
    public LogicaCuentas(GestorDatos gestorDatos){
        this.gestorDatos = gestorDatos;
    }
    
    public boolean agregarCuenta(String nombre, String contraseña, String email, boolean admin, String direccionImagenPerfil){
        if (datosValidos(contraseña) && !existeCuenta(email)){
            gestorDatos.agregarCuenta(new Cuenta(nombre, contraseña, email, admin, direccionImagenPerfil));
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean modificarCuenta(String emailActual, String nuevoNombre, String nuevaContraseña, 
            String nuevoEmail, boolean nuevoAdmin, String nuevaDireccionImagenPerfil){
        if (datosValidos(nuevaContraseña) && !existeCuenta(emailActual)){
            Cuenta cuentaModificada = buscarCuenta(emailActual);
            cuentaModificada.setNombre(nuevoNombre);
            cuentaModificada.setContraseña(nuevaContraseña);
            cuentaModificada.setEmail(nuevoEmail);
            cuentaModificada.setAdmin(nuevoAdmin);
            cuentaModificada.setImagenPerfil(nuevaDireccionImagenPerfil);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean eliminarCuenta(String email){
        if(!existeCuenta(email)){
            gestorDatos.eliminarCuenta(email);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean existeCuenta(String email){
        boolean emailExiste = false;
        for(int index = 0; index < gestorDatos.getCuentas().size() && !emailExiste; index++){
            if(email.equals(gestorDatos.getCuentas().get(index).getEmail())){
                emailExiste = true;
            }
        }
        return emailExiste;
    }
    
    public Cuenta buscarCuenta(String email){
        boolean cuentaEncontrada = false;
        int index;
        for(index = 0; index < gestorDatos.getCuentas().size() && !cuentaEncontrada; index++){
            if(email.equals(gestorDatos.getCuentas().get(index).getEmail())){
                cuentaEncontrada = true;
            }
        }
        return gestorDatos.getCuentas().get(index);
    }
    
    private boolean datosValidos(String contraseña){
        //TODO: validar formato del email
        boolean validos = true;
        if(contraseña.length() < 6){
            validos = false;
        }
        return validos;
    }
}
