package DataBase;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class TeamWithPlayer {
    @Embedded public Team team;
    @Relation(
            parentColumn = "name",
            entityColumn = "teamName"
    )
    public List<Player> players;
}
