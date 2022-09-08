package com.example.myproject2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {
    ArrayList<Mymedicines>mymedicineslist;

    public MyListAdapter( ArrayList<Mymedicines> mymedicinesArrayList) {
        this.mymedicineslist = mymedicinesArrayList;
    }

    @NonNull
    @Override
    public MyListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_my_med, parent, false);
        return new MyListAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyViewHolder holder, int position) {
     holder.medName.setText(mymedicineslist.get(position).addedmed);
     holder.medsize.setText(mymedicineslist.get(position).adedsize);
     holder.medinfo.setText(mymedicineslist.get(position).info);
    }

    @Override
    public int getItemCount() {
        return (mymedicineslist == null) ? 0 : mymedicineslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView medName;
        TextView medsize;
        TextView medinfo;
        TextView medtime;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            medName = (TextView) itemView.findViewById(R.id.medname);
            medsize = (TextView) itemView.findViewById(R.id.medsize);
            medinfo = (TextView) itemView.findViewById(R.id.medinfo);

        }
    }
}

