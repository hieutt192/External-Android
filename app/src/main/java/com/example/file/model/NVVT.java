package com.example.file.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class NVVT implements Serializable {
    private int id;
    private NV nv;
    private VT vt;
    private String createAt;
    private static int sma=1000;
    public NVVT() {
    }

    public NVVT(NV nv, VT vt) {
        this.id=sma++;
        this.nv= nv;
        this.vt=vt;
        this.createAt = LocalDate.now().toString();
    }
    public int getId() {
        return id;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int vtm) {
        NVVT.sma = vtm;
    }
    public void setId(int id) {
        this.id = id;
    }
    public NV getNv() {
        return nv;
    }

    public void setNv(NV nv) {
        this.nv = nv;
    }

    public VT getVt() {
        return vt;
    }

    public void setVt(VT vt) {
        this.vt = vt;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "NVVT{" +
                "id=" + id +
                ", nv=" + nv.getId()+
                ", vt=" + vt.getId() +
                ", createAt='" + createAt + '\'' +
                '}';
    }
}
