package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.file.controller.IOFile;
import com.example.file.model.NV;

import java.io.File;
import java.util.ArrayList;

public class AddNV extends AppCompatActivity {

    private ArrayList<NV> nvs;
    private ArrayAdapter<NV> adnv;
    private String filename = "nv7.txt";
    private EditText txtName,txtQue,txtDOB;
    private ListView lv;
    private Spinner spTrinhDo;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnv);
        btnAdd = findViewById(R.id.btnaddNV);
        txtName = findViewById(R.id.txtName);
        txtQue = findViewById(R.id.txtQue);
        txtDOB = findViewById(R.id.txtNamSinh);
        lv = findViewById(R.id.list);
        spTrinhDo = findViewById(R.id.spTD);

        String[] s = {"Cao Đẳng", "Đại học", "Sau đại học"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTrinhDo.setAdapter(ad);
        spTrinhDo.setSelection(0);

        nvs= IOFile.doc(this,filename);
        if(nvs.size()>0){
            NV.setSma(nvs.get(nvs.size()-1).getId()+1);
            loadData();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String que = txtQue.getText().toString();
                String DOB = txtDOB.getText().toString();
                String trinhdo = spTrinhDo.getSelectedItem().toString();
                NV nv = new NV( name, que, DOB, trinhdo);
                nvs.add(nv);
                IOFile.ghi(AddNV.this,filename,nvs);
                nvs= IOFile.doc(AddNV.this,filename);
                loadData();
            }
        });
    }
    private void loadData(){
        adnv = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, nvs);
        adnv.setNotifyOnChange(true);
        lv.setAdapter(adnv);
    }

}