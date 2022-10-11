package DataBase;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.google.android.material.circularreveal.CircularRevealHelper;

import java.util.List;

@Dao
public interface AppDAO {

    @Query("UPDATE league_player SET sp = sp + :tot WHERE leaguePlayerID = :id")
    public void incrementSp(int tot, int id);

    @Update
    public void updateLeague(League l);

    @Delete
    public void deleteLeaguePlayer(LeaguePlayer leaguePlayer);

    @Transaction
    @Query("SELECT * FROM league_team WHERE id = :id")
    public LiveData<LeagueTeam> findLeagueTeamById(int id);

    @Transaction
    @Query("SELECT * FROM league_player WHERE leaguePlayerID = :id")
    public LiveData<LeaguePlayerWithAbility> findAbilities(int id);

    @Transaction
    @Query("SELECT * FROM player WHERE playerName = :type")
    public LiveData<PlayerWithAbility> findAbilities(String type);

    @Transaction
    @Query("SELECT * FROM league_team WHERE league = :leagueId AND owner = :nameCoach")
    public LiveData<LeagueTeam> findTeam(String nameCoach, int leagueId);

    @Transaction
    @Query("SELECT * FROM league_team WHERE league = :leagueId AND owner = :nameCoach")
    public LiveData<LeagueTeamWithLeaguePlayers> findPlayers(int leagueId, String nameCoach);

    @Transaction
    @Query("SELECT * FROM league_team WHERE league = :leagueID")
    public LiveData<List<LeagueTeam>> findTeamsInLeague(int leagueID);

    @Transaction
    @Query("SELECT * FROM coach WHERE coach.userName = :name")
    public LiveData<Coach> findCoach(String name);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void coachInsert(Coach coach);

    @Transaction
    @Query("SELECT * FROM coach WHERE coach.userName = :name")
    public LiveData<CoachWithTeams> findTeamsByCoach(String name);

    @Transaction
    @Query("SELECT * FROM team where team.name = :team")
    public LiveData<Team> findTeam(String team);

    @Transaction
    @Query("SELECT team.name FROM team")
    public LiveData<List<String>> findTeamsNames();

    @Transaction
    @Query("SELECT * FROM league WHERE leagueID = :id")
    public LiveData<League> findLeaguesById(Integer id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void teamInsert(LeagueTeam leagueTeam);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void leagueInsert(League league);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void leaguePlayerInsert(LeaguePlayer leaguePlayer);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void typeTeamInsert(Team team);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void loadAllTypeTeam(List<Team> teams);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void loadAllAbility(List<Ability> abilities);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void loadAllPlayer(List<Player> players);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void loadAllPlayerWithAbility(List<PlayerAbilityCrossRef> playerAbilityCrossRefs);

    @Transaction
    @Query("SELECT * FROM league_team WHERE id = :id")
    public LiveData<LeagueTeamWithLeaguePlayers> getAllPlayerFromALeagueTeam(int id);

    @Transaction
    @Query("SELECT * FROM team WHERE name = :teamName")
    public LiveData<TeamWithPlayer> getAllPlayerFromATeam(String teamName);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertMatch(Match m);

    @Transaction
    @Query("SELECT * FROM league")
    public LiveData<List<League>> getAllLeague();

    @Transaction
    @Query("SELECT * FROM league WHERE league.leagueID = :id")
    public LiveData<LeagueWithMatches> getMatches(int id);

    @Update
    public void updateLeagueTeam(LeagueTeam leagueTeam);

    @Insert
    public void insertEvent(Event e);

    @Transaction
    @Query("UPDATE `match` SET played = 1 WHERE matchID = :id")
    public void matchPlayedUpdate(int id);

    @Transaction
    @Query("SELECT * FROM `match` WHERE matchID = :id")
    public LiveData<MatchWithEvents> findMatchWithEvents(int id);

    @Transaction
    @Query("UPDATE league_team SET score = score + :i  WHERE id = :teamID")
    public void updateScore(int teamID, int i);

    @Query("SELECT * FROM ability")
    public LiveData<List<Ability>> getAllAbilities();

    @Query("UPDATE league_team SET tv = tv + :toAdd  WHERE id = :idTeam")
    public void addTeamValue(int idTeam, int toAdd);

    @Insert
    public void insertLeaguePlayerAbilityCrossRef(LeaguePlayerAbilityCrossRef leaguePlayerAbilityCrossRef);

    @Transaction
    @Query("SELECT * FROM league_team WHERE leagueOwner = 1 AND league = :leagueID")
    public LiveData<LeagueTeam> getLeagueTeamOwnerOfALeague(int leagueID);
}
