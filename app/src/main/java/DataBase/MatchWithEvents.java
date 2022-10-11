package DataBase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class MatchWithEvents {
    @Embedded
    public Match match;
    @Relation(
            parentColumn = "matchID",
            entityColumn = "matchID"
    )
    public List<Event> events;
}
