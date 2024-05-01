package com.example.finalassigment_a194333.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finalassigment_a194333.R;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database=FirebaseDatabase.getInstance();
    }
}