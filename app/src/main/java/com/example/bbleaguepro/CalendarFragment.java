package com.example.bbleaguepro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.bbleaguepro.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import DataBase.Event;
import DataBase.LeaguePlayer;
import DataBase.LeagueTeam;
import DataBase.LeagueTeamWithLeaguePlayers;
import DataBase.LeagueWithMatches;
import DataBase.Match;
import DataBase.MatchWithEvents;

public class CalendarFragment extends Fragment {

    LinearLayoutCompat calendarLayoutList;
    MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.real_calendar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendarLayoutList = getActivity().findViewById(R.id.list_layout_real_calendar);
        MainActivity main = (MainActivity) getActivity();
        viewModel = main.getViewModel();
        viewModel.getMatches().observe(getActivity(), new Observer<LeagueWithMatches>() {
            //prendo i match
            @Override
            public void onChanged(LeagueWithMatches leagueWithMatches) {
                LinearLayoutCompat addHere = view.findViewById(R.id.list_layout_real_calendar);
                addHere.removeAllViews();
                if (leagueWithMatches.matches != null){
                        List<Integer> days = new ArrayList<>();
                    //conto le giornate
                    for (Match m : leagueWithMatches.matches) {
                        if (!days.contains(m.day)) {
                            days.add(m.day);
                        }
                    }
                    //recuperato il numero dell giornata per ognuna inserisco in view i match
                    for (int i = 0; i < days.size(); i++) {
                        View v = loadDayBanner(i);
                        //per ogni match controllo che sia della giornata giusta da displeyare
                        for (Match m : leagueWithMatches.matches) {
                            if (m.day == i) {
                                LiveData<LeagueTeam> team1 = viewModel.getTeamById(m.homeTeam);
                                team1.observe(getActivity(), new Observer<LeagueTeam>() {
                                    //se la giornata è quella giusta prendo il primo team
                                    @Override
                                    public void onChanged(LeagueTeam leagueTeam1) {
                                        team1.removeObserver(this);
                                        LiveData<LeagueTeam> team2 = viewModel.getTeamById(m.awayTeam);
                                        team2.observe(getActivity(), new Observer<LeagueTeam>() {
                                            //poi prendo il secondo quando arriva il primo e posso inserire i nomi in view e poi fare i conti sui td
                                            @Override
                                            public void onChanged(LeagueTeam leagueTeam2) {
                                                team2.removeObserver(this);
                                                LinearLayoutCompat layoutCompat = v.findViewById(R.id.day_matches);
                                                View row = loadMatchRow(leagueTeam1.name, leagueTeam2.name);
                                                TextView result = row.findViewById(R.id.calendar_match_result);
                                                //qui calcolo e inserisco il risultato del match per motivi di view, vedi leadMatchRow()
                                                //se la partita non è stata giocata displayo " - " altrimenti guardo gli eventi
                                                if(!m.played){
                                                    result.setText("  -  ");
                                                } else {
                                                    LiveData<MatchWithEvents> matchWithEventsLiveData = viewModel.getEvents(m.matchID);
                                                    matchWithEventsLiveData.observe(getActivity(), new Observer<MatchWithEvents>() {
                                                        @Override
                                                        public void onChanged(MatchWithEvents matchWithEvents) {
                                                            matchWithEventsLiveData.removeObserver(this);
                                                            //se ci sono eventi conto i touchdown, altrimenti pareggio 0-0 automatico
                                                            if(matchWithEvents.events != null){
                                                                LiveData<LeagueTeamWithLeaguePlayers> leaguePlayersLiveData = viewModel.getAllPlayerFromALeagueTeam(leagueTeam1.id);
                                                                        leaguePlayersLiveData.observe(getActivity(), new Observer<LeagueTeamWithLeaguePlayers>() {
                                                                            @Override
                                                                            public void onChanged(LeagueTeamWithLeaguePlayers leagueTeamWithLeaguePlayers) {
                                                                                leaguePlayersLiveData.removeObserver(this);
                                                                                if(leagueTeamWithLeaguePlayers.players != null) {
                                                                                    int td = 0;
                                                                                    int td2 = 0;
                                                                                    int find = 0;
                                                                                    for (Event e : matchWithEvents.events){
                                                                                        //controllo che l'evento sia una meta
                                                                                        if(e.type.equals("TD")){
                                                                                            //controllo se la meta l'ha fatta il team 1
                                                                                            for (LeaguePlayer p : leagueTeamWithLeaguePlayers.players) {
                                                                                                if (e.playerID == p.leaguePlayerID) {
                                                                                                    System.out.println("ho addato al primo");
                                                                                                    td++;
                                                                                                    find = 1;
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            // se non l'ha fatta nessuno dei giocatori del team 1 assegno la meta al team 2
                                                                                            if (find == 0) {
                                                                                                System.out.println("ho addato al secondo");
                                                                                                td2++;
                                                                                            }
                                                                                            find = 0;
                                                                                        }
                                                                                    }
                                                                                    //td.size() sono i td del team 1 e td2.size() quelli del team 2
                                                                                    String s = td + " - " + td2;
                                                                                    //displayo e il gioco è fatto
                                                                                    result.setText(s);
                                                                                }
                                                                            }
                                                                        });
                                                            } else {
                                                                result.setText("0 - 0");
                                                            }
                                                        }
                                                    });
                                                }
                                                layoutCompat.addView(row);
                                            }
                                        });
                                    }
                                });

                            }
                        }
                        addHere.addView(v);
                    }
                }
            }
        });
    }

    private View loadDayBanner(int day){
        View banner = getLayoutInflater().inflate(R.layout.day_banner, null);
        TextView dayTextView = banner.findViewById(R.id.day_number);
        day = day + 1;
        String s = "Giornata " + day;
        dayTextView.setText(s);
        return banner;
    }

    private View loadMatchRow(String homeTeam, String awayTeam){
        View row = getLayoutInflater().inflate(R.layout.calendar_row_layout, null);
        TextView team1 = row.findViewById(R.id.text_view_name_team_1);
        team1.setText(homeTeam);
        TextView team2 = row.findViewById(R.id.text_view_name_team_2);
        team2.setText(awayTeam);
        return row;
    }

}
