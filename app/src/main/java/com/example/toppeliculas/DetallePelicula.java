package com.example.toppeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toppeliculas.Adapters.GridAdapter;
import com.example.toppeliculas.Fragment.Favoritas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetallePelicula extends AppCompatActivity {
    private ImageView imagedetalle;
    private TextView puntuaciondetalle, titulodetalle, fechadetalle;
    private Favoritas favoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        favoritas = new Favoritas();

        imagedetalle = findViewById(R.id.imagenLogodetalle);
        puntuaciondetalle = findViewById(R.id.Puntuaciondetalle);
        titulodetalle = findViewById(R.id.titulodetalle);
        fechadetalle = findViewById(R.id.Fechadetalle);

        Bundle datos = this.getIntent().getExtras();

        String imagen = datos.getString("imagen");
        String puntu = datos.getString("calificación");
        String titul = datos.getString("titulo");
        String fecha = datos.getString("fecha");

        Picasso.with(this).load(imagen).placeholder(R.drawable.ic_broken_image_black_24dp).fit().centerCrop().into(imagedetalle);
        puntuaciondetalle.setText(puntu);
        titulodetalle.setText(titul);
        fechadetalle.setText(fecha);
        FloatingActionButton fab = findViewById(R.id.btnAddfavoritos);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().add(R.id.id_Fragment_Contenido, favoritas).commit();
                setTitle(R.string.title_favoritas);

            }
        });




    }
}
