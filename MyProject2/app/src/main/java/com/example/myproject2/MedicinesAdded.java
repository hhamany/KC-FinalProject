package com.example.myproject2;

public class MedicinesAdded {
    private String name ;
    private String size ;
    private String info ;


    public MedicinesAdded(String name, String  size, String info) {
        this.name = name;
        this.size = size;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

