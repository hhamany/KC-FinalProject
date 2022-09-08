package com.example.myproject2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class List1 extends AppCompatActivity{

private RecyclerView recycleview ;
String [] medname = {"panadol extra 48 tap","strepsils cool 16loz","CETAPHIL GENTLE SKIN CLEANSER"
,"VOLTAREN EMULGEL", "OBU VITAMIN D3 PEACH FLAVOR" , "STERIMAR BLOCKED NOSE","CARROTEN SUMMER DREAMS  TANNING OIL"
,"REVITOL SUNBLOCK TINTED LOTION ","CETAPHIL MOISTURIZING JAR"} ;
String[] medprice = { "1.200" , " 1.600" , "7.600" , "2.290" , "7.000" , "5.750", "5.175", "10.200" ,"22.020" };
String[] medUrl = {"https://www.pharmazonekw.com/panadol-extra-48-tab" , "https://www.pharmazonekw.com/strepsils-cool-16loz", "https://www.pharmazonekw.com/cetaphil-gentle-skin-cleanser-pump"
, "https://www.pharmazonekw.com/voltaren-emulgel-12-hours-50g", "https://www.pharmazonekw.com/obu-vitamin-d3-peach-flavor-60-gummies"
, "https://www.pharmazonekw.com/sterimar-blocked-nose-100-ml", "https://www.pharmazonekw.com/carroten-summer-dreams-spf6-tanning-oil-200ml"
, "https://www.pharmazonekw.com/revitol-sunblock-tinted-lotion-spf50-offer-1-1" , "https://www.pharmazonekw.com/cetaphil-moisturizing-jar-cr-453gm"} ;
    private RecyclerView.Adapter MedAdapter2;
    int[] medimage = {R.drawable.panadol, R.drawable.medicine1, R.drawable.clean , R.drawable.gel ,R.drawable.vit,R.drawable.nose ,
    R.drawable.tanoil , R.drawable.sunblock, R.drawable.lotion};
    int[] medLott = { R.raw.pills ,R.raw.pills ,R.raw. gell , R.raw.gell , R.raw.pills, R.raw.spray ,R.raw.spray ,R.raw.gell ,
            R.raw.gell };

    static ArrayList <HashMap< String, String >> medItem;
    HashMap < String,String > map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);
        recycleview = findViewById(R.id.rv);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recycleview.setLayoutManager(mLayoutManager);
        medItem = new ArrayList < >();

        for (int i = 0; i < medname.length; i++) {

            map = new HashMap < String , String > ();
            map.put("mednames", medname[i]);
            map.put("medprices", medprice[i] + "");
            map.put("medimages", medimage[i] + "");
            map.put("medanimations", medLott[i] + "");
            map.put("medurl", medUrl[i]);
            medItem.add(map);
        }
        MedAdapter2 = new MedAdapter2( getApplicationContext(),medItem);
        recycleview.setAdapter(MedAdapter2);

    }
}