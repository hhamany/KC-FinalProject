package com.example.myproject2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class MyList extends AppCompatActivity {
     RecyclerView recyclerView3 ;
     ArrayList<Mymedicines> mymedicines= new ArrayList<>() ;
     MyListAdapter myListAdapter ;
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_big);
        recyclerView3 = findViewById(R.id.myList);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final Mymedicines newItem = (Mymedicines) extras.getSerializable("newmedicine");
            mymedicines.add(newItem);
        }

        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        myListAdapter = new MyListAdapter( mymedicines);
        recyclerView3.setAdapter(myListAdapter);

//AddMedicine Button
        LottieAnimationView addmedd = findViewById(R.id.addmednow);
        addmedd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyList.this,AddingMedActivity.class);
                startActivity(intent);
            }
        });


    }
}