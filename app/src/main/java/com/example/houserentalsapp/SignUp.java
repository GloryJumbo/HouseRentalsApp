package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    TextInputLayout username,password,rePassword;
    Button sgnIn_btn, AlreadySgnUp_btn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (TextInputLayout)findViewById(R.id.usernameUp);
        password = (TextInputLayout)findViewById(R.id.passwordUp);
        rePassword = (TextInputLayout)findViewById(R.id.rePasswordUp);

        sgnIn_btn = (Button) findViewById(R.id.sgnIn_btnUp);
        AlreadySgnUp_btn = (Button) findViewById(R.id.AlreadySgnUp_btnUp);

        myDB = new DBHelper(this);

        sgnIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getEditText().getText().toString();
                String pass = password.getEditText().toString();
                String rePass  = rePassword.getEditText().toString();

                if(user.equals("") || pass.equals("") || rePass.equals("")){
                    Toast.makeText(SignUp.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (pass.equals(rePass)){
                        Boolean userCheckResult = myDB.checkUsername(user);
                        if (userCheckResult==false)
                        {
                            Boolean regResult = myDB.insertData(user,pass);
                            if (regResult==true){
                                Toast.makeText(SignUp.this, "Registration Successful ", Toast.LENGTH_SHORT).show();
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
            }
        });
        AlreadySgnUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

    }
}