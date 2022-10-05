package com.example.myproject2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        EditText name = findViewById(R.id.name);
        EditText email =findViewById(R.id.email);
        EditText phone = findViewById(R.id.phone);
        EditText pass =findViewById(R.id.pass);
        EditText age = findViewById(R.id.age);
        LottieAnimationView btn = findViewById(R.id.lot);

        btn. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText())){
                    name.setError("لرجاء ادخال اسمك ");
                }

                else   if (TextUtils.isEmpty(age.getText())){
                    age.setError("لرجاء ادخال العمر ");
                }

                else   if (TextUtils.isEmpty(phone.getText())){
                    phone.setError("لرجاء ادخال رقم هاتفك ");
                }

                else   if (TextUtils.isEmpty(email.getText())){
                    email.setError("لرجاء ادخال الايميل ");
                }
                else   if (TextUtils.isEmpty(pass.getText())){
                    pass.setError("لرجاء ادخال الرقم السري ");
                }
               else {

                Intent intent = new Intent(SignActivity.this, FirsPage.class);
                    startActivity(intent);
            }}
        });



    }
}