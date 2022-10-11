package DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ability {
    @PrimaryKey
    @NonNull
    public String abilityName;

    public Ability(String abilityName) {
        this.abilityName = abilityName;
    }

    public static List<Ability> prePopulateAbility() {
        List<Ability> abilityList = new ArrayList<>();

        abilityList.add(new Ability("Accurato"));
        abilityList.add(new Ability("Animale selvaggio"));
        abilityList.add(new Ability("Animosità"));
        abilityList.add(new Ability("Arma segreta"));
        abilityList.add(new Ability("Arrestare"));
        abilityList.add(new Ability("Artigli"));
        abilityList.add(new Ability("Balzo"));
        abilityList.add(new Ability("Blocco"));
        abilityList.add(new Ability("Blocco multiplo"));
        abilityList.add(new Ability("Bombarolo"));
        abilityList.add(new Ability("Braccia in più"));
        abilityList.add(new Ability("Braccio Forte"));
        abilityList.add(new Ability("Calcio"));
        abilityList.add(new Ability("Cancrena di Nurgle"));
        abilityList.add(new Ability("Coda Prensile"));
        abilityList.add(new Ability("Colpo possente"));
        abilityList.add(new Ability("Corna"));
        abilityList.add(new Ability("Due teste"));
        abilityList.add(new Ability("Fallo furtivo"));
        abilityList.add(new Ability("Fastidioso"));
        abilityList.add(new Ability("Furia"));
        abilityList.add(new Ability("Gambe lunghe"));
        abilityList.add(new Ability("Gioco sporco"));
        abilityList.add(new Ability("Guardia"));
        abilityList.add(new Ability("Idolo dei tifosi"));
        abilityList.add(new Ability("Inarrestabile"));
        abilityList.add(new Ability("Incosciente"));
        abilityList.add(new Ability("Interferenza"));
        abilityList.add(new Ability("Lanciami"));
        abilityList.add(new Ability("Lanciare compagni"));
        abilityList.add(new Ability("Lancio disperato"));
        abilityList.add(new Ability("Lancio sicuro"));
        abilityList.add(new Ability("Lottare"));
        abilityList.add(new Ability("Manona"));
        abilityList.add(new Ability("Marcare"));
        abilityList.add(new Ability("Marcio"));
        abilityList.add(new Ability("Massiccio"));
        abilityList.add(new Ability("Mettere radici"));
        abilityList.add(new Ability("Minuscolo"));
        abilityList.add(new Ability("Motosega"));
        abilityList.add(new Ability("Nervi d’acciaio"));
        abilityList.add(new Ability("Paletto"));
        abilityList.add(new Ability("Palla e catena"));
        abilityList.add(new Ability("Passare"));
        abilityList.add(new Ability("Pelle dura"));
        abilityList.add(new Ability("Piccoletto"));
        abilityList.add(new Ability("Piè fermo"));
        abilityList.add(new Ability("Placcaggio"));
        abilityList.add(new Ability("Placcaggio in tuffo"));
        abilityList.add(new Ability("Presa sicura"));
        abilityList.add(new Ability("Pro"));
        abilityList.add(new Ability("Pugnale"));
        abilityList.add(new Ability("Repellente"));
        abilityList.add(new Ability("Ricevere"));
        abilityList.add(new Ability("Ricezione in tuffo"));
        abilityList.add(new Ability("Rigenerazione"));
        abilityList.add(new Ability("Ritorno Kick-off"));
        abilityList.add(new Ability("Rompere marcatura"));
        abilityList.add(new Ability("Rubar palla"));
        abilityList.add(new Ability("Saltar su"));
        abilityList.add(new Ability("Scaricare"));
        abilityList.add(new Ability("Scattare"));
        abilityList.add(new Ability("Schiacciare"));
        abilityList.add(new Ability("Schivare"));
        abilityList.add(new Ability("Sempre Affamato"));
        abilityList.add(new Ability("Senza mani"));
        abilityList.add(new Ability("Sete di Sangue"));
        abilityList.add(new Ability("Sguardo ipnotico"));
        abilityList.add(new Ability("Smarcarsi"));
        abilityList.add(new Ability("Solitario"));
        abilityList.add(new Ability("Stupido"));
        abilityList.add(new Ability("Tentacoli"));
        abilityList.add(new Ability("Tonto"));
        abilityList.add(new Ability("Trascinare"));

        return abilityList;
    }


}
