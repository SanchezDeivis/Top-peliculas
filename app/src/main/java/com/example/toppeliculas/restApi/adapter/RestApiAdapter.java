package com.example.toppeliculas.restApi.adapter;

import com.example.toppeliculas.Pelicula;
import com.example.toppeliculas.restApi.ConstantesRestApi;
import com.example.toppeliculas.restApi.EndpointsApi;
import com.example.toppeliculas.restApi.deserializador.PeliculaDeserializador;
import com.example.toppeliculas.restApi.model.PeliculaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public EndpointsApi establecerConexionRestApiapiThemoviedb(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsApi.class);
    }
    public Gson ConstruyeGsonDeserializadorInformationRecent(){
        GsonBuilder gsonBuilder= new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PeliculaResponse.class, new PeliculaDeserializador());

       return gsonBuilder.create();
    }
}
