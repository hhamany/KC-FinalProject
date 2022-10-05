package com.example.myproject2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        EditText email = findViewById(R.id.signemail);
        EditText pass = findViewById(R.id.signinpss);
        LottieAnimationView next = findViewById(R.id.nextLottie);
        TextView nexttxt = findViewById(R.id.nexttxt);

        nexttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText())){
                    email.setError("enter your email");
                }
                else if (TextUtils.isEmpty(pass.getText())){
                    pass.setError("enter your pass");
                }
                else {
                    Intent intent = new Intent(SigninActivity.this, NextActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}