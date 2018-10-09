package com.farrasabiyyu12.kamusgaul.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL="https://kitabgaul.com/api/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Apinterface getInstance() {
        return setInit().create(Apinterface.class);
    }
}
