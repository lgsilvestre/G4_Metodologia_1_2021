package datos;

import logica.media.*;
import logica.Cuenta;
import logica.DatoHistorial;
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
    private ArrayList<Serie> series;
    private ArrayList<Episodio> episodios;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Musica> musica;
    private final String direccionDatosCuentas = "src/datos/DatosCuentas.txt";
    private final String direccionDatosMultimedia = "src/datos/DatosMultimedia.txt";
    private final String direccionDatosHistorial = "src/datos/DatosHistorial.txt";
    
    public GestorDatos(){
        cuentas = new ArrayList<>();
        series = new ArrayList<>();
        peliculas = new ArrayList<>();
        musica = new ArrayList<>();
        episodios = new ArrayList<>();
        leerCuentas();
        leerMultimedia();
    }
    
    public void setCuentas(ArrayList<Cuenta> cuentas){
        this.cuentas = cuentas;
    }
    
    public void setSeries(ArrayList<Serie> series){
        this.series = series;
    }
    public void setPeliculas(ArrayList<Pelicula> peliculas){
        this.peliculas = peliculas;
    }

    public void setMusica(ArrayList<Musica> musica){
        this.musica = musica;
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

    public boolean agregarEpisodio(Episodio episodio){
        boolean episodioAgregado = false;
        for(int index = 0; index < series.size() && !episodioAgregado; index++){
            if(episodio.getSerie().equals(series.get(index).getTitulo())){
                series.get(index).agregarEpisodio(episodio);
                episodioAgregado = true;
            }
        }
        return episodioAgregado;
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
                            String genero = datosSeparados.get(2);
                            String fechaString = datosSeparados.get(3);
                            String direccionPortada = datosSeparados.get(4);
                            int reproducciones = Integer.valueOf(datosSeparados.get(5));
                            if(tipo.equals("Episodio") || tipo.equals("Pelicula") || tipo.equals("Musica")){
                                String direccionArchivo = datosSeparados.get(6);
                                switch (tipo) {
                                    case "Episodio":
                                        String serie = datosSeparados.get(7);
                                        int numEpisodio = Integer.valueOf(datosSeparados.get(8));
                                        episodios.add(new Episodio(titulo, genero,
                                                fechaString, direccionPortada,
                                                reproducciones, direccionArchivo,
                                                serie, numEpisodio));
                                        break;
                                    case "Pelicula":
                                        String director = datosSeparados.get(7);
                                        String descripcion = datosSeparados.get(8);
                                        peliculas.add(new Pelicula(titulo, genero,
                                                fechaString, direccionPortada,
                                                reproducciones, direccionArchivo,
                                                director, descripcion));
                                        break;
                                    case "Musica":
                                        String album = datosSeparados.get(7);
                                        String artista = datosSeparados.get(8);
                                        peliculas.add(new Pelicula(titulo, genero,
                                                fechaString, direccionPortada,
                                                reproducciones, direccionArchivo,
                                                album, artista));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            else{
                                String descripcion = datosSeparados.get(6);
                                series.add(new Serie(titulo, genero, fechaString,
                                direccionPortada, reproducciones, descripcion));                          
                            }
                        }
                    }
                    vincularEpisodios();
                }
            } catch (FileNotFoundException ex) {}       
        }
    }
    
    private void vincularEpisodios(){
        while(!episodios.isEmpty()){
            Episodio episodio = episodios.remove(0);
            boolean agregado = false;
            for(int indiceSeries = 0; indiceSeries < series.size() && !agregado; indiceSeries++){
                if(episodio.getSerie().equals(series.get(indiceSeries).getTitulo())){
                    series.get(indiceSeries).agregarEpisodio(episodio);
                    agregado = true;
                }
            }
        }
    }
    
    private void leerHistorial(){
        File datosHistorial = new File(direccionDatosHistorial);
        if(datosHistorial.exists()){
            try {
                try (Scanner lector = new Scanner(datosHistorial)) {
                    while(lector.hasNextLine()){
                        String datos = lector.nextLine();
                        ArrayList<String> datosSeparados = new ArrayList<>(Arrays.asList(datos.split(",")));
                        if(datosSeparados.size() == 4){
                            String correo = datosSeparados.get(0);
                            String tipo = datosSeparados.get(1);
                            String titulo = datosSeparados.get(2);
                            String completadoString = datosSeparados.get(3);
                            boolean completado = false;
                            if(completadoString.equalsIgnoreCase("true")){
                                completado = true;
                            }
                            agregarAHistorial(correo, tipo, titulo, completado);
                        }
                    }
                }
            } catch (FileNotFoundException ex) {}       
        }
    }
    
    private boolean agregarAHistorial(String email, String tipo, String titulo, boolean completado){
        switch (tipo) {
            case "Serie":
                for(int i = 0; i < series.size(); i++){
                    if(titulo.equals(series.get(i).getTitulo())){
                        Multimedia media = series.get(i);
                        return agregarAHistorial(email, media, completado);
                    }
                }
                break;
            case "Episodio":
                for(int i = 0; i < episodios.size(); i++){
                    if(titulo.equals(episodios.get(i).getTitulo())){
                        Multimedia media = episodios.get(i);
                        return agregarAHistorial(email, media, completado);
                    }
                }
                break;
            case "Pelicula":
                for(int i = 0; i < peliculas.size(); i++){
                    if(titulo.equals(peliculas.get(i).getTitulo())){
                        Multimedia media = peliculas.get(i);
                        return agregarAHistorial(email, media, completado);
                    }
                }
                break;
            case "Musica":
                for(int i = 0; i < musica.size(); i++){
                    if(titulo.equals(musica.get(i).getTitulo())){
                        Multimedia media = musica.get(i);
                        return agregarAHistorial(email, media, completado);
                    }
                }
                break;
            default:
                break;
        }
        return false;
    }
    
    private boolean agregarAHistorial(String email, Multimedia media, boolean completado){
        for(int index = 0; index < cuentas.size(); index++){
            if(email.equals(cuentas.get(index).getEmail())){
                cuentas.get(index).agregarAHistorial(media, completado);
                return true;
            }
        }
        return false;
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
                    String datos = serie.datosEnString();
                    escritor.write(datos+"\n");
                    for(Episodio episodio: serie.getEpisodios()){
                        datos = episodio.datosEnString();
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
    
    public void almacenarHistorial(){
        File datosHistorialViejos = new File(direccionDatosHistorial);
        datosHistorialViejos.delete();
        File datosHistorialNuevos = new File(direccionDatosHistorial);
        try{
            datosHistorialNuevos.createNewFile();
        }catch(IOException IOException){}
        try {
            try (FileWriter escritor = new FileWriter(direccionDatosHistorial)) {
                for(Cuenta usuario: cuentas){
                    String correo = usuario.getEmail();
                    for(DatoHistorial historia: usuario.getHistorial()){
                        String tipo = historia.getMedia().getTipo();
                        String titulo = historia.getMedia().getTitulo();
                        String completado;
                        if(historia.getCompletado()){
                            completado = "true";
                        }
                        else{
                            completado = "false";
                        }
                        String datos = correo+","+tipo+","+titulo+","+completado;
                        escritor.write(datos+"\n");
                    }
                }
            }
        } catch (IOException ex) {}
    }
}
