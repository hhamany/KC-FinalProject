package com.example.myproject2;

import java.io.Serializable;

public class Mymedicines implements Serializable {
    String addedmed, adedsize, info;

    public Mymedicines(String addedmed, String adedsize, String info) {
        this.addedmed = addedmed;
        this.adedsize = adedsize;
        this.info = info;
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
}

