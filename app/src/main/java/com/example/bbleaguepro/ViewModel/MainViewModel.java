package com.example.bbleaguepro.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import DataBase.Ability;
import DataBase.AppRepository;
import DataBase.League;
import DataBase.LeaguePlayer;
import DataBase.LeaguePlayerAbilityCrossRef;
import DataBase.LeaguePlayerWithAbility;
import DataBase.LeagueTeam;
import DataBase.LeagueTeamWithLeaguePlayers;
import DataBase.LeagueWithMatches;
import DataBase.Match;
import DataBase.MatchWithEvents;
import DataBase.PlayerWithAbility;

public class MainViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<LeagueTeam> team;
    private LiveData<League> league;
    private LiveData<List<LeagueTeam>> teamsInLeague;
    private LiveData<LeagueTeamWithLeaguePlayers> teamPlayers;
    private LiveData<LeagueWithMatches> matches;
    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }

    public void initializeLiveData(int id, String coachName){
        league = repository.getLeague(id);
        team = repository.getLeagueTeam(coachName, id);
        teamsInLeague = repository.getTeamsInLeague(id);
        teamPlayers = repository.getTeamPlayers(id, coachName);
        matches = repository.getMatches(id);
    }

    public LiveData<LeagueTeam> getTeam(){
        return team;
    }

    public LiveData<League> getLeague(){
        return league;
    }

    public LiveData<List<LeagueTeam>> getTeamsInLeague() {
        return teamsInLeague;
    }

    public LiveData<LeagueTeamWithLeaguePlayers> getTeamPlayers() {
        return teamPlayers;
    }

    public LiveData<PlayerWithAbility> getPlayerAbilities(String name){
        return repository.getPlayerAbilities(name);
    }
    public LiveData<LeaguePlayerWithAbility> getPlayerAbilities(int playerID){
        return repository.getPlayerAbilities(playerID);
    }

    public void updateLeague(League l){
        repository.updateLeague(l);
    }

    public void updateLeagueTeam(LeagueTeam leagueTeam){
        repository.updateLeagueTeam(leagueTeam);
    }

    public LiveData<LeagueTeamWithLeaguePlayers> getAllPlayerFromALeagueTeam(int id){
        return repository.getAllPlayersFromALeagueTeam(id);
    }
    public void insertMatch(Match m){
        repository.insertMatch(m);
    }

    public LiveData<LeagueWithMatches> getMatches(){
        return matches;
    }

    public LiveData<LeagueTeam> getTeamById(int id){
        return repository.getLeagueTeam(id);
    }

    public LiveData<DataBase.TeamWithPlayer> getAllPlayerFromATeam(String type){
        return repository.getAllPlayerFromATeam(type);
    }

    public void deleteLeaguePlayer(LeaguePlayer leaguePlayer) {
        repository.deleteLeaguePlayer(leaguePlayer);
    }

    public LiveData<MatchWithEvents> getEvents(int id){
        return repository.getMatchWithEvents(id);
    }

    public LiveData<LeagueTeamWithLeaguePlayers> getPlayersByTeamID(int id){
        return repository.getAllPlayersFromALeagueTeam(id);
    }

    public void insertLeaguePlayer(LeaguePlayer leaguePlayer){
        repository.insertLeaguePlayer(leaguePlayer);
    }

    public LiveData<List<Ability>> getAllAbilities(){
        return repository.getAllAbilities();
    }

    public void insertLeaguePlayerAbilityCrossRef(LeaguePlayerAbilityCrossRef leaguePlayerAbilityCrossRef) {
        repository.insertLeaguePlayerAbilityCrossRef(leaguePlayerAbilityCrossRef);
    }

    public LiveData<LeagueTeam> getLeagueTeamOwnerOfALeague(int leagueID){
        return repository.getLeagueTeamOwnerOfALeague(leagueID);
    }

}
