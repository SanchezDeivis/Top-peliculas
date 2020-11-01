package com.example.toppeliculas.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import android.app.FragmentTransaction;
import com.example.toppeliculas.Adapters.GridAdapter;
import com.example.toppeliculas.Pelicula;
import com.example.toppeliculas.R;
import com.example.toppeliculas.restApi.EndpointsApi;
import com.example.toppeliculas.restApi.adapter.RestApiAdapter;
import com.example.toppeliculas.restApi.model.PeliculaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Todas extends Fragment {
    private GridAdapter adaptador;
    private GridView gridView;

    private List<Pelicula> gridViewPeliculaList = new ArrayList<>();


    public Todas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todas, container, false);


        obtenerInformation();


        gridView = (GridView) view.findViewById(R.id.gridview);

        adaptador = new GridAdapter(view.getContext(), (ArrayList<Pelicula>) gridViewPeliculaList);
        gridView.setAdapter(adaptador);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(AdapterView<?> item, View vista, int position, long id) {

                Pelicula item1 = (Pelicula) item.getItemAtPosition(position);

                DetallePelicula detallePelicula = new DetallePelicula();

                Bundle bundle = new Bundle();
                bundle.putString("titulo", item1.getTítulo());
                Toast.makeText(getContext(), "¡¡" + item1.getTítulo(), Toast.LENGTH_SHORT).show();
                bundle.putString("calificación", item1.getCalificación());
                bundle.putString("descripción", item1.getDescripción());
                bundle.putString("fecha", item1.getFecha());
                bundle.putString("imagen", item1.getUrl_poster());
                detallePelicula.setArguments(bundle);

                /*getActivity().getSupportFragmentManager().beginTransaction().replace
                        (R.id.id_Fragment_Contenido, detallePelicula, "detallePelicula")
                        .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .addToBackStack("detallePelicula").commit();*/

                androidx.fragment.app.FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.id_Fragment_Contenido, detallePelicula);
                fragmentTransaction.commit();
            }

        });

        return view;
    }

    public void obtenerInformation() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonInformationRecent = restApiAdapter.ConstruyeGsonDeserializadorInformationRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiapiThemoviedb(gsonInformationRecent);

        Call<PeliculaResponse> peliculaResponseCall = endpointsApi.getRecentInformation();

        peliculaResponseCall.enqueue(new Callback<PeliculaResponse>() {
            @Override
            public void onResponse(Call<PeliculaResponse> call, Response<PeliculaResponse> response) {
                PeliculaResponse peliculaResponse = response.body();
                gridViewPeliculaList = peliculaResponse.getListPelicula();
            }

            @Override
            public void onFailure(Call<PeliculaResponse> call, Throwable t) {
                Toast.makeText(getContext(), "AlgoSucedio en la Conexion intenta de nuevo", Toast.LENGTH_SHORT).show();
                System.out.println("FALLO LA CONEXIONM--- "+ t.toString());
            }
        });

    }

}
