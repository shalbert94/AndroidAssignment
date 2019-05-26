package com.jobrapp.androidinterview.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jobrapp.androidinterview.R;
import com.jobrapp.server.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobViewHolder> {

    private ArrayList<User> users;
    public JobAdapter(){
        users=new ArrayList<>();
    }
    public void addAll(List<User> newUser){
        int count=users.size();
        users.addAll(newUser);
        notifyItemRangeInserted (count, newUser.size());

    }
    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.user_grid_item, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        User user=users.get(position);
        if (!TextUtils.isEmpty(user.getName())){
            holder.userName.setText(user.getName());
        }
        if (!TextUtils.isEmpty(user.getProfile_url())){
            Picasso.get()
                    .load(user.getProfile_url())
                    //.placeholder(R.drawable.user_placeholder)
                    //.error(R.drawable.user_placeholder_error)
                    .into(holder.userImage);
        }


    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
