package com.example.rebootrebels_ps10;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class NavigationBar extends AppCompatActivity {
    Fragment selectedFragment = null;
    private FactBook mFactBook=new FactBook();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);
        TextView facts= findViewById(R.id.fact);
        //AlertDialog.Builder builder = new AlertDialog.Builder(NavigationBar.this);
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
        String fact=mFactBook.getFact();
//        builder.setMessage(fact);
//        builder.setTitle("Fun Fact!");
//        builder.setCancelable(true);
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
        //facts.setText(fact);
        final AlertDialog.Builder builder = new AlertDialog.Builder(NavigationBar.this,R.style.CustomAlertDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);

        View dialogView = LayoutInflater.from(NavigationBar.this).inflate(R.layout.custom_dialog, viewGroup, false);
        Button buttonOk=dialogView.findViewById(R.id.buttonOk);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}