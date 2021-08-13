package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextInputLayout usernameLog, passwordLog;
    Button signUp_btn, signIn_btnLog;

    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLog =(TextInputLayout) findViewById(R.id.usernameLogin);
        passwordLog =(TextInputLayout) findViewById(R.id.passwordLogin);
        signIn_btnLog =(Button) findViewById(R.id.signIn_btnLogin);
        signUp_btn = (Button) findViewById(R.id.signUp_btn);

        myDB = new DBHelper(this);

        signIn_btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernameLog.getEditText().toString();
                String pass = passwordLog.getEditText().toString();

                if (user.equals("") || pass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter the credentials", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    Boolean result = myDB.checkUsernamePassword(user,pass);

                    if(result == true) {
                        Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),CustomerPanel.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                    }
                }
        });
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
    }
}