package com.example.rebootrebels_ps10;

import android.annotation.SuppressLint;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    TextView textView,emailEdit,forgotPass,password;
    ImageView ShowHidePass;
    Button login;
    ImageButton gLogin;
    FirebaseAuth mAuth;

    private GoogleApiClient googleApiClient;
    private static final int RC_SIGN_IN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        textView =findViewById(R.id.sign_up);
        ShowHidePass = findViewById(R.id.eye_hide);
        password =findViewById(R.id.password_edit);
        emailEdit =findViewById(R.id.email_edit);
        login = findViewById(R.id.sign_in);
        forgotPass=findViewById(R.id.forgot_password);
        gLogin = findViewById(R.id.google);
        String text="New to AppName? Sign up";
        ForegroundColorSpan green = new ForegroundColorSpan(Color.rgb(50,132,40));
        ForegroundColorSpan blackish = new ForegroundColorSpan(Color.rgb(47,46,65));
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(blackish,
                0, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(green,
                16, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
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
        textView.setOnClickListener(view -> startActivity(new Intent(LoginPage.this, CreateAccount.class)));
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(view -> {
            loginUser();
        });
    }


    private void loginUser() {
        String email = emailEdit.getText().toString();
        String passwordMatch = password.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailEdit.setError("Email cannot be empty");
            emailEdit.requestFocus();
        } else if (TextUtils.isEmpty(passwordMatch)) {
            password.setError("Password cannot be empty");
            password.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, passwordMatch).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginPage.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(LoginPage.this, NavigationBar.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(LoginPage.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}