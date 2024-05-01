package com.example.finalassigment_a194333.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.finalassigment_a194333.Domain.category;
import com.example.finalassigment_a194333.Domain.cloth;
import com.example.finalassigment_a194333.R;
import com.example.finalassigment_a194333.activity.ClothListActivity;

import java.util.ArrayList;
import java.util.Locale;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.viewholder> {

    ArrayList<category> items;
    Context context;

    public categoryAdapter(ArrayList<category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public categoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_viewholder,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapter.viewholder holder, int position) {

        holder.titleTxt.setText(items.get(position).getName());

        int drawableResourceId=context.getResources().getIdentifier(items.get(position).getImagePath()
                , "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ClothListActivity.class);
            intent.putExtra("CategoryId",items.get(position).getId());
            intent.putExtra("CategoryName",items.get(position).getName());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView titleTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {

            super(itemView);
            titleTxt=itemView.findViewById(R.id.catNameTxt);
            pic=itemView.findViewById(R.id.imgCat);


        }
    }
}
