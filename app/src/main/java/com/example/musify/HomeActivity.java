package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.musify.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    Boolean isAllFabVisible;
    LinearLayout btnAlbum,btnArtist,btnLiked,btnRecent;
    RecyclerView playlistsRecycler,discoverRecycler;
    PlayListAdapter playListAdapter;
    ArrayList<PlayList> playLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        View rootView=binding.getRoot();
        setContentView(rootView);

        playLists=new ArrayList<>();
        btnAlbum=binding.btnAlbum;
        btnArtist=binding.btnArtist;
        btnLiked=binding.btnLiked;
        btnRecent=binding.btnRecent;
        playlistsRecycler=binding.recyclerPlaylists;
        discoverRecycler=binding.recyclerDiscover;
        fabExtend();

        getPlayLists();

        playListAdapter=new PlayListAdapter(this,playLists);
        playlistsRecycler.setLayoutManager(new GridLayoutManager(this,2 ));
        playlistsRecycler.setAdapter(playListAdapter);

    }
    private void getPlayLists(){
        playLists.add(new PlayList("On Repeat","Spotify",R.drawable.liked_songs));
        playLists.add(new PlayList("Liked","Spotify",R.drawable.liked_songs));
        playLists.add(new PlayList("Discover Weekly","Spotify",R.drawable.liked_songs));
        playLists.add(new PlayList("Sharkztech","Sharkz",R.drawable.liked_songs));
    }
    private void fabExtend(){

        btnAlbum.setVisibility(View.GONE);
        btnArtist.setVisibility(View.GONE);
        btnLiked.setVisibility(View.GONE);
        btnRecent.setVisibility(View.GONE);

        isAllFabVisible=false;
        binding.btnFab.shrink();

        binding.btnFab.setOnClickListener(view->{
            if(!isAllFabVisible){
                btnAlbum.setVisibility(View.VISIBLE);
                btnArtist.setVisibility(View.VISIBLE);
                btnLiked.setVisibility(View.VISIBLE);
                btnRecent.setVisibility(View.VISIBLE);

                binding.homeLayout.setAlpha(0.1f);
               binding.btmAppbar.setAlpha(0.1f);

                binding.btnFab.extend();
                binding.btnFab.setIcon(getDrawable(R.drawable.unfold));
                binding.btnFab.setIconTint(getResources().getColorStateList(R.color.white));
                binding.btnFab.setBackgroundTintList(getColorStateList(R.color.fab_bg2));
                isAllFabVisible=true;
            }else{
                btnAlbum.setVisibility(View.GONE);
                btnArtist.setVisibility(View.GONE);
                btnLiked.setVisibility(View.GONE);
                btnRecent.setVisibility(View.GONE);

                binding.homeLayout.setAlpha(1);
                binding.btmAppbar.setAlpha(1);

                binding.btnFab.shrink();
                binding.btnFab.setIcon(getDrawable(R.drawable.sp_logo));
                binding.btnFab.setIconTint(getResources().getColorStateList(R.color.fab_bg1));
                binding.btnFab.setBackgroundTintList(getColorStateList(R.color.bg_1));

                isAllFabVisible=false;
            }
        });
    }
}