package DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"leaguePlayerID", "abilityName"})
public class LeaguePlayerAbilityCrossRef {
    @NonNull
    @ColumnInfo(index = true)
    public int leaguePlayerID;
    @NonNull
    @ColumnInfo(index = true)
    public  String abilityName;
}
