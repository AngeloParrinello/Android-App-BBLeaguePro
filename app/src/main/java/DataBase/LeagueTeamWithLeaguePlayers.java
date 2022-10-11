package DataBase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class LeagueTeamWithLeaguePlayers {
    @Embedded
    public LeagueTeam team;
    @Relation(
            parentColumn = "id",
            entityColumn = "teamID"
    )
    public List<LeaguePlayer> players;
}
