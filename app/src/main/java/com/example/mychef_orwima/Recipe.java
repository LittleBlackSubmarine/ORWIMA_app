package com.example.mychef_orwima;

public class Recipe {
    private String name;
    private String [] food_pairing;
    private String image_url;

    public Recipe(String name,String [] food_pairing,String image_url){
        this.name=name;
       this.food_pairing=food_pairing;
       this.image_url=image_url;
    }

    public String [] getFood() {
        return food_pairing;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() { return image_url; }
}
