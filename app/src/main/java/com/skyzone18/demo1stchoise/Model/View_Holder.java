package com.skyzone18.demo1stchoise.Model;


import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyzone18.demo1stchoise.R;


//The adapters View Holder
public class View_Holder extends RecyclerView.ViewHolder {

    public TextView tvName;
    public CardView cardview;
    View view;
    public ImageView ivImage;

    public View_Holder(@NonNull View itemView) {

        super(itemView);
        view = itemView;
        tvName = (TextView)itemView.findViewById(R.id.name);
        cardview = (CardView)itemView.findViewById(R.id.cardview);
        ivImage = (ImageView)itemView.findViewById(R.id.ivImage);


    }
}
