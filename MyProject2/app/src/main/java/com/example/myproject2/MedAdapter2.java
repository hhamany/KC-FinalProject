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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class MedAdapter2 extends RecyclerView.Adapter<MedAdapter2.MyViewHolder> {
    private ArrayList<HashMap<String, String>> dataSet2;
    Context context2;

    public MedAdapter2(Context context2, ArrayList<HashMap<String, String>> dataSet) {
        this.dataSet2 = dataSet;
        this.context2 = context2;

    }


    @NonNull
    @Override
    public MedAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_raw, parent, false);
        return new MedAdapter2.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedAdapter2.MyViewHolder holder, final int position) {
        final HashMap<String, String> Details2 = dataSet2.get(position);
        holder.medName.setText(Details2.get("mednames"));
        holder.medPrice.setText(Details2.get("medprices"));
        holder.medimg.setImageResource(Integer.parseInt(Details2.get("medimages")));
        holder.medLott.setAnimation(Integer.parseInt(Details2.get("medanimations")));
        holder.buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String medUrls = Details2.get("medurl");
                Intent medUrlintent = new Intent(Intent.ACTION_VIEW, Uri.parse(medUrls));
                context2.startActivity(medUrlintent);
            }
        });
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.slide));

    }

    @Override
    public int getItemCount() {
        return (dataSet2 == null) ? 0 : dataSet2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView medName;
        TextView medPrice;
        ImageView medimg;
        LottieAnimationView medLott;
        Button buynow ;
        Button addToList ;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            medName = (TextView) itemView.findViewById(R.id.name3);
            medPrice = (TextView) itemView.findViewById(R.id.price3);
            medimg = (ImageView) itemView.findViewById(R.id.img3);
            medLott = (LottieAnimationView) itemView.findViewById(R.id.lottiepic3);
            buynow = (Button) itemView.findViewById(R.id.buynow);

        }
    }
}
