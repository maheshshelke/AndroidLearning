package in.co.phoenixenterprise.transapp.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import in.co.phoenixenterprise.transapp.entity.Credentials;

@Database(entities = {Credentials.class}, version = 2, exportSchema = false)
public abstract class TransAppDatabase extends RoomDatabase {
    private static TransAppDatabase INSTANCE;

    public abstract CredentialsDao credentialsDao();

    public static TransAppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),TransAppDatabase.class,"transapp_db")
                    .fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

    public static TransAppDatabase getDatabase(){
        return INSTANCE;
    }
}
