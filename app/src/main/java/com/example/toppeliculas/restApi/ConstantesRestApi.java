package com.example.toppeliculas.restApi;

public final class ConstantesRestApi {

    public static final String VERSION = "/3/";
    public static final String ROOT_URL = "https://api.themoviedb.org" + VERSION;
    public static final String ACCESS_TOKEN = "0d677b16a44d2b5a79edf325bc1ee9b7&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
    public static final String KEY_ACCESS_TOKEN = "movie?api_key=";
    public static final String KEY_GET_INFORMATION_DISCOVER = "discover/";
    public static final String URL_GET_INFORMATION_DISCOVER = KEY_GET_INFORMATION_DISCOVER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



    //  https://api.themoviedb.org/3/discover/movie?api_key=0d677b16a44d2b5a79edf325bc1ee9b7&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1
    //https://api.themoviedb.org/3/configuration?api_key=0d677b16a44d2b5a79edf325bc1ee9b7
}
