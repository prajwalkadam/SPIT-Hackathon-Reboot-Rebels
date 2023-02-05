package com.example.rebootrebels_ps10;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.Fragment;


public class StarreddFragment extends Fragment {

    public StarreddFragment() {

    }

    Button start;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_starredd, container, false);
        start=view.findViewById(R.id.button_2);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QuizActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}