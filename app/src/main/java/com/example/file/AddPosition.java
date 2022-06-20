package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.file.controller.IOFile;
import com.example.file.model.VT;

import java.io.File;
import java.util.ArrayList;

public class AddPosition extends AppCompatActivity {
    private ArrayList<VT> nvs;
    private ArrayAdapter<VT> adnv;
    private String filename = "vt.txt";
    private EditText txtName,txtDes;
    private ListView lv;
    private Button btnAdd;
    private File f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addvt);
        btnAdd = findViewById(R.id.button);
        txtName = findViewById(R.id.title);
        txtDes = findViewById(R.id.des);
        lv = findViewById(R.id.list);

        nvs= IOFile.doc(this,filename);
        if(nvs.size()>0){
            VT.setSma(nvs.get(nvs.size()-1).getId()+1);
            adnv = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, nvs);
            adnv.setNotifyOnChange(true);
            lv.setAdapter(adnv);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String des = txtDes.getText().toString();
                VT nv = new VT( name, des);
                nvs.add(nv);
                IOFile.ghi(AddPosition.this,filename,nvs);
                nvs= IOFile.doc(AddPosition.this,filename);
                adnv = new ArrayAdapter<>(AddPosition.this,
                        android.R.layout.simple_list_item_1,
                        nvs);
                lv.setAdapter(adnv);
            }
        });
    }
}