package com.example.rebootrebels_ps10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityLineUp extends AppCompatActivity {
    DatabaseReference buzzRef = FirebaseDatabase.getInstance().getReference().child("Users");
    Button Buzz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_up);
        Buzz = findViewById(R.id.buzzline);

        Buzz.setOnClickListener(v -> {
            buzzRef.addListenerForSingleValueEvent (new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String str = (String) dataSnapshot.child("tScore").getValue();
                    assert str != null;
                    int value = Integer.parseInt(str)+6;
                    buzzRef.child("tScore").setValue(String.valueOf(value));
                    Toast.makeText(ActivityLineUp.this, "Transaction succeeded.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ActivityLineUp.this, "Transaction failed.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}