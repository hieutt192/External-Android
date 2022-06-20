package com.example.file.model;

import java.io.Serializable;

public class VT implements Serializable {
    private String title, des;
    private int id;
    private static int sma=1000;
    public VT() {

    }

    public VT(String title, String des) {
        this.id=sma++;
        this.title = title;
        this.des = des;
    }
    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        VT.sma = sma;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VT{" +
                "title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", id=" + id +
                '}';
    }
}
