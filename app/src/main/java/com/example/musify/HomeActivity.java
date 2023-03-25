package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.musify.databinding.ActivityHomeBinding;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    Boolean isAllFabVisible;
    LinearLayout btnAlbum,btnArtist,btnLiked,btnRecent;
    RecyclerView playlistsRecycler,discoverRecycler;
    PlayListAdapter playListAdapter;
    ArrayList<PlayList> playLists;
    DiscoverAdapter discoverAdapter;
    ExtendedFloatingActionButton btnFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        View rootView=binding.getRoot();
        setContentView(rootView);

        playLists=new ArrayList<>();
        btnFab=binding.btmAppbar.btnFab;
        btnAlbum=binding.btmAppbar.btnAlbum;
        btnArtist=binding.btmAppbar.btnArtist;
        btnLiked=binding.btmAppbar.btnLiked;
        btnRecent=binding.btmAppbar.btnRecent;
        playlistsRecycler=binding.recyclerPlaylists;
        discoverRecycler=binding.recyclerDiscover;
        fabExtend();

        getPlayLists();


        discoverAdapter=new DiscoverAdapter(this,playLists);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        discoverRecycler.setLayoutManager(linearLayoutManager);
        discoverRecycler.setAdapter(discoverAdapter);

        playListAdapter=new PlayListAdapter(this,playLists);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        playlistsRecycler.setLayoutManager(gridLayoutManager);
        playlistsRecycler.setAdapter(playListAdapter);

        binding.minPlayer.minPlayer.setOnClickListener(view -> {
            startActivity(new Intent(this,PlayerActivity.class));
        });


    }
    private void getPlayLists(){
        playLists.add(new PlayList("On Repeat","Spotify",R.drawable.repeat_));
        playLists.add(new PlayList("Liked","Spotify",R.drawable.liked_songs));
        playLists.add(new PlayList("Discover Weekly","Spotify", R.drawable.discover_));
        playLists.add(new PlayList("Sharkztech","Sharkz", R.drawable.playlist));


        playLists.add(new PlayList("Discover Weekly","Spotify", R.drawable.discover_));
        playLists.add(new PlayList("On Repeat","Spotify",R.drawable.repeat_));
        playLists.add(new PlayList("Liked","Spotify",R.drawable.liked_songs));
        playLists.add(new PlayList("Sharkztech","Sharkz", R.drawable.playlist));


    }
    private void fabExtend(){

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