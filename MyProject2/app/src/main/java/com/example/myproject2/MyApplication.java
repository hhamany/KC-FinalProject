package com.example.myproject2;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    private ArrayList<Mymedicines> mymedicines = new ArrayList<>() ;

    public ArrayList<Mymedicines> getMymedicines() {
        return mymedicines;
    }

    public void setMymedicines(ArrayList<Mymedicines> mymedicines) {
        this.mymedicines = mymedicines;
    }
}
