package com.farrasabiyyu12.kamusgaul.rest;

import com.farrasabiyyu12.kamusgaul.model.ResponseGaul;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apinterface {
    @GET("entries;trending?maxCount=100")
    Call<ResponseGaul> getBahasa();
}
