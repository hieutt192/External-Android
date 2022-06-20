package com.example.file;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.file.controller.IOFile;
import com.example.file.model.NV;

import java.io.File;
import java.util.ArrayList;

public class ListNV extends AppCompatActivity {
    private ArrayList<NV> nvs;
    private ArrayAdapter<NV> adnv;
    private String filename = "nv7.txt";
    private EditText txtName,txtYear;
    private ListView lv;
    private Button btnAdd;
    private File f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listnv);
        btnAdd = findViewById(R.id.button);
        txtName = findViewById(R.id.name);
        txtYear = findViewById(R.id.year);
        lv = findViewById(R.id.list);

        nvs= IOFile.doc(this,filename);
        if(nvs.size()>0){
            adnv = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, nvs);
            adnv.setNotifyOnChange(true);
            lv.setAdapter(adnv);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String year = txtYear.getText().toString();
                ArrayList<NV> filter= new ArrayList<>();
                for(NV nv: nvs){
                    if(nv.getName().equals(name) && nv.getNamsinh().equals(year)){
                        filter.add(nv);
                    }
                }
                adnv = new ArrayAdapter<>(ListNV.this,
                        android.R.layout.simple_list_item_1,
                        filter);
                lv.setAdapter(adnv);
            }
        });
    }
}