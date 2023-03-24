package com.example.musify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.btnHomeActivity);
        Button btn1=findViewById(R.id.btnPlayerActivity);
        btn.setOnClickListener(view -> {
            startActivity(new Intent(this,HomeActivity.class));
        });
        btn1.setOnClickListener(view -> {
            startActivity(new Intent(this,PlayerActivity.class));
        });
    }
}