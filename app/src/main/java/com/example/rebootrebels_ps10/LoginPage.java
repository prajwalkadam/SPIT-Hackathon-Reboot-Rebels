package com.example.rebootrebels_ps10;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    TextView textView,password;
    ImageView ShowHidePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        textView =findViewById(R.id.sign_up);
        ShowHidePass = findViewById(R.id.eye_hide);
        password =findViewById(R.id.password_edit);
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
    }
}