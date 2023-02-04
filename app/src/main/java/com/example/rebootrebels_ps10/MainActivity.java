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
            Intent intent=new Intent(MainActivity.this,Scan.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);
        Notify.build(getApplicationContext())
                .setTitle("Jill Zhao")
                .setContent("Hi! So I meet you today?")
                .setSmallIcon(R.drawable.ic_home)
                .setLargeIcon("https://images.pexels.com/photos/139829/pexels-photo-139829.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=150&w=440")
                .largeCircularIcon()
                .setPicture("https://images.pexels.com/photos/1058683/pexels-photo-1058683.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
                .setColor(R.color.black)
                .show();
    }
}