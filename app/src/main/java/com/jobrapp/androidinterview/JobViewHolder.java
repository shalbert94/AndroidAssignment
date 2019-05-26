package com.jobrapp.androidinterview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class JobViewHolder extends RecyclerView.ViewHolder {
    public TextView userName;
    public ImageView userImage;
    public JobViewHolder(@NonNull View itemView) {
        super(itemView);
        userName=(TextView)itemView.findViewById(R.id.name);
        userImage=(ImageView)itemView.findViewById(R.id.image);
    }
}
