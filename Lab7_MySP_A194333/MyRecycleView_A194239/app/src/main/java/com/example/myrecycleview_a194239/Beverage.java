package com.example.myrecycleview_a194239;

public class Beverage {
    String name;
    int image;

   public Beverage(String name, int image) {
       this.image = image;
       this.name = name;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
