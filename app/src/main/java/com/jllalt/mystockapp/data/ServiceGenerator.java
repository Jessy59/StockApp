package com.jllalt.mystockapp.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public final class ServiceGenerator {

    private static Retrofit sRetrofit;

    private static final String BASE_URL_API = "https://apimgt.gateway.alexandrelamoot.cloud/gateway/api-stock/api/";

    private ServiceGenerator() {
    }

    private static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return sRetrofit;
    }

    public static <S> S createService(Class<S> serviceClass) {
        return getRetrofit().create(serviceClass);
    }
}
