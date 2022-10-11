package com.example.bbleaguepro;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.bbleaguepro.ViewModel.SettingsViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DataBase.AppRepository;
import DataBase.CoachWithTeams;
import DataBase.League;
import DataBase.LeagueTeam;

public class SettingsFragment extends Fragment {

    LinearLayoutCompat settingLayoutList;
    SettingsViewModel viewModel;
    String nameCoach;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton logoutButton = getActivity().findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

            Bundle dataPassed = getActivity().getIntent().getExtras();
            nameCoach = dataPassed.getString("coachName");

            TextView nomeUtente = getActivity().findViewById(R.id.text_view_settings_nome);
            nomeUtente.setText(nameCoach);

            settingLayoutList = (LinearLayoutCompat) getActivity().findViewById(R.id.list_layout_real_settings);

            viewModel = new SettingsViewModel(getActivity().getApplication());
            viewModel.getCoachWithTeams(nameCoach).observe(getActivity(), new Observer<CoachWithTeams>() {

                @Override
                public void onChanged(CoachWithTeams coachWithTeams) {
                    System.out.println(coachWithTeams.coach.toString());
                    System.out.println(coachWithTeams.teams.toString());
                    for (LeagueTeam lt : coachWithTeams.teams) {
                        loadSettingsRow(lt);
                    }
                }
            });
            Button createLeagueButton = view.findViewById(R.id.button_settings_create_league);
            Button enterLeagueButton = view.findViewById(R.id.button_settings_login_league);


            createLeagueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewModel.getCoachWithTeams(nameCoach).removeObservers(getActivity());
                    Utilities.insertFragment((AppCompatActivity) getActivity(), new NewLegaFragment(), "New Lega Fragment");
                }
            });

            enterLeagueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog dialog;
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    View layout = getLayoutInflater().inflate(R.layout.join_league_popup, null);
                    TextInputLayout id = layout.findViewById(R.id.popup_ID);
                    TextInputLayout name = layout.findViewById(R.id.popup_team_name);
                    TextInputLayout spinnerLayout = layout.findViewById(R.id.popup_team_type);
                    AutoCompleteTextView spinner = layout.findViewById(R.id.popup_teams);
                    MaterialButton go = layout.findViewById(R.id.popup_go);

                    List<String> nameList = new ArrayList<>();
                    ArrayAdapter listAdapter;
                    viewModel.getTeamNames().observe(getActivity(), new Observer<List<String>>() {
                        @Override
                        public void onChanged(List<String> strings) {
                            nameList.addAll(strings);
                        }
                    });

                    builder.setView(layout);
                    dialog = builder.create();

                    listAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                            R.layout.support_simple_spinner_dropdown_item, nameList);
                    spinner.setAdapter(listAdapter);
                    spinner.setThreshold(1);

                    go.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewModel.getAllLeague().observe(getActivity(), new Observer<List<League>>() {
                                @Override
                                public void onChanged(List<League> leagues) {
                                    int leagueID = 0;
                                    int possibleID = Integer.valueOf(id.getEditText().getText().toString());
                                    for(League league : leagues){
                                        if(league.leagueID == possibleID){
                                            leagueID = possibleID;
                                        }
                                    }

                                    if(leagueID != 0){
                                        viewModel.getLeague(leagueID).observe(getActivity(),
                                                new Observer<League>() {
                                                    @Override
                                                    public void onChanged(League league) {
                                                        if(!league.active) {
                                                            LeagueTeam toInsert = new LeagueTeam();
                                                            toInsert.score = 0;
                                                            toInsert.leagueOwner = false;
                                                            toInsert.league = Integer.parseInt(id.getEditText().getText().toString());
                                                            toInsert.name = name.getEditText().getText().toString();
                                                            toInsert.owner = nameCoach;
                                                            toInsert.tv = 1000000;
                                                            toInsert.type = spinnerLayout.getEditText().getText().toString();
                                                            viewModel.insertLeagueTeam(toInsert);
                                                            } else {
                                                                Toast.makeText(getContext(), "Lega già cominciata!", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                });
                                    } else {
                                        Toast.makeText(getContext(), "Lega inesistente!", Toast.LENGTH_SHORT).show();
                                    }

                                }

                            });
                                    dialog.cancel();
                            }
                    });

                    dialog.show();
                }
            });

    }




    private void loadSettingsRow(LeagueTeam t) {
            View settingsRows = LayoutInflater.from(getActivity()).inflate(R.layout.settings_row_layout, null,
                    false);

            TextView textSettingsView = settingsRows.findViewById(R.id.league_name_row);
            textSettingsView.setTextSize(20);
            textSettingsView.setLetterSpacing(Float.valueOf("0.3"));
            textSettingsView.setText(t.name);
            if (t.leagueOwner) {
                textSettingsView.setTextColor(getResources().getColor(R.color.purple_500));
            } else {
                textSettingsView.setTextColor(getResources().getColor(R.color.black));
            }
            textSettingsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("leagueID", t.league);
                    intent.putExtra("coachName", nameCoach);
                    startActivity(intent);
                }
            });
            settingLayoutList.addView(settingsRows);
    }

}
