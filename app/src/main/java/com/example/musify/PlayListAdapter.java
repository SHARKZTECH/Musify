package com.example.musify;

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

import java.util.ArrayList;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.MyVievHolder> {

    Context context;
    ArrayList<PlayList> playLists;

    public PlayListAdapter(Context context, ArrayList<PlayList> playLists) {
        this.context = context;
        this.playLists = playLists;
    }

    @NonNull
    @Override
    public MyVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item,parent,false);
        return new MyVievHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVievHolder holder, int position) {
        PlayList playList=playLists.get(position);
        holder.name.setText(playList.getName());
        holder.owner.setText(playList.getOwner());
        Glide.with(holder.itemView.getContext()).load(playList.getImage()).into(holder.image);

        holder.itemView.setOnClickListener(view -> {
            context.startActivity(new Intent(context,PlayListContentActivity.class));
        });

    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }

    public class MyVievHolder extends RecyclerView.ViewHolder{
        TextView name,owner;
        ImageView image;

        public MyVievHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            owner=itemView.findViewById(R.id.owner);
            image=itemView.findViewById(R.id.image);
        }
    }
}
