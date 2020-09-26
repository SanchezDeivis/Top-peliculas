package com.example.toppeliculas.restApi.model;

import com.example.toppeliculas.Pelicula;

import java.util.ArrayList;

public class PeliculaResponse {

    ArrayList<Pelicula> ListPelicula;


    public ArrayList<Pelicula> getListPelicula() {
        return ListPelicula;
    }

    public void setListPelicula(ArrayList<Pelicula> listPelicula) {
        ListPelicula = listPelicula;
    }
}
