package com.skyzone18.demo1stchoise.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skyzone18.demo1stchoise.Activity.MainActivity;
import com.skyzone18.demo1stchoise.Model.Datum;
import com.skyzone18.demo1stchoise.Model.View_Holder;
import com.skyzone18.demo1stchoise.R;
import com.skyzone18.demo1stchoise.RestClient.Responce;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class OfferCatWiseProadapter extends RecyclerView.Adapter<View_Holder> {
    List<Datum> dataSet;
    MainActivity dactivity;

    public OfferCatWiseProadapter(MainActivity mainActivity, List<Datum> items) {
        this.dataSet =items;
        this.dactivity = mainActivity;

    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_subpro_item, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int i) {

        holder.tvName.setText(dataSet.get(i).getCatName());
        Picasso.with(dactivity)
                .load(dataSet.get(i).getCatImage())
                .resize(300 ,300)
                .placeholder(R.mipmap.ic_launcher) //this is optional the image to display while the url image is downloading
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return 5;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }

}
