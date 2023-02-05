package com.example.rebootrebels_ps10;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    DatabaseReference reference;
    FirebaseUser fuser;
    FirebaseAuth mAuth;
    TextView username,taskScore,quizScore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        username=view.findViewById(R.id.name);
        taskScore=view.findViewById(R.id.taskScore);
        quizScore=view.findViewById(R.id.Qscore);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Scan.class);
                startActivity(intent);
            }
        });
        fuser = FirebaseAuth.getInstance().getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String user = (String) dataSnapshot.child("username").getValue();
                username.setText(user);
                String ScoreT = (String) dataSnapshot.child("tScore").getValue();
                taskScore.setText(ScoreT);
                String ScoreQ = (String) dataSnapshot.child("qScore").getValue();
                quizScore.setText(ScoreQ);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        return view;
    }
}
