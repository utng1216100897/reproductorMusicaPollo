/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author gerardo
 */
public class Cancion {
    
    private String titulo;
    private String genero;
    private String artista;
    private String album;
    private int year;
    private String ruta;
    private int id;
    private static int contador=0;

    public static void setContador(int contador) {
        Cancion.contador = contador;
    }

    
    public static int getContador() {
        return contador;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }
    
    
    
    

    public Cancion(int id,String titulo, String genero, String artista, String album, int year, String ruta) {
        this.titulo = titulo;
        this.genero = genero;
        this.artista = artista;
        this.album = album;
        this.year = year;
        this.ruta = ruta;
        this.id = id;
    }

    public Cancion() {
        this(0,"","","","",0,"");
        id = ++contador;
    }

    @Override
    public String toString() {
        return "Cancion{" + "titulo=" + titulo + ", genero=" + genero + ", artista=" + artista + ", album=" + album + ", year=" + year + ", ruta=" + ruta + '}';
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    
    
    
    
    
    
}
