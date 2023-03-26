package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.musify.databinding.ActivityPlayListContentBinding;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class PlayListContentActivity extends AppCompatActivity {

    PlayListContentAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Song> songs;

    ActivityPlayListContentBinding binding;
    LinearLayout btnAlbum,btnArtist,btnLiked,btnRecent;
    Boolean isAllFabVisible;
    ExtendedFloatingActionButton btnFab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayListContentBinding.inflate(getLayoutInflater());
        View rootView=binding.getRoot();
        setContentView(rootView);



        songs=new ArrayList<>();
        recyclerView=binding.recycler;
        btnFab=binding.btmAppbar.btnFab;
        btnAlbum=binding.btmAppbar.btnAlbum;
        btnArtist=binding.btmAppbar.btnArtist;
        btnLiked=binding.btmAppbar.btnLiked;
        btnRecent=binding.btmAppbar.btnRecent;
        ImageView btnBack=binding.btnBack;

        btnBack.setOnClickListener(view -> {
            super.onBackPressed();
        });

        binding.minPlayer.minPlayer.setOnClickListener(view -> {
            startActivity(new Intent(this,PlayerActivity.class));
        });
        binding.btmAppbar.btnHome.setOnClickListener(view -> {
            startActivity(new Intent(this,HomeActivity.class));
        });

        fabExtend();

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
    public void fabExtend(){

        btnAlbum.setVisibility(View.GONE);
        btnArtist.setVisibility(View.GONE);
        btnLiked.setVisibility(View.GONE);
        btnRecent.setVisibility(View.GONE);

        isAllFabVisible=false;
        btnFab.shrink();

        btnFab.setOnClickListener(view->{
            if(!isAllFabVisible){
                btnAlbum.setVisibility(View.VISIBLE);
                btnArtist.setVisibility(View.VISIBLE);
                btnLiked.setVisibility(View.VISIBLE);
                btnRecent.setVisibility(View.VISIBLE);

                binding.homeLayout.setAlpha(0.1f);
                binding.btmAppbar.btmAppbar.setAlpha(0.1f);
                binding.minPlayer.minPlayer.setAlpha(.1f);
                binding.minPlayer.minPlayer.setBottom(210);

                btnFab.extend();
                btnFab.setIcon(getDrawable(R.drawable.unfold));
                btnFab.setIconTint(getResources().getColorStateList(R.color.white));
                btnFab.setBackgroundTintList(getColorStateList(R.color.fab_bg2));
                isAllFabVisible=true;
            }else{
                btnAlbum.setVisibility(View.GONE);
                btnArtist.setVisibility(View.GONE);
                btnLiked.setVisibility(View.GONE);
                btnRecent.setVisibility(View.GONE);

                binding.homeLayout.setAlpha(1);
                binding.btmAppbar.btmAppbar.setAlpha(1);
                binding.minPlayer.minPlayer.setAlpha(1);
                binding.minPlayer.minPlayer.setBottom(100);

                btnFab.shrink();
                btnFab.setIcon(getDrawable(R.drawable.sp_logo));
                btnFab.setIconTint(getResources().getColorStateList(R.color.fab_bg1));
                btnFab.setBackgroundTintList(getColorStateList(R.color.bg_1));

                isAllFabVisible=false;
            }
        });
    }


}