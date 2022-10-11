package com.example.bbleaguepro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.bbleaguepro.ViewModel.MainViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import DataBase.League;
import DataBase.LeagueTeam;
import DataBase.Match;

public class HomeFragment extends Fragment {

    private MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            MainActivity main = (MainActivity) getActivity();
            viewModel = main.getViewModel();

            TextView descriptionLeague = view.findViewById(R.id.card_descrizione_lega);

            viewModel.getLeague().observe(getActivity(), new Observer<League>() {
                @Override
                public void onChanged(League league) {
                    descriptionLeague.setText(league.description);
                }
            });

            viewModel.getTeam().observe(getActivity() , new Observer<LeagueTeam>() {
                @Override
                public void onChanged(LeagueTeam leagueTeam) {
                    if(leagueTeam.leagueOwner){
                        LinearLayoutCompat layout = view.findViewById(R.id.cards_container);
                        View v = getLayoutInflater().inflate(R.layout.admin_card, null, false);
                        TextView idText = v.findViewById(R.id.text_id_view);
                        String s = "ID : " + String.valueOf(leagueTeam.league);
                        idText.setText(s);


                        viewModel.getTeamsInLeague().observe(getActivity(), new Observer<List<LeagueTeam>>() {
                            @Override
                            public void onChanged(List<LeagueTeam> leagueTeams) {
                                TextView members = v.findViewById(R.id.text_members_view);
                                String s1 = "Membri : " + String.valueOf(leagueTeams.size());
                                members.setText(s1);
                            }
                        });
                        FloatingActionButton play = v.findViewById(R.id.start_button_admin);
                        play.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewModel.getLeague().observe(getActivity(), new Observer<League>() {
                                    //prendo la lega per controllare che non sia già partita
                                    @Override
                                    public void onChanged(League league) {
                                        //qui controllo se è attiva
                                        if(!league.active) {
                                            viewModel.getLeague().removeObserver(this);
                                            viewModel.getTeamsInLeague().observe(getActivity(), new Observer<List<LeagueTeam>>() {
                                                //prendo i team in lega
                                                @Override
                                                public void onChanged(List<LeagueTeam> leagueTeams) {
                                                    viewModel.getTeamsInLeague().removeObserver(this);
                                                    //controllo che siano pari, se fossero dispari l'algoritmo non funzionerebbe
                                                    if (leagueTeams.size() % 2 == 0) {
                                                        //da qui parte l'algoritmo per la generazione del calendario
                                                        int idLeague = league.leagueID;
                                                        List<Integer> list1 = new ArrayList<>();
                                                        List<Integer> list2 = new ArrayList<>();
                                                        int intero = 0;
                                                        for (LeagueTeam lt : leagueTeams) {
                                                            list1.add(intero);
                                                            intero++;
                                                        }
                                                        int cycles = list1.size() / 2;
                                                        for (int i = 0; i < cycles; i++) {
                                                            list2.add(list1.get(0));
                                                            list1.remove(0);
                                                        }
                                                        //numero giornate
                                                        for (int j = 0; j < leagueTeams.size() - 1; j++) {
                                                            for (int i = 0; i < list1.size(); i++) {
                                                                Match m = new Match();
                                                                m.day = j;
                                                                m.homeTeam = leagueTeams.get(list1.get(i)).id;
                                                                m.awayTeam = leagueTeams.get(list2.get(i)).id;
                                                                m.league = idLeague;
                                                                m.played = false;
                                                                viewModel.insertMatch(m);
                                                            }
                                                            Integer last = list1.get(list1.size() - 1);
                                                            Integer first = list2.get(0);
                                                            list1.add(1, first);
                                                            list1.remove(list1.size() - 1);
                                                            list2.add(last);
                                                            list2.remove(0);
                                                        }
                                                        //finito l'algoritmo starto la lega
                                                        main.startLeague();
                                                    } else {
                                                        Toast.makeText(getContext(), "serve un numero pari di partecipanti", Toast.LENGTH_LONG).show();
                                                    }
                                                }

                                            });
                                        } else {
                                            Toast.makeText(getContext(), "la lega è ancora in corso", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                            }
                        });
                        //qui va messo il tasto stop, il tasto dovrebbe fermare la lega (da definire cosa vuol dire fermare la lega)
                        layout.addView(v);
                    }
                }
            });
        }
    }

