package com.example.myrecycleview_a194239;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myrecycleview_a194239.adapter.BeverageRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById((R.id.recycler_view));

        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);


        List<Beverage> allBeverageInfor = getAllBeverageInfor();
        BeverageRecyclerViewAdapter beverageRecyclerViewAdapter = new BeverageRecyclerViewAdapter(MainActivity.this,allBeverageInfor);
        recyclerView.setAdapter(beverageRecyclerViewAdapter);
    }

    private List<Beverage> getAllBeverageInfor()
    {
        List<Beverage> allBeverage = new ArrayList<Beverage>();

        allBeverage. add(new Beverage("Dunk Alpha", R.drawable.dunk_alpha));
        allBeverage. add(new Beverage("jamorant", R.drawable.jamorant));
        allBeverage. add(new Beverage("kd", R.drawable.kd));
        allBeverage. add(new Beverage("kobe mamba" , R.drawable.kobe_mamba));
        allBeverage. add(new Beverage("kyrie4" , R.drawable.kyrie4));


        allBeverage. add(new Beverage("Sabrina photon" , R.drawable.sabrina_photon));
        allBeverage. add(new Beverage("zion" , R.drawable.zion));





        return allBeverage;


    }



}