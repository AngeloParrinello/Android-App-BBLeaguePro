package com.example.bbleaguepro;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.bbleaguepro.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DataBase.AppRepository;
import DataBase.League;
import DataBase.LeaguePlayer;
import DataBase.LeagueTeam;
import DataBase.LeagueTeamWithLeaguePlayers;
import DataBase.Player;
import DataBase.TeamWithPlayer;

public class ShopFragment extends Fragment {
    private LinearLayoutCompat addHere;
    private MainViewModel mainViewModel;
    private Activity activity;
    private Map<String, Integer> mapponza;
    private int totalLeaguePlayer;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addHere = getActivity().findViewById(R.id.list_layout_real_shop);

        MainActivity main = (MainActivity) getActivity();

        mainViewModel = main.getViewModel();

        mapponza = new HashMap<>();
        activity = getActivity();

        totalLeaguePlayer = 0;

        LiveData<LeagueTeam> leagueTeamLiveData = mainViewModel.getTeam();
        leagueTeamLiveData.observe((LifecycleOwner) activity, new Observer<LeagueTeam>() {
            @Override
            public void onChanged(LeagueTeam leagueTeam) {
                leagueTeamLiveData.removeObserver(this);

                LiveData<LeagueTeamWithLeaguePlayers> leagueTeamWithLeaguePlayersLiveData = mainViewModel.getAllPlayerFromALeagueTeam(leagueTeam.id);
                leagueTeamWithLeaguePlayersLiveData.observe((LifecycleOwner) activity,
                        new Observer<LeagueTeamWithLeaguePlayers>() {
                    @Override
                    public void onChanged(LeagueTeamWithLeaguePlayers leagueTeamWithLeaguePlayers) {
                        leagueTeamWithLeaguePlayersLiveData.removeObserver(this);
                        totalLeaguePlayer = leagueTeamWithLeaguePlayers.players.size();
                        for(LeaguePlayer leaguePlayer : leagueTeamWithLeaguePlayers.players){
                            if(mapponza.containsKey(leaguePlayer.type)) {
                                int intero = mapponza.get(leaguePlayer.type);
                                intero++;
                                mapponza.remove(leaguePlayer.type);
                                mapponza.put(leaguePlayer.type, intero);
                            } else {
                                mapponza.put(leaguePlayer.type, 1);
                            }
                        }
                    }
                });
            }
        });

        LiveData<LeagueTeam> leagueTeamLiveData1 = mainViewModel.getTeam();
        leagueTeamLiveData1.observe((LifecycleOwner) activity, new Observer<LeagueTeam>() {
            @Override
            public void onChanged(LeagueTeam leagueTeam) {
                leagueTeamLiveData1.removeObserver(this);

                LiveData<TeamWithPlayer> teamWithPlayerLiveData = mainViewModel.getAllPlayerFromATeam(leagueTeam.type);
                teamWithPlayerLiveData.observe((LifecycleOwner) activity,
                        new Observer<TeamWithPlayer>() {
                    @Override
                    public void onChanged(TeamWithPlayer teamWithPlayer) {
                        teamWithPlayerLiveData.removeObserver(this);
                        for(Player player : teamWithPlayer.players){
                            loadPlayerRow(player, leagueTeam);
                        }
                    }
                });
            }
        });
    }

    private void loadPlayerRow(Player player, LeagueTeam leagueTeam) {
        if (this.isAdded()) {

            View row = LayoutInflater.from(getActivity()).inflate(R.layout.shop_card, null,
                    false);

            EditText editTextUnitShop = (EditText) row.findViewById(R.id.editText_unit_shop);
            Button plusButton = (Button) row.findViewById(R.id.plus_unit_shop_button);
            Button minusButton = (Button) row.findViewById(R.id.minus_unit_shop_button);

            editTextUnitShop.setText(String.valueOf(0));

            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int numInt;

                    if (editTextUnitShop.getText().toString().equals("")) {
                        numInt = 0;
                    } else {
                        numInt = Integer.valueOf(editTextUnitShop.getText().toString());
                        if (numInt < 99) {
                            numInt++;
                        }
                    }
                    editTextUnitShop.setText(String.valueOf(numInt));
                }
            });

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int numInt;
                    if (editTextUnitShop.getText().toString().equals("")) {
                        numInt = 0;
                    } else {
                        numInt = Integer.valueOf(editTextUnitShop.getText().toString());
                        if (numInt > 0) {
                            numInt--;
                        }
                    }
                    editTextUnitShop.setText(String.valueOf(numInt));
                }
            });

            TextView namePlayer = (TextView) row.findViewById(R.id.namePlayerTextView);
            TextView pricePlayer = (TextView) row.findViewById(R.id.pricePlayerTextView);

            namePlayer.setText(player.playerName);
            pricePlayer.setText(String.valueOf(player.cost));

            Button buyButton = (Button) row.findViewById(R.id.buy_unit_shop_button);
            buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int total = 0;
                    LeagueTeam myLeagueTeam = leagueTeam;

                    if (mapponza.get(player.playerName) != null) {
                        total = Integer.parseInt(editTextUnitShop.getText().toString()) + mapponza.get(player.playerName);
                    } else {
                        total = Integer.parseInt(editTextUnitShop.getText().toString());
                    }

                    if (total > player.max) {
                        Toast.makeText(activity, "Non puoi aggiungere così tanti giocatori di questo tipo!",
                                Toast.LENGTH_SHORT).show();
                    } else {

                        int unit = Integer.parseInt(editTextUnitShop.getText().toString());
                        int cost = (player.cost * unit);

                        if (leagueTeam.tv >= cost) {
                            myLeagueTeam.tv = leagueTeam.tv - cost;

                            for (int i = 0; i < (Integer.parseInt(editTextUnitShop.getText().toString())); i++) {
                                LeaguePlayer leaguePlayer = new LeaguePlayer();
                                leaguePlayer.type = player.playerName;
                                leaguePlayer.agility = player.agility;
                                leaguePlayer.armor = player.armor;
                                leaguePlayer.movement = player.movement;
                                leaguePlayer.number = (i + totalLeaguePlayer);
                                leaguePlayer.sp = 0;
                                leaguePlayer.strength = player.strength;
                                leaguePlayer.teamID = leagueTeam.id;
                                mainViewModel.insertLeaguePlayer(leaguePlayer);
                            }
                            if (Integer.parseInt(editTextUnitShop.getText().toString()) > 0) {
                                Toast.makeText(activity, "Giocatori aggiunti!",
                                        Toast.LENGTH_SHORT).show();
                                editTextUnitShop.setText(String.valueOf(0));
                                mainViewModel.updateLeagueTeam(myLeagueTeam);
                            }
                        } else {
                            Toast.makeText(activity, "Non hai abbastanza TV!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            addHere.addView(row);
        }
    }



}
