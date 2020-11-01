package com.example.toppeliculas.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.toppeliculas.Adapters.GridAdapter;
import com.example.toppeliculas.Pelicula;
import com.example.toppeliculas.R;

import java.util.ArrayList;
import java.util.List;

public class Favoritas extends Fragment {

    private GridAdapter adaptador;
    private GridView gridViewf;
    private String titulodetalle, puntuaciondetalle, fechadetalle, imagen;

    private List<Pelicula> gridViewPeliculaList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favoritas, container, false);
        if (getArguments() != null) {
            titulodetalle = getArguments().getString("titulodetalle");
            puntuaciondetalle = getArguments().getString("puntuaciondetalle");
            fechadetalle = getArguments().getString("fechadetalle");
            imagen = getArguments().getString("imagen");
        }
        obtenerInformation();

        gridViewf = (GridView) view.findViewById(R.id.gridviewfavoritas);
        adaptador = new GridAdapter(view.getContext(), (ArrayList<Pelicula>) gridViewPeliculaList);
        gridViewf.setAdapter(adaptador);
        return view;
    }

    private void obtenerInformation() {
        Pelicula peliculaActual;
        peliculaActual = new Pelicula(titulodetalle,"","","",fechadetalle,imagen);
        gridViewPeliculaList.add(peliculaActual
        );
    }


}
