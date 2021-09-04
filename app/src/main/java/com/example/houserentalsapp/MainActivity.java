package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText userId,password;
    Button signUp_btn, signIn_btnLog;
    TextView adminLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = (EditText) findViewById(R.id.btnUsernameSgnIn);
        password = (EditText)findViewById(R.id.btnPasswordSgIn);
        signIn_btnLog = (Button)findViewById(R.id.btnSignIn);
        signUp_btn = (Button) findViewById(R.id.btnSignUpSgn);

        signUp_btn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        });
        signIn_btnLog.setOnClickListener(view -> {
            String userIdText =userId.getText().toString();
            String passwordText =password.getText().toString();

            if (userIdText.isEmpty() || passwordText.isEmpty()){
                Toast.makeText(getApplicationContext(), "Fill all the Fields", Toast.LENGTH_SHORT).show();
            }
            else {
                //perform query
                TenantDatabase tenantDatabase = TenantDatabase.getTenantDatabase(getApplicationContext());
                final TenantDao tenantDao = tenantDatabase.tenantDao();
                new Thread(() -> {
                    TenantEntity tenantEntity = tenantDao.btnSignIn(userIdText,passwordText);

                    if (tenantEntity == null){
                        runOnUiThread(() ->
                                Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show());
                    }else {
                        Intent intent = new Intent(MainActivity.this, CustomerPanel.class);
                        startActivity(intent);

                    }
                }).start();
            }
        });
        adminLink = findViewById(R.id.adminPaneLink);
        adminLink.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),LoginAdminPanel.class);
             startActivity(intent);
         });
    }
}