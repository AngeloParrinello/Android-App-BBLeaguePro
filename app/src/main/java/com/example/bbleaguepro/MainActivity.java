package com.example.bbleaguepro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toolbar;

import com.example.bbleaguepro.ViewModel.MainViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import DataBase.League;
import DataBase.LeagueTeam;

public class MainActivity extends AppCompatActivity {
    private Fragment teamFragment;
    private Fragment ranking;
    private final Activity activity = this;
    private Fragment calendar;
    private MainViewModel myViewModel;
    private LeagueTeam myLeagueTeam;
    private String nameCoach;
    private int leagueID;
    private League infoLeague;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameCoach = activity.getIntent().getExtras().getString("coachName");
        leagueID = activity.getIntent().getExtras().getInt("leagueID");

        /*
            set the topbar title with league name
         */
        myViewModel = new MainViewModel(getApplication());
        myViewModel.initializeLiveData(getIntent().getExtras().getInt("leagueID"), getIntent().getExtras().getString("coachName"));
        myViewModel.getLeague().observe(this, new Observer<League>() {
            @Override
            public void onChanged(League league) {
                MaterialToolbar toolbar = (MaterialToolbar) findViewById(R.id.topAppBar);
                toolbar.setTitle(league.name);
                infoLeague = league;
            }
        });
        myViewModel.getTeam().observe(this, new Observer<LeagueTeam>() {
            @Override
            public void onChanged(LeagueTeam leagueTeam) {
                myLeagueTeam = leagueTeam;
            }
        });
        /*
            insert first fragment
         */
        if (savedInstanceState == null) {
            Utilities.insertFragmentWithoutBackStack(this, new HomeFragment(), "Home Fragment");
        }
        /*
            setting up fab add
         */
        final Activity activity = this;
        if (activity != null) {

            FloatingActionButton floatingActionButton = this.findViewById(R.id.fab_add_real);


            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, AddActivity.class);
                    intent.putExtra("idTeam", myLeagueTeam.id);
                    startActivity(intent);
                }
            });
        }
        /*
            setting onClick on the tab of the bottom nav bar
         */
        View home = this.findViewById(R.id.page_1);
        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Utilities.insertFragment((AppCompatActivity) activity, new HomeFragment(),
                        "HomeFragment");
            }
        });
        
        View calendar = this.findViewById(R.id.page_3);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BackgroundTask task = new BackgroundTask((AppCompatActivity) activity);
                //task.execute();
                createCalendar();
            }
        });
        
        View ranking = this.findViewById(R.id.page_4);
        ranking.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                createRanking();
            }
        });

        View team = this.findViewById(R.id.page_5);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.insertFragment((AppCompatActivity) activity, getTeamFragment(),
                        "TeamFragment");
            }
        });

        View stats = this.findViewById(R.id.app_bar_chart);
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        View settings = this.findViewById(R.id.app_bar_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SettingsActivity.class);

                intent.putExtra("coachName", nameCoach);
                intent.putExtra("leagueID", leagueID);
                startActivity(intent);
            }
        });


    }

    private void createCalendar() {

                if(this.calendar == null){
                    this.calendar = new CalendarFragment();
                }
                Utilities.insertFragment((AppCompatActivity) activity, calendar, "CalendarFragment");
    }

    /**
     * If is never been create it creates a new TeamFragment, else return the already created one.
     * @return the team fragment.
     */
    private Fragment getTeamFragment(){
        if(this.teamFragment == null) {
            this.teamFragment = new TeamFragment();
        }
        return this.teamFragment;
    }

    private void createRanking(){
        if(this.ranking == null) {
            this.ranking = new RankingFragment();
        }
        Utilities.insertFragment((AppCompatActivity) activity, ranking,
                "RankingFragment");
    }

    public MainViewModel getViewModel(){
        return this.myViewModel;
    }

    public void startLeague(){
        infoLeague.active = true;
        myViewModel.updateLeague(infoLeague);
    }
}

