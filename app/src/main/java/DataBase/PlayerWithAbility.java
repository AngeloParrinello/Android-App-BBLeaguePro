package DataBase;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class PlayerWithAbility {
    @Embedded public Player player;
    @Relation(
            parentColumn = "playerName",
            entityColumn = "abilityName",
            associateBy = @Junction(PlayerAbilityCrossRef.class)
    )
    public List<Ability> abilities;
}
