package com.example.validateusercredentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VIewCredentials extends AppCompatActivity {
    private TextView mTvUsername;
    private TextView mTvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_iew_credentials);
        mTvEmail=findViewById(R.id.tvEmail);
        mTvUsername=findViewById(R.id.tvUserName);
        Intent intent =getIntent();
        String userName =intent.getStringExtra("username");
        String email= intent.getStringExtra("email");
        mTvEmail.setText("Email is: "+email);
        mTvUsername.setText("Username is: "+userName);
    }
}