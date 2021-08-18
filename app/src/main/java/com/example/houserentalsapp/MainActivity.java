package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText usernameLog, passwordLog;
    Button signUp_btn, signIn_btnLog;
    TextView adminLink;

    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLog = findViewById(R.id.btnUsernameSgnIn);
        passwordLog = findViewById(R.id.btnPasswordSgIn);
        signIn_btnLog = findViewById(R.id.btnSignIn);
        signUp_btn = findViewById(R.id.btnSignUpSgn);

        adminLink = findViewById(R.id.adminPaneLink);

        myDB = new DBHelper(this);

        signIn_btnLog.setOnClickListener(view -> {
            String user = usernameLog.getText().toString();
            String pass = passwordLog.getText().toString();

            if (user.equals("") || pass.equals(""))
            {
                Toast.makeText(MainActivity.this, "Enter the credentials", Toast.LENGTH_SHORT).show();
            }
            else
                {
                Boolean result = myDB.checkUsernamePassword(user,pass);

                if(result) {
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),CustomerPanel.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }

                }
            });
        signUp_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),SignUp.class);
            startActivity(intent);
        });
        adminLink.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),LoginAdminPanel.class);
            startActivity(intent);
        });
    }
}