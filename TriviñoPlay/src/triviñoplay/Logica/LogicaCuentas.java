/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviñoplay.Logica;

import triviñoplay.Datos.GestorDatos;

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
    
    private boolean existeCuenta(String email){
        boolean emailExiste = false;
        for(int index = 0; index < gestorDatos.getCuentas().size() && !emailExiste; index++){
            if(email.equals(gestorDatos.getCuentas().get(index).getEmail())){
                emailExiste = true;
            }
        }
        return emailExiste;
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
