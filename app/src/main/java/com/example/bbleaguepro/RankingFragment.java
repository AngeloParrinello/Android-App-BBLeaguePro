package com.example.bbleaguepro;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.bbleaguepro.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DataBase.Event;
import DataBase.League;
import DataBase.LeaguePlayer;
import DataBase.LeagueTeam;
import DataBase.LeagueTeamWithLeaguePlayers;
import DataBase.LeagueWithMatches;
import DataBase.Match;
import DataBase.MatchWithEvents;

public class RankingFragment extends Fragment {

    LinearLayoutCompat rankingLayoutList;
    MainViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.real_ranking, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rankingLayoutList = view.findViewById(R.id.list_layout_ranking);
        MainActivity main = (MainActivity) getActivity();
        viewModel = main.getViewModel();
        viewModel.getTeamsInLeague().observe(main, new Observer<List<LeagueTeam>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<LeagueTeam> leagueTeams) {
                //ordino la lista in base all'attributo score
                leagueTeams.sort((x,y)->{
                    return Integer.compare(y.score, x.score);
                });
                //passo la lista ad un metodo privato che si occupa di displayare
                loadRankingRows(leagueTeams);
            }
        });
    }

    //questo metodo dovrà prendere qualcosa in ingresso che identifica la squadra
    private void loadRankingRows(List<LeagueTeam> list){
        int position = 1;
        for(LeagueTeam lt : list) {
            View rankingRow = getLayoutInflater().inflate(R.layout.ranking_row_layout, null,
                    false);
            TextView positionTextView = rankingRow.findViewById(R.id.position_ranking);
            positionTextView.setText(String.valueOf(position));
            TextView teamNameTextView = rankingRow.findViewById(R.id.team_name_ranking);
            teamNameTextView.setText(lt.name);
            rankingLayoutList.addView(rankingRow);
            position++;
        }
    }
}
