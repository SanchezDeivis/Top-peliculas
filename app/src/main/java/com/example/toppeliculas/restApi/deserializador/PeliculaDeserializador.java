package com.example.toppeliculas.restApi.deserializador;

import com.example.toppeliculas.Pelicula;
import com.example.toppeliculas.restApi.JsonKeys;
import com.example.toppeliculas.restApi.model.PeliculaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PeliculaDeserializador implements JsonDeserializer<PeliculaResponse> {

    @Override
    public PeliculaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PeliculaResponse peliculaResponse= gson.fromJson(json, PeliculaResponse.class);
        JsonArray peliculaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.INFORMATION_RESPONSE_ARRAY);
        peliculaResponse.setListPelicula(deserializarPeliculaDeJson(peliculaResponseData));

        return peliculaResponse;
    }
    private ArrayList<Pelicula> deserializarPeliculaDeJson(JsonArray peliculaResponseData){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for (int i=0; i< peliculaResponseData.size();i++) {
            JsonObject peliculaResponseDataOject = peliculaResponseData.get(i).getAsJsonObject();
            String title = peliculaResponseDataOject.get(JsonKeys.INFORMATION_TITLE).getAsString();
            String original_title = peliculaResponseDataOject.get(JsonKeys.INFORMATION_ORIGINAL_TITLE).getAsString();
            String overview = peliculaResponseDataOject.get(JsonKeys.INFORMATION_DESCRIPCION).getAsString();
            String poster_path = peliculaResponseDataOject.get(JsonKeys.INFORMATION_URL_IMAGEN).getAsString();
            float vote_average = peliculaResponseDataOject.get(JsonKeys.INFORMATION_PUNTUACION).getAsFloat();
            String release_date = peliculaResponseDataOject.get(JsonKeys.INFORMATION_FECHA).getAsString();

            String url_poster=("http://image.tmdb.org/t/p/original/"+poster_path);

            Pelicula peliculaActual;
            peliculaActual = new Pelicula(title,original_title,vote_average+"",overview,release_date,url_poster);
           // peliculaActual.setTítulo(title);
            peliculas.add(peliculaActual);
        }
        return peliculas;
    }
}
