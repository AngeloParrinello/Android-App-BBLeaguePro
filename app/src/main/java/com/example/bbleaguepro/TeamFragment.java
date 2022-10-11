package com.example.bbleaguepro;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.bbleaguepro.ViewModel.MainViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import DataBase.Ability;
import DataBase.LeaguePlayer;
import DataBase.LeaguePlayerAbilityCrossRef;
import DataBase.LeaguePlayerWithAbility;
import DataBase.LeagueTeam;
import DataBase.LeagueTeamWithLeaguePlayers;
import DataBase.PlayerWithAbility;

public class TeamFragment extends Fragment {
    private LinearLayoutCompat addHere;
    private MainViewModel viewModel;
    private TextView tvView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addHere = view.findViewById(R.id.linear_layout_team);

        MainActivity main = (MainActivity) getActivity();

        viewModel = main.getViewModel();

        TextView nameTeamTextView = view.findViewById(R.id.teamName);
        nameTeamTextView.setText(viewModel.getTeam().getValue().name);

        tvView = getActivity().findViewById(R.id.teamValue);

        LiveData<LeagueTeam> leagueTeamLiveData = viewModel.getTeam();
        leagueTeamLiveData.observe(getActivity(), new Observer<LeagueTeam>() {
            @Override
            public void onChanged(LeagueTeam leagueTeam) {
                leagueTeamLiveData.removeObserver(this);
                tvView.setText(String.valueOf(leagueTeam.tv));
            }
        });

        Button shopButton = getActivity().findViewById(R.id.shop_button);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.insertFragment((AppCompatActivity) getActivity(), new ShopFragment(), "ShopFragment");
            }
        });

        LiveData<LeagueTeamWithLeaguePlayers> leagueTeamWithLeaguePlayersLiveData = viewModel.getTeamPlayers();
        leagueTeamWithLeaguePlayersLiveData.observe(getActivity(), new Observer<LeagueTeamWithLeaguePlayers>() {
            @Override
            public void onChanged(LeagueTeamWithLeaguePlayers leagueTeamWithLeaguePlayers) {
                    if (leagueTeamWithLeaguePlayers.players != null) {
                        leagueTeamWithLeaguePlayersLiveData.removeObserver(this);
                        System.out.println(leagueTeamWithLeaguePlayers.players.size());
                        for (LeaguePlayer lp : leagueTeamWithLeaguePlayers.players) {
                            if (lp != null) {
                                //prendo le abilità dei Player
                                LiveData<PlayerWithAbility> playerWithAbilityLiveData = viewModel.getPlayerAbilities(lp.type);
                                playerWithAbilityLiveData.observe(getActivity(), new Observer<PlayerWithAbility>() {
                                    @Override
                                    public void onChanged(PlayerWithAbility playerWithAbility) {
                                        playerWithAbilityLiveData.removeObserver(this);
                                        if (playerWithAbility != null) {
                                            //prendo le abilita dei League Player
                                            LiveData<LeaguePlayerWithAbility> leaguePlayerWithAbilityLiveData = viewModel.getPlayerAbilities(lp.leaguePlayerID);
                                            leaguePlayerWithAbilityLiveData.observe(getActivity(), new Observer<LeaguePlayerWithAbility>() {
                                                @Override
                                                public void onChanged(LeaguePlayerWithAbility leaguePlayerWithAbility) {
                                                    leaguePlayerWithAbilityLiveData.removeObserver(this);
                                                    if (leaguePlayerWithAbility != null) {
                                                        //creo le lista di parole concatenate con le Abilità dei Player
                                                        String toConcatPlayer = " ";
                                                        for (Ability a : playerWithAbility.abilities) {
                                                            toConcatPlayer = toConcatPlayer.concat(a.abilityName + " ");
                                                        }
                                                        //creo le lista di parole concatenate con le Abilità dei LeaguePlayer
                                                        String toConcatLeaguePlayer = " ";
                                                        for (Ability a : leaguePlayerWithAbility.abilities) {
                                                            toConcatLeaguePlayer = toConcatLeaguePlayer.concat(a.abilityName + " ");
                                                        }
                                                        String finalConcatAbilities = toConcatLeaguePlayer.concat(toConcatPlayer);
                                                        //displayo
                                                        loadTeamRow(lp, finalConcatAbilities);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    }
            }
        });

    }

    private void loadTeamRow(LeaguePlayer lp, String abilities){
        View row = getLayoutInflater().inflate(R.layout.team_row, null,
                false);
        TextView number = row.findViewById(R.id.text_view_number);
        number.setText(String.valueOf(lp.number));
        TextView type = row.findViewById(R.id.text_view_type);
        type.setText(lp.type);
        TextView mo = row.findViewById(R.id.text_view_mo);
        mo.setText(String.valueOf(lp.movement));
        TextView fo = row.findViewById(R.id.text_view_fo);
        fo.setText(String.valueOf(lp.strength));
        TextView ag = row.findViewById(R.id.text_view_ag);
        ag.setText(String.valueOf(lp.agility));
        TextView va = row.findViewById(R.id.text_view_va);
        va.setText(String.valueOf(lp.armor));
        TextView ability = row.findViewById(R.id.text_view_ability);
        ability.setText(abilities);
        TextView sp = row.findViewById(R.id.text_view_sp);
        sp.setText(String.valueOf(lp.sp));

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View layout = getLayoutInflater().inflate(R.layout.player_popup, null);
                MaterialButton deleteButton = layout.findViewById(R.id.button_popup_delete);
                TextInputLayout addAbilityTextInputLayout = layout.findViewById(R.id.textinputlayout_popup_add_ability);
                MaterialButton addAbilityButton = layout.findViewById(R.id.add_ability_button);
                AutoCompleteTextView scrollerAbility = layout.findViewById(R.id.act_what_ability_input);

                List<String> abilityList = new ArrayList<>();
                ArrayAdapter listAdapter;
                viewModel.getAllAbilities().observe(getActivity(), new Observer<List<Ability>>() {
                    @Override
                    public void onChanged(List<Ability> abilities) {
                        for(Ability a : abilities){
                            abilityList.add(a.abilityName);
                        }
                    }
                });

                listAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                        R.layout.support_simple_spinner_dropdown_item, abilityList);
                scrollerAbility.setAdapter(listAdapter);
                scrollerAbility.setThreshold(1);

                builder.setView(layout);
                dialog = builder.create();

                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addHere.removeView(row);
                        viewModel.deleteLeaguePlayer(lp);
                        dialog.cancel();
                    }
                });

                addAbilityButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LeaguePlayerAbilityCrossRef leaguePlayerAbilityCrossRef = new LeaguePlayerAbilityCrossRef();
                        leaguePlayerAbilityCrossRef.abilityName = addAbilityTextInputLayout.getEditText().getText().toString();
                        leaguePlayerAbilityCrossRef.leaguePlayerID = lp.leaguePlayerID;
                        viewModel.insertLeaguePlayerAbilityCrossRef(leaguePlayerAbilityCrossRef);
                        dialog.cancel();
                    }
                });

                dialog.show();

            }
        });

        addHere.addView(row);
    }

}
