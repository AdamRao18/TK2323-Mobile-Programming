package com.example.myroom_a194239;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import dao.BeverageDao;
import entities.Beverage;

@Database(entities = {Beverage.class}, version = 1)
public abstract class MyBeverageDB extends RoomDatabase {

    public abstract BeverageDao beverageDao();




}
