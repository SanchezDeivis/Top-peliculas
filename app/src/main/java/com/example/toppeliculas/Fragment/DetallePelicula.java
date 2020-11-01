package com.example.toppeliculas.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.toppeliculas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetallePelicula extends Fragment {
    private ImageView imagedetalle;
    private TextView puntuaciondetalle, titulodetalle, fechadetalle;
    private Favoritas favoritas;
    private String imagen;
    Context context;

    public DetallePelicula() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);

        context=getContext();
        favoritas = new Favoritas();

        imagedetalle = view.findViewById(R.id.imagenLogodetalle);
        puntuaciondetalle = view.findViewById(R.id.Puntuaciondetalle);
        titulodetalle = view.findViewById(R.id.titulodetalle);
        fechadetalle = view.findViewById(R.id.Fechadetalle);

        if (getArguments() != null) {

            Bundle datos = getActivity().getIntent().getExtras();

            imagen = getArguments().getString("imagen");
            String puntu = getArguments().getString("calificación");
            final String titul = getArguments().getString("titulo");
            String fecha = getArguments().getString("fecha");

            getActivity().setTitle(titul);

            Picasso.with(context).load(imagen).placeholder(R.drawable.ic_broken_image_black_24dp).fit().centerCrop().into(imagedetalle);
            puntuaciondetalle.setText(puntu);
            titulodetalle.setText(titul);
            fechadetalle.setText(fecha);
        }
        FloatingActionButton fab = view.findViewById(R.id.btnAddfavoritos);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("titulodetalle", titulodetalle.getText().toString());
                bundle.putString("puntuaciondetalle", puntuaciondetalle.getText().toString());
                bundle.putString("fechadetalle", fechadetalle.getText().toString());
                bundle.putString("imagen", imagen);
                favoritas.setArguments(bundle);

              /* getSupportFragmentManager().beginTransaction().add
                        (R.id.id_Fragment_Contenido, favoritas, "favoritas")
                        .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .addToBackStack("favoritas").commit();
                getSupportFragmentManager().beginTransaction().add(R.id.id_Fragment_Contenido, favoritas).commit();
                setTitle(R.string.title_favoritas);*/

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.id_Fragment_Contenido, favoritas);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

}
