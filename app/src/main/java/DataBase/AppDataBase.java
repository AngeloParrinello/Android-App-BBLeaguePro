package DataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Ability.class, Coach.class, Event.class,
        League.class, LeaguePlayer.class, LeagueTeam.class,
        Match.class, Player.class, Team.class, PlayerAbilityCrossRef.class, LeaguePlayerAbilityCrossRef.class},
        version = 20)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AppDAO appDAO();
    public static volatile AppDataBase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService DataBaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);



    public static AppDataBase getDatabase(final Context context) {
        if(INSTANCE == null){
            synchronized (AppDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,
                            "app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                    DataBaseWriteExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            getDatabase(context.getApplicationContext()).appDAO().loadAllAbility(Ability.prePopulateAbility());
                            getDatabase(context.getApplicationContext()).appDAO().loadAllPlayer(Player.prePopulatePlayer());
                            getDatabase(context.getApplicationContext()).appDAO().loadAllTypeTeam(Team.prepopulateTeam());
                            getDatabase(context.getApplicationContext()).appDAO().loadAllPlayerWithAbility(PlayerAbilityCrossRef.prePopulateAbilityCrossRef());

                        }
                    });
                }
            }
        }
        return INSTANCE;
    }




}
