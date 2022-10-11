package com.example.bbleaguepro;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DataBase.AppRepository;
import DataBase.Event;
import DataBase.LeaguePlayer;
import DataBase.LeagueTeam;
import DataBase.LeagueTeamWithLeaguePlayers;
import DataBase.LeagueWithMatches;
import DataBase.Match;

public class AddActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private SliderPagerAdapter pagerAdapter;
    private LinearLayoutCompat dotsContaier;
    private TextView[] dots;
    int matchID;
    int loggedUserTeamID;
    int unloggedUserTeamID;
    List<Fragment> list;
    AppCompatActivity activity = this;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.match_top_app_bar, menu);
        return true;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_slider);

        list = new ArrayList<>();
        this.discoverIds();
        findViewById(R.id.app_bar_chart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loggedUserTeamID != 0 && unloggedUserTeamID != 0 && matchID != 0) {
                    AppRepository repo = new AppRepository(getApplication());
                    //ho bisogno di castare i fragment ad AddFragment per getMappone()
                    AddFragment frag = (AddFragment) list.get(0);
                    AddFragment frag2 = (AddFragment) list.get(1);
                    //prendo tutti i giocatori del team loggedUserID
                    LiveData<LeagueTeamWithLeaguePlayers> teamAndPlayers = repo.getAllPlayersFromALeagueTeam(loggedUserTeamID);
                    teamAndPlayers.observe(activity, new Observer<LeagueTeamWithLeaguePlayers>() {
                        int tdLogged = 0;
                        int spIncrementLogged = 0;
                        @Override
                        public void onChanged(LeagueTeamWithLeaguePlayers leagueTeamWithLeaguePlayers) {
                            //controllo che la squadra abbia dei giocatori
                            if(leagueTeamWithLeaguePlayers.players != null) {
                                teamAndPlayers.removeObserver(this);
                                for (Map.Entry<TextInputLayout, TextInputLayout> entry : frag.getMappone().entrySet()) {
                                    Event e = new Event();
                                    e.matchID = matchID;
                                    e.type = entry.getValue().getEditText().getText().toString();
                                    switch(e.type){
                                        case "TD":
                                            tdLogged++;
                                            spIncrementLogged = 3;
                                            break;

                                        case "CS":
                                            spIncrementLogged = 2;
                                            break;

                                        case "PS":
                                            spIncrementLogged = 1;
                                            break;

                                        default:
                                            break;
                                    }
                                    //salvo il numero del giocatore
                                    int number = Integer.parseInt(entry.getKey().getEditText().getText().toString());
                                    //quando ho trovato il giocatore con quel numero prendo il suo ID ed esco
                                    for (LeaguePlayer p : leagueTeamWithLeaguePlayers.players) {
                                        if (p.number == number) {
                                            e.playerID = p.leaguePlayerID;
                                            repo.incrementSp(spIncrementLogged, p.leaguePlayerID);
                                            break;
                                        }
                                    }
                                    repo.insertEvent(e);
                                }
                            }
                            LiveData<LeagueTeamWithLeaguePlayers> teamAndPlayer2 = repo.getAllPlayersFromALeagueTeam(unloggedUserTeamID);
                            teamAndPlayer2.observe(activity, new Observer<LeagueTeamWithLeaguePlayers>() {
                                @Override
                                public void onChanged(LeagueTeamWithLeaguePlayers leagueTeamWithLeaguePlayers) {
                                    //controllo che la squadra abbia dei giocatori
                                    if(leagueTeamWithLeaguePlayers.players != null) {
                                        teamAndPlayer2.removeObserver(this);
                                        int tdUnlogged = 0;
                                        int spIncrementUnLogged = 0;
                                        for (Map.Entry<TextInputLayout, TextInputLayout> entry : frag2.getMappone().entrySet()) {
                                            Event e = new Event();
                                            e.matchID = matchID;
                                            e.type = entry.getValue().getEditText().getText().toString();
                                            switch(e.type){
                                                case "TD":
                                                    tdUnlogged++;
                                                    spIncrementUnLogged = 3;
                                                    break;

                                                case "CS":
                                                    spIncrementUnLogged = 2;
                                                    break;

                                                case "PS":
                                                    spIncrementUnLogged = 1;
                                                    break;

                                                default:
                                                    break;
                                            }
                                            //salvo il numero del giocatore
                                            int number = Integer.parseInt(entry.getKey().getEditText().getText().toString());
                                            //quando ho trovato il giocatore con quel numero prendo il suo ID ed esco
                                            for (LeaguePlayer p : leagueTeamWithLeaguePlayers.players) {
                                                if (p.number == number) {
                                                    e.playerID = p.leaguePlayerID;
                                                    repo.incrementSp(spIncrementUnLogged, p.leaguePlayerID);
                                                    break;
                                                }
                                            }
                                            repo.insertEvent(e);
                                        }
                                        //aggiornare i punteggi delle squadre
                                        if(tdUnlogged > tdLogged){
                                            repo.updateScore(unloggedUserTeamID, 3);
                                        } else if(tdUnlogged < tdLogged){
                                            repo.updateScore(loggedUserTeamID, 3);
                                        } else {
                                            repo.updateScore(unloggedUserTeamID, 1);
                                            repo.updateScore(loggedUserTeamID, 1);
                                        }
                                    }
                                }
                            });
                        }
                    });
                    //aumento la tesoreria
                    String money = frag.getMoney().getText().toString();
                    if(!money.equals("")) {
                        repo.addTeamValue(loggedUserTeamID, Integer.parseInt(money));
                    }
                    money = frag2.getMoney().getText().toString();
                    if(!money.equals("")) {
                        repo.addTeamValue(unloggedUserTeamID, Integer.parseInt(money));
                    }
                    //aggiorno il match a giocato
                    repo.matchPlayed(matchID);

                } else {
                    Toast.makeText(activity, "qualcosa è andato storto", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void selectIndicator(int position) {
        if(position==0){
            dots[0].setTextColor(getResources().getColor(R.color.black));
            dots[1].setTextColor(getResources().getColor(R.color.grey));
        } else {
            dots[1].setTextColor(getResources().getColor(R.color.black));
            dots[0].setTextColor(getResources().getColor(R.color.grey));
        }
    }

    private void dotsIndicator() {
        for(int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            dotsContaier.addView(dots[i]);
        }
    }

    /**
     * dopo aver chiamato questo metodo abbiamo nei campi della classe l'id del team dell'utente che sta usando l'app,
     * quello del suo avversario e quello del match.
     */
    private void discoverIds(){
        loggedUserTeamID = getIntent().getExtras().getInt("idTeam");
        AppRepository repo = new AppRepository(getApplication());
        LiveData<LeagueTeam> teamLiveData = repo.getLeagueTeam(loggedUserTeamID);
        teamLiveData.observe(this, new Observer<LeagueTeam>() {
            //chiedo la squadra
            @Override
            public void onChanged(LeagueTeam leagueTeam) {
                if (list.isEmpty()) {
                    LiveData<LeagueWithMatches> cazzone = repo.getMatches(leagueTeam.league);
                    cazzone.observe(activity, new Observer<LeagueWithMatches>() {
                        //chiedo i match
                        @Override
                        public void onChanged(LeagueWithMatches leagueWithMatches) {
                            if (list.isEmpty()) {
                                //controllo che siano stati creati dei match per la lega
                                if (leagueWithMatches.matches != null) {
                                    List<Match> toPlay = new ArrayList<>();
                                    //prendo tutti i match  ancora da giocare dell'utente loggato (ho l'id del suo team)
                                    for (Match m : leagueWithMatches.matches) {
                                        if ((m.homeTeam == loggedUserTeamID || m.awayTeam == loggedUserTeamID) && !m.played) {
                                            toPlay.add(m);
                                        }
                                    }
                                    //controllo che ci siano partite da giocare per quell'utente
                                    if (!toPlay.isEmpty()) {
                                        //prendo il match con la giornata minore
                                        Match theMatch = toPlay.get(0);
                                        for (Match m : toPlay) {
                                            if (m.day < theMatch.day) {
                                                theMatch = m;
                                            }
                                        }
                                        //a questo punto ho il match giusto e posso salvare il suo id e quello dei due team
                                        matchID = theMatch.matchID;
                                        unloggedUserTeamID = theMatch.homeTeam == loggedUserTeamID ? theMatch.awayTeam : theMatch.homeTeam;
                                        AddFragment first = new AddFragment();
                                        first.setTeamID(loggedUserTeamID);
                                        list.add(first);
                                        AddFragment second = new AddFragment();
                                        second.setTeamID(unloggedUserTeamID);
                                        list.add(second);

                                        dotsContaier = findViewById(R.id.dots_container);
                                        viewPager2 = findViewById(R.id.match_view_pager);
                                        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(), activity.getLifecycle(), list);
                                        viewPager2.setAdapter(pagerAdapter);

                                        dots = new TextView[2];
                                        dotsIndicator();

                                        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                                            @Override
                                            public void onPageSelected(int position) {
                                                selectIndicator(position);
                                                super.onPageSelected(position);
                                            }
                                        });
                                    } else {
                                        Toast.makeText(activity, "Hai finito le partite", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(activity, "Non ci sono partite da giocare", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                cazzone.removeObserver(this);
                            }
                        }
                    });
                } else {
                    teamLiveData.removeObserver(this);
                }
            }
        });
    }
}
