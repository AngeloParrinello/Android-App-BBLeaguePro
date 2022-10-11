package DataBase;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class LeaguePlayerWithAbility {
    @Embedded
    public LeaguePlayer player;
    @Relation(
            parentColumn = "leaguePlayerID",
            entityColumn = "abilityName",
            associateBy = @Junction(LeaguePlayerAbilityCrossRef.class)
    )
    public List<Ability> abilities;
}
