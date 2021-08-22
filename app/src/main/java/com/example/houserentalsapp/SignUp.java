package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText username,password,RePassword;
    Button sgnIn_btn, AlreadySgnUp_btn;
    //DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.RegUsername);
        password = (EditText)findViewById(R.id.RegPassword);

        RePassword = (EditText) findViewById(R.id.RegRePassword);

        sgnIn_btn = (Button) findViewById(R.id.btnSignUp);
        AlreadySgnUp_btn = (Button) findViewById(R.id.btnSignInReg);

        sgnIn_btn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this, MainActivity.class);
                  startActivity(intent);

        });

        //myDB = new DBHelper(this);

//        sgnIn_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = username.getText().toString().trim();
//                String pass = password.getText().toString().trim();
//                String rePass  = RePassword.getText().toString().trim();
//
//                if (pass.equals(rePass)){
//                    long val = myDB.addUser(user,pass);
//
//                    if (val>0){
//                        //Toast.makeText(SignUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(SignUp.this, MainActivity.class);
//                        startActivity(intent);
//                    }
//                    else{
//                        Toast.makeText(SignUp.this, "Registration Error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else
//                {
//                    Toast.makeText(SignUp.this, "Password is not Matching", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        AlreadySgnUp_btn.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        });

    }
}