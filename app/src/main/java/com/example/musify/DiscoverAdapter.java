package com.example.musify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.MyViewHolder> {

    Context context;
    ArrayList<PlayList> playLists;

    public DiscoverAdapter(Context context, ArrayList<PlayList> playLists) {
        this.context = context;
        this.playLists = playLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PlayList playList=playLists.get(position);
        holder.name.setText(playList.getName());
        holder.owner.setText(playList.getOwner());
//        Glide.with(holder.itemView.getContext()).load(playList.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,owner;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            owner=itemView.findViewById(R.id.owner);
            image=itemView.findViewById(R.id.image);
        }
    }
}
