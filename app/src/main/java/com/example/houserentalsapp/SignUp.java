package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText username,password,RePassword;
    Button sgnIn_btn, AlreadySgnUp_btn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.RegUsername);
        password = findViewById(R.id.RegPassword);

        RePassword = findViewById(R.id.RegRePassword);

        sgnIn_btn = findViewById(R.id.btnSignUp);
        AlreadySgnUp_btn = findViewById(R.id.btnSignInReg);

        myDB = new DBHelper(this);

        sgnIn_btn.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String rePass  = RePassword.getText().toString();

            if(user.equals("") || pass.equals("") || rePass.equals("")){
                Toast.makeText(SignUp.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (pass.equals(rePass)){
                    Boolean userCheckResult = myDB.checkUsername(user);
                    if (!userCheckResult)
                    {
                        Boolean regResult = myDB.insertData(user,pass);
                        if (regResult){
                            Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(SignUp.this, "User already Exists.\n please Sign In", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(SignUp.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlreadySgnUp_btn.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        });

    }
}