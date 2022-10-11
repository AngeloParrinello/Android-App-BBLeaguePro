package com.example.bbleaguepro;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        if (savedInstanceState == null) {
            Utilities.insertFragment(this, new LoginFragment(), "Login Fragment");
        }

    }
}
