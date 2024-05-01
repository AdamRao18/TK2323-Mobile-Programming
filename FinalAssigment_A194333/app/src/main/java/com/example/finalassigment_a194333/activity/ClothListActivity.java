package com.example.finalassigment_a194333.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.finalassigment_a194333.Adapter.categoryAdapter;
import com.example.finalassigment_a194333.Adapter.clothListAdapter;
import com.example.finalassigment_a194333.Adapter.hotDealsAdapter;
import com.example.finalassigment_a194333.Domain.category;
import com.example.finalassigment_a194333.Domain.cloth;
import com.example.finalassigment_a194333.R;
import com.example.finalassigment_a194333.databinding.ActivityClothListBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClothListActivity extends BaseActivity {
    ActivityClothListBinding binding;
    private RecyclerView.Adapter adapterListCloth;
    private int categoryId;
    private String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityClothListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        initList();
    }

    private void initList() {

        DatabaseReference myref=database.getReference("Cloths");
        binding.progressBar.setVisibility(View.VISIBLE);
        ArrayList<cloth> list=new ArrayList<>();
        Query query=myref.orderByChild("CategoryId").equalTo(categoryId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(cloth.class));
                    }
                    if(list.size()>0) {
                        binding.clothListView.setLayoutManager(new GridLayoutManager(ClothListActivity.this,2));
                        adapterListCloth = new clothListAdapter(list);
                        binding.clothListView.setAdapter(adapterListCloth);

                    }
                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void getIntentExtra() {
        categoryId=getIntent().getIntExtra("CategoryId",0);
        categoryName=getIntent().getStringExtra("CategoryName");

        binding.titleTxt.setText(categoryName);
        binding.backbtn.setOnClickListener(v -> finish());
    }
}