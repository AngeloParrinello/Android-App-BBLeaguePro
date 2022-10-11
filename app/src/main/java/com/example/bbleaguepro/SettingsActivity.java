package com.example.bbleaguepro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.Map;

import DataBase.AppDataBase;
import DataBase.AppRepository;
import DataBase.CoachWithTeams;
import DataBase.LeagueTeam;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.real_settings);
        if (savedInstanceState == null) {
            Utilities.insertFragment(this, new SettingsFragment(), "Settings Fragment");
        }

    }

    @Override
    public void onBackPressed() {

        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);
        if (f instanceof SettingsFragment) {

        }else{
            super.onBackPressed();
        }
    }
}
