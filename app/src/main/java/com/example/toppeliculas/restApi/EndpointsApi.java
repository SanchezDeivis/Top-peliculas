package com.example.toppeliculas.restApi;

import com.example.toppeliculas.restApi.model.PeliculaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_INFORMATION_DISCOVER)
    Call<PeliculaResponse> getRecentInformation();



}
