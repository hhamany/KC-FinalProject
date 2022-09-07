package com.example.myproject2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Mymedicines implements Serializable {
    String addedmed, adedsize, info, time1;

    public Mymedicines(String addedmed, String adedsize, String info, String time1) {
        this.addedmed = addedmed;
        this.adedsize = adedsize;
        this.info = info;
        this.time1 = time1;
    }

    public String getAddedmed() {
        return addedmed;
    }

    public void setAddedmed(String addedmed) {
        this.addedmed = addedmed;
    }

    public String getAdedsize() {
        return adedsize;
    }

    public void setAdedsize(String adedsize) {
        this.adedsize = adedsize;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }
}

