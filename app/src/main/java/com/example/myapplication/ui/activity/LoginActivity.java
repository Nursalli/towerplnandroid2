package com.example.myapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.contract.LoginContract;
import com.example.myapplication.response.LoginResponse;
import com.example.myapplication.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract {
    Button btn_submit;
    LoginPresenter loginPresenter;
    EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btn_submit = findViewById(R.id.btn_submit);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        loginPresenter = new LoginPresenter(this);

        btn_submit.setOnClickListener(v -> {
            if (et_username.getText().toString().equals("")) {
                et_username.setError("Harap Isi Username");
                Toast.makeText(this,
                        "Harap Isi Username",
                        Toast.LENGTH_SHORT).show();
            }

            if (et_password.getText().toString().equals("")) {
                et_password.setError("Harap Isi Password");
                Toast.makeText(this,
                        "Harap Isi Password",
                        Toast.LENGTH_SHORT).show();
            }

            if (!et_username.getText().toString().equals("") &&
                    !et_password.getText().toString().equals("")) {
//                loginPresenter.postLogin(
//                        et_username.getText().toString(),
//                        et_password.getText().toString()
//                );
                SharedPreferences sp = getSharedPreferences("login", 0);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor spedit = sp.edit();
                spedit.putString("username", "ujang");
                spedit.apply();

                startActivity(new Intent(this, MainActivity.class));
            }
        });
    }

    @Override
    public void postLoginStart() {
        Toast.makeText(this,
                "Harap Menunggu",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void postLoginCompleted(LoginResponse loginResponse) {
        SharedPreferences sp = getSharedPreferences("login", 0);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor spedit = sp.edit();
        spedit.putString("username", loginResponse.getUsername());
        spedit.apply();

        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void postLoginFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}