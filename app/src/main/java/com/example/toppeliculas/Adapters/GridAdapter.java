package com.example.toppeliculas.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.toppeliculas.Pelicula;
import com.example.toppeliculas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * {@link BaseAdapter} personalizado para el gridview
 */
public class GridAdapter extends BaseAdapter {

    private Context contexto;
    private ArrayList<Pelicula> vectorDatos;

    private TextView titulo,calificación,fecha;
    private ImageView imageView;

    public GridAdapter(Context contexto, ArrayList<Pelicula> datos) {
        //Se asignan los valores a los atributos de la clase Pelicula.
        this.contexto = contexto;
        this.vectorDatos = datos;
    }

    @Override
    public int getCount() {
        return vectorDatos.size();
    }

    @Override
    public Object getItem(int posicion) {
        return vectorDatos.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            LayoutInflater layout_inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
            convertView = layout_inflater.inflate(R.layout.gridview_card, null);
        }
        titulo = (TextView) convertView.findViewById(R.id.informacion);
        titulo.setText(vectorDatos.get(position).getTítulo());

        calificación= convertView.findViewById(R.id.Puntuacion);
        calificación.setText(vectorDatos.get(position).getCalificación());

        fecha=convertView.findViewById(R.id.Fecha);
        fecha.setText(vectorDatos.get(position).getFecha());

        imageView=convertView.findViewById(R.id.imagenLogo);
        //imageView.setImageResource(vectorDatos.get(position).getImagen());

        Picasso.with(contexto)
                .load(vectorDatos.get(position).getUrl_poster())
                .placeholder(R.drawable.ic_broken_image_black_24dp)
                .fit()
                .centerCrop().into(imageView);

        return convertView;
    }
}

