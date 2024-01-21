package com.example.portableportfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SplashFragment())
                .commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Replace SplashFragment with your main fragment or activity
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SplashFragment())
                        .commit();
            }
        }, 3000);
    }
}