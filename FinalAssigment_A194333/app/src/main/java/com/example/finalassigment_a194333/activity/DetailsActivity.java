package com.example.finalassigment_a194333.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.finalassigment_a194333.Domain.cloth;
import com.example.finalassigment_a194333.R;
import com.example.finalassigment_a194333.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;

    private cloth object;
    private int num=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailsActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText("RM" + object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar() + "Rating");
        binding.ratingBar.setRating((float)object.getStar());
        binding.totalTxt.setText(num * object.getPrice() + "RM");
    }

    private void getIntentExtra() {
        object= (cloth) getIntent().getSerializableExtra("object");
    }
}