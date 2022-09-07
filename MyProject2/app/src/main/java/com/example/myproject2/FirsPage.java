package com.example.myproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class FirsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firs_page);
        LottieAnimationView btn1 =findViewById(R.id.lottie);
        LottieAnimationView btn2 =findViewById(R.id.lottie2);
        LottieAnimationView btn3 =findViewById(R.id.lottie3);
        TextView mylist = findViewById(R.id.my);
        TextView pupularmeds = findViewById(R.id.my2);
        TextView pharmacies = findViewById(R.id.my3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myList = new Intent(FirsPage.this, MyList.class);
                startActivity(myList);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirsPage.this,List1.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(FirsPage.this,PharmaciesList.class);
                startActivity(p);
            }
        });


        mylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myList = new Intent(FirsPage.this, MyList.class);
                startActivity(myList);
            }
        });
        pupularmeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirsPage.this,List1.class);
                startActivity(intent);
            }
        });
        pharmacies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(FirsPage.this,PharmaciesList.class);
                startActivity(p);
            }
        });


    }
}