package com.example.rebootrebels_ps10;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CreateAccount extends AppCompatActivity {
    TextView textView,emailEdit,password,name;
    ImageView ShowHidePass;
    Button signUp;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    Task<Void> reference;
    Users users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        textView =findViewById(R.id.sign_up);
        ShowHidePass = findViewById(R.id.eye_hide);
        password =findViewById(R.id.password_edit);
        emailEdit = findViewById(R.id.email_edit);
        signUp=findViewById(R.id.sign_in);
        name=findViewById(R.id.username);
        users = new Users();
        String text="Already have an account? Sign in";
        ForegroundColorSpan green = new ForegroundColorSpan(Color.rgb(50,142,40));
        ForegroundColorSpan blackish = new ForegroundColorSpan(Color.rgb(47,46,65));
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(blackish,
                0, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(green,
                25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        ShowHidePass.setOnClickListener(view -> {

            if(view.getId()==R.id.eye_hide){
                if(password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_remove_red_eye);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    ((ImageView)(view)).setImageResource(R.drawable.eyehide);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        textView.setOnClickListener(view -> startActivity(new Intent(CreateAccount.this, LoginPage.class)));
        mAuth = FirebaseAuth.getInstance();
        signUp.setOnClickListener(view -> createUser());
    }
    private void createUser(){
        String email = emailEdit.getText().toString();
        String passwordMatch = password.getText().toString();
        String username = name.getText().toString();
        if (TextUtils.isEmpty(email)){
            emailEdit.setError("Email cannot be empty");
            emailEdit.requestFocus();
        }else if (TextUtils.isEmpty(passwordMatch)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }else{
            //                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
//                        assert firebaseUser != null;
//                        String userid = firebaseUser.getUid();
//                        reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
//                        HashMap<String, String> hashMap = new HashMap<>();
//                        hashMap.put("id", userid);
//                        hashMap.put("email",email);
//                        hashMap.put("password",password);
//
//                        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()){
//                                    Intent intent = new Intent(CreateAccount.this, Login.class);
//                                    Toast.makeText(CreateAccount.this, "User registered successfully", Toast.LENGTH_SHORT).show();
//                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }
//                        });
//                    }
            mAuth.createUserWithEmailAndPassword(email,passwordMatch).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("email",email);
                    hashMap.put("passwordMatch",passwordMatch);
                    hashMap.put("username", username);
                    hashMap.put("qScore", "default");
                    hashMap.put("tScore", "default");
                    // below line is used to get reference for our database.
                    FirebaseDatabase.getInstance().getReference().child("Users").setValue("Hello");
                    Toast.makeText(CreateAccount.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(CreateAccount.this, LoginPage.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(CreateAccount.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}