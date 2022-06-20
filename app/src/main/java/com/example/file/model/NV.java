package com.example.file.model;

import java.io.Serializable;

public class NV implements Serializable {
    private String name,que,namsinh,trinhdo;
    private int id;
    private static int sma=1000;
    public NV() {

    }

    public NV(String name, String que, String namsinh, String trinhdo) {
        this.id=sma++;
        this.name = name;
        this.que = que;
        this.namsinh = namsinh;
        this.trinhdo = trinhdo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        NV.sma = sma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    @Override
    public String toString() {
        return "NV{" +id+
                "name='" + name + '\'' +
                ", que='" + que + '\'' +
                ", namsinh='" + namsinh + '\'' +
                ", trinhdo='" + trinhdo + '\'' +
                '}';
    }
}
