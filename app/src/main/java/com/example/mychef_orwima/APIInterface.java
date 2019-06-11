package com.example.mychef_orwima;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("beers")
    Call<List<Recipe>> getRecipe();
}
