package com.example.validateusercredentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginCredentials extends AppCompatActivity {
    private Button mTvBtnLogin;
    private String emailValidation ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+";
    private EditText mEtEmail;
    private  EditText mEtPassword;
    private  EditText mEtConfPassword;
    private EditText mEtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_credentials);

        initView();

        mTvBtnLogin=findViewById(R.id.tvBtnLogin);

        mTvBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid() && isPasswordValid() && isUsernameValid() && isConfirmPassword()){
                    Intent intent =new Intent(LoginCredentials.this,VIewCredentials.class);
                    intent.putExtra("email",mEtEmail.getText().toString());
                    intent.putExtra("username",mEtUsername.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void initView(){

        mEtEmail =findViewById(R.id.teEmail);
        mEtPassword =findViewById(R.id.tePassword);
        mEtConfPassword =findViewById(R.id.teConfPassword);
        mTvBtnLogin = findViewById(R.id.tvBtnLogin);
        mEtUsername =findViewById(R.id.teUsername);
    }

    private boolean isEmailValid(){
        if (mEtEmail.getText().toString().length()>=1 && mEtEmail.getText().toString().matches(emailValidation)){
            return true;
        }
        else {
            mEtEmail.setError("invalid email");
            return false;
        }
    }
    private boolean isPasswordValid(){
        if(mEtPassword.getText().toString().length()>=6){
            return true;
        }else{
            mEtPassword.setError("Invalid password");
            return false;
        }

    }
    private boolean isConfirmPassword(){
        if (mEtConfPassword.getText().toString().equals(mEtPassword.getText().toString())){
            return true;
        }
        else{
            mEtConfPassword.setError("Password did't match");
            return false;
        }
    }
    private boolean isUsernameValid(){
        if (mEtUsername.getText().toString().length()>=3)
            return true;
        else{
            mEtUsername.setError("Invalid Username");
            return false;
        }
    }

}