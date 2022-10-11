package com.example.bbleaguepro.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import DataBase.AppDataBase;
import DataBase.AppRepository;
import DataBase.Coach;
import DataBase.CoachWithTeams;
import DataBase.League;
import DataBase.LeagueTeam;
import DataBase.Team;

public class SettingsViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<CoachWithTeams> coachWithTeams;
    private LiveData<Coach> coach;
    private LiveData<List<String>> teamNames;

    public SettingsViewModel(@NonNull Application application) {
        super(application);

        this.repository = new AppRepository(application);
        teamNames = repository.getTeamsNames();
    }

    public LiveData<Coach> getCoach(String name) {
        if(coach == null){
            coach = repository.getCoach(name);
        }
        return coach;
    }

    public LiveData<CoachWithTeams> getCoachWithTeams(String nameCoach) {
        if(coachWithTeams == null){
            coachWithTeams = repository.getTeams(nameCoach);
        }
        return this.coachWithTeams;
    }

    public void insertLeague(League league) {
        repository.leagueInsert(league);
    }

    public void insertTypeTeam(Team team) {
        repository.typeTeamInsert(team);
    }

    public void insertLeagueTeam(LeagueTeam leagueTeam) {
        repository.teamInsert(leagueTeam);
    }

    public LiveData<League> getLeague(Integer id) {
        return this.repository.getLeague(id);
    }

    public void insertLeagueAndLeagueTeam(League league, LeagueTeam leagueTeam) {
        this.repository.insertLeagueAndLeagueTeam(league, leagueTeam);
    }

    public LiveData<List<String>> getTeamNames(){
        return this.teamNames;
    }

    public LiveData<List<League>> getAllLeague(){
        return this.repository.getAllLeague();
    }
}
