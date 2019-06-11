package com.example.mychef_orwima;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class CardViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvFood;
    private ImageView ivBeer;

    public CardViewHolder(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.name_tv);
        tvFood = itemView.findViewById(R.id.food_tv);
        ivBeer = itemView.findViewById(R.id.beer_iv);
    }

    public void setName(String name){
     tvName.setText(name);
    }
    public void setFood(String food) { tvFood.setText(food); }
    public void setImage(String image) { Picasso.get().load(image).into(ivBeer); }

}