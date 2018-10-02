package com.example.heba.raye7task.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.heba.raye7task.R;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent articleIntent = new Intent(SplashActivity.this, ArticlesActivity.class);
                startActivity(articleIntent);
                finish();
            }
        }, 3000);
    }
}
