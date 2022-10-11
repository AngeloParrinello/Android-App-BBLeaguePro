package DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "player")
public class Player {
    @PrimaryKey
    @NonNull
    public String playerName;
    public String teamName;
    public int armor;
    public int agility;
    public int strength;
    public int movement;
    public int cost;
    public String shortName;
    public int max;


    public Player(String playerName, String teamName, int armor, int agility, int strength, int movement, int cost, String shortName, int max) {
        this.playerName = playerName;
        this.teamName = teamName;
        this.armor = armor;
        this.agility = agility;
        this.strength = strength;
        this.movement = movement;
        this.cost = cost;
        this.shortName = shortName;
        this.max = max;
    }

    public static List<Player> prePopulatePlayer(){
        List<Player> list = new ArrayList<>();
        list.add(new Player("Donna di linea", "Amazzoni", 7, 3,
                3, 6, 50000, "Donna di linea", 16));
        list.add(new Player("Lanciatrice","Amazzoni", 7, 3,
                3, 6, 70000, "Lanciatrice", 2));
        list.add(new Player("Ricevitrice","Amazzoni", 7, 3,
                3, 6, 70000, "Ricevitrice", 2));
        list.add(new Player("Blitzer amazzone","Amazzoni", 7, 3,
                3, 6, 90000, "Blitzer",4));
        list.add(new Player("Uomo bestia","Caos", 8, 3,
                3, 6, 60000, "Uomo bestia", 16));
        list.add(new Player("Guerriero del caos","Caos", 9, 3,
                4, 5, 100000, "Guerriero del caos", 4));
        list.add(new Player("Minotauro caos","Caos", 8, 2,
                5, 5, 150000, "Minotauro", 1));
        list.add(new Player("Elfo di linea","Elfi", 7, 4,
                3, 6, 60000, "Elfo di linea", 16));
        list.add(new Player("Lanciatore elfo","Elfi", 7, 4,
                3, 6, 70000,"Lanciatore", 2));
        list.add(new Player("Ricevitore elfo","Elfi", 7, 4,
                3, 8, 100000, "Ricevitore", 4));
        list.add(new Player("Blitzer elfo","Elfi", 8, 4,
                3, 7, 110000, "Blitzer", 2));
        list.add(new Player("Elfo alto di linea","Elfi alti", 8, 4,
                3, 6, 70000, "Elfo di linea", 16));
        list.add(new Player("Lanciatore elfo alto","Elfi alti", 8, 4,
                3, 6, 90000, "Lanciatore", 2));
        list.add(new Player("Ricevitore elfo alto","Elfi alti", 7, 4,
                3, 8, 90000, "Ricevitore", 4));
        list.add(new Player("Blitzer elfo alto","Elfi alti", 8, 4,
                3, 7, 100000, "Blitzer", 2));
        list.add(new Player("Corridore elfo oscuro","Elfi oscuri", 7, 4,
                3, 7, 70000, "Corridore", 2));
        list.add(new Player("Assassino","Elfi oscuri", 7, 4,
                3, 6, 70000, "Assassino", 2));
        list.add(new Player("Strega","Elfi oscuri", 7, 4,
                3, 7, 110000, "Strega", 2));
        list.add(new Player("Elfo oscuro di linea","Elfi oscuri", 8, 4,
                3, 6, 70000, "Elfo di linea", 16));
        list.add(new Player("Blitzer elfo oscuro","Elfi oscuri", 7, 4,
                3, 7, 70000, "Blitzer", 4));
        list.add(new Player("Elfo silvano di linea","Elfi silvani", 7, 4,
                3, 7, 70000, "Elfo di linea", 16));
        list.add(new Player("Ricevitore elfo silvano","Elfi silvani", 7, 4,
                2, 8, 90000, "Ricevitore", 4));
        list.add(new Player("Lanciatore elfo silvano","Elfi silvani", 7, 4,
                3, 7, 90000, "Lanciatore", 2));
        list.add(new Player("Wardancer","Elfi silvani", 7, 4,
                3, 8, 120000, "Wardancer", 2));
        list.add(new Player("Uomo albero elfo silvano","Elfi silvani", 10, 1,
                6, 2, 120000, "Uomo albero", 1));
        list.add(new Player("Goblin","Goblin", 7, 3,
                2, 6, 40000, "Goblin", 16));
        list.add(new Player("Bombarolo","Goblin", 7, 3,
                2, 6, 40000, "Bombarolo", 1));
        list.add(new Player("Pogo","Goblin", 7, 3,
                2, 7, 70000, "Pogo", 1));
        list.add(new Player("Motosega","Goblin", 7, 3,
                2, 6, 40000, "Motosega", 1));
        list.add(new Player("Fanatico","Goblin", 7, 3,
                7, 3, 70000, "Fanatico", 1));
        list.add(new Player("Troll goblin","Goblin", 9, 1,
                5, 4, 110000, "Troll", 2));
        list.add(new Player("Halfling","Halfling", 6, 3,
                2, 5, 30000, "Halfling", 16));
        list.add(new Player("Uomo albero halfling","Halfling", 10, 1,
                6, 2, 120000, "Uomo albero", 2));
        list.add(new Player("Scheletro khemri","Khemri", 7, 2,
                3, 5, 40000, "Scheletro", 16));
        list.add(new Player("Thro-Ra","Khemri", 7, 2,
                3, 6, 70000, "Thro-Ra", 2));
        list.add(new Player("Blitzer khemri","Khemri", 8, 2,
                3, 6, 90000, "Blitz-Ra", 2));
        list.add(new Player("Guardiano di tombe","Khemri", 9, 1,
                5, 4, 100000, "Guardiano di tombe", 4));
        list.add(new Player("Bloccatore","Nani", 9, 2,
                3, 4, 70000, "Bloccatore", 16));
        list.add(new Player("Corridore nano","Nani", 8, 3,
                3, 6, 80000, "Corridore", 2));
        list.add(new Player("Blitzer nano","Nani", 9, 3,
                3, 5, 80000, "Blitzer", 2));
        list.add(new Player("Sventratore","Nani", 8, 2,
                3, 5, 90000, "Sventratore", 2));
        list.add(new Player("Schiacciasassi","Nani", 10, 1,
                7, 4, 160000, "Schiacciasassi", 1));
        list.add(new Player("Hobgoblin","Nani del caos", 7, 3,
                3, 6, 40000, "Hobgoblin", 16));
        list.add(new Player("Nano del caos","Nani del caos", 9, 2,
                3, 4, 70000, "Nano del caos", 6));
        list.add(new Player("Toro Centauro","Nani del caos", 9, 2,
                4, 6, 130000, "Centauro", 2));
        list.add(new Player("Minotauro nano caos","Nani del caos", 8, 2,
                5, 5, 150000, "Minotauro", 1));
        list.add(new Player("Zombi necromante","Necromanti", 8, 2,
                3, 4, 40000, "Zombi", 16));
        list.add(new Player("Ghoul necromante","Necromanti", 7, 3,
                3, 7, 70000, "Ghoul", 2));
        list.add(new Player("Spettro necromante","Necromanti", 8, 3,
                3, 6, 90000, "Spettro", 2));
        list.add(new Player("Golem di carne","Necromanti", 9, 2,
                4, 4, 100000, "Golem di carne", 2));
        list.add(new Player("Lupo mannaro","Necromanti", 8, 3,
                3, 8, 120000, "Lupo mannaro", 2));
        list.add(new Player("Scheletro non-morto","Non-morti", 7, 2,
                3, 5, 40000, "Scheletro", 16));
        list.add(new Player("Zombi non-morto","Non-morti", 8, 2,
                3, 4, 40000, "Zombi", 16));
        list.add(new Player("Ghoul non-morto","Non-morti", 7, 3,
                3, 7, 70000, "Ghoul", 4));
        list.add(new Player("Spettro non-morto","Non-morti", 8, 3,
                3, 6, 90000, "Spettro", 2));
        list.add(new Player("Mummia","Non-morti", 9, 1,
                5, 3, 120000, "Mummia", 2));
        list.add(new Player("Uomo di linea norse","Norse", 7, 3,
                3, 6, 50000, "Uomo di linea", 16));
        list.add(new Player("Lanciatore norse","Norse", 7, 3,
                3, 6, 70000, "Lanciatore", 2));
        list.add(new Player("Corridore norse","Norse", 7, 3,
                3, 7, 90000, "Corridore", 2));
        list.add(new Player("Berserker","Norse", 7, 3,
                3, 6, 90000, "Berserker", 2));
        list.add(new Player("Ulfwerener","Norse", 8, 2,
                4, 6, 110000, "Ulfwerener", 2));
        list.add(new Player("Yeti","Norse", 8, 1,
                5, 5, 140000, "Yeti", 1));
        list.add(new Player("Putrido","Nurgle", 8, 3,
                3, 5, 40000, "Putrido", 16));
        list.add(new Player("Pestigor","Nurgle", 8, 3,
                3, 6, 80000, "Pestigor", 4));
        list.add(new Player("Guerriero nurgle","Nurgle", 9, 2,
                4, 4, 110000, "Guerriero nurgle", 4));
        list.add(new Player("Bestia di nurgle","Nurgle", 9, 1,
                5, 4, 140000, "Bestia di nurgle", 1));
        list.add(new Player("Orco di linea","Orchi", 9, 3,
                3, 9, 50000, "Orco di linea", 16));
        list.add(new Player("Goblin orco","Orchi", 7, 3,
                2, 6, 40000, "Goblin", 4));
        list.add(new Player("Lanciatore orco","Orchi", 8, 3,
                3, 5, 70000, "Lanciatore", 2));
        list.add(new Player("Orco nero","Orchi", 9, 2,
                4, 4, 80000, "Orco nero", 4));
        list.add(new Player("Blitzer orco","Orchi", 9, 3,
                3, 6, 80000, "Blitzer", 4));
        list.add(new Player("Troll orco","Orchi", 9, 1,
                5, 4, 110000, "Troll", 1));
        list.add(new Player("Snotling","Ogri", 5, 3,
                1, 5, 20000, "Snotling", 16));
        list.add(new Player("Ogre","Ogri", 9, 2,
                5, 5, 140000, "Ogre", 6));
        list.add(new Player("Ratto di linea","Skaven", 7, 3,
                3, 7, 50000, "Ratto di linea", 16));
        list.add(new Player("Lanciatore skaven","Skaven", 7, 3,
                3, 7, 70000, "Lanciatore", 2));
        list.add(new Player("Pantegana","Skaven", 7, 4,
                2, 9, 80000, "Pantegana", 4));
        list.add(new Player("Blitzer skaven","Skaven", 8, 3,
                3, 7, 80000, "Blitzer", 2));
        list.add(new Player("Rattogre","Skaven", 8, 2,
                5, 6, 150000, "Rattogre", 1));
        list.add(new Player("Uomo di linea","Umani", 8, 3,
                3, 6, 50000, "Uomo di linea", 16));
        list.add(new Player("Ricevitore umano","Umani", 7, 3,
                2, 8, 70000, "Ricevitore", 4));
        list.add(new Player("Lanciatore umano","Umani", 8, 3,
                3, 6, 70000, "Lanciatore", 2));
        list.add(new Player("Blitzer umano","Umani", 8, 3,
                3, 7, 90000, "Blitzer", 4));
        list.add(new Player("Ogre umano","Umani", 9, 2,
                5, 5, 140000, "Ogre", 1));
        list.add(new Player("Scinco","Uomini lucertola", 7, 3,
                2, 8, 60000, "Scinco", 16));
        list.add(new Player("Sauro","Uomini lucertola", 9, 1,
                4, 6, 80000, "Sauro", 6));
        list.add(new Player("Kroxigor","Uomini lucertola", 9, 1,
                5, 6, 140000, "Kroxigor", 1));
        list.add(new Player("Thrall","Vampiri", 7, 3,
                3, 6, 40000, "Thrall", 16));
        list.add(new Player("Vampiro","Vampiri", 8, 4,
                4, 6, 110000, "Vampiro", 6));
        return  list;
    }

}
