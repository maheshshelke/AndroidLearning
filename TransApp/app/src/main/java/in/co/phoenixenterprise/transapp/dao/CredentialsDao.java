package in.co.phoenixenterprise.transapp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import in.co.phoenixenterprise.transapp.entity.Credentials;

@Dao
public interface CredentialsDao {

    @Insert //(onConflict = OnConflictStrategy.REPLACE)
    public void insertCredentials(Credentials... credentials);


    @Query("SELECT * FROM credentials WHERE userId like :userId")
    public Credentials[] loadCredentialsOfUserId(String userId);

    @Update
    void updateCredentials(Credentials credentials);

    @Delete
    void deleteCredentials(Credentials credentials);

}
