package com.jllalt.mystockapp.data.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IProductServices {

    @GET
    Call<Object> getAllProducts();

    @POST
    Call<Object> postProduct(String codeEan);
}
