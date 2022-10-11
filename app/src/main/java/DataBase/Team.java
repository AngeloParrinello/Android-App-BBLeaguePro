package DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @PrimaryKey
    @NonNull
    public String name;
    public int rerollCost;

    public Team(String name, int rerollCost){
        this.name = name;
        this.rerollCost = rerollCost;
    }

    public static List<Team> prepopulateTeam(){
        List<Team> list = new ArrayList<>();

        list.add(new Team("Amazzoni", 50000));
        list.add(new Team("Caos", 60000));
        list.add(new Team("Elfi", 60000));
        list.add(new Team("Elfi alti", 50000));
        list.add(new Team("Elfi oscuri", 50000));
        list.add(new Team("Elfi silvani", 50000));
        list.add(new Team("Goblin", 60000));
        list.add(new Team("Halfling", 60000));
        list.add(new Team("Khemri", 70000));
        list.add(new Team("Nani", 50000));
        list.add(new Team("Nani del caos", 70000));
        list.add(new Team("Necromanti", 70000));
        list.add(new Team("Non-morti", 70000));
        list.add(new Team("Norse", 60000));
        list.add(new Team("Nurgle", 70000));
        list.add(new Team("Ogri", 70000));
        list.add(new Team("Orchi", 60000));
        list.add(new Team("Skaven", 60000));
        list.add(new Team("Umani", 50000));
        list.add(new Team("Uomini lucertola", 60000));
        list.add(new Team("Vampiri", 70000));

        return list;
    }
}
