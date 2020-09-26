package com.example.toppeliculas;

import android.app.Activity;
import android.os.Bundle;

import com.example.toppeliculas.Fragment.Favoritas;
import com.example.toppeliculas.Fragment.Todas;
import com.example.toppeliculas.restApi.EndpointsApi;
import com.example.toppeliculas.restApi.adapter.RestApiAdapter;
import com.example.toppeliculas.restApi.model.PeliculaResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Todas todas;
    private Favoritas favoritas;

private  List<Pelicula> gridViewPeliculaList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        obtenerInformation();


        todas = new Todas();
        favoritas = new Favoritas();
        mTextMessage = findViewById(R.id.message);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().add(R.id.id_Fragment_Contenido, todas).commit();
        setTitle(R.string.title_todas);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Todas:
                    setFragment(todas);
                    setTitle(R.string.title_todas);
                    return true;
                case R.id.navigation_Faviritas:
                    setFragment(favoritas);
                    setTitle(R.string.title_favoritas);
                    return true;
                case R.id.navigation_notifications:
                    setTitle(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.id_Fragment_Contenido, fragment);
        fragmentTransaction.commit();
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
                Toast.makeText(MainActivity.this, "AlgoSucedio en la Conexion intenta de nuevo", Toast.LENGTH_SHORT).show();
                System.out.println("FALLO LA CONEXIONM--- "+ t.toString());
            }
        });


    }


}
