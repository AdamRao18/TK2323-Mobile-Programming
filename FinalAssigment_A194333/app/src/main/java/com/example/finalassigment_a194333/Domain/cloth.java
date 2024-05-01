package com.example.finalassigment_a194333.Domain;

import java.io.Serializable;

public class cloth implements Serializable {

    private int CategoryId;
    private String Description;
    private int Id;
    private String ImagePath;
    private double Price;
    private double Star;
    private String Title;
    private boolean HotDeal;

    public cloth() {
    }

    @Override
    public String toString() {

        return Title;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {

        CategoryId = categoryId;
    }

    public String getDescription() {

        return Description;
    }

    public void setDescription(String description) {

        Description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getStar() {
        return Star;
    }

    public void setStar(double star) {
        Star = star;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isHotDeal() {
        return HotDeal;
    }

    public void setHotDeal(boolean hotDeal) {
        this.HotDeal = HotDeal;
    }
}
