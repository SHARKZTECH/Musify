package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.musify.databinding.ActivityPlayerBinding;

public class PlayerActivity extends AppCompatActivity {

    ActivityPlayerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayerBinding.inflate(getLayoutInflater());
        View rootView=binding.getRoot();
        setContentView(rootView);

        binding.btnShrink.setOnClickListener(view -> {
            startActivity(new Intent(this,HomeActivity.class));
        });
    }
}