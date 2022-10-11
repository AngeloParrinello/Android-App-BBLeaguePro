package DataBase;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {

    private AppDAO appDAO;

    public AppRepository(Application application){
        AppDataBase appDataBase = AppDataBase.getDatabase(application);
        appDAO = appDataBase.appDAO();
    }

    public void incrementSp(int tot, int id){
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.incrementSp(tot, id);
            }
        });
    }

    public LiveData<LeagueTeam> getLeagueTeam(int id){
        return appDAO.findLeagueTeamById(id);
    }

    public LiveData<LeagueWithMatches> getMatches(int id){
        return appDAO.getMatches(id);
    }
    public void updateLeague(League l){
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.updateLeague(l);
            }
        });
    }

    public LiveData<Coach> getCoach(String name){
        return appDAO.findCoach(name);
    }

    public LiveData<CoachWithTeams> getTeams(String name) {
        return appDAO.findTeamsByCoach(name);
    }

    public LiveData<Team> getTypeTeam(String team) {
        return appDAO.findTeam(team);
    }

    public void coachInsert(Coach coach) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.coachInsert(coach);
            }
        });
    }

    public void teamInsert(LeagueTeam leagueTeam) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.teamInsert(leagueTeam);
            }
        });
    }

    public void leagueInsert(League league) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.leagueInsert(league);
            }
        });
    }

    public void typeTeamInsert(Team team) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.typeTeamInsert(team);
            }
        });
    }

    public LiveData<League> getLeague(Integer id) {
        return appDAO.findLeaguesById(id);
    }

    public void insertLeaguePlayer(LeaguePlayer leaguePlayer){
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.leaguePlayerInsert(leaguePlayer);
            }
        });
    }

    public void insertLeagueAndLeagueTeam(League league, LeagueTeam leagueTeam) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.leagueInsert(league);
                appDAO.teamInsert(leagueTeam);
            }
        });
    }

    public LiveData<LeagueTeam> getLeagueTeam(String nameCoach, int leagueId){
        return appDAO.findTeam(nameCoach, leagueId);
    }

    public LiveData<LeagueTeamWithLeaguePlayers> getAllPlayersFromALeagueTeam(int id) {
        return appDAO.getAllPlayerFromALeagueTeam(id);
    }
    
    public LiveData<List<LeagueTeam>> getTeamsInLeague(int leagueId){
        return appDAO.findTeamsInLeague(leagueId);
    }

    public LiveData<LeagueTeamWithLeaguePlayers> getTeamPlayers(int id, String nameCoach){
        return appDAO.findPlayers(id, nameCoach);
    }

    public LiveData<PlayerWithAbility> getPlayerAbilities(String type){
        return appDAO.findAbilities(type);
    }

    public LiveData<LeaguePlayerWithAbility> getPlayerAbilities(int playerId){
        return appDAO.findAbilities(playerId);
    }

    public LiveData<TeamWithPlayer> getAllPlayerFromATeam(String team){
        return appDAO.getAllPlayerFromATeam(team);
    }

    public LiveData<List<String>> getTeamsNames() {
        return appDAO.findTeamsNames();
    }

    public LiveData<List<League>> getAllLeague(){
        return appDAO.getAllLeague();
    }

    public void insertMatch(Match m){
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.insertMatch(m);
            }
        });
    }

    public void updateLeagueTeam(LeagueTeam leagueTeam) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.updateLeagueTeam(leagueTeam);
            }
        });
    }

    public void insertEvent(Event e) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.insertEvent(e);
            }
        });
    }

    public void matchPlayed(int id){
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.matchPlayedUpdate(id);
            }
        });
    }

    public void deleteLeaguePlayer(LeaguePlayer leaguePlayer){
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.deleteLeaguePlayer(leaguePlayer);
            }
        });
    }

    public LiveData<MatchWithEvents> getMatchWithEvents(int id){
        return appDAO.findMatchWithEvents(id);
    }

    public void updateScore(int teamID, int i) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.updateScore(teamID, i);
            }
        });
    }

    public LiveData<List<Ability>> getAllAbilities() {
        return appDAO.getAllAbilities();
    }
    
    public void addTeamValue(int idTeam, int toAdd) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.addTeamValue(idTeam, toAdd);
            }
        });
    }

    public void insertLeaguePlayerAbilityCrossRef(LeaguePlayerAbilityCrossRef leaguePlayerAbilityCrossRef) {
        AppDataBase.DataBaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                appDAO.insertLeaguePlayerAbilityCrossRef(leaguePlayerAbilityCrossRef);
            }
        });
    }

    public LiveData<LeagueTeam> getLeagueTeamOwnerOfALeague(int leagueID){
        return appDAO.getLeagueTeamOwnerOfALeague(leagueID);
    }
}
