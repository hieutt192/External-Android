package com.example.file;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.file.controller.IOFile;
import com.example.file.model.NV;
import com.example.file.model.NVVT;
import com.example.file.model.VT;

import java.io.File;
import java.util.ArrayList;

public class AddNVVT extends AppCompatActivity {

    private ArrayList<NVVT> nvvt;
    private ArrayList<NV> nv;
    private ArrayList<VT> vt;
    private ArrayAdapter<NVVT> nvvt_adapter;
    private String filename = "nvvt4.txt";
    private String fileNV="nv7.txt";
    private String fileVT="vt.txt";
    private ListView lv;
    private Spinner spnv,spvt;
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnvvt);
        btnAdd = findViewById(R.id.button);
        lv = findViewById(R.id.list);
        spvt = findViewById(R.id.idVT);
        spnv = findViewById(R.id.idNV);
        nv=IOFile.doc(this,fileNV);
        vt=IOFile.doc(this,fileVT);
        if(nv!=null &&vt!=null){
            ArrayAdapter<NV> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,nv);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnv.setAdapter(ad);

            ArrayAdapter<VT> ad2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,vt);
            ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spvt.setAdapter(ad2);
        }

        nvvt= IOFile.doc(this,filename);
        if(nvvt.size()>0){
            NVVT.setSma(nvvt.get(nvvt.size()-1).getId()+1);
            nvvt_adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, nvvt);
            nvvt_adapter.setNotifyOnChange(true);
            lv.setAdapter(nvvt_adapter);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NV selectNV = (NV) spnv.getSelectedItem();
                VT selectVT = (VT) spvt.getSelectedItem();
                NVVT rs  = new NVVT(selectNV,selectVT);
                nvvt.add(rs);
                IOFile.ghi(AddNVVT.this,filename,nvvt);
                nvvt= IOFile.doc(AddNVVT.this,filename);
                nvvt_adapter = new ArrayAdapter<>(AddNVVT.this,
                        android.R.layout.simple_list_item_1,
                        nvvt);
                lv.setAdapter(nvvt_adapter);
            }
        });

    }
}