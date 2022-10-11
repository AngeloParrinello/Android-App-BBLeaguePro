package DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "league_player", foreignKeys = @ForeignKey(
        entity = Player.class, parentColumns = "playerName", childColumns = "type", onDelete = ForeignKey.CASCADE
))
public class LeaguePlayer {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int leaguePlayerID;
    public int number;
    public int teamID;
    public int sp;
    public int armor;
    public int agility;
    public int strength;
    public int movement;
    @ColumnInfo(index = true)
    public String type;
}
