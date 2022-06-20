package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button add_staff, add_position,staff_pos,statistic,list_staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_position=findViewById(R.id.position_add);
        add_staff=findViewById(R.id.staff_add);
        staff_pos=findViewById(R.id.staff_position);
        statistic=findViewById(R.id.statistic);
        list_staff=findViewById(R.id.list_name);
        add_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddPosition.class);
                startActivity(i);
            }
        });
        add_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddNV.class);
                startActivity(i);
            }
        });
        staff_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddNVVT.class);
                startActivity(i);
            }
        });
        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, statistic.class);
                startActivity(i);
            }
        });
        list_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ListNV.class);
                startActivity(i);
            }
        });
    }
}