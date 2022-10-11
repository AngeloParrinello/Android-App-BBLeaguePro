package DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = LeaguePlayer.class, parentColumns = {"leaguePlayerID"} ,
childColumns = {"playerID"}, onDelete = ForeignKey.CASCADE))
public class Event {
    @PrimaryKey(autoGenerate = true)
    public int eventID;
    @ColumnInfo(index = true)
    public int playerID;
    public String type;
    public int matchID;
    /**
     * TO DO
     * type dovrebbe essere un Enum non una String
     */
}
