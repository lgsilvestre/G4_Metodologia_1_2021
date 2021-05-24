package triviñoplay.Datos;
import triviñoplay.Logica.Cuenta;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sudaii
 */
public class GestorDatos {
    private final ArrayList<Cuenta> cuentas;
    private final String direccionImagenesPerfil;
    
    public GestorDatos(){
        cuentas = new ArrayList<>();
        //media = new ArrayList();
        direccionImagenesPerfil = "Recursos/Imagenes/Perfil";
        leerCuentas();
        //leerMedia();
    }
    
    public ArrayList<Cuenta> getCuentas(){
        return cuentas;
    }
    
    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
    
    public boolean eliminarCuenta(String email){
        for(Cuenta cuenta: cuentas){
            if(cuenta.getEmail().equals(email)){
                cuentas.remove(cuenta);
                return true;
            }
        }
        return false;
    }
    
    private void leerCuentas(){
        File datosCuentas = new File("Datos/BaseDeDatos.txt");
        if(datosCuentas.exists()){
            try {
                Scanner lector = new Scanner(datosCuentas);
                while(lector.hasNextLine()){
                    String datos = lector.nextLine();
                    ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(datos.split(",")));
                    if(datosSeparados.size() == 5){
                        String nombre = datosSeparados.get(0);
                        String contrasena = datosSeparados.get(1);
                        String email = datosSeparados.get(2);
                        String adminString = datosSeparados.get(3);
                        boolean admin = false;
                        if(adminString.equals("true")){
                            admin = true;
                        }
                        String nombreImagen = datosSeparados.get(4);
                        String direccionImagenPerfil  = direccionImagenesPerfil+"/"+nombreImagen;
                        cuentas.add(new Cuenta(nombre, contrasena, email, admin, direccionImagenPerfil));
                    }
                }
            } catch (FileNotFoundException ex) {}       
        }
    }
    
    private void leerMedia(){
        
    }
    
    public void almacenarCuentas(){
        File datosCuentasViejos = new File("Datos/BaseDeDatos.txt");
        datosCuentasViejos.delete();
        File datosCuentasNuevos = new File("Datos/BaseDeDatos.txt");
        try{
            datosCuentasNuevos.createNewFile();
        }catch(IOException IOException){}
        try {
            FileWriter escritor = new FileWriter("Datos/BaseDeDatos.txt");
            for(Cuenta cuenta: cuentas){
                String datos = cuenta.datosEnString();
            }
            writer.close();
        } catch (IOException ex) {}

    }

}
