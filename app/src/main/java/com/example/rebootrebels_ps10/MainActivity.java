package com.example.rebootrebels_ps10;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.application.isradeleon.notify.Notify;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            Intent intent=new Intent(MainActivity.this,NavigationBar.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);
        Notify.build(getApplicationContext())
                .setTitle("Hey AVENGER! It's Lily")
                .setContent("Unleash your power, be the guardian of earth. Save humanity as the coolest protector.")
                .setSmallIcon(R.drawable.launchlogo)
                .setLargeIcon("")
                .largeCircularIcon()
                .setPicture(R.drawable.noti_image2)
                .setColor(R.color.black)
        .show();
    }
}