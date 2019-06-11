package com.example.mychef_orwima;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GApi {
    private static final String BASE_API =
            "https://api.punkapi.com/v2/";
    private static APIInterface apiInterface;
    public static APIInterface getApiInterface() {
        if (apiInterface == null) {
            retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(APIInterface.class);
        }
        return apiInterface;
    }
}
