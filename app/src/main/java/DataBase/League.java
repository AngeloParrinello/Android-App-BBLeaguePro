package DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "league")
public class League {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int leagueID;
    public String name;
    public String description;
    public boolean active;
}
