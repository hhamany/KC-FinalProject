package com.example.myproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class PharmaciesList extends AppCompatActivity  {
   private   RecyclerView recyclerView2 ;
     String [] phname= {  "PharmaZone" , " Royal" , " Al Mutawa " , "Al Awda"};
     String[] urls = { "https://www.pharmazonekw.com/medicines" , "https://royalph.com/en/medicines.html"
             , "https://www.almutawapharmacies.com.kw/?gclid=CjwKCAjwvNaYBhA3EiwACgndgqp9ndl2FCje6BFsUEc94z9JBH_wJISn8Yw_LyvtIITU_PZkWcDSPxoCX1IQAvD_BwE" , "https://alawdapharmacy.com/"};
    private RecyclerView.Adapter PharmaciesAdapter;
     int[] images =  {    R.drawable.p1 , R.drawable.royal  , R.drawable.p3 , R.drawable.p7};
     int[] phpiclottie=  {R.raw.pharmacy2,R.raw.pharmacy2,R.raw.pharmacy2,R.raw.pharmacy2} ;
     String[] phnumbers=  {"222111000","1881010","1800229","22657497"} ;
    static ArrayList <HashMap< String, String >> dataItem;
    HashMap < String,String > map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacies_list);
        recyclerView2 = findViewById(R.id.prv);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView2.setLayoutManager(mLayoutManager);
        dataItem = new ArrayList < >();

        for (int i = 0; i < phname.length; i++) {

            map = new HashMap < String , String > ();
            map.put("phname", phname[i]);
            map.put("images", images[i] + "");
            map.put("numbers", phnumbers[i] );
            map.put("animation", phpiclottie[i] + "");
            map.put("url", urls[i]);
            dataItem.add(map);
        }
        PharmaciesAdapter = new PharmaciesAdapter(getApplicationContext(), dataItem);
        recyclerView2.setAdapter(PharmaciesAdapter);

    }
    }

