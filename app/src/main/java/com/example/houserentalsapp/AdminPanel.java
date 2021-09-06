package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPanel extends AppCompatActivity {
    Button btnPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        btnPanel =  findViewById(R.id.btnPanel3);

        btnPanel.setOnClickListener(view -> {
            Intent intent = new Intent(AdminPanel.this, CustomerPanel.class);
            startActivity(intent);
        });
    }
}