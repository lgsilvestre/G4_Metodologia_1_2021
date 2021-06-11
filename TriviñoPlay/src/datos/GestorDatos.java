package datos;
import logica.media.Episodio;
import logica.media.Serie;
import logica.media.Musica;
import logica.media.Pelicula;
import logica.Cuenta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Sudaii
 */
public class GestorDatos {
    private ArrayList<Cuenta> cuentas;
    private final ArrayList<Serie> series;
    private final ArrayList<Pelicula> peliculas;
    private final ArrayList<Musica> musica;
    private final String direccionDatosCuentas = "src/datos/DatosCuentas.txt";
    private final String direccionDatosSeries = "src/datos/DatosSeries.txt";
    private final String direccionDatosMultimedia = "src/datos/DatosMultimedia.txt";
    
    public GestorDatos(){
        cuentas = new ArrayList<>();
        series = new ArrayList<>();
        peliculas = new ArrayList<>();
        musica = new ArrayList<>();
        leerCuentas();
        leerMultimedia();
    }
    
    public void setCuentas(ArrayList<Cuenta> cuentas){
        this.cuentas = cuentas;
    }
    
    public ArrayList<Cuenta> getCuentas(){
        return cuentas;
    }
    
    public ArrayList<Serie> getSeries(){
        return series;
    }
    
    public ArrayList<Pelicula> getPeliculas(){
        return peliculas;
    }
    
    public ArrayList<Musica> getMusica(){
        return musica;
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
    
    public void agregarEpisodio(Episodio episodio){
        boolean episodioAgregado = false;
        for(int index = 0; index < series.size() && !episodioAgregado; index++){
            if(episodio.getSerie().equals(series.get(index).getTitulo())){
                series.get(index).agregarEpisodio(episodio);
                episodioAgregado = true;
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
                            if(adminString.equalsIgnoreCase("true")){
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
    
    private void leerMultimedia(){
        leerSeries();
        File datosMultimedia = new File(direccionDatosMultimedia);
        if(datosMultimedia.exists()){
            try {
                try (Scanner lector = new Scanner(datosMultimedia)) {
                    while(lector.hasNextLine()){
                        String datos = lector.nextLine();
                        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(datos.split(",")));
                        if(datosSeparados.size() > 6){
                            String tipo = datosSeparados.get(0);
                            String titulo = datosSeparados.get(1);
                            String fechaString = datosSeparados.get(2);
                            int reproducciones = Integer.valueOf(datosSeparados.get(3));
                            String direccionArchivo = datosSeparados.get(4);
                            String direccionPortada = datosSeparados.get(5);
                            switch (tipo) {
                                case "Episodio":
                                    String serie = datosSeparados.get(6);
                                    int numEpisodio = Integer.valueOf(datosSeparados.get(7));
                                    agregarEpisodio(new Episodio(direccionArchivo, 
                                            titulo, fechaString, direccionPortada, 
                                            reproducciones,serie, numEpisodio));
                                    break;
                                case "Pelicula":
                                    String director = datosSeparados.get(6);
                                    String descripcion = datosSeparados.get(7);
                                    String generoPelicula = datosSeparados.get(8);
                                    peliculas.add(new Pelicula(direccionArchivo, 
                                            titulo, fechaString, direccionPortada, reproducciones,
                                            director, descripcion, generoPelicula));
                                    break;
                                case "Musica":
                                    String album = datosSeparados.get(6);
                                    String artista = datosSeparados.get(7);
                                    String generoMusica = datosSeparados.get(8);  
                                    musica.add(new Musica(direccionArchivo, titulo, 
                                            fechaString, direccionPortada, reproducciones,
                                            album, artista, generoMusica));
                                    break;
                                default:
                                    break;
                            }
                        }
                        
                    }
                }
            } catch (FileNotFoundException ex) {}       
        }
    }
    
    private void leerSeries(){
        File datosSeries = new File(direccionDatosSeries);
        if(datosSeries.exists()){
            try {
                try (Scanner lector = new Scanner(datosSeries)) {
                    while(lector.hasNextLine()){
                        String datos = lector.nextLine();
                        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(datos.split(",")));
                        if(datosSeparados.size() == 4){
                            String titulo = datosSeparados.get(0);
                            String generoSerie = datosSeparados.get(1);
                            String descripcion = datosSeparados.get(2);
                            String direccionPortada = datosSeparados.get(3);
                            series.add(new Serie(titulo, generoSerie, descripcion, direccionPortada));
                        }
                    }
                }
            } catch (FileNotFoundException ex) {}       
        }
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
    
    public void almacenarMultimedia(){
        File datosMultimediaViejos = new File(direccionDatosMultimedia);
        datosMultimediaViejos.delete();
        File datosMultimediaNuevos = new File(direccionDatosMultimedia);
        try{
            datosMultimediaNuevos.createNewFile();
        }catch(IOException IOException){}
        try {
            try (FileWriter escritor = new FileWriter(direccionDatosMultimedia)) {
                for(Serie serie: series){
                    for(Episodio episodio: serie.getEpisodios()){
                        String datos = episodio.datosEnString();
                        escritor.write(datos+"\n");
                    }
                }
                for(Pelicula pelicula: peliculas){
                    String datos = pelicula.datosEnString();
                    escritor.write(datos+"\n");
                }
                for(Musica cancion: musica){
                    String datos = cancion.datosEnString();
                    escritor.write(datos+"\n");
                }
            }
        } catch (IOException ex) {}
    }
    
    public void almacenarSeries(){
        File datosSeriesViejos = new File(direccionDatosSeries);
        datosSeriesViejos.delete();
        File datosSeriesNuevos = new File(direccionDatosSeries);
        try{
            datosSeriesNuevos.createNewFile();
        }catch(IOException IOException){}
        try {
            try (FileWriter escritor = new FileWriter(direccionDatosSeries)) {
                for(Serie serie: series){
                    String datos = serie.datosEnString();
                    escritor.write(datos+"\n");
                }
            }
        } catch (IOException ex) {}
    }

}
