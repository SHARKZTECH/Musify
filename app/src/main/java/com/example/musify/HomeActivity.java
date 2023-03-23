package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.musify.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    Boolean isAllFabVisible;
    LinearLayout btnAlbum,btnArtist,btnLiked,btnRecent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        View rootView=binding.getRoot();
        setContentView(rootView);

        btnAlbum=binding.btnAlbum;
        btnArtist=binding.btnArtist;
        btnLiked=binding.btnLiked;
        btnRecent=binding.btnRecent;

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

                binding.btnFab.extend();
                isAllFabVisible=true;
            }else{
                btnAlbum.setVisibility(View.GONE);
                btnArtist.setVisibility(View.GONE);
                btnLiked.setVisibility(View.GONE);
                btnRecent.setVisibility(View.GONE);

                binding.btnFab.shrink();
                isAllFabVisible=false;
            }
        });
    }
}