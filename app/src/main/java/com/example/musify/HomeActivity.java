package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.ColorStateList;
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

        fabExtend();

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

                binding.btnFab.shrink();
                binding.btnFab.setIcon(getDrawable(R.drawable.sp_logo));
                binding.btnFab.setIconTint(getResources().getColorStateList(R.color.fab_bg1));
                binding.btnFab.setBackgroundTintList(getColorStateList(R.color.bg_1));

                isAllFabVisible=false;
            }
        });
    }
}