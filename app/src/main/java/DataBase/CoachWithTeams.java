package DataBase;


import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CoachWithTeams {
    @Embedded
    public Coach coach;
    @Relation(
            parentColumn = "userName",
            entityColumn = "owner"
    )
    public List<LeagueTeam> teams;
}
