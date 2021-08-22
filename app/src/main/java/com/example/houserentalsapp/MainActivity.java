package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText usernameLog, passwordLog;
    Button signUp_btn, signIn_btnLog;
    TextView adminLink;

    //DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLog = (EditText) findViewById(R.id.btnUsernameSgnIn);
        passwordLog = (EditText)findViewById(R.id.btnPasswordSgIn);
        signIn_btnLog = (Button)findViewById(R.id.btnSignIn);
        signUp_btn = (Button) findViewById(R.id.btnSignUpSgn);

        adminLink = findViewById(R.id.adminPaneLink);

       // myDB = new DBHelper(this);

        signUp_btn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        });
        signIn_btnLog.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CustomerPanel.class);
               startActivity(intent);
        });
//
//        signIn_btnLog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = usernameLog.getText().toString().trim();
//                String pass = passwordLog.getText().toString().trim();
//                boolean res = myDB.checkUser(user,pass);
//                if (res == true) {
//                    Intent intent = new Intent(MainActivity.this, CustomerPanel.class);
//                    startActivity(intent);
//                   // Toast.makeText(MainActivity.this, "Successfully Signed In", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Sign In Error", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        adminLink.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),LoginAdminPanel.class);
             startActivity(intent);
         });
    }
}