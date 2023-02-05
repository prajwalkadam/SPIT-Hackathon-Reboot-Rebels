package com.example.rebootrebels_ps10;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SearchFragment extends Fragment {

    public SearchFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_search, container, false);
//    }
CardView nosweat,lineup,lightsout,shower,shuteye,bin2win;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        nosweat=view.findViewById(R.id.no_sweat);
        lineup=view.findViewById(R.id.line_up);
        lightsout=view.findViewById(R.id.lights_out);
        shower=view.findViewById(R.id.shower);
        shuteye=view.findViewById(R.id.shut_eye);
        bin2win=view.findViewById(R.id.bin2win);


        FloatingActionButton fab = view.findViewById(R.id.fabchat);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChatBot.class);
                startActivity(intent);
            }
        });
        nosweat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoSweat.class);
                startActivity(intent);
            }
        });
        lineup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ActivityLineUp.class);
                startActivity(intent);
            }
        });
        lightsout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LightsOut.class);
                startActivity(intent);
            }
        });
        shower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShowerSprinter.class);
                startActivity(intent);
            }
        });
        shuteye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShutEye.class);
                startActivity(intent);
            }
        });
        bin2win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Bin2Win.class);
                startActivity(intent);
            }
        });

        return view;
    }
}