package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.musify.databinding.ActivityPlayListContentBinding;

import java.util.ArrayList;

public class PlayListContentActivity extends AppCompatActivity {

    PlayListContentAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Song> songs;

    ActivityPlayListContentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayListContentBinding.inflate(getLayoutInflater());
        View rootView=binding.getRoot();
        setContentView(rootView);

        HomeActivity homeActivity=new HomeActivity();
        homeActivity.fabExtend();

        songs=new ArrayList<>();
        recyclerView=binding.recycler;

        getSongs();

        adapter=new PlayListContentAdapter(this,songs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    private void getSongs(){
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
        songs.add(new Song("Ugly","GALYE"));
    }

}