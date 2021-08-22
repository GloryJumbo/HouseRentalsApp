package com.example.houserentalsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerPanel extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] s1;
    String[] s2;
    int[] images = {R.drawable.img1,R.drawable.img2, R.drawable.img3,R.drawable.img1,R.drawable.img5,
            R.drawable.img1,R.drawable.img3,R.drawable.img5,R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_panel);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.house_list);
        s2 = getResources().getStringArray(R.array.description_id);

        HouseAdapter houseAdapter = new HouseAdapter(this, s1, s2, images);
        recyclerView.setAdapter(houseAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}