package DataBase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class LeagueWithMatches {
    @Embedded
    public League league;
    @Relation(
            parentColumn = "leagueID",
            entityColumn = "league"
    )
    public List<Match> matches;
}
