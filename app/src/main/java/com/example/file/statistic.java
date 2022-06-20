package com.example.file;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.file.controller.IOFile;
import com.example.file.model.NVVT;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class statistic extends AppCompatActivity {
    private ArrayList<NVVT> nvvt;
    private ArrayAdapter<String> nvvt_adapter;
    private String filename = "nvvt3.txt";
    private ListView lv;
    private Button btnAdd;
    private File f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);
        btnAdd = findViewById(R.id.button);
        lv = findViewById(R.id.list);
        nvvt= IOFile.doc(this,filename);
        if(nvvt.size()>0){
            Map<Integer,Integer> map= new Hashtable<>();
            for(NVVT i:nvvt){
                if(map.containsKey(i.getVt().getId())){
                    int value=map.get(i.getVt().getId());
                    value++;
                    map.replace(i.getVt().getId(),value);
                }
                else{
                    map.put(i.getVt().getId(),1);
                }
            }
            ArrayList<String> rs= new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry: map.entrySet()){
                rs.add("Vi tri ma so: "+entry.getKey()+" co "+entry.getValue()+" nhan vien");
            }
            nvvt_adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, rs);
            nvvt_adapter.setNotifyOnChange(true);
            lv.setAdapter(nvvt_adapter);
        }
    }
}