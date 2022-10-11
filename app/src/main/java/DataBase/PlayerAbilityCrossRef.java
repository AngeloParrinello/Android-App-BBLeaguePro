package DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity(primaryKeys = {"playerName", "abilityName"})
public class PlayerAbilityCrossRef {
    @NonNull
    @ColumnInfo(index = true)
    public String playerName;
    @NonNull
    @ColumnInfo(index = true)
    public String abilityName;

    public PlayerAbilityCrossRef(String playerName, String abilityName){
        this.playerName = playerName;
        this.abilityName = abilityName;
    }


    public static List<PlayerAbilityCrossRef> prePopulateAbilityCrossRef() {
        List<PlayerAbilityCrossRef> playerAbilityCrossRefList = new ArrayList<>();

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Donna di linea", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatrice", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatrice", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitrice", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitrice", "Ricevere"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer amazzone", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer amazzone", "Blocco"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo bestia", "Corna"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro caos", "Animale selvaggio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro caos", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro caos", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro caos", "Corna"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro caos", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro caos", "Solitario"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore elfo", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore elfo", "Ricevere"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore elfo", "Nervi d’acciaio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer elfo", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer elfo", "Schivare"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore elfo alto", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore elfo alto", "Lancio sicuro"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore elfo alto", "Ricevere"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer elfo alto", "Blocco"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Corridore elfo oscuro", "Scaricare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Assassino", "Marcare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Assassino", "Pugnale"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer elfo oscuro", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Strega", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Strega", "Saltar su"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Strega", "Smarcarsi"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore elfo silvano", "Ricevere"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore elfo silvano", "Scatto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore elfo silvano", "Smarcarsi"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore elfo silvano", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Wardancer", "Balzo"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Wardancer", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Wardancer", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero elfo silvano", "Braccio forte"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero elfo silvano", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero elfo silvano", "Lanciare compagni"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero elfo silvano", "Massiccio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero elfo silvano", "Mette radici"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero elfo silvano", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero elfo silvano", "Solitario"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Goblin", "Lanciami"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Goblin", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Goblin", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bombarolo", "Arma segreta"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bombarolo", "Bombarolo"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bombarolo", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bombarolo", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pogo", "Balzo"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pogo", "Gambe lunghe"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pogo", "Gioco sporco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pogo", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pogo", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Motosega", "Arma segreta"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Motosega", "Motosega"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Motosega", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Fanatico", "Arma segreta"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Fanatico", "Palla e catena"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Fanatico", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Fanatico", "Senza mani"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll goblin", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll goblin", "Lanciare compagni"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll goblin", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll goblin", "Sempre affamato"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll goblin", "Solitario"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll goblin", "Stupido"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Halfling", "Lanciami"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Halfling", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Halfling", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero halfling", "Braccio forte"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero halfling", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero halfling", "Lanciare compagni"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero halfling", "Massiccio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero halfling", "Mette radici"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo albero halfling", "Pelle dura"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Scheletro khemri", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Scheletro khemri", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Thro-Ra", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Thro-Ra", "Presa sicura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Thro-Ra", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer khemri", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer khemri", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Guardiano di tombe", "Marcio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Guardiano di tombe", "Rigenerazione"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bloccatore", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bloccatore", "Placcaggio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bloccatore", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Corridore nano", "Presa sicura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Corridore nano", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer nano", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer nano", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Sventratore", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Sventratore", "Incosciente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Sventratore", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Sventratore", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Arma segreta"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Gioco sporco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Inarrestabile"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Massiccio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Rompere marcatura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Senza mani"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Schiacciasassi", "Solitario"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Nano del caos", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Nano del caos", "Placcaggio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Nano del caos", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Toro centauro", "Piè fermo"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Toro centauro", "Scatto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Toro centauro", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro nano caos", "Animale selvaggio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro nano caos", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro nano caos", "Corna"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro nano caos", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro nano caos", "Solitario"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Minotauro nano caos", "Pelle dura"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Zombi necromante", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ghoul necromante", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Spettro necromante", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Spettro necromante", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Golem di carne", "Massiccio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Golem di carne", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Golem di carne", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lupo mannaro", "Artigli"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lupo mannaro", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lupo mannaro", "Rigenerazione"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Scheletro non-morto", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Scheletro non-morto", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Zombi non-morto", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ghoul non-morto", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Spettro non-morto", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Spettro non-morto", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Mummia", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Mummia", "Rigenerazione"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Uomo di linea norse", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore norse", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore norse", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Corridore norse", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Corridore norse", "Incosciente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Berserker", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Berserker", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Berserker", "Saltar su"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ulfwerener", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Yeti", "Animale selvaggio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Yeti", "Artigli"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Yeti", "Fastidioso"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Yeti", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Yeti", "Solitario"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Putrido", "Cancrena di nurgle"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Putrido", "Marcio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pestigor", "Cancrena di nurgle"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pestigor", "Corna"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pestigor", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Guerriero nurgle", "Cancrena di nurgle"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Guerriero nurgle", "Fastidioso"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Guerriero nurgle", "Repellente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Guerriero nurgle", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Cancrena di nurgle"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Fastidioso"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Repellente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Solitario"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Stupido"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Bestia di nurgle", "Tentacoli"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Snotling", "Lanciami"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Snotling", "Minuscolo"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Snotling", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Snotling", "Schivare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Snotling", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre", "Lanciare compagni"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre", "Pelle dura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre", "Tonto"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Goblin orco", "Lanciami"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Goblin orco", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Goblin orco", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore orco", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore orco", "Presa sicura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer orco", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll orco", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll orco", "Lanciare compagni"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll orco", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll orco", "Sempre affamato"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll orco", "Stupido"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Troll orco", "Solitario"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore skaven", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore skaven", "Presa sicura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Pantegana", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer skaven", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Rattogre", "Animale selvaggio"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Rattogre", "Coda prensile"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Rattogre", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Rattogre", "Furia"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Rattogre", "solitario"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore umano", "Ricevere"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ricevitore umano", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore umano", "Passare"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Lanciatore umano", "Presa sicura"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Blitzer umano", "Blocco"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre umano", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre umano", "Lanciare compagni"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre umano", "Solitario"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre umano", "Tonto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Ogre umano", "Pelle dura"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Scinco", "Smarcarsi"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Scinco", "Piccoletto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Kroxigor", "Coda prensile"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Kroxigor", "Colpo possente"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Kroxigor", "Tonto"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Kroxigor", "Solitario"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Kroxigor", "Pelle dura"));

        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Vampiro", "Rigenerazione"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Vampiro", "Sete di sangue"));
        playerAbilityCrossRefList.add(new PlayerAbilityCrossRef
                ("Vampiro", "Sguardo ipnotico"));
        return playerAbilityCrossRefList;

    }

}