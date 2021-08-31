package com.example.houserentalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText userId,password,name;
    Button sgnIn_btn, AlreadySgnUp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userId = findViewById(R.id.RegUsername);
        password = findViewById(R.id.RegPassword);

        name = findViewById(R.id.RegRePassword);

        sgnIn_btn = findViewById(R.id.btnSignUp);
        AlreadySgnUp_btn = findViewById(R.id.btnSignInReg);

        sgnIn_btn.setOnClickListener(view -> {
            //creating Tenant Entity
            final TenantEntity tenantEntity = new TenantEntity();
            tenantEntity.setUserId(userId.getText().toString());
            tenantEntity.setPassword(password.getText().toString());
            tenantEntity.setName(name.getText().toString());

            if (validateInput(tenantEntity)){

                // do insert operation
                TenantDatabase tenantDatabase = TenantDatabase.getTenantDatabase(getApplicationContext());
                TenantDao tenantDao = tenantDatabase.tenantDao();

                new Thread(() -> {
                    //register tenant
                    tenantDao.registerTenant(tenantEntity);

                    runOnUiThread(() ->
                            Toast.makeText(getApplicationContext(), "You are Registered", Toast.LENGTH_SHORT).show());
                }).start();
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Fill all the fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private Boolean validateInput(TenantEntity tenantEntity){
        return !tenantEntity.getUserId().isEmpty() && !tenantEntity.getPassword().isEmpty() &&
                !tenantEntity.getName().isEmpty();
    }
}