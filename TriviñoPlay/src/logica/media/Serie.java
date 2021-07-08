package logica.media;

import java.util.ArrayList;

/**
 * Serie implementa una serie; un recurso audiovisual que consta de una lista de
 * episodios reproducibles vinculadas por una trama o tema, con la intención
 * de verse en un orden especifico.
 * @author Sudaii
 */
public class Serie extends Multimedia {
    //episodios: lista de episodios de la serie.
    private ArrayList<Episodio> episodios;
    //descripcion: de que trata la serie.
    private final String descripcion;
    
    /**
     * Constructor Serie. Genera una Serie con los datos ingresados.
     * @param titulo titulo del objeto Multimedia
     * @param genero genero del objeto Multimedia
     * @param fechaString fecha en la que se producio el objeto Multimedia
     * (formato: "aaaa-mm-dd")
     * @param direccionPortada la direccion de la portada del objeto Multimedia 
     * @param reproducciones numero de veces que se ha reproducido el objeto Multimedia
     * @param descripcion de que trata la serie
     */
    public Serie(String titulo, String genero, String fechaString, 
            String direccionPortada, int reproducciones, String descripcion){
        super(titulo, genero, fechaString, direccionPortada, reproducciones);
        tipo = "Serie";
        this.descripcion = descripcion;
    }
    
    /**
     * Retorna la lista de episodios de la serie.
     * @return la lista de episodios de la serie
     */
    public ArrayList<Episodio> getEpisodios(){
        return episodios;
    }
    
    /**
     * Retorna de que trata la serie.
     * @return de que trata la serie
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Agrega un episodio a la lista de episodios de la serie.
     * @param episodio episodio a agregar a la lista
     */
    public void agregarEpisodio(Episodio episodio){
        if(existeEpisodio(episodio.getNumEpisodio())){
            episodios.remove(episodio.getNumEpisodio());
            episodios.add(episodio.getNumEpisodio(), episodio);
        }
        else{
            int index;
            for(index = 0; 
                    index < episodios.size() && episodios.get(index).getNumEpisodio() < episodio.getNumEpisodio(); 
                    index++){}
            episodios.add(index, episodio);
        }
        actualizarReproducciones();
    }
    
    /**
     * Remueve un episodio de la lista de episodios de la serie.
     * @param numEpisodio númer del episodio a remover de la lista
     * @return si el episodio se removio exitosamente
     */
    public boolean removerEpisodio(int numEpisodio){
        boolean removido = false;
        if(existeEpisodio(numEpisodio)){
            episodios.remove(numEpisodio);
                actualizarReproducciones();
        }
        return removido;
    }
    
    private boolean existeEpisodio(int numEpisodio){
        boolean existeEpisodio = false;
        for(int index = 0; index < episodios.size() && !existeEpisodio; index++){
            if(numEpisodio == episodios.get(index).getNumEpisodio()){
                existeEpisodio = true;
            }
        }
        return existeEpisodio;        
    }
    
    /**
     * Reproduce el episodio de número ingresado.
     * @param numEpisodio el número del episodio a reproducir
     */
    public void reproducirEpisodio(int numEpisodio){
        episodios.get(numEpisodio).reproducir();
        actualizarReproducciones();
    }
    
    /**
     * Actualiza la cantidad de veces que se ha reproducido la serie en base
     * a sus episodios.
     */
    private void actualizarReproducciones(){
        reproducciones = 0;
        episodios.forEach((episodio) -> {
            reproducciones+=episodio.getReproducciones();
        });
    }
    
    /**
     * Retorna los datos de la Serie, separados por comas, en forma de String.
     * @return los datos de la Serie, separados por comas, en forma de String
     */
    @Override
    public String datosEnString(){
        String datos = tipo+","+datosComunesEnString()+","+descripcion;
        return datos;
    }
}
