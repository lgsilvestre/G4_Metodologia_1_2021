/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Admn
 */
public abstract class Contenido implements Comparable<Contenido> , java.io.Serializable{
    String nombre;
    String autor;
    String fechaEstreno;
    String genero;
    String codigoCapitulo;
    String duracion;
    String sinopsis;

    double duracionTotal;
    double ultimaDuracion;
    int visitCount;

    public double getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(double duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
    

    
    public Contenido() {
        ultimaDuracion=0;
    }
    
    
    
    
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public String getGenero() {
        return genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getCodigoCapitulo() {
        return codigoCapitulo;
    }

    public void setCodigoCapitulo(String codigoCapitulo) {
        this.codigoCapitulo = codigoCapitulo;
    }

 

    public double getUltimaDuracion() {
        return ultimaDuracion;
    }

    public void setUltimaDuracion(double ultimaDuracion) {
        this.ultimaDuracion = ultimaDuracion;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
    
    /**Compara dos contenidos según su contador de visitas.
     * @param c Contenido a comparar.
     * @return el numero resultado de comparar.
     * -1 si el contenido a comparar es menor.
     * 0 si el contenido a comparar es igual.
     * 1 si el contenido a comparar es mayor
     */
    @Override
    public int compareTo(Contenido c) {
        return (this.getVisitCount() < c.getVisitCount() ? 1:
                this.getVisitCount() == c.getVisitCount() ? 0 : -1);
    }
    
}
