package DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = LeagueTeam.class,
        parentColumns = "id", childColumns = "homeTeam", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = LeagueTeam.class, parentColumns = "id", childColumns = "awayTeam",
                onDelete = ForeignKey.CASCADE)})
public class Match {
    @PrimaryKey(autoGenerate = true)
    public int matchID;
    public int league;
    public int day;
    @ColumnInfo(index = true)
    public int homeTeam;
    @ColumnInfo(index = true)
    public int awayTeam;
    public boolean played;
}
