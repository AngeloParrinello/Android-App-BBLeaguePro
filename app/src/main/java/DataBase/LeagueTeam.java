package DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "league_team", foreignKeys = {@ForeignKey(entity = Team.class,
        parentColumns = "name", childColumns = "type", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = League.class, parentColumns = "leagueID", childColumns = "league",
                onDelete = ForeignKey.CASCADE)})
public class LeagueTeam {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int tv;
    public String name;
    @ColumnInfo(index = true)
    public String type;
    /*
     *  foreing key su id della lega
     */
    @ColumnInfo(index = true)
    public int league;
    public String owner;
    /*
     *  se true il proprietario della squadra gestisce la lega associata
     */
    public boolean leagueOwner;
    //da modificare ogni volta che viene inserita una partita
    public int score;
}
