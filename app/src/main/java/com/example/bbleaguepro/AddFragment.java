package com.example.bbleaguepro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DataBase.AppRepository;
import DataBase.EventType;
import DataBase.LeaguePlayer;
import DataBase.LeagueTeam;
import DataBase.LeagueTeamWithLeaguePlayers;
import DataBase.LeagueWithMatches;
import DataBase.Match;

public class AddFragment extends Fragment {

    private View view;
    private LinearLayoutCompat layoutList;
    private MaterialButton buttonAdd;
    private EditText money;
    private Map<TextInputLayout, TextInputLayout> mappone = new HashMap<TextInputLayout, TextInputLayout>();
    private int teamID;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.match_sheet, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutList = view.findViewById(R.id.list_layout_match_sheet);
        money = view.findViewById(R.id.incassi_input_layout);
        buttonAdd = view.findViewById(R.id.add_button);

        //aggiungi una riga
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSheetRow();
            }
        });
    }


    private void loadSheetRow(){

        AppRepository appRepository = new AppRepository(getActivity().getApplication());

        View playerView = getLayoutInflater().inflate(R.layout.match_sheet_row, null,
                false);
        TextInputLayout player = (TextInputLayout) playerView.findViewById(R.id.player_input_layout);
        TextInputLayout event = (TextInputLayout) playerView.findViewById(R.id.event_input_layout);

        AutoCompleteTextView completePlayer = (AutoCompleteTextView) playerView.findViewById(R.id.act_player_input);
        AutoCompleteTextView completeEvent = (AutoCompleteTextView) playerView.findViewById(R.id.act_event_input);

        List<String> leaguePlayersList = new ArrayList<>();
        List<EventType> eventsList = new ArrayList<>();

        ArrayAdapter listPlayerAdapter;
        ArrayAdapter listEventAdapter;

        //devo passare una volta l'id di una squadra e una volta quello dell'avversario
        appRepository.getAllPlayersFromALeagueTeam(teamID)
                .observe(getActivity(), new Observer<LeagueTeamWithLeaguePlayers>() {
            //inserisco nella lista i numeri dei giocatori
            @Override
            public void onChanged(LeagueTeamWithLeaguePlayers leagueTeamWithLeaguePlayers) {
                for(LeaguePlayer lp : leagueTeamWithLeaguePlayers.players){
                    leaguePlayersList.add(String.valueOf(lp.number));
                }
            }
        });



        eventsList.addAll(new ArrayList<EventType>(Arrays.asList(EventType.values())));

        listPlayerAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, leaguePlayersList);
        listEventAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, eventsList);

        completePlayer.setAdapter(listPlayerAdapter);
        completeEvent.setAdapter(listEventAdapter);

        completePlayer.setThreshold(1);
        completeEvent.setThreshold(1);
        mappone.put(player, event);


        ImageView imgClose = (ImageView) playerView.findViewById(R.id.x_img);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutList.removeView(playerView);
                mappone.remove(player);
            }
        });

        layoutList.addView(playerView);
    }

    public LinearLayoutCompat getLayoutList(){
        return this.layoutList;
    }

    public Map<TextInputLayout, TextInputLayout> getMappone(){
        return this.mappone;
    }

    public void setTeamID(int id){
        this.teamID = id;
    }

    public EditText getMoney() {
        return money;
    }

}
