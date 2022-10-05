package com.example.myproject2;

public class Pharmacies {
    private String pname;
    private int ppic;
    private  String url ;

    public Pharmacies(String pname, int ppic, int piclott, String url) {
        this.pname = pname;
        this.ppic = ppic;
        this.url = url;
    }

    public String getPname() {
        return pname;
    }

    public int getPpic() {
        return ppic;
    }

    public String getUrl() {
        return url;
    }
}
