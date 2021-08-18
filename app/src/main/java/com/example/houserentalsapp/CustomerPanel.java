package com.example.houserentalsapp;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerPanel extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_panel);

        listView = findViewById(R.id.listView);

        //creating add data

        ArrayList<House> arrayList = new ArrayList<>();
        arrayList.add(new House(R.drawable.img1, "Location:Matawale","Price : K300000"));
        arrayList.add(new House(R.drawable.img2, "Location:Jali", "Price : k400000"));
        arrayList.add(new House(R.drawable.img3, "Location:AirWing", "Price : K150000"));
        arrayList.add(new House(R.drawable.img4, "Location:NewRoad", "Price : k 70000"));
        arrayList.add(new House(R.drawable.img5, "Location:3 Miles", "Price : K55000"));

        //we make customerAdapter
        HouseAdapter houseAdapter = new HouseAdapter(this,R.layout.row,arrayList);
        listView.setAdapter(houseAdapter);
    }
}