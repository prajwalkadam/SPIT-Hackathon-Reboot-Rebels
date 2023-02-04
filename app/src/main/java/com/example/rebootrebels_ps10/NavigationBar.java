package com.example.rebootrebels_ps10;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class NavigationBar extends AppCompatActivity {
    Fragment selectedFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);
        BubbleNavigationLinearView bubbleNavigation = findViewById(R.id.bubbleNavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new com.example.rebootrebels_ps10.HomeFragment()).commit();

        bubbleNavigation.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position) {
                    case 0:
                        selectedFragment = new com.example.rebootrebels_ps10.HomeFragment();
                        break;
                    case 1:
                        selectedFragment = new com.example.rebootrebels_ps10.SearchFragment();
                        break;
                    case 2:
                        selectedFragment = new StarredFragment();
                        break;
                    case 3:
                        selectedFragment = new com.example.rebootrebels_ps10.StarreddFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });
    }
}