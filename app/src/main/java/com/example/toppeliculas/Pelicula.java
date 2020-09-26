package com.example.toppeliculas;

public class Pelicula {
    private String título,titulo_original, calificación, descripción, fecha,url_poster;
    private int imagen;


    public Pelicula(String título, String calificación, String descripción, String fecha, int imagen) {
        this.título = título;
        this.calificación = calificación;
        this.descripción = descripción;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public Pelicula(String título,String titulo_original, String calificación, String descripción, String fecha, String url_poster) {
        this.título = título;
        this.titulo_original=titulo_original;
        this.calificación = calificación;
        this.descripción = descripción;
        this.fecha = fecha;
        this.url_poster = url_poster;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    public String getUrl_poster() {
        return url_poster;
    }

    public void setUrl_poster(String url_poster) {
        this.url_poster = url_poster;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getCalificación() {
        return calificación;
    }

    public void setCalificación(String calificación) {
        this.calificación = calificación;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
