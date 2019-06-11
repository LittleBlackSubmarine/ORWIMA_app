package com.example.mychef_orwima;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<CardViewHolder> {



    private List<String> nameList= new ArrayList<>();
    private List<String> foodList= new ArrayList<>();
    private List<String> imageList= new ArrayList<>();


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent ,int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cardview,parent,false);
        return new CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int position) {
        cardViewHolder.setName(nameList.get(position));
        cardViewHolder.setFood(foodList.get(position));
        cardViewHolder.setImage(imageList.get(position));
    }


    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void addName(List<String> textdata){
        this.nameList.clear();
        this.nameList.addAll(textdata);
        notifyDataSetChanged();
    }

    public void addFood(List<String> fooddata){
        this.foodList.clear();
        this.foodList.addAll(fooddata);
        notifyDataSetChanged();
    }

    public void addImage(List<String> imagedata){
        this.imageList.clear();
        this.imageList.addAll(imagedata);
        notifyDataSetChanged();
    }


}