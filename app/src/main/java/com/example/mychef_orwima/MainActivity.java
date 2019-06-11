package com.example.mychef_orwima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecipeAdapter adp;
    private RecyclerView rv;

    private List<String> nameList= new ArrayList<>();
    private List<String> foodList= new ArrayList<>();
    private List<String> imageList= new ArrayList<>();

    private Call<List<Recipe>> apiCall;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetUpRecycler();

        setUpApiCall();


    }

    private void SetUpRecycler(){
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adp=new RecipeAdapter();
        rv.setAdapter(adp);

    }

    private void setUpApiCall() {
        apiCall = GApi.getApiInterface().getRecipe();
        apiCall.enqueue(new Callback<List<Recipe>> () {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>>
                    response) {
                if (response.isSuccessful() && response.body() != null) {
                    showRecipe(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showRecipe(List<Recipe> data) {
        for (Recipe tempRecipe: data) {
            nameList.add(tempRecipe.getName());
            foodList.add(Arrays.toString(tempRecipe.getFood()).replace("[", "").replace("]", ""));
            imageList.add(tempRecipe.getImgUrl());
        }

        adp.addName(nameList);
        adp.addFood(foodList);
        adp.addImage(imageList);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiCall != null)
            apiCall.cancel();
    }




}
