package com.example.myproject2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.HashMap;

public class PharmaciesAdapter extends RecyclerView.Adapter<PharmaciesAdapter.MyViewHolder> {
    private ArrayList<HashMap<String, String>> dataSet;
    Context context;

    public PharmaciesAdapter(Context context, ArrayList<HashMap<String, String>> dataSet) {
        this.dataSet = dataSet;
        this.context = context;

    }

    @NonNull
    @Override
    public PharmaciesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pharmacies, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PharmaciesAdapter.MyViewHolder holder, final int position) {
        final HashMap<String, String> Details = dataSet.get(position);
        holder.pharmacyName.setText(Details.get("phname"));
        holder.pharmacyImage.setImageResource(Integer.parseInt(Details.get("images")));
        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String pharmUrls = Details.get("url");
                Intent pharmurl = new Intent(Intent.ACTION_VIEW, Uri.parse(pharmUrls));
                context.startActivity(pharmurl);
            }
        });
       holder.getPharmacyNumber.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final String pharmnum = Details.get("numbers");
               Intent callIntent = new Intent(Intent.ACTION_DIAL);
               callIntent.setData(Uri.parse("tel:"+pharmnum));
               context.startActivity(callIntent);
           }
       });

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.slide));

    }

    @Override
    public int getItemCount() {
        return (dataSet == null) ? 0 : dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pharmacyName;
        Button getPharmacyNumber;
        ImageView pharmacyImage;
        LottieAnimationView pharmacyLot;
        Button visit;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pharmacyName = (TextView) itemView.findViewById(R.id.namep);
            getPharmacyNumber =  (Button) itemView.findViewById(R.id.call);
            pharmacyImage = (ImageView) itemView.findViewById(R.id.imgp);
            visit = (Button) itemView.findViewById(R.id.visit);

        }
    }
}
