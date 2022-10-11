package com.example.bbleaguepro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.bbleaguepro.ViewModel.SettingsViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DataBase.AppRepository;
import DataBase.League;
import DataBase.LeagueTeam;
import DataBase.Team;

public class NewLegaFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_lega, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppRepository repository = new AppRepository(getActivity().getApplication());
        SettingsViewModel settingsViewModel = new SettingsViewModel(getActivity().getApplication());

        Button createButton = getActivity().findViewById(R.id.create_new_lega_button);

        TextInputLayout textInputLayoutTeamType = (TextInputLayout) getActivity().findViewById(R.id.edit_text_type);
        AutoCompleteTextView autoCompleteTextViewTeamType = (AutoCompleteTextView) getActivity().findViewById(R.id.act_race_input);
        ArrayAdapter listRaceAdapter;
        List<String> nameTeams = new ArrayList<>();

        settingsViewModel.getTeamNames().observe(getActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                if(strings != null) {
                    nameTeams.addAll(strings);
                }
            }
        });

        listRaceAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item, nameTeams);
        autoCompleteTextViewTeamType.setAdapter(listRaceAdapter);
        autoCompleteTextViewTeamType.setThreshold(1);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameLeague = getActivity().findViewById(R.id.edit_text_name_league);
                EditText descriptionLeague = getActivity().findViewById(R.id.edit_text_description_league);
                EditText nameTeamLeague = getActivity().findViewById(R.id.edit_text_name_team_league);


                Random random = new Random();

                int provaID = random.nextInt(1000000000);
                settingsViewModel.getLeague(provaID).observe(getActivity(), new Observer<League>() {
                    @Override
                    public void onChanged(League league) {
                        if(league == null){
                            League newLeague = new League();
                            newLeague.leagueID = provaID;
                            newLeague.active = false;
                            newLeague.description = descriptionLeague.getText().toString();
                            newLeague.name = nameLeague.getText().toString();


                            LeagueTeam leagueTeam = new LeagueTeam();
                            leagueTeam.score = 0;
                            leagueTeam.name = nameTeamLeague.getText().toString();
                            leagueTeam.league = provaID;
                            Bundle dataPassed = getActivity().getIntent().getExtras();
                            leagueTeam.owner = dataPassed.getString("coachName");
                            leagueTeam.tv = 1000000;
                            leagueTeam.leagueOwner = true;
                            leagueTeam.type = textInputLayoutTeamType.getEditText().getText().toString();

                            settingsViewModel.insertLeagueAndLeagueTeam(newLeague, leagueTeam);

                            Utilities.insertFragment((AppCompatActivity) getActivity(), new SettingsFragment(), "SettingsFragment");
                        }
                    }
                });

            }
        });

    }
}
