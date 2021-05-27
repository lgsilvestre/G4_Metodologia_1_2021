package triviñoplay.Datos;
import triviñoplay.Logica.Cuenta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Sudaii
 */
public class GestorDatos {
    private final ArrayList<Cuenta> cuentas;
    private final String direccionDatosCuentas = "Datos/DatosCuentas.txt";
    
    public GestorDatos(){
        cuentas = new ArrayList<>();
        //media = new ArrayList();
        leerCuentas();
        //leerMedia();
    }
    
    public ArrayList<Cuenta> getCuentas(){
        return cuentas;
    }
    
    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
    
    public void eliminarCuenta(String email){
        boolean cuentaEliminada = false;
        for(int index = 0; index < cuentas.size() && !cuentaEliminada; index++){
            if(email.equals(cuentas.get(index).getEmail())){
                cuentas.remove(index);
                cuentaEliminada = true;
            }
        }
    }
    
    private void leerCuentas(){
        File datosCuentas = new File(direccionDatosCuentas);
        if(datosCuentas.exists()){
            try {
                try (Scanner lector = new Scanner(datosCuentas)) {
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
                            String direccionImagenPerfil = datosSeparados.get(4);
                            cuentas.add(new Cuenta(nombre, contrasena, email, admin, direccionImagenPerfil));
                        }
                    }
                }
            } catch (FileNotFoundException ex) {}       
        }
    }
    
    private void leerMedia(){
        
    }
    
    public void almacenarCuentas(){
        File datosCuentasViejos = new File(direccionDatosCuentas);
        datosCuentasViejos.delete();
        File datosCuentasNuevos = new File(direccionDatosCuentas);
        try{
            datosCuentasNuevos.createNewFile();
        }catch(IOException IOException){}
        try {
            try (FileWriter escritor = new FileWriter(direccionDatosCuentas)) {
                for(Cuenta cuenta: cuentas){
                    String datos = cuenta.datosEnString();
                    escritor.write(datos+"\n");
                }
            }
        } catch (IOException ex) {}
    }

}
