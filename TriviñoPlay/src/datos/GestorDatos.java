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
    private ArrayList<Serie> series;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Musica> musica;
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
                    ArrayList<Episodio> episodios = new ArrayList<>();
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
                    vincularEpisodios(episodios);
                }
            } catch (FileNotFoundException ex) {}       
        }
    }
    
    private void vincularEpisodios(ArrayList<Episodio> episodios){
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
