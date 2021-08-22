package com.example.houserentalsapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HouseDetails extends AppCompatActivity {
    ImageView imageDetail;
    TextView title, description;

    String data, data2;
    int mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_details);

        imageDetail = findViewById(R.id.imgDetail);
        title = (TextView) findViewById(R.id.textDetail1);
        description =(TextView) findViewById(R.id.textDetail2);

        getData();
        setData();

    }
    public void getData(){
        if (getIntent().hasExtra("mImage") && getIntent().hasExtra("data")){
            data = getIntent().getStringExtra("data");
            //data2 = getIntent().getStringExtra("data2");
            mImage = getIntent().getIntExtra("mImage", 1);

        }
        else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    public void setData(){

        title.setText(data);
        description.setText(data2);
        imageDetail.setImageResource(mImage);
    }
}